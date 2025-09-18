package com.cmt.vending.server.operation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.cmt.octopus.RwlAdapter;
import com.cmt.octopus.RwlReturn;
import com.cmt.octopus.TimeVerData;

import com.cmt.vending.util.ReceiptUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OctopusComm {
	public static final Logger logger = LogManager.getLogger("octopus");
	
	public static boolean isOctNormal = true;
	
	private static RwlAdapter adapter = null;
	
	public static final int V_BLANK = -30000;
	public static final int V_DASH = -30001;

	public static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static final DecimalFormat AMOUNT_FORMAT = new DecimalFormat("#0.0");


	private static TimeVerData timeVerData;
	
	public static String DEVICE_NO = "";
	
	
	public static synchronized RwlAdapter getAdapter() {
		if(adapter == null) {
			logger.info("Init RwlAdapter.");
			adapter = new RwlAdapter();
		}
		
		return adapter;
	}
	
	public static String getDeviceNo(){
		return DEVICE_NO;
	}

	
	/**
	 * Perform daily task including firmware upgrade if any (according documentation)
	 * @return
	 */
	public static synchronized RwlReturn HouseKeeping() {		
		if(isOctNormal) {
			RwlReturn returnObj = new RwlReturn();
			returnObj = getAdapter().HouseKeeping();
			logger.info("HouseKeeping Return:\t\t" + returnObj.getReturnCode());
			return returnObj;
		}
		else {
			logger.info("Octopus not normal. HouseKeeping ignored");
			return null;
		}
	}
	
	
	/**
	 * Initiate communication with R/W
	 * @param port
	 * @param baud
	 * @param controllerId
	 * @return
	 */
	public static synchronized RwlReturn initComm(int port, int baud, int controllerId) {
		RwlReturn rwlReturn = getAdapter().InitComm(port, baud, controllerId);
		logger.info("InitComm Call:\t\t" + port + "," + baud + "," + controllerId);
		if(rwlReturn.getReturnCode() == 0) {
			// If initialization succeed -> play a normal tone and display green light
			playNormalToneOctopus();
			timeVer();
			isOctNormal = true;
		} else if(rwlReturn.getReturnCode() == 100099) {
			logger.info("Octopus Card Reader Firmware upgraded successfully!");
			isOctNormal = true;
		} else {
			isOctNormal = false;
		}
		logger.info("InitComm Return:\t\t" + rwlReturn.getReturnCode());
		
		return rwlReturn;
	}
	
	/**
	 * Retrieve hardware information from R/W
	 * @return
	 */
	public static synchronized RwlReturn timeVer() {
		RwlReturn returnObj = new RwlReturn();
		logger.info("TimeVer Call");
		returnObj = getAdapter().TimeVer();
		if (returnObj.getReturnCode() < 100000) {
			TimeVerData data = (TimeVerData) returnObj.getReturnData();
			String octDevID = Integer.toHexString(data.getDevID()).toUpperCase();
			logger.info("TimeVer Return:\t\t" + returnObj.getReturnCode() + ", Dev ID:" + octDevID + "," + data.getDevTime() + ","
					+ data.getFIRMVer() + "," + data.getBLVer() + "," + data.getIntBLVer());
			DEVICE_NO = octDevID;
			timeVerData = data;
			
		} else {
			DEVICE_NO = "";
			logger.info("TimeVer Return:\t\t" + returnObj.getReturnCode());
		}
		return returnObj;
	}
	
	/**
	 * Generate MPS file
	 * @return
	 */
	public static synchronized RwlReturn xFile() {
		logger.info("XFile Call");
		RwlReturn rwlReturn = getAdapter().XFile();
		logger.info("XFile Return:\t\t" + rwlReturn.getReturnCode() + "\tFile Name:" + rwlReturn.getReturnData());
		return rwlReturn;
	}
	
	/**
	 * Play normal tone and display 8 dashes
	 */
	public static synchronized void playNormalToneOctopus() {
		TxnAmt(V_DASH, V_DASH, (char)2, (char)1);
	}
	public static synchronized RwlReturn TxnAmt(int v, int rv, char led, char sound) {
		RwlReturn returnObj = new RwlReturn();	
		logger.info("TxnAmt Call:\t\t" + v + "," + rv + "," + ((int) led) + "," + ((int) sound));
		returnObj = getAdapter().TxnAmt(v, rv, led, sound);
		logger.info("TxnAmt Return:\t\t" + returnObj.getReturnCode());
		return returnObj;
	}
	
	
	/**
	 * Poll card (detect card)
	 * @return
	 */
	public static synchronized RwlReturn poll() {
		return poll((char)0, (char)10);
	}
	public static synchronized RwlReturn poll(char subCom, char timeout) {
		logger.info("Poll Call:\t\t" + ((int) subCom) + "," + ((int) timeout));
		RwlReturn rwlReturn = getAdapter().Poll(subCom, timeout);
		logger.info("Poll Return:\t\t" + rwlReturn.getReturnCode() + "\tPoll Data:" + rwlReturn.getReturnData());
		
		return rwlReturn;
	}
	
	/**
	 * Deduct amount from the card
	 * @param amt
	 * @param receiptNoStr
	 * @param cardId
	 * @return
	 */
	public static synchronized RwlReturn deduct(int amt, String receiptNoStr, String cardId) {
		int defer = 0;
		int receiptNo = ReceiptUtil.getReceiptNoInt(receiptNoStr);
		int receiptNoA = (receiptNo % 10000 / 100);
		int receiptNoB = (receiptNo % 100);
		String AIString = String.format("%d,%d,0,0,0,%d,%d", receiptNoA, receiptNoB, receiptNoA, receiptNoB);
		
		logger.info("Deduct Call:\t\t" + amt + ",[" + AIString + "]," + defer);
		RwlReturn rwlReturn = getAdapter().Deduct(amt, receiptNoA, receiptNoB, defer);
		if (rwlReturn.getReturnCode() < 100000) {
			rwlReturn.setReturnData(new Date());	//deduct datetime
			logger.info("Deduct Return:\t\t" + cardId + "," + receiptNoStr + "," + amt + "," + rwlReturn.getReturnCode());
		}
		else {
			logger.info("Deduct Return:\t\t" + rwlReturn.getReturnCode());
		}
		
		return rwlReturn;
	}
	
	
	public static synchronized RwlReturn getExtraInfo() {
		return getExtraInfo((char)0, (char)1);
	}
	public static synchronized RwlReturn getExtraInfo(char uiCom, char uiParam) {
		logger.info("GetExtraInfo Call:\t\t" + ((int) uiCom) + "," + ((int) uiParam));
		RwlReturn rwlReturn = getAdapter().GetExtraInfo(uiCom, uiParam);
		logger.info("GetExtraInfo Return:\t\t" + rwlReturn.getReturnCode() + "\tResult:" + rwlReturn.getReturnData());
		return rwlReturn;
	}

	public static TimeVerData getTimeVerData() {
		return timeVerData;
	}

	public static String getTransactionAmount(String amt) {
		try {
			BigDecimal dec = new BigDecimal(amt);
			dec = dec.divide(new BigDecimal(10), MathContext.DECIMAL32);
			String amtFormat = AMOUNT_FORMAT.format(dec);

			int diff = dec.compareTo(BigDecimal.ZERO);
			if(diff == 0) {
				return "$" + amtFormat;
			}
			else if(diff > 0) {
				return "+$" + amtFormat;
			}
			else {
				return "-$" + amtFormat.replaceFirst("-", "");
			}
		} catch (Exception e) {
			logger.error("Failed to decode amount!", e);
			return amt;
		}
	}
	public static String getTransactionDateTime(String timeInSecSince2000) {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.set(2000, 0, 1, 0, 0, 0);
		logger.debug(DATETIME_FORMAT.format(cal.getTime()));

		try {
			cal.add(Calendar.SECOND, Integer.parseInt(timeInSecSince2000));
			return DATETIME_FORMAT.format(cal.getTime());
		} catch (Exception e) {
			logger.error("Failed to decode datetime!", e);
			return timeInSecSince2000;
		}
	}

}
	

	

