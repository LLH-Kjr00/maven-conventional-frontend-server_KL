package com.cmt.vending.server.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.model.VmRequestLogHistory;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.ws.LogVmRequest;
import com.cmt.vending.ws.LogVmRequestResponse;
import com.cmt.vending.ws.VendingStub;
import com.cmt.vending.ws.obj.xsd.VmRequestLogInfo;
import com.cmt.vending.ws.obj.xsd.VmRequestLogReq;
import com.cmt.vending.ws.obj.xsd.VmRequestLogResp;

public class UploadVmRequestLogJob implements Runnable {
	private static Logger logger = LogManager.getLogger(UploadVmRequestLogJob.class);
	
	private static VmRequestLogHistory history = null;
	
	public static VmRequestLogHistory getVmRequestLogHistory() {
		if(history == null) {
			history = (VmRequestLogHistory) ResourceManager.getInfo(ResourceManager.INFO_VM_REQUEST_LOG);
		}
		
		if(history == null) {
			history = new VmRequestLogHistory();
		}
		
		return history;
	}

	@Override
	public void run() {
		logger.info("[UploadVmRequestLogJob-call]Start to upload request log to the server.");
		
		// If no video log history, ignore this job
		if(history.getHistory().size() == 0) {
			logger.info("[UploadVmRequestLogJob-run]Request list is empty, Ignore current job.");
			return ;
		} else {
			logger.info("[UploadVmRequestLogJob-run]Num of request waiting to upload: " + history.getHistory().size());
		}
		
		// Make the history be array
		VmRequestLogInfo[] array = history.getHistory().toArray(new VmRequestLogInfo[history.getHistory().size()]);
		if(array == null || array.length == 0) {
			logger.info("[UploadVmRequestLogJob-run]Request list is empty, Ignore current job.");
			return ;
		}
		
		try {
			VendingStub stub = BackendServerComm.getVendingStub();
			LogVmRequest req = new LogVmRequest();
			VmRequestLogReq reqObj = new VmRequestLogReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			
			reqObj.setRequestLogs(array);
			
			try {
				LogVmRequestResponse resp = stub.logVmRequest(req);
				VmRequestLogResp respObj = resp.get_return();
				
				HeartbeatJob.updateSucessTimeMsToServer();
				
				if(respObj.getResult()) {
					logger.info("[UploadVmRequestLogJob-run]Upload request Log Successfully.");
					history.getHistory().clear();
					ResourceManager.saveInfo(history, ResourceManager.INFO_VM_REQUEST_LOG);
					return;
				}
				else {
					logger.error("[UploadVmRequestLogJob-run]Failed to upload request log to server : [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
					if(history != null) {
						ResourceManager.saveInfo(history, ResourceManager.INFO_VM_REQUEST_LOG);
					}
				}
				
			} catch (Exception e) {
				logger.error("[UploadVmRequestLogJob-run]Failed to upload request log: ", e);
			}
			
		} catch(Exception e) {
			logger.error("[UploadVmRequestLogJob-run]Failed to init comm with server: " , e);
		}
	}
}
