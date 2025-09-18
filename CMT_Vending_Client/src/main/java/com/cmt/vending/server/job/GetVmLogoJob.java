package com.cmt.vending.server.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.util.RuntimeUtil;
import com.cmt.vending.server.operation.SFTPComm;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.ws.Eight_LaundryStub;
import com.cmt.vending.ws.GetLogoMediaId;
import com.cmt.vending.ws.GetLogoMediaIdResponse;
import com.cmt.vending.ws.obj.xsd.GetLogoMediaIdReq;
import com.cmt.vending.ws.obj.xsd.GetLogoMediaIdResp;

public class GetVmLogoJob implements Runnable {
	private static final Logger logger = LogManager.getLogger(GetVmLogoJob.class);
	
	private static boolean isExecuted = false;
	
	@Override
	public void run() {
		if (!isExecuted) {
			isExecuted = true;
			logger.info("[GetVmLogoJob-run] Start to get logo.");
			getLogoMediaId();
			isExecuted = false;
		}else {
			logger.info("[GetVmLogoJob-run]Downloading logo. Ignore current job");
		}
	}
	
	private void getLogoMediaId() {
		try {
			Eight_LaundryStub stub = BackendServerComm.get8LaundryStub();
			GetLogoMediaId req = new GetLogoMediaId();
			GetLogoMediaIdReq reqObj = new GetLogoMediaIdReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			
			try {
				GetLogoMediaIdResponse resp = stub.getLogoMediaId(req);
				GetLogoMediaIdResp respObj = resp.get_return();
				
				HeartbeatJob.updateSucessTimeMsToServer();
				
				if (respObj.getResult()) {
					// Download Logo
					downloadLogo(respObj.getMediaId(),respObj.getDefaultMediaId());
					return;
				} else {
					logger.error("[getLogoMediaId]Failed to get logo media Id: [" + respObj.getErrorCode() + "] "
							+ respObj.getErrorMsg());
				}
			} catch(Exception e) {
				logger.error("[getLogoMediaId]Failed to get logo media Id.");
			}
			
		} catch(Exception e) {
			logger.error("[getLogoMediaId]Failed to init comm with server: " , e);
		}
		
		return;
	}
	
	private void downloadLogo(int MediaId,int DefaultMediaId ) {
		boolean res = false;
		boolean reboot = false;
		
		try {
			logger.info("[downloadLogo]Downloading Media default LOGO image.");
			res = SFTPComm.download(String.valueOf(DefaultMediaId), ResourceManager.MEDIA_FOLDER, "default",false);
			
//			File indicatorDefaultFile = new File(ResourceUtil.MEDIA_FOLODER + "/" + DefaultMediaId + "_finished");
//			File realDefaultFile = new File(ResourceUtil.MEDIA_FOLODER + "/" + "default");
			
//			if (indicatorDefaultFile.exists() && realDefaultFile.exists() && realDefaultFile.length() > 0) {
//				logger.info("[downloadLogo]Media default LOGO image is downloaded already.");
//			} else if (indicatorDefaultFile.exists() && !realDefaultFile.exists()) {
//				logger.info("[downloadLogo]Media default LOGO image is not exist, download now.");
//				res = SFTPUtil.download(String.valueOf(DefaultMediaId), ResourceUtil.MEDIA_FOLODER, "default",false);
//			} else if (indicatorDefaultFile.exists() && realDefaultFile.exists() &&  realDefaultFile.length() == 0) {
//				logger.info("[downloadLogo]Media default LOGO image is empty, download now.");
//				realDefaultFile.delete();
//				res = SFTPUtil.download(String.valueOf(DefaultMediaId), ResourceUtil.MEDIA_FOLODER, "default",false);
//			} else if (!indicatorDefaultFile.exists()) {
//				logger.info("[downloadLogo]Media default LOGO image is outdated");
//				if (realDefaultFile.exists()) realDefaultFile.delete();
//				res = SFTPUtil.download(String.valueOf(DefaultMediaId), ResourceUtil.MEDIA_FOLODER, "default",false);
//				if (res) {
//					indicatorDefaultFile.createNewFile();
//				}
//			}
			
			if (res) reboot = true;
			
			logger.info("[downloadLogo]Downloading Media LOGO image.");
			res = SFTPComm.download(String.valueOf(MediaId), ResourceManager.MEDIA_FOLDER, "logo",false);
			
//			File indicatorLogoFile = new File(ResourceUtil.MEDIA_FOLODER + "/" + MediaId + "_finished");
//			File realLogoFile = new File(ResourceUtil.MEDIA_FOLODER + "/" + "logo");
			
//			if (indicatorLogoFile.exists() && realLogoFile.exists() && realLogoFile.length() > 0) {
//				logger.info("[downloadLogo]Media LOGO is downloaded already.");
//			} else if (indicatorLogoFile.exists() && !realLogoFile.exists()) {
//				logger.info("[downloadLogo]Media LOGO image is not exist, download now.");
//				res = SFTPUtil.download(String.valueOf(MediaId), ResourceUtil.MEDIA_FOLODER, "logo",false);
//			} else if (indicatorLogoFile.exists() && realLogoFile.exists() &&  realLogoFile.length() == 0) {
//				logger.info("[downloadLogo]Media LOGO image is empty, download now.");
//				realLogoFile.delete();
//				res = SFTPUtil.download(String.valueOf(MediaId), ResourceUtil.MEDIA_FOLODER, "logo",false);
//			} else if (!indicatorLogoFile.exists()) {
//				logger.info("[downloadLogo]Media LOGO image is outdated");
//				if (realLogoFile.exists()) realLogoFile.delete();
//				res = SFTPUtil.download(String.valueOf(MediaId), ResourceUtil.MEDIA_FOLODER, "logo",false);
//				if (res) {
//					indicatorLogoFile.createNewFile();
//				}
//			}
			
			if (res) reboot = true;
			
			try {
				if (reboot ) {
					logger.info("[downloadLogo]New media downlaoded, reboot now. ");
					
					while (TransactionManager.IS_TRAN_PROCESS) {
						Thread.sleep(200);
					}
					
					RuntimeUtil.rebootCommand();
					
				} else {
					logger.info("[downloadLogo]No new media is downloaded, no need to reboot.");
				}
			} catch(Exception e) {
				logger.error("[downloadLogo]Error in waiting to reboot: ", e);
			}

		} catch(Exception e) {
			logger.error("[downloadLogo]Failed to download logo from server.");
		}

	}

}
