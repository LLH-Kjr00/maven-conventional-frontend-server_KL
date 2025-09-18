package com.cmt.vending.server.vmc.jy;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.config.VmcConfig;
import com.cmt.vending.server.job.SendAlertJob;
import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.vmc.AbstractVmc;
import com.cmt.vending.ui.response.VendWaitingWashMachineFailResp;
import com.cmt.vending.ui.response.VendWaitingWashMachineResp;
import com.cmt.vending.ui.response.VendWaitingWashMachineSuccessResp;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.BitSet;
import java.util.TooManyListenersException;

public class JyApiOne extends AbstractVmc implements SerialPortEventListener, Runnable  {

	protected Logger logger = LogManager.getLogger("vmc");

	private boolean receiveResp = false;
	private boolean checkOptocoupler = false;

	private Runnable runnable;		// HeartbeatCheckOptocoupler runnable
	private Thread heartbeatCheckOptocouplerThread;
	public static final int HEARTBEAT_INTERVAL_MS =10000; 	//use for checking the optocoupler status interval

	private static BitSet optocouplerStatus = null;

	//count Start Pulse
	private static int countStartPulse = 0;

	private byte[] cRecv = new byte[512];
	private int dataLen = 0;

	public JyApiOne(VmcConfig config) {
		super(config);
	}

	@Override
	public void init() {
		logger.info("[init]Initiate VMC now: JY_1");

		logger.info("[init]Initiate the vending machine");
		boolean portOpened = false;
		boolean alert = false;

		do {
			portOpened = openPort();

			if (portOpened) {
				try {
					serialPort.addEventListener(this);

				} catch (TooManyListenersException e1) {
					logger.error("[init]Failed to add event listener to VMC", e1);
					return;
				}
				serialPort.notifyOnDataAvailable(true);
				logger.info("[init]Initiate complete");

			} else {
				if (!alert) {
					SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_VMC_DEVICE, "Not Started At Init"));
					alert = true;
				}

				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					logger.error("[init]Error in Sleep", e);
				}
			}
		} while (!portOpened);

		this.enableHeartbeat();

		// After the port opened but there is alert before
		if (alert) {
			SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_VMC_DEVICE, "F->S"));
		}
	}

	protected void sendCommand(byte[] command) {
		try {
			logger.info("Send CMD: " + AbstractVmc.formatHexString(command));
			super.sendCommand(command);

			Thread.sleep(200);
		} catch (Exception e) {
			logger.error("Failed to send command to vmc...", e);
		}
	}

	public void sendHeartbeatCheckOptocouplerCommand(byte[] command){
		try {
			logger.info("Send HeartbeatCheckOptocouplerCommand: " + AbstractVmc.formatHexString(command));
			super.sendCommand(command);

			Thread.sleep(200);
		} catch (Exception e) {
			logger.error("Failed to send command to vmc...", e);
		}
	}


	@Override
	public void serialEvent(SerialPortEvent spe) {
		long ms = System.currentTimeMillis();

		logger.info("[serialEvent]Last response time: " + lastResponseMs + ", Current response time: " + ms + ", EventType:" + spe.getEventType());
		lastResponseMs = ms;

		int data;
		int dataLength = 0;
		byte[] response = null;

		try {
			while (((data = in.read()) > -1)) {
				if (dataLen == 0) {
					if ((byte) data == (byte) 0xFE) { 							//	如果接收到0XFE，開始接收一個新的返回
						cRecv[dataLen++] = (byte) data;
					}
				} else if(dataLen == 1){
					cRecv[dataLen++] = (byte) data;
					dataLength = ((byte) data == (byte) 0x10) ? 8 : 7;			// 0x10 為閃開指令，返回長度為8
				} else {
					cRecv[dataLen++] = (byte) data;
				}

				if (dataLen == dataLength) {
					response = new byte[dataLen];
					for (int i = 0; i < dataLen; i++) {
						response[i] = cRecv[i];
					}
					break;
				}
			}

			// Vending Command Return (Flash switch 閃開)
			if(response[1] == (byte) 0x10) {
				logger.info("[serialEvent]Receive response " + AbstractVmc.formatHexString(response) + " of sending flash switch at pulse: "+countStartPulse);
				checkOptocoupler = true;

			// Check Column Return (Optocoupler)
			} else if(response[1] == (byte) 0x02){

				optocouplerStatus = CommandSet.byteArray2BitSet(new byte[] {response[3], response[4]});

				// If this the return after sending vending command
				if (checkOptocoupler) {
					logger.info("[serialEvent]Receive response " + AbstractVmc.formatHexString(response) + " of checking optocoupler at pulse: "+countStartPulse);
					boolean status = optocouplerStatus.get(CommandSet.convertIndex( TransactionManager.CURRENT_TX.getItemNo()));
					// False means the laundry machine is inited
					if (status == false) {
						receiveResp = true;
						checkOptocoupler = false;
					}
				}

				boolean needToUpdateUI = false;

				if (LocalDataManager.getCellInfo().getCellInfo().size() != 0) {
					for (int i = 0; i < LocalDataManager.getCellInfo().getCellInfo().size(); i++) {
						CellInfo cellInfo = LocalDataManager.getCellInfo().getCellInfo().get(i);

						if (!cellInfo.isEnabled()) continue;

						if(optocouplerStatus != null) {
							boolean status = optocouplerStatus.get(CommandSet.convertIndex(cellInfo.getItemNo()));

							// If status change -> up ui
							if(status != cellInfo.isColumnNormal()) {
								needToUpdateUI = true;
							}
							cellInfo.setColumnNormal(status);
						} else {
							logger.error("[serialEvent]The Optocoupler status is null");
							cellInfo.setColumnNormal(false);
						}
					}

					if (needToUpdateUI) {
						UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVmInfoResult(null));
					}
				}
			}
		} catch (Exception e) {
			logger.error("[serialEvent]Failed to receive data from vmc", e);
		} finally {
			dataLen = 0;
		}

	}

	protected void enableHeartbeat() {
		runnable = new HeartbeatCheckOptocoupler();
		heartbeatCheckOptocouplerThread = new Thread(runnable);

		logger.info("[enableHeartbeat]: Now enable to check Optocoupler of the relay board." );
		heartbeatCheckOptocouplerThread.start();
	}

	protected void disableHeartbeat() {
		logger.info("[disableHeartbeat]: Now disable to check Optocoupler of the relay board." );
		heartbeatCheckOptocouplerThread.interrupt();
	}


	@Override
	public void vendProduct() {
		try {
			countStartPulse = 0;

			// Disable checking Optocoupler status
			disableHeartbeat();

			for (int i = 0; i < 3; i ++) {
				countStartPulse ++;

				this.sendCommand(CommandSet.CMD_FLASH_ON_RELAY(TransactionManager.CURRENT_TX.getItemNo(), 1)); // 10 = 1s, 1 = 0.1s
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVendWaitingResult(new VendWaitingWashMachineResp("VEND_WAITING", countStartPulse)));

				logger.info("[vendProduct]Send start pulse :"+countStartPulse);
				Thread.sleep(1000);

				// After sending command, now checking whether the washing machine receive the command by OPTOCOUPLER signal
				if (checkOptocoupler) {
					sendHeartbeatCheckOptocouplerCommand(CommandSet.CMD_CHECK_OPTOCOUPLER_STATUS);
					Thread.sleep(1000);
				}

				if (receiveResp == true) {
					break;
				}
			}

			Thread.sleep(1000);

			// After Sending three pulse, still does not get the response.
			if (countStartPulse == 3 && receiveResp == false) {
				logger.info("[vendProduct]Could not receive response from the washing machine. The washing machine failed to be inited." + " itemNo: "
						+  TransactionManager.CURRENT_TX.getItemNo() + "productId: " + TransactionManager.CURRENT_TX.getProductId());
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVendWaitingResult(new VendWaitingWashMachineFailResp("VEND_FAIL", TransactionManager.CURRENT_TX.getReceiptNo(), "99999")));

				// The size of the list is 1.
				// TODO
//				logger.info("[vendProduct]Lock this column");
//				CellInfo cell = LocalDataManager.getCellInfoByItemNo(TransactionManager.CURRENT_TX.getItemNo());
//				cell.setLaundryLock(true);

				// Send the alert
				SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_VMC, "Item " +TransactionManager.CURRENT_TX.getItemNo()+ ": No response after sending 3 pulses."));

				// To update the UI, showing the selected washing machine could not be used now.
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVmInfoResult(null));

			} else {
				receiveResp = false;
				logger.info("[vendProduct]Receive response from the washing machine. The washing machine is inited.");
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVendWaitingResult(new VendWaitingWashMachineSuccessResp("WASH_MACHINE_INIT_SUCCESS")));
			}

			checkOptocoupler = false;

			enableHeartbeat();

		}
		catch(Exception e) {
			logger.error("[vendProduct] " + e);
		}
	}



	@Override
	public void checkColumn(int itemNo) {
		this.sendCommand(CommandSet.CMD_CHECK_OPTOCOUPLER_STATUS);
	}


	@Override
	public void run() {

	}
}
