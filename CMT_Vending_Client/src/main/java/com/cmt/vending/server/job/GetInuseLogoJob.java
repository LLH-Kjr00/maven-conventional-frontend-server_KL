package com.cmt.vending.server.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.util.RuntimeUtil;
import com.cmt.vending.server.operation.SFTPComm;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.ws.GetServiceStub;
import com.cmt.vending.ws.GetSoldoutMediaId;
import com.cmt.vending.ws.GetSoldoutMediaIdResponse;
import com.cmt.vending.ws.obj.xsd.GetMediaReq;
import com.cmt.vending.ws.obj.xsd.GetMediaResp;

public class GetInuseLogoJob implements Runnable{
	
	private static final Logger logger = LogManager.getLogger(GetInuseLogoJob.class);
	
	private static boolean isExecuted = false;
	
	@Override
	public void run() {
		if (!isExecuted) {
			isExecuted = true;
			logger.info("[GetVmLogoJob-call]Start to download InUse logo.");
			
			getInuseLogoId();
			isExecuted = false;
		} else {
			logger.info("[GetVmLogoJob-call]Downloading InUse logo. Ignore current job");
		}

	}
	
	private void getInuseLogoId() {
		try {
			GetServiceStub stub = BackendServerComm.getGetServiceStub();
			GetSoldoutMediaId req = new GetSoldoutMediaId();
			GetMediaReq reqObj = new GetMediaReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			
			try {
				GetSoldoutMediaIdResponse resp = stub.getSoldoutMediaId(req);
				GetMediaResp respObj = resp.get_return();
				
				HeartbeatJob.updateSucessTimeMsToServer();
				
				if (respObj.getResult()) {
					// Download Logo
					downloadInuseLogo(respObj.getMediaId());
					return;
				} else {
					logger.error("[getInuseLogoId]Failed to get logo media Id: [" + respObj.getErrorCode() + "] "
							+ respObj.getErrorMsg());
				}
			} catch(Exception e) {
				logger.error("[getInuseLogoId]Failed to get logo media Id.");
			}
			
		} catch(Exception e) {
			logger.error("[getInuseLogoId]Failed to init comm with server: " , e);
		}
		return;
	}
	
	private void downloadInuseLogo(int MediaId) {
		boolean res = false;
		boolean reboot = false;
		
		try {
			logger.info("[downloadInuseLogo]Downloading NotInUse image.");
			res = SFTPComm.download(String.valueOf(MediaId), ResourceManager.MEDIA_FOLDER, "soldout",false);
			if (res) reboot = true;
			
//			File indicatorFile = new File(ResourceUtil.MEDIA_FOLODER + "/" + MediaId + "_finished");
//			File realFile = new File(ResourceUtil.MEDIA_FOLODER + "/" + "soldout");
//			File realFileChi = new File(ResourceUtil.MEDIA_FOLODER + "/" + "soldoutChi");
			
			
//			if (indicatorFile.exists()) {
//				if (realFile.exists() && realFile.length()>0) {
//					logger.info("[downloadInuseLogo]NotInUse image is downloaded already.");
//				} else if (!realFile.exists()) {
//					logger.info("[downloadInuseLogo]NotInUse image not exist, download now.");
//					res = SFTPUtil.download(String.valueOf(MediaId), ResourceUtil.MEDIA_FOLODER, "soldout",false);
//				} else if (realFile.exists() && realFile.length() == 0) {
//					logger.info("[downloadInuseLogo]NotInUse image is empty, download now.");
//					realFile.delete();
//					res = SFTPUtil.download(String.valueOf(MediaId), ResourceUtil.MEDIA_FOLODER, "soldout",false);
//				}
//				
//				if (res) reboot = true;
//				
//				if (realFileChi.exists() && realFileChi.length()>0) {
//					logger.info("[downloadInuseLogo]NotInUse chinese image is downloaded already.");
//				} else if (!realFileChi.exists()) {
//					logger.info("[downloadInuseLogo]NotInUse chinese image not exist, download now.");
//					res = SFTPUtil.download(String.valueOf(MediaId), ResourceUtil.MEDIA_FOLODER, "soldoutChi",false);
//				} else if (realFileChi.exists() && realFileChi.length() == 0) {
//					logger.info("[downloadInuseLogo]NotInUse chinese image is empty, download now.");
//					realFileChi.delete();
//					res = SFTPUtil.download(String.valueOf(MediaId), ResourceUtil.MEDIA_FOLODER, "soldoutChi",false);
//				}
//				
//				if (res) reboot = true;
//				
//			}  else {
//				logger.info("[downloadInuseLogo]NotInUse image is outdated");
//				if (realFile.exists()) realFile.delete();
//				if (realFileChi.exists()) realFileChi.delete();
//				
//				res = SFTPUtil.download(String.valueOf(MediaId), ResourceUtil.MEDIA_FOLODER, "soldout",false);
//				if (res) reboot = true;
//				res = SFTPUtil.download(String.valueOf(MediaId), ResourceUtil.MEDIA_FOLODER, "soldoutChi",false);
//				if (res) reboot = true;
//				
//				if (res) {
//					indicatorFile.createNewFile();
//				}
//			}
			
			try {
				if (reboot) {
					logger.info("[downloadInuseLogo]New media downlaoded, reboot now. ");
					
					while (TransactionManager.IS_TRAN_PROCESS) {
						Thread.sleep(200);
					}
					
					RuntimeUtil.rebootCommand();
					
				} else {
					logger.info("[downloadInuseLogo]No new media is downloaded, no need to reboot.");
				}
			} catch(Exception e) {
				logger.error("[downloadInuseLogo]Error in waiting to reboot: ", e);
			}
			
		} catch(Exception e) {
			logger.error("[downloadInuseLogo]Failed to download logo from server.");
		}
	}
	

}
