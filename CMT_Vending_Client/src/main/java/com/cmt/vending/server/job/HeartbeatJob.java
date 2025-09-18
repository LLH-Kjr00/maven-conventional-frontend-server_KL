package com.cmt.vending.server.job;

import java.util.Date;
import java.util.concurrent.Callable;

import com.cmt.vending.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.util.ModemUtil;
import com.cmt.vending.ws.Heartbeat;
import com.cmt.vending.ws.HeartbeatResponse;
import com.cmt.vending.ws.VendingStub;
import com.cmt.vending.ws.obj.xsd.WsReq;
import com.cmt.vending.ws.obj.xsd.WsResp;

public class HeartbeatJob implements Callable<Boolean>, Job{
	private static final Logger logger = LogManager.getLogger("schedule");
	
	private static long lastSuccessTimsMsToServer = System.currentTimeMillis();
	
	private static boolean isExecuted = false;
	
	public static int RETRY_DURATION_SEC = 3;
	public static int MAX_RETRY_COUNT = 1;
	

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		BackendServerComm.startJob(this);
	}

	@Override
	public Boolean call() throws Exception {
		boolean res = false;
		
		if(!isExecuted) {
			
			isExecuted = true;
			logger.info("[HeartbeatJob-call]Start to send heartbeat to server.");
			
			res = sendHeartbeat();
			isExecuted = false;
			
		} else {
			logger.info("[HeartbeatJob-call]Sending heartbeat, Ignore current job. ");
		}
		return res;
	}
	
	private Boolean sendHeartbeat() {
		boolean res = false;
		
		try {
			VendingStub stub = BackendServerComm.getVendingStub();
			WsReq reqObj = new WsReq();
			Heartbeat req = new Heartbeat();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			
			for (int i = 0; i <= MAX_RETRY_COUNT; i++) {
				logger.info("[sendHeartbeat]Retry Count: " + (i + 1));
				
				try {
					HeartbeatResponse resp = stub.heartbeat(req);
					WsResp respObj = resp.get_return();
					
					HeartbeatJob.updateSucessTimeMsToServer(); 
					
					if (respObj.getResult()) {
						logger.info("[sendHeartbeat]Last data version: " + reqObj.getVmVersionMs() + ", Date: " + DateUtil.formatDateTime(new Date(reqObj.getVmVersionMs()), true));
						logger.info("[sendHeartbeat]Latest data version: " + respObj.getVmVersionServerMs() + ", Date: " + DateUtil.formatDateTime(new Date(respObj.getVmVersionServerMs()), true));
					
						// If the version is the same
						if (reqObj.getVmVersionMs() == respObj.getVmVersionServerMs()) {
							logger.info("[sendHeartbeat]Current data version is the latest"); 
							
							// Keep doing the downloading job
							BackendServerComm.startJob(new GetOtherMediaJob());
							
							return true;

						}
						// If the version is not the same -> start getVmInfoJob, get groupId job, get logo job
						else {
							logger.info("[sendHeartbeat]Current data version is not the latest");
							BackendServerComm.startJob(new GetVmInfoJob());
							BackendServerComm.startJob(new GetGroupIdJob());
							BackendServerComm.startJob(new GetVmLogoJob());
							BackendServerComm.startJob(new GetInuseLogoJob());
							return true;
						}
					
					} else {
						logger.info("[sendHeartbeat]Failed to complete heartbeat: [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
					}
					
				} catch (Exception e) {
					if (i < MAX_RETRY_COUNT) {
						logger.error("[sendHeartbeat]Failed to complete heartbeat. Retry After " + RETRY_DURATION_SEC + "s : ",	e);

						try {
							Thread.sleep(RETRY_DURATION_SEC * 1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}

					} else {
						logger.error("[sendHeartbeat]Failed to complete heartbeat, cancel current job: ", e);
					}
				}
			}
			// End of for loop
			
			if(BackendServerComm.IS_WIRELESS_NETWORK){
				logger.info("[SendAlertJob-call]Try to reconnect mobile network.");
				ModemUtil.reconnect();
			}
			
		} catch (Exception e) {
			logger.error("[sendHeartbeat]Failed to init comm with server.", e);
		}
		
		return res;
		
	}
	
	
	
	/**
	 * Update the time when successfully communicate with the back end server
	 * @return
	 */
	public static long updateSucessTimeMsToServer(){		
		lastSuccessTimsMsToServer = System.currentTimeMillis();		
		return lastSuccessTimsMsToServer;
	}
	

	/**
	 * Check the last time when successfully communicate with the back end server
	 * If the machine has not accessed to the back end server more than NETWORK_DISABLE_DURATION_MIN -> reboot
	 * @return
	 */
	public static boolean checkSuccessTimeMsToServer(){
		long tm = System.currentTimeMillis();
		long tmDiff = BackendServerComm.NETWORK_DISABLE_DURATION_MIN * 60000;
		boolean withinRange = lastSuccessTimsMsToServer == -1 || (tm - lastSuccessTimsMsToServer < tmDiff);
		
		if(!withinRange){
			logger.info("[checkSuccessTimeMsToServer]Not withing range, last success req to server " + ((tm - lastSuccessTimsMsToServer) / 1000) + " sec ago, setting (" + BackendServerComm.NETWORK_DISABLE_DURATION_MIN  + " min), try to reboot server now, ");
			BackendServerComm.startJob(new RebootVMJob());
		}
		else{
			logger.info("[checkSuccessTimeMsToServer]Within range, not reboot now");
		}
		
		return withinRange;
	}
}
