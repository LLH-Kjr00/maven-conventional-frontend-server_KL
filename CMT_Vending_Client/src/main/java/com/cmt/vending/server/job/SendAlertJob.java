package com.cmt.vending.server.job;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cmt.vending.server.model.AlertHistory;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.util.ModemUtil;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.ws.SendAlert;
import com.cmt.vending.ws.SendAlertResponse;
import com.cmt.vending.ws.VendingStub;
import com.cmt.vending.ws.obj.xsd.AlertInfo;
import com.cmt.vending.ws.obj.xsd.SendAlertReq;
import com.cmt.vending.ws.obj.xsd.SendAlertResp;

public class SendAlertJob implements Callable<Boolean>, Job {
	private static Logger logger = LogManager.getLogger("schedule");
	
	private static AlertHistory history = null;
	
	public static final int ALERT_TYPE_OCT_SETTLEMENT_FILE = 1;
	public static final int ALERT_TYPE_OCT_META_FILE = 2;
	public static final int ALERT_TYPE_OCT_BLACK_LIST = 3;
	public static final int ALERT_TYPE_OCT_DEVICE = 4;
	public static final int ALERT_TYPE_VMC = 5;
	public static final int ALERT_TYPE_VMC_DEVICE = 6;
	public static final int ALERT_TYPE_STORAGE = 7;
	public static final int ALERT_TYPE_STAT = 8;
	public static final int ALERT_TYPE_OTHER = 9;
	
	public static AlertHistory getAlertHistory() {
		if(history == null) {
			history = (AlertHistory) ResourceManager.getInfo(ResourceManager.INFO_ALERT_LOG);
		}
		
		if(history == null) {
			history = new AlertHistory();
		}
		
		return history;
	}
	
	public static AlertInfo createAlert(Integer alertType, String description) {
		AlertInfo alert = new AlertInfo();
		alert.setAlertType(alertType);
		alert.setAlertTimeMs(System.currentTimeMillis());
		alert.setDescription(description);
		return alert;
	}
	
	/**
	 * Add alert to the history and start its execution
	 * @param alert
	 */
	public static void addAlert(AlertInfo alert) {
		logger.info("[addAlert]Add new alert: Type: " + alert.getAlertType() + ", Alert Time: " + alert.getAlertTimeMs());
		history.getAlert().add(alert);
		startJob(new SendAlertJob());
	}
	
	/**
	 * Start the sending log job
	 * This is different from execute();
	 * execute() is performed in schedule
	 * @param job
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void startJob(SendAlertJob job) {
		try {
			boolean res = (Boolean) BackendServerComm.startJob(job).get();
			
			// If successful -> clear the alert history
			if (res) {
				history.getAlert().clear();
			}
			// Save the history file
			ResourceManager.saveInfo(history, ResourceManager.INFO_ALERT_LOG);
		} catch(Exception e) {
			logger.error("[startJob]Error in excutaion of send alert job: ", e);
		}
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			boolean res = (Boolean) BackendServerComm.startJob(this).get();
			
			// If successful -> clear the alert history
			if (res) history.getAlert().clear();
			// Save the history file
			ResourceManager.saveInfo(history, ResourceManager.INFO_ALERT_LOG);
		} catch(Exception e) {
			logger.error("[SendAlertJob-execute]Error in excutaion of send alert job: ", e);
		}
	}

	@Override
	public Boolean call() throws Exception {
		logger.info("[SendAlertJob-call]Start to upload alert log to server.");
		boolean res = false;
		
		// If no alert history, ignore this job
		if(history.getAlert().size() == 0) {
			logger.info("[SendAlertJob-call]Alert history list is empty, Ignore current job.");
			return true;
		} else {
			int numOfAlert = history.getAlert().size();
			logger.info("[SendTranJob-call]Num of alert waiting to upload: " + history.getAlert().size());
		}
		
		// Make the alert be array
		AlertInfo[] array = history.getAlert().toArray(new AlertInfo[history.getAlert().size()]);
		if(array == null || array.length == 0) {
			logger.info("[SendAlertJob-call]Alert history list is empty, Ignore current job.");
			return true;
		}
					
		try {
			VendingStub stub = BackendServerComm.getVendingStub();
			SendAlert req = new SendAlert();
			SendAlertReq reqObj = new SendAlertReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			
			reqObj.setAlerts(array);
			
			try {
				SendAlertResponse resp = stub.sendAlert(req);
				SendAlertResp respObj = resp.get_return();
				
				HeartbeatJob.updateSucessTimeMsToServer();
				
				if(respObj.getResult()) {
					logger.info("[SendAlertJob-call]Upload Alert log Successfully.");
					return true;
				}
				else {
					logger.error("[SendAlertJob-call]Request of uploading alert aborted : [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
				}
				
			} catch (Exception e) {
				logger.error("[SendAlertJob-call]Failed to upload alert: ", e);
			}
			
			if(BackendServerComm.IS_WIRELESS_NETWORK){
				logger.info("[SendAlertJob-call]Try to reconnect mobile network.");
				ModemUtil.reconnect();
			}
			
		} catch (Exception e) {
			logger.error("[SendAlertJob-call]Failed to init comm with server: " , e);
		}
		
		return res;
	}
	
}
