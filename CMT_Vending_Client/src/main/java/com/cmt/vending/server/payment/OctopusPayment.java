package com.cmt.vending.server.payment;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

import javax.xml.bind.DatatypeConverter;

import com.cmt.octopus.ExtraInfoData;
import com.cmt.octopus.PollData;
import com.cmt.octopus.PollDeductReturn;
import com.cmt.octopus.RwlReturn;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.config.OctConfig;
import com.cmt.vending.server.job.DownloadOctBlackListJob;
import com.cmt.vending.server.job.DownloadOctMetaFileJob;
import com.cmt.vending.server.job.GenerateSettlementFileJob;
import com.cmt.vending.server.job.SendAlertJob;
import com.cmt.vending.server.model.OctEnquiryHistory;
import com.cmt.vending.server.model.OctTranRecord;
import com.cmt.vending.server.model.RFIDInfo;
import com.cmt.vending.server.model.RewardConfigInfo;
import com.cmt.vending.server.operation.*;
import com.cmt.vending.ui.response.*;
import com.cmt.vending.ui.webSocket.ReturnResult;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;
import com.cmt.vending.util.DateUtil;
import com.cmt.vending.util.StringUtil;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OctopusPayment extends Payment {
	public static OctConfig octconfig = null;
	
	public static final int CODE = 1;
	public static final String NAME = "OCTOPUS";
	
	private final long POLL_TIMEOUT_MS = 60000;				// Time to wait for a poll For Octopus2
	private final long ERROR_100022_TIMEOUT_MS= 25000;      // Time of locking For Octopus2

	private final long ERROR_Incomplete_Trans_TIMEOUT_MS= 20000;      // Time of locking For Octopus3
	
	private boolean isHealthCheckExecuted = false;
	private final long HEALTH_CHECK_DURATION_MS  = 5000;

	private boolean stopWaitingPolling = false;
	private boolean stopWaitingEnquiry = false;

	private Boolean retryPoll = null;		// For octopus3
	private String customMessageId;
	
	private int port = 0;
	private int baud = 115200;
	private int controllerId = 0;
	
	private boolean normal = true;

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0");

	public OctopusPayment() {
		super(CODE, NAME);
		octconfig = new OctConfig();

		try {
			octconfig.initProp();
		}catch (Exception e) {
			logger.error("[OctopusPayment]Error in loading octopus configuration: ", e);
		}

		if (octconfig.getVERSION() == 2){
			this.initComm();
		} else if (octconfig.getVERSION()== 3){
			this.initComm3();
		}
	}
	
	public boolean isNormal() {
		return this.normal;
	}


	public void initComm3(){
		logger.info("[initComm3]Initiate octopus communication");

		try {
			int returnCode  = Octopus3Comm.connect(octconfig.getCOMM_DEV_3()+octconfig.getCOMM_PORT_3());
			if(returnCode == 0) {
				logger.info("[initComm3]Init octopus3 communication successfully");

				if(!this.normal) {
					logger.info("[initComm3]Octopus Device status changed: F->S, send alert to server");
					this.normal = true;
					SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_OCT_DEVICE, "F->S"));
				} else {
					logger.info("[initComm3]Failed to init oct comm");
					if(this.normal) {
						logger.info("[initComm3]Octopus Device status changed: S->F, send alert to server");
						this.normal = false;
						SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_OCT_DEVICE, "S->F"));
						healthCheck();
					}
				}
			} else {
				logger.info("[initComm3]Failed to init octopus3 comm");
				if(this.normal) {
					logger.info("[initComm3]Octopus Device status changed: S->F, send alert to server");
					this.normal = false;
					SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_OCT_DEVICE, "S->F"));
					healthCheck();
				}
			}
		} catch(Exception e) {
			logger.error("[initComm3]Failed to init comm for Octopus3:" + e.getMessage(), e);
		}
	}

	/**
	 * Initialize octopus communication
	 * Step 1: Call initComm to initiate octopus card reader
	 * Step 2: Play normal tone and display green light of octopus card reader
	 * Step 3: Retrieve card reader information (e.g. device id)
	 * Step 4: If the octopus card reader is not normal before but normal now -> Send alert to backend;
	 * Step 5: Download Meta file and do house keeping
	 * Step 6: Download Blacklist file and do house keeping
	 * Step 7: Generate settlement file (MPS) and send it to the backend server
	 * @return
	 */
	public RwlReturn initComm() {
		logger.info("[initComm]Initiate octopus communication");
		RwlReturn rwlReturn = null;
		
		try {
			// Step 1-3
			rwlReturn = OctopusComm.initComm(this.port, this.baud, this.controllerId);
			
			if(rwlReturn.getReturnCode() == 0) {
				logger.info("[initComm]Init octopus communication successfully");
				
				// Step 4
				if(!this.normal) {
					logger.info("[initComm]Octopus Device status changed: F->S, send alert to server");
					this.normal = true;
					SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_OCT_DEVICE, "F->S"));
				}
				
				new Thread(()->{
					try {
						// Step 5
						BackendServerComm.startJob(new DownloadOctMetaFileJob());
						// Step 6
						BackendServerComm.startJob(new DownloadOctBlackListJob());

						// Step 7
						if(TransactionManager.getTranUUID().getUuid().size() > 0) {
							BackendServerComm.startJob(new GenerateSettlementFileJob());
						}
					} catch (Exception e) {
						logger.error("[initComm]Failed to process oct job", e);
					}
				}).start();
				
			}
			// Firmware upgrade is performed and successful
			else if(rwlReturn.getReturnCode() == 100099) {
				if(!this.normal) {
					logger.info("[initComm]Octopus Device status changed: F->S, send alert to server");
					this.normal = true;
					SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_OCT_DEVICE, "F->S"));
				}
			}
			else {
				logger.info("[initComm]Failed to init oct comm");
				if(this.normal) {
					logger.info("[initComm]Octopus Device status changed: S->F, send alert to server");
					this.normal = false;
					SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_OCT_DEVICE, "S->F"));
					healthCheck();
				}
			}
		} catch (Exception e) {
			logger.error("[initComm]Failed to init comm for Octopus:" + e.getMessage(), e);
		}
		
		logger.info("[initComm]Is octopus reader is normal: " + this.normal);
		
		return rwlReturn;
	}
	
	
	/**
	 * Keep trying to call initComm when the octopus card reader is not normal
	 */
	public void healthCheck() {
		if(!isHealthCheckExecuted) {
			new Thread(()->{
				isHealthCheckExecuted = true;
				
				do {
					if (octconfig.getVERSION()== 2){
						this.initComm();
					} else if (octconfig.getVERSION()== 3){
						this.initComm3();
					}
					
					if(!this.normal) {
						logger.info("[healthCheck]Octopus init comm fail, retry after " + HEALTH_CHECK_DURATION_MS + " ms");
						try {
							Thread.sleep(HEALTH_CHECK_DURATION_MS);
						}catch(Exception e) {
							
						}
					}
					
				} while(!this.normal);
				
				isHealthCheckExecuted = false;
			}).start();
		}
	}


	public void setCustomMessageId(String id){
		this.customMessageId = id;
	}

	public void removeMessageId(){
		this.customMessageId = null;
	}

	public void getSchema(){

	}

	/**
	 * For Octopus3 to handle connection lost
	 */
	public void handleLostConnection3(){
		logger.info("[OctopusPayment-handleLostConnection3]Octopus Device status changed: S->F, send alert to server");
		this.normal = false;
		SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_OCT_DEVICE, "S->F"));
		healthCheck();
	}


	public void discountSchemeEnquiry(){
		Logger Octopuslogger = LogManager.getLogger("octopus");
		String enquiryResp = Octopus3Comm.getDiscountScheme();
		if (enquiryResp == null){
			Octopuslogger.info("[OctopusPayment-discountSchemeEnquiry]No response");
			return;
		}

		Gson gson = new Gson();
		try {
			Map enquiryMap = gson.fromJson(enquiryResp, Map.class);

			String result = (String) enquiryMap.get("result");

			if (result != null && result.equals("fail")) {
				// If there is error message -> display the message
				ArrayList<String> errorMessage = (ArrayList) enquiryMap.get("errorMessage");
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctSchemeEnquiryMessage(new OctDiscountSchemeResp(errorMessage.get(0), errorMessage.get(1))));
				return;
			}

			ArrayList<Map> schemes = (ArrayList) enquiryMap.get("schemes");
			if (schemes != null && !schemes.isEmpty()){
				String[][] scheme = new String[schemes.size()][2];
				int count = 0;
				for (Map data : schemes){
					ArrayList<String> schemeDesc = (ArrayList) data.get("schemeDesc");
					scheme[count][0] = schemeDesc.get(0);
					scheme[count][1] = schemeDesc.get(1);
					count += 1;
				}

				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctSchemeEnquiryMessage(new OctDiscountSchemeResp(scheme)));
			}
		} catch	(Exception e){
			Octopuslogger.error("[OctopusPayment-discountSchemeEnquiry]Error in getting Discount scheme:\t\t" + e );
		}

	}

	//Ken Lung: ping Octo3pay
	public void payByOctopus3(BigDecimal price, BigDecimal vipPrice){
		// TODO handle vip and reward

		new Thread(()->{
			int deductAmt = TransactionManager.CURRENT_TX.getPrice().multiply(new BigDecimal(10)).intValueExact();
			logger.info("[OctopusPayment-payByOctopus3]Polling: deductAmt:" + deductAmt);

			Gson gson = new Gson();
			Logger Octopuslogger = LogManager.getLogger("octopus");
			this.stopWaitingPolling = false;
			Double expTime = 0.0;
			String transID;

			// Deduct command
			String deductResp =  Octopus3Comm.deduct(deductAmt);

			// If no response : lost connection with octopus -> end this transaction directly
			// set readerNormal as true -> UI: other error, allow the user to leave the payment page
			if (deductResp == null) {
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(OctMsgResp.lostConnection()));
				handleLostConnection3();
				this.stopWaitingPolling = true;
				return;
			}

			try {
				Map deductMap = gson.fromJson(deductResp, Map.class);
				logger.error("KEN LUNG CHECKING deductMap:" + deductMap.toString());

				String result = (String) deductMap.get("result");

				// If the deduct command fail -> display the error message -> end this transaction directly
				// set readerNormal as true -> UI: other error, allow the user to leave the payment page
				logger.error("KEN LUNG CHECKING result:" + result);
				if (result != null && result.equals("fail")) {
					// If there is error message -> display the message
					ArrayList<String> errorMessage = (ArrayList) deductMap.get("errorMessage");
					UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(OctMsgResp.otherError(errorMessage.get(0), errorMessage.get(1))));
					this.stopWaitingPolling = true;
					return;
				}

				// If ok -> get the transaction ID and the expiry time (in ses)
				transID = (String) deductMap.get("transactionId");
				expTime = (Double) deductMap.get("expiry");

			} catch (Exception e) {
				Octopuslogger.error("[OctopusPayment-payByOctopus3]Error in requestAction:\t\t" + e );
				return;
			}

			// If there is transaction ID -> perform the action

			if (transID != null) {
				// Send the expiry time to UI
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(OctMsgResp.waitingTime(expTime.intValue())));
				long timeout = (long) (System.currentTimeMillis() + expTime * 1000);
				String performResp = "";
				String performRet = "";
				Map performMap;

				do {
					this.retryPoll = null;

					try {
						// Check if the client cancel the transaction
						if (stopWaitingPolling){
							// Try to cancel the transaction
							String cancelResp = Octopus3Comm.cancelAction(transID);

							// If no resp -> lost connection -> allow the client to leave transaction
							if (cancelResp == null){
								handleLostConnection3();
								UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getUnselectProductPaymentResult());
								break;
							}

							String cancelRet;
							Map cancelMap;
							try {
								cancelMap = gson.fromJson(cancelResp, Map.class);
								cancelRet = (String) cancelMap.get("result");
								// If the transaction cancel successfully -> allow the client to leave transaction
								if (cancelRet == null || (cancelRet != null && cancelRet.equals("ok"))){
									UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getUnselectProductPaymentResult());
									break;
								}
							} catch (Exception e) {
								Octopuslogger.error("[OctopusPayment-payByOctopus3]Error in cancelAction:\t\t" + e );
								break;
							}

							// If cannot cancel(by incomplete transaction), client cant leave payment within 20s
							stopWaitingEnquiry = false;
							OctEnquiryMsgResp resp = new OctEnquiryMsgResp("Octopus.IncompleteTx");
							resp.setLockDialog(true);
							UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(resp));
						}

						// Perform deduct action
						performResp = Octopus3Comm.performAction(transID);

						// If no resp -> lost connection
						if (performResp == null) {
							Octopuslogger.info("[OctopusPayment-payByOctopus3]Lost connection with Octopus");
							UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(OctMsgResp.lostConnectionButRetry()));
							handleLostConnection3();

							// Waiting the client choose (the timer lock here)
							while (retryPoll == null) {
								try {
									Thread.sleep(500);
								} catch (Exception e) {

								}
							}

							// If the client chose not to retry
							if (retryPoll == false) {
								Octopuslogger.info("[OctopusPayment-payByOctopus3]The user try to cancel this transaction");
								String cancelResp = Octopus3Comm.cancelAction(transID);

								// If no resp -> still in lost connection status -> allow the client to leave transaction
								if (cancelResp == null) {
									UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getUnselectProductPaymentResult());
									break;
								}

								// If has resp
								String cancelRet;
								Map cancelMap;
								try {
									cancelMap = gson.fromJson(cancelResp, Map.class);
									cancelRet = (String) cancelMap.get("result");
									// If the transaction cancel successfully (it means no tapping occur during disconnection) -> allow the client to leave transaction
									if (cancelRet == null || (cancelRet != null && cancelRet.equals("ok"))) {
										UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getUnselectProductPaymentResult());
										break;
									}
									// If cannot cancel -> the card is tapped already -> not allow the client to leave transaction
									if (cancelRet.equals("fail")) {
										continue;
									}
								} catch (Exception e) {
									Octopuslogger.error("[OctopusPayment-payByOctopus3]Error in cancelAction:\t\t" + e);
									break;
								}
							}
							Octopuslogger.info("[OctopusPayment-payByOctopus3]The client chose to retry this transaction");
							// if the client chose to retry -> restart the timer
							timeout = (long) (System.currentTimeMillis() + expTime * 1000);
							continue;

						}

						performMap = gson.fromJson(performResp, Map.class);
						performRet = (String) performMap.get("result");

						// If the perform command fail
						if (performRet.equals("fail")) {

							// If the retry = false -> the transaction cant be retried
							if (!(boolean) performMap.get("retry")) {
								this.stopWaitingPolling = true;
								break;
							}

							// If there is error message -> display the message
							ArrayList<String> errorMessage = (ArrayList) performMap.get("errorMessage");
							if (errorMessage != null)
								UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(OctMsgResp.retry3(errorMessage.get(0), errorMessage.get(1))));

							// Waiting the client choose (the timer lock here)
							while (retryPoll == null) {
								try {
									Thread.sleep(500);
								}catch(Exception e) {

								}
							}
							// If the client chose not to retry -> end this transaction
							if (retryPoll == false) {
								Octopuslogger.info("[OctopusPayment-payByOctopus3]The client chose not to retry");
								break;
							}
							Octopuslogger.info("[OctopusPayment-payByOctopus3]The client chose to retry");
							// if the client chose to retry -> restart the timer
							timeout = (long) (System.currentTimeMillis() + expTime * 1000);

						} else if (performRet.equals("processing")){
							// If there is error message -> display the message
							ArrayList<String> errorMessage = (ArrayList) performMap.get("errorMessage");
							if (errorMessage != null)
								UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(OctMsgResp.processingError(errorMessage.get(0), errorMessage.get(1))));

						} else if (performRet.equals("ok")){
							// Display custom message
							if (this.customMessageId != null){
								Octopus3Comm.displayCustomMessage(this.customMessageId);
							}

							TransactionManager.CURRENT_TX.setPayStatusCode(TransactionManager.PAYMENT_STATUS_SUCCESS);

							TransactionManager.CURRENT_TX.setStockQty(LocalDataManager.getCellInfoByItemNo(TransactionManager.CURRENT_TX.getItemNo()).getQty()-1);
							TransactionManager.CURRENT_TX.setVmcStatusCode(DatatypeConverter.printHexBinary(new byte[]{(byte)0xFF}));

							TransactionManager.CURRENT_TX.setTranDttmMs(System.currentTimeMillis());
							Octopuslogger.info("[OctopusPayment-payByOctopus3]Transaction Dttm: " + new Date(TransactionManager.CURRENT_TX.getTranDttmMs()));

							TransactionManager.CURRENT_TX.setRemark(DateUtil.formatDateTime(new Date(System.currentTimeMillis()), true));

							TransactionManager.CURRENT_TX.setReceiptNo(LocalDataManager.formatReceiptNo(this.CODE,  LocalDataManager.getOctReceiptNoCurrent()));
							Octopuslogger.info("[OctopusPayment-payByOctopus3]ReceiptNo: " + TransactionManager.CURRENT_TX.getReceiptNo());

							TransactionManager.CURRENT_TX.setOctReceiptNo(LocalDataManager.getOctReceiptNoCurrent(true));
							Octopuslogger.info("[OctopusPayment-payByOctopus3]Oct Receipt No: " + TransactionManager.CURRENT_TX.getOctReceiptNo());

							Map transactionMap = (Map) performMap.get("transactionData");
							Double remainingValue = (Double) transactionMap.get("remainingValue");
							TransactionManager.CURRENT_TX.setRemainingValue(new BigDecimal(remainingValue).divide(new BigDecimal(10)));
							double cardId = (Double) transactionMap.get("cardId");
							int cardIdInt = (int) cardId;
							TransactionManager.CURRENT_TX.setOctCardNo(String.valueOf(cardIdInt));
							Double octopusType = (Double) transactionMap.get("octopusType");
							TransactionManager.CURRENT_TX.setOctCardType(String.valueOf(octopusType.intValue()));
							TransactionManager.CURRENT_TX.setOctDeviceNo((String) transactionMap.get("deviceId"));
							TransactionManager.CURRENT_TX.setOctLavDate((String)transactionMap.get("lastAddValueDate"));
							TransactionManager.CURRENT_TX.setOctLavDeviceNo((String)transactionMap.get("lastAddValueDevice"));
							Double lastAddValueType = (Double) transactionMap.get("lastAddValueType");
							TransactionManager.CURRENT_TX.setOctLavType(lastAddValueType.intValue());
							TransactionManager.CURRENT_TX.setTransactionId(transID);

							ArrayList<String> schemeName = (ArrayList<String>) transactionMap.get("schemeName");
							if (schemeName != null && !schemeName.isEmpty()) {
								Octopuslogger.info("[OctopusPayment-payByOctopus3]There is scheme involved");
								String[] schemeNamesArray = new String[] { schemeName.get(0), schemeName.get(1) };
								TransactionManager.CURRENT_TX.setSchemeName(schemeNamesArray);
								Double discountAmount = (Double) transactionMap.get("discountAmount");
								TransactionManager.CURRENT_TX.setDiscount(new BigDecimal(discountAmount).divide(new BigDecimal(10)));
								Double transactionValue = (Double) transactionMap.get("transactionValue");
								TransactionManager.CURRENT_TX.setAmount(new BigDecimal(transactionValue).divide(new BigDecimal(10))) ;
							}


							ArrayList<Map> printDataObject = (ArrayList) performMap.get("printData");
							if (printDataObject != null && !printDataObject.isEmpty()){
								Octopuslogger.info("[OctopusPayment-payByOctopus3]There is print data");
								String eng = "";
								String chi = "";
								for (Map data : printDataObject){
									String type = (String) data.get("type");
									if (!type.equals("line")) continue;
									ArrayList<String> values = (ArrayList) data.get("values");
									eng += values.get(0) + "<br>";
									chi += values.get(1) + "<br>";
								}
								paySuccess(eng, chi);
							} else {
								paySuccess();
							}
						}

					} catch (Exception e) {
						Octopuslogger.error("[OctopusPayment-payByOctopus3]Error in performAction:\t\t" + e );
						return;
					}
				} while (timeout - 2000 >= System.currentTimeMillis() && performRet != null && (performRet.equals("processing") || performRet.equals("fail")));

			}

		}).start();


	}

	//Ken Lung: ping pay
	@Override
	public synchronized void pay(BigDecimal price, BigDecimal vipPrice) {
		if (octconfig.getVERSION()== 3){
			this.payByOctopus3(price, vipPrice);
			return;
		}
		this.stopWaitingPolling = false;

		new Thread(()->{
			
			long timeout = System.currentTimeMillis() + this.POLL_TIMEOUT_MS;	// The duration waiting poll
			int count = 0;
			int deductAmt = TransactionManager.CURRENT_TX.getPrice().multiply(new BigDecimal(10)).intValueExact();
			RewardConfigInfo rewardConfig = LocalDataManager.getVmInfo().getCurrentRewardConfig();
			String cardNo = null;
			RwlReturn rwlReturn = null;
			
			PollDeductReturn res = new PollDeductReturn(deductAmt);
			
			boolean incompleteTransaction = false;
			long incompleteTime =0 ;
			
			do {
				logger.info("[OctopusPayment-pay]Polling:" + (++count) + ", deductAmt:" + deductAmt);
				rwlReturn = OctopusComm.poll();
				
				// If there is error
				if (rwlReturn.getReturnCode() > 100000) {
					if(rwlReturn.getReturnCode() != 100032) {
						// If lose connection with octopus card reader -> Reconnect Reader 
						if(rwlReturn.getReturnCode() == 100001 || rwlReturn.getReturnCode() == 100005) {
							logger.info("[OctopusPayment-pay]Octopus Device status changed: S->F, send alert to server");
							UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(new OctMsgResp(rwlReturn.getReturnCode(), cardNo, true, false)));
							this.normal = false;
							SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_OCT_DEVICE, "S->F"));
							healthCheck();
							break;
						}
						
						// UI shows the error code
						UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(new OctMsgResp(rwlReturn.getReturnCode(), cardNo, true)));
						
					// If error code = 100032 (not card detected) and the transaction was incomplete before (100022 occurred)
					} else if (rwlReturn.getReturnCode() == 100032 && incompleteTransaction) {
						// If within 25 s, UI show the error code
						if ( System.currentTimeMillis() < (incompleteTime + this.ERROR_100022_TIMEOUT_MS)) {
							UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(new OctMsgResp(rwlReturn.getReturnCode(), cardNo, true)));
						// If not -> reset
						} else {
							incompleteTransaction = false;
							incompleteTime =0;
						}
					}
				// If no error
				} else {
					res.setPollReturn(rwlReturn);
					PollData pollData = (PollData) rwlReturn.getReturnData();
					pollData.processData();
					logger.info("[OctopusPayment-pay]Card No.:" + pollData.getCardId() + ", Acc Balance:" + rwlReturn.getReturnCode());
				
					TransactionManager.CURRENT_TX.setOctCardNo(pollData.getCardId());
					
					// get PollData customer data for more info;
					String[] customerInfoSplit = pollData.getCustomerInfo().split("-");
					String cardType;

					if(customerInfoSplit.length == 5){	
						cardType = customerInfoSplit[0];
//						TransactionManager.CURRENT_TX.setCardType(cardType);
						TransactionManager.CURRENT_TX.setOctCardType(cardType);
					} 

					// If there is vip price for this card and the vip price == 0
					if(vipPrice != null && this.isValidCard(pollData.getCardId()) && vipPrice.compareTo(BigDecimal.ZERO) == 0) {
						logger.info("[OctopusPayment-pay]This card vip price of 0");
						TransactionManager.CURRENT_TX.setPrice(vipPrice);
						TransactionManager.CURRENT_TX.setAmount(vipPrice);
						TransactionManager.CURRENT_TX.setTranDttmMs(System.currentTimeMillis());
						TransactionManager.CURRENT_TX.setRemark(DateUtil.formatDateTime(new Date(System.currentTimeMillis()), true));
						
						TransactionManager.CURRENT_TX.setPayStatusCode(TransactionManager.PAYMENT_STATUS_SUCCESS);
						TransactionManager.CURRENT_TX.setOctDeviceNo(OctopusComm.getDeviceNo());
						TransactionManager.CURRENT_TX.setRemainingValue(new BigDecimal(rwlReturn.getReturnCode()).divide(new BigDecimal(10)));

						TransactionManager.CURRENT_TX.setStockQty(LocalDataManager.getCellInfoByItemNo(TransactionManager.CURRENT_TX.getItemNo()).getQty() -1);
						TransactionManager.CURRENT_TX.setVmcStatusCode(DatatypeConverter.printHexBinary(new byte[]{(byte)0xFF}));

						TransactionManager.IS_TRAN_SUCCESS = true;
						paySuccess();
						break;
					}
					
					OctTranRecord record = LocalDataManager.getOctTranRecordByCardNo(TransactionManager.CURRENT_TX.getOctCardNo());
					
					// If this card enjoy reward (N give 1)
					if(rewardConfig != null && record != null && record.getTranDttms().size() == rewardConfig.getQtyX()) {
						logger.info("[OctopusPayment-pay]This card enjoy reward");
						TransactionManager.CURRENT_TX.setPrice(BigDecimal.ZERO);
						TransactionManager.CURRENT_TX.setAmount(BigDecimal.ZERO);
						TransactionManager.CURRENT_TX.setTranDttmMs(System.currentTimeMillis());
						TransactionManager.CURRENT_TX.setRemark(DateUtil.formatDateTime(new Date(System.currentTimeMillis()), true));

						TransactionManager.CURRENT_TX.setTranTypeId(TransactionManager.TRAN_TYPE_REWARD);
						TransactionManager.CURRENT_TX.setPayStatusCode(TransactionManager.PAYMENT_STATUS_SUCCESS);
						TransactionManager.CURRENT_TX.setOctDeviceNo(OctopusComm.getDeviceNo());
						TransactionManager.CURRENT_TX.setRemainingValue(new BigDecimal(rwlReturn.getReturnCode()).divide(new BigDecimal(10)));

						TransactionManager.CURRENT_TX.setStockQty(LocalDataManager.getCellInfoByItemNo(TransactionManager.CURRENT_TX.getItemNo()).getQty() -1);
						TransactionManager.CURRENT_TX.setVmcStatusCode(DatatypeConverter.printHexBinary(new byte[]{(byte)0xFF}));

						// Clear all the record of this card
						record.getTranDttms().clear();
						ResourceManager.saveInfo(LocalDataManager.getOctTranHistory(), ResourceManager.INFO_OCT_TRAN_HISTORY);

						TransactionManager.IS_TRAN_SUCCESS = true;
						paySuccess();
						break;
					}
					
					if(!TransactionManager.IS_TRAN_SUCCESS) {
						// If it is the first time to detect the card or The previous card detected == current card detected -> Deduct amount from the card
						if((cardNo == null || pollData.getCardId().equals(cardNo)) && (deductAmt > 0)) {
							logger.info("[OctopusPayment-pay]Deduct Amt:" + deductAmt + ", returnCode:" + rwlReturn.getReturnCode());

							// If there is vip price
							if(vipPrice != null && this.isValidCard(pollData.getCardId())) {
								logger.info("[OctopusPayment-pay]This card enjoy vip price of "+vipPrice);
								deductAmt = vipPrice.multiply(new BigDecimal(10)).intValueExact();
								res.setDeductAmt(deductAmt);
								TransactionManager.CURRENT_TX.setPrice(vipPrice);
							}

							// Deduct amount
							rwlReturn = OctopusComm.deduct(deductAmt, String.format("%04d", LocalDataManager.getOctReceiptNoCurrent()), pollData.getCardId());
							
							// If there is error when deducting amount
							if(rwlReturn.getReturnCode() > 100000) {
								
								// If the octopus card reader lose connection
								if(rwlReturn.getReturnCode() == 100001 || rwlReturn.getReturnCode() == 100005) {
									OctopusComm.initComm(this.port, this.baud, this.controllerId);
								}
								
								OctMsgResp resp = new OctMsgResp(rwlReturn.getReturnCode(), cardNo, true);
								
								// Incomplete Transaction Error (Occurs when a customer pulls out the card too quickly)
								if(rwlReturn.getReturnCode() == 100022 || rwlReturn.getReturnCode() == 100025) {
									logger.info("[OctopusPayment-pay]Incomplete Transaction.");
									logger.info("[OctopusPayment-pay]Lock all dialog until complete transaction or timeout.");
									
									incompleteTransaction = true;
									incompleteTime = System.currentTimeMillis();
									
									// Set the card no 
									cardNo = pollData.getCardId();
									
									// If the remaining waiting time is less than 25 s -> increase the timeout by 25 s and reset the countdown in UI
									if(timeout - System.currentTimeMillis() < this.ERROR_100022_TIMEOUT_MS) {
										timeout += this.ERROR_100022_TIMEOUT_MS;
										resp.setResetCountdown(true);
									}
									
									// Lock the dialog again
									resp.setLockDialog(true);
								}
								
								UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(resp));

							// If no error
							} else {
								TransactionManager.CURRENT_TX.setTranDttmMs(System.currentTimeMillis());
								logger.info("[OctopusPayment-pay]Transaction Dttm: " + new Date(TransactionManager.CURRENT_TX.getTranDttmMs()));
								
								TransactionManager.CURRENT_TX.setRemark(DateUtil.formatDateTime(new Date(System.currentTimeMillis()), true));
								
								TransactionManager.CURRENT_TX.setReceiptNo(LocalDataManager.formatReceiptNo(this.CODE,  LocalDataManager.getOctReceiptNoCurrent()));
								logger.info("[OctopusPayment-pay]ReceiptNo: " + TransactionManager.CURRENT_TX.getReceiptNo());
								
								TransactionManager.CURRENT_TX.setOctReceiptNo(LocalDataManager.getOctReceiptNoCurrent(true));
								logger.info("[OctopusPayment-pay]Oct Receipt No: " + TransactionManager.CURRENT_TX.getOctReceiptNo());
								
								TransactionManager.CURRENT_TX.setRemainingValue(new BigDecimal(rwlReturn.getReturnCode()).divide(new BigDecimal(10)));
								TransactionManager.CURRENT_TX.setPayStatusCode(TransactionManager.PAYMENT_STATUS_SUCCESS);
								TransactionManager.CURRENT_TX.setOctDeviceNo(OctopusComm.getDeviceNo());

								TransactionManager.CURRENT_TX.setStockQty(LocalDataManager.getCellInfoByItemNo(TransactionManager.CURRENT_TX.getItemNo()).getQty()-1);
								TransactionManager.CURRENT_TX.setVmcStatusCode(DatatypeConverter.printHexBinary(new byte[]{(byte)0xFF}));
								
								res.setDeductReturn(rwlReturn);
								
								rwlReturn = OctopusComm.getExtraInfo();
								if(rwlReturn.getReturnCode() <= 100000) {
									res.setExtraInfoReturn(rwlReturn);
									
									ExtraInfoData data = (ExtraInfoData) rwlReturn.getReturnData();
									data.processData();
									
									TransactionManager.CURRENT_TX.setOctLavDate(data.getLastAddValueDate());
									TransactionManager.CURRENT_TX.setOctLavDeviceNo(data.getLastAddValueDeviceId());
									logger.info("[OctopusPayment-pay]Last add value type: " + Integer.valueOf(data.getLastAddValueType()));
									TransactionManager.CURRENT_TX.setOctLavType(Integer.valueOf(data.getLastAddValueType()));
									logger.info("[OctopusPayment-pay]This add value type " + TransactionManager.CURRENT_TX.getOctLavType());
								}

								// Add this transaction into reward record
								if(rewardConfig != null) {
									OctTranRecord cardRecord = LocalDataManager.getOctTranRecordByCardNo(TransactionManager.CURRENT_TX.getOctCardNo());
									if(cardRecord == null) {
										cardRecord = new OctTranRecord(TransactionManager.CURRENT_TX.getOctCardNo());
										LocalDataManager.getOctTranHistory().getRecords().add(cardRecord);
									}
									
									cardRecord.getTranDttms().add(TransactionManager.CURRENT_TX.getTranDttmMs());
									ResourceManager.saveInfo(LocalDataManager.getOctTranHistory(), ResourceManager.INFO_OCT_TRAN_HISTORY);
								}
								
								TransactionManager.IS_TRAN_SUCCESS = true;
								paySuccess(); 
							}
						
						}else {
							UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctMessage(OctMsgResp.retry(cardNo, true)));
						}
					}
					
				}
				
			}while (!TransactionManager.IS_TRAN_SUCCESS && timeout - 2000 >= System.currentTimeMillis() && !this.stopWaitingPolling);

			if (this.stopWaitingPolling){
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getUnselectProductPaymentResult());
			}

			if(timeout - 2000 >= System.currentTimeMillis() && !TransactionManager.IS_TRAN_SUCCESS) {
				OctopusComm.logger.info("[OctopusPayment-pay]Cancel payment by user");
			}else {
				OctopusComm.logger.info("[OctopusPayment-pay]Payment timeout");
			}
			
		}).start();
		
	}

	private boolean isValidCard(String cardNo) {
		if(LocalDataManager.getVmInfo().getRfids() != null) {
			for(int i = 0; i < LocalDataManager.getVmInfo().getRfids().size(); i++)  {
				RFIDInfo info = LocalDataManager.getVmInfo().getRfids().get(i);
				if(info.getCardNo().equals(cardNo) && info.getEffDate() < System.currentTimeMillis() && info.getExpDate() >= System.currentTimeMillis()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void paySuccess() {
		logger.info("[OctopusPayment-paySuccess]User pay by octopus successfully");
		TransactionManager.addTran(TransactionManager.CURRENT_TX);
		
		if(TransactionManager.CURRENT_TX.getTranTypeId() == TransactionManager.TRAN_TYPE_SALE || TransactionManager.CURRENT_TX.getTranTypeId() == TransactionManager.TRAN_TYPE_REWARD) {
			// UI show the receipt
			UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getTranCompleteResult(new TranCompleteResp(TransactionManager.CURRENT_TX)));

			// Vend the product
			LocalServer.getVmc().vendProduct();

			// Send the transaction
			TransactionManager.sendTran();
		}
	}
	public void paySuccess(String printDataEng, String printDataChi) {
		logger.info("[OctopusPayment-paySuccess with printData]User pay by octopus successfully");
		TransactionManager.addTran(TransactionManager.CURRENT_TX);

		if(TransactionManager.CURRENT_TX.getTranTypeId() == TransactionManager.TRAN_TYPE_SALE || TransactionManager.CURRENT_TX.getTranTypeId() == TransactionManager.TRAN_TYPE_REWARD) {
			// UI show the receipt
			UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getTranCompleteResult(new TranCompleteResp(TransactionManager.CURRENT_TX, printDataEng, printDataChi)));

			// Vend the product
			LocalServer.getVmc().vendProduct();

			// Send the transaction
			TransactionManager.sendTran();
		}
	}

	@Override
	public void payFail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void payCancel() {
		// If stopWaitingPolling is true already
		if (this.stopWaitingPolling){
			UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getUnselectProductPaymentResult());
		}
		this.stopWaitingPolling = true;

	}

	@Override
	public void continuePayment() {
		logger.info("[continuePayment]Continue pay / enquiry by octopus");
		this.retryPoll = true;
	}

	@Override
	public void stopPayment() {
		this.retryPoll = false;
	}


	public void changeVersion(int version) {
		octconfig.setVERSION(version);

		logger.info("[changeVersion]Change Octopus Version now");

		this.normal = true;

		if (octconfig.getVERSION()== 2){
			this.initComm();
		} else if (octconfig.getVERSION()== 3){
			this.initComm3();
		}
	}

	public void cancelEnquiry(){
		// If true already
		if (this.stopWaitingEnquiry == true){
			UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctCancelEnquiryResult());
		}
		this.stopWaitingEnquiry = true;
	}

	// TODO update here
	public void enquiry3(){

		new Thread(()->{
			logger.info("[enquiry3]Start to enquiry tran history");

			Gson gson = new Gson();
			Logger Octopuslogger = LogManager.getLogger("octopus");
			this.stopWaitingEnquiry = false;
			Double expTime = 0.0;
			String transID;

			String enquiryResp =  Octopus3Comm.cardEnquiry();

			// If no response : lost connection with octopus
			if (enquiryResp == null) {
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(new OctEnquiryMsgResp("Octopus.Error")));
				handleLostConnection3();
				this.stopWaitingEnquiry = true;
				return;
			}

			try {
				Map enquiryMap = gson.fromJson(enquiryResp, Map.class);
				Octopuslogger.info("trans.request enquiry return:\t\t" + enquiryMap );

				String result = (String) enquiryMap.get("result");

				// If the enquiry command fail -> display the error message
				if (result != null && result.equals("fail")) {
					ArrayList<String> errorMessage = (ArrayList) enquiryMap.get("errorMessage");
					UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(new OctEnquiryMsgResp( errorMessage.get(0), errorMessage.get(1))));
					this.stopWaitingEnquiry = true;
					return;
				}

				// If ok -> get the transaction ID and the expiry time (in ses)
				transID = (String) enquiryMap.get("transactionId");
				expTime = (Double) enquiryMap.get("expiry");

			} catch (Exception e) {
				logger.error("[enquiry3]Error in requestAction:\t\t" + e );
				return;
			}

			// If there is transaction ID -> perform the action
			if (transID != null) {
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(new OctEnquiryMsgResp("Octopus.ViewHistory")));

				long timeout = (long) (System.currentTimeMillis() + expTime * 1000);

				String performResp = "";
				String performRet = "";
				Map performMap;

				do {
					this.retryPoll = null;

					try {
						// Check if the client cancel the transaction
						if (stopWaitingEnquiry){
							// Try to cancel the enquiry
							String cancelResp = Octopus3Comm.cancelAction(transID);

							// If no resp -> lost connection
							if (cancelResp == null){
								handleLostConnection3();
								UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctCancelEnquiryResult());
								break;
							}

							String cancelRet;
							Map cancelMap;
							try {
								cancelMap = gson.fromJson(cancelResp, Map.class);
								Octopuslogger.info("trans.cancel return:\t\t" + cancelMap );
								cancelRet = (String) cancelMap.get("result");
								// If the enquiry cancel successfully -> end this transaction
								if (cancelRet == null || (cancelRet != null && cancelRet.equals("ok"))){
									UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctCancelEnquiryResult());
									break;
								}
							} catch (Exception e) {
								logger.error("[enquiry3]Error in cancelAction:\t\t" + e );
								break;
							}

							// If cannot cancel(by incomplete transaction), client cant leave payment within 20s
							stopWaitingEnquiry = false;
							OctEnquiryMsgResp resp = new OctEnquiryMsgResp("Octopus.IncompleteTx");
							resp.setLockDialog(true);
							UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(resp));
						}

						// Perform deduct action
						performResp = Octopus3Comm.performAction(transID);

						// If no resp -> lost connection
						if (performResp == null) {
							UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(new OctEnquiryMsgResp("Octopus.Error")));
							handleLostConnection3();
							break;
						}

						performMap = gson.fromJson(performResp, Map.class);
						Octopuslogger.info("trans.perform return:\t\t" + performMap );
						performRet = (String) performMap.get("result");

						// If the perform command fail
						if (performRet.equals("fail")) {

							// If the retry = false -> the enquiry cant be retried
							if (!(boolean) performMap.get("retry"))
								break;

							// If there is error message -> display the message
							ArrayList errorMessage = (ArrayList) performMap.get("errorMessage");
							if (errorMessage != null)
								UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(OctEnquiryMsgResp.retry3(errorMessage.toString())));


							// Waiting the client choose (the timer lock here)
							while (retryPoll == null) {
								try {
									Thread.sleep(500);
								}catch(Exception e) {

								}
							}
							// If the client chose not to retry -> end this transaction
							if (retryPoll == false) {
								logger.info("[enquiry3]The client chose not to retry");
								break;
							}
							logger.info("[enquiry3]The client chose to retry");
							// if the client chose to retry -> restart the timer
							timeout = (long) (System.currentTimeMillis() + expTime * 1000);
							continue;
						}

						// The transaction succeed
						if (performRet.equals("ok")){
							ReturnResult res = ReturnResult.newSuccessInstance("OCT_ENQUIRY");
							OctEnquiryResp resp = new OctEnquiryResp();

							Map transactionMap = (Map) performMap.get("transactionData");
							double cardId = (Double) transactionMap.get("cardId");
							int cardIdInt = (int) cardId;
							resp.setCardID(String.valueOf(cardIdInt));

							Double octopusType = (Double) transactionMap.get("octopusType");
							resp.setCardType(String.valueOf(octopusType.intValue()));

							Double remainingValue = (Double) transactionMap.get("remainingValue");
							resp.setRemainingValue(new BigDecimal(remainingValue).divide(new BigDecimal(10)));

							String currentDeviceId = (String) transactionMap.get("deviceId");

							ArrayList transactionLogs = (ArrayList) performMap.get("transactionLogs");
							if (!transactionLogs.isEmpty()){
								for (int i = 0; i< transactionLogs.size(); i++){
									OctEnquiryHistory history = new OctEnquiryHistory();

									Map recordMap = (Map)transactionLogs.get(i);
									Double amount = (Double)recordMap.get("amount")/10;
									// Using NumberFormat
									NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
									String formatted = formatter.format(amount);
									history.setAmount(formatted);

									history.setTranDttm((String) recordMap.get("date") + " " +(String) recordMap.get("time") );
									String deviceId = (String) recordMap.get("machineId");
									history.setSameDevice(currentDeviceId != null && currentDeviceId.contains(deviceId));
									history.setDevId(deviceId);

									resp.getHistorys().add(history);
								}
							}

							res.setDataObj(resp);
							UIWebSocketEndpoint.pushMessage(res);
							break;
						}

					} catch (Exception e) {
						logger.error("[enquiry3]Error in performAction:\t\t" + e );
						return;
					}
				} while (timeout - 2000 >= System.currentTimeMillis() && performRet != null && (performRet.equals("processing") || performRet.equals("fail")));

			}

		}).start();
	}

	public void enquiry(){
		if (octconfig.getVERSION()== 3){
			this.enquiry3();
			return;
		}

		this.stopWaitingEnquiry = false;

		new Thread(()->{
			logger.info("[enquiry]Start to enquiry tran history");

			if(!this.normal) {
				initComm();
			}

			UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(new OctEnquiryMsgResp("Octopus.ViewHistory")));

			try {
				long timeout = System.currentTimeMillis() + this.POLL_TIMEOUT_MS;
				RwlReturn rwlReturn = null;

				do {
					rwlReturn = OctopusComm.poll((char)2, (char)10);
					if (rwlReturn.getReturnCode() > 100000) {
						logger.info("[enquiry]Failed to enquiry, ErrCode: " + rwlReturn.getReturnCode());
						if(rwlReturn.getReturnCode() != 100032) {
							UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(new OctEnquiryMsgResp(rwlReturn.getReturnCode())));
						}

						if(rwlReturn.getReturnCode() == 100001 || rwlReturn.getReturnCode() == 100005) {
							rwlReturn = initComm();
						}
					}
					else {

						logger.info("[enquiry]Enquiry Success.");

						PollData pollData = (PollData) rwlReturn.getReturnData();
						pollData.processData();

						String[] customerInfoSplit = pollData.getCustomerInfo().split("-");
						String cardType = null;
						if(customerInfoSplit.length == 5){
							cardType = customerInfoSplit[0];
						}

						BigDecimal rv = new BigDecimal(rwlReturn.getReturnCode()).divide(new BigDecimal(10));
						logger.info("[enquiry]Card No.:" + pollData.getCardId() +"Card Type: "+ cardType + ", Acc Balance: " + DECIMAL_FORMAT.format(rv));

						ReturnResult res = ReturnResult.newSuccessInstance("OCT_ENQUIRY");
						res.setDataObj(showTransHist(pollData, rv, cardType));

						UIWebSocketEndpoint.pushMessage(res);
						break;
					}
				}
				while(timeout > System.currentTimeMillis() && !stopWaitingEnquiry);

				if (this.stopWaitingEnquiry){
					UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctCancelEnquiryResult());
				}


			} catch(Throwable e) {
				logger.error("[enquiry]Failed to enquiry tran history:", e);
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getOctEnquiryMessage(new OctEnquiryMsgResp("ERR40001")));
			}
		}).start();
	}

	private OctEnquiryResp showTransHist(PollData pd, BigDecimal rv, String cardType) {
		OctEnquiryResp resp = new OctEnquiryResp();

		String[] customerInfoSplit = pd.getCustomerInfo().split("-");

		resp.setCardID(pd.getCardId());
		resp.setCardType(cardType);
		resp.setRemainingValue(rv);

		String tran = pd.getTransactions();
		if(!StringUtil.isEmpty(tran)) {
			String[] trans = tran.split(",");

			//show last 4 trans only
			//[Card Log n] = <SP Type>,<Transaction Amt>,<Transaction Time >,<Machine ID>,<Service Info>
			int noOfTrans = trans.length / 5;
			noOfTrans = Math.min(noOfTrans, 4);

			if(noOfTrans > 0) {
				String devId;
				String currentDeviceId = Integer.toHexString(OctopusComm.getTimeVerData().getDevID()).toUpperCase();

				for(int i = 0; i < noOfTrans; i ++) {
					OctEnquiryHistory history = new OctEnquiryHistory();
					history.setAmount(OctopusComm.getTransactionAmount(trans[1 + (i * 5)]));
					history.setTranDttm(OctopusComm.getTransactionDateTime(trans[2 + (i * 5)]));

					try {
						devId= Integer.toHexString(Integer.parseInt(trans[3 + (i * 5)])).toUpperCase();
					} catch (Exception e) {
						devId = trans[3 + (i * 5)];
						logger.error("[showTransHist]Failed to decode device ID!", e);
					}
					history.setSameDevice(currentDeviceId!= null && currentDeviceId.indexOf(devId) != -1);
					history.setDevId(devId);

					resp.getHistorys().add(history);
				}
			}
		}

		return resp;
	}

	public void settle3(){
		try {
			while (TransactionManager.IS_TRAN_PROCESS){
				Thread.sleep(1000);
			}
		} catch ( InterruptedException e) {

		}


		String settleResp = Octopus3Comm.settle();

		// If no response : lost connection with octopus
		if (settleResp == null) {
			return;
		}

		Gson gson = new Gson();
		Logger Octopuslogger = LogManager.getLogger("octopus");
		String transID;

		try {
			Map settleMap = gson.fromJson(settleResp, Map.class);
			Octopuslogger.info("trans.request settle return:\t\t" + settleMap );

			String result = (String) settleMap.get("result");
			if (result != null && result.equals("fail")) return;

			transID = (String) settleMap.get("transactionId");

		} catch (Exception e) {
			Octopuslogger.error("Error in requestAction:\t\t" + e );
			return;
		}

		// If there is transaction ID -> perform the action
		if (transID != null) {
			String performResp = "";
			String performRet = "";
			Map performMap;

			do {
				performResp = Octopus3Comm.performAction(transID);
				if (performResp == null) break;

				performMap = gson.fromJson(performResp, Map.class);
				Octopuslogger.info("trans.perform return:\t\t" + performMap );
				performRet = (String) performMap.get("result");

				if (performRet.equals("fail")) break;

				if (performRet.equals("ok")){
					String upgrade = (String) performMap.get("upgrade");
					if (upgrade == null) break;
					if (upgrade.equals("os")){
						this.normal = false;
						try {
							Thread.sleep(600000);
							Octopus3Comm.getConfig();
							healthCheck();
						} catch ( InterruptedException e) {

						}

					}else if (upgrade.equals("firmware")){
						this.normal = false;
						try {
							Thread.sleep(120000);
							Octopus3Comm.getConfig();
							healthCheck();
						} catch ( InterruptedException e) {

						}
					}
				}

			} while(performRet.equals("processing") );

		}

	}
}
