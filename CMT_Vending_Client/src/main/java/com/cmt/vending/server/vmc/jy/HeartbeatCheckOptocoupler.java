package com.cmt.vending.server.vmc.jy;


import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.job.SendAlertJob;
import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.model.VsCellInfo;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.vmc.AbstractVmc;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HeartbeatCheckOptocoupler implements Runnable {

	public static final int HEARTBEAT_INTERVAL_MS =60000;
	
	public static JyApiOne vmc;
	
	protected Logger logger = LogManager.getLogger("vmc");
	
	@Override
	public void run() {
		vmc = (JyApiOne) LocalServer.getVmc();
				
		boolean currentStatus = true;
		while(!Thread.currentThread().isInterrupted()){
				try {
					if(!TransactionManager.IS_TRAN_PROCESS && LocalDataManager.getVmInfo().getInfo().isEnabled()) {
						vmc.sendHeartbeatCheckOptocouplerCommand(CommandSet.CMD_CHECK_OPTOCOUPLER_STATUS);							// FOR TESTING
						long tm = System.currentTimeMillis();
						// If originally status = true but exceed timeout
						if (tm - vmc.getLastResponseMs()> AbstractVmc.DEFAULT_VMC_TIMEOUT && currentStatus) {
							currentStatus = false;
							SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_VMC_DEVICE, "S->F"));
						} else if (tm - vmc.getLastResponseMs() <= AbstractVmc.DEFAULT_VMC_TIMEOUT) {
							currentStatus = true;
							SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_VMC_DEVICE, "S->F"));

						}
					}

					Thread.sleep(HEARTBEAT_INTERVAL_MS);

				} catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				} catch (Exception e) {
					logger.error("[HeartbeatCheckOptocoupler-run]Error: ", e);
					
				}	
		}
		logger.info("[HeartbeatCheckOptocoupler-run]: Check Optocoupler of the relay board thread stopped." );
	}
}
