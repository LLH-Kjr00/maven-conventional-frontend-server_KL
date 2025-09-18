package com.cmt.vending.server.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.model.VideoDownloadLogHistory;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.ws.LogVideoDownload;
import com.cmt.vending.ws.LogVideoDownloadResponse;
import com.cmt.vending.ws.VendingStub;
import com.cmt.vending.ws.obj.xsd.VideoDownloadLogInfo;
import com.cmt.vending.ws.obj.xsd.VideoDownloadLogReq;
import com.cmt.vending.ws.obj.xsd.VideoDownloadLogResp;

public class UploadVideoDownloadLogJob implements Runnable{
	private static Logger logger = LogManager.getLogger(UploadVideoDownloadLogJob.class);
	
	private static VideoDownloadLogHistory history = null;
	
	public static VideoDownloadLogHistory getVideoDownloadLogHistory() {
		if(history == null) {
			history = (VideoDownloadLogHistory) ResourceManager.getInfo(ResourceManager.INFO_VIDEO_DOWNLOAD_LOG);
		}
		
		if(history == null) {
			history = new VideoDownloadLogHistory();
		}
		
		return history;
	}

	@Override
	public void run() {
		logger.info("[VideoDownloadLogJob-run]Start to upload video download log to the server.");
		
		// If no video log history, ignore this job
		if(history.getHistory().size() == 0) {
			logger.info("[VideoDownloadLogJob-run]Video download history list is empty, Ignore current job.");
			return ;
		} else {
			logger.info("[VideoDownloadLogJob-run]Num of video log waiting to upload: " + history.getHistory().size());
		}
		
		// Make the history be array
		VideoDownloadLogInfo[] array = history.getHistory().toArray(new VideoDownloadLogInfo[history.getHistory().size()]);
		if(array == null || array.length == 0) {
			logger.info("[VideoDownloadLogJob-run]Video download history list is empty, Ignore current job.");
			return ;
		}
		
		try {
			VendingStub stub = BackendServerComm.getVendingStub();
			LogVideoDownload req = new LogVideoDownload();
			VideoDownloadLogReq reqObj = new VideoDownloadLogReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			
			reqObj.setDownloadLogs(array);
			
			try {
				LogVideoDownloadResponse resp = stub.logVideoDownload(req);
				VideoDownloadLogResp respObj = resp.get_return();
				
				HeartbeatJob.updateSucessTimeMsToServer();
				
				if(respObj.getResult()) {
					logger.info("[VideoDownloadLogJob-run]Upload Video Log Successfully.");
					history.getHistory().clear();
					ResourceManager.saveInfo(history, ResourceManager.INFO_VIDEO_DOWNLOAD_LOG);
					return;
				}
				else {
					logger.error("[VideoDownloadLogJob-run]Failed to upload video log to server : [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
					if(history != null) {
						ResourceManager.saveInfo(history, ResourceManager.INFO_VIDEO_DOWNLOAD_LOG);
					}
				}
				
			} catch (Exception e) {
				logger.error("[VideoDownloadLogJob-run]Failed to upload video download log: ", e);
			}
			
		} catch(Exception e) {
			logger.error("[VideoDownloadLogJob-run]Failed to init comm with server: " , e);
		}
	}
}
