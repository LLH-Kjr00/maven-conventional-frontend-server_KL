package com.cmt.vending.server.job;

import java.io.File;
import java.util.concurrent.Callable;

import javax.activation.DataHandler;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.cmt.vending.server.model.SettlementFile;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.util.ModemUtil;
import com.cmt.vending.server.operation.OctopusComm;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.ws.OctopusStub;
import com.cmt.vending.ws.Octopus_IwashStub;
import com.cmt.vending.ws.UploadSettlementFile;
import com.cmt.vending.ws.UploadSettlementFileResponse;
import com.cmt.vending.ws.obj.xsd.FileItem;
import com.cmt.vending.ws.obj.xsd.OctSettlementFileInfo;
import com.cmt.vending.ws.obj.xsd.UploadOctSettlementFileReq;
import com.cmt.vending.ws.obj.xsd.UploadOctSettlementFileResp;

public class UploadSettlementFileJob implements Callable<Boolean> {
	private static Logger logger = LogManager.getLogger("schedule");
	
	private static boolean isExecuted = false;
	
	public static int RETRY_DURATION_SEC = 60;
	public static int MAX_RETRY_COUNT = 3;
	
	public static String OCT_UPLOAD_FOLDER = "/opt/octopus/upload";
	public static String OCT_UPLOAD_OUTDATED_FOLDER = "/opt/octopus/upload_finished";
	

	private boolean isIwashStatment() {
		return (LocalDataManager.getGroupInfo().getGroupId() == 14);
	}
	
	private FileItem createFileItem(String fileName) {
		logger.info("[createFileItem]Start to create fileItem [ " + fileName + " ]");
		FileItem f = new FileItem();
		File zipFile = new File(OCT_UPLOAD_FOLDER + "/" + fileName);
		logger.info("[createFileItem]File location: " + zipFile.getAbsolutePath());
		f.setName(zipFile.getName());
		f.setSize(zipFile.length());
		try {
			f.setContent(new DataHandler(zipFile.toURI().toURL()));
			f.setMd5(DigestUtils.md5Hex(IOUtils.toByteArray(zipFile.toURI().toURL())));
			
		} catch (Exception e) {
			logger.error("[createFileItem]Failed to set content into fileItem", e);
		}
		
		return f;
	}
	
	@Override
	public Boolean call() throws Exception {
		boolean res = false;
		
		if (!isExecuted) {
			
			isExecuted = true;
			logger.info("[UploadSettlementFileJob-call]Start to upload octopus settlement file.");
			
			res  = uploadFile();
			isExecuted = false;
		} else {
			logger.info("[UploadSettlementFileJob-call]Uploading octopus settlement file, Ignore current job");
		}
		
		return res;
	}
	
	private Boolean uploadFile() {
		boolean res = false;
		
		if(TransactionManager.getOctSettlement().getSettlementFile().size() == 0) {
			logger.info("[uploadFile]No need to upload octopus settlement file to server.");
			res = true;
			return res;
		}
		
		if(isIwashStatment()) {
			res = handleIwashSettlement();
		} else {
			res = handleSettlement();
		}
		return res;
	}
	
	private Boolean handleIwashSettlement() {
		boolean res = false;
		
		try {
			Octopus_IwashStub stub = BackendServerComm.getOctopusIwashStub();
			UploadSettlementFile req = new UploadSettlementFile();
			UploadOctSettlementFileReq reqObj = new UploadOctSettlementFileReq();
			
			req.setReq(reqObj);
			BackendServerComm.setGeneralInfo(reqObj);
			
			for(int i = 0; i <= MAX_RETRY_COUNT; i++) {
				logger.info("[handleIwashSettlement]Rerty Count: "+ (i + 1));
				
				try {
					UploadSettlementFileResponse resp = stub.uploadSettlementFile(req);
					UploadOctSettlementFileResp respObj = resp.get_return();
					
					HeartbeatJob.updateSucessTimeMsToServer();
					
					if(respObj.getResult()) {
						for(OctSettlementFileInfo f : req.getReq().getSettlementFiles()) {
							OctopusComm.logger.info("[handleIwashSettlements]MPS Success - " + f.getFileName() +" uploaded");
							File a = new File(OCT_UPLOAD_FOLDER + "/" + f.getFileName());
							FileUtils.moveFile(a, new File(OCT_UPLOAD_OUTDATED_FOLDER + "/" + a.getName()));
						}
						return true;
						
					}else {
						OctopusComm.logger.error("[handleIwashSettlements]MTP - Uploaded Fail, errer message: [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
						logger.error("[handleIwashSettlements]Failed to upload settlement file to server: [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
					}
					
				} catch(Exception e) {
					if (i < MAX_RETRY_COUNT) {
						OctopusComm.logger.error("[handleIwashSettlements]MTP - Uploaded Fail. Retry After " + RETRY_DURATION_SEC + "s : ",	e);
						logger.error("[handleIwashSettlements]Failed to upload settlement file to server. Retry After " + RETRY_DURATION_SEC + "s : ",	e);

						try {
							Thread.sleep(RETRY_DURATION_SEC * 1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}

					} else {
						logger.error("[handleIwashSettlements]Failed to upload settlement file to server, cancel current job: ", e);
					}
				}
			}
			
			
		} catch(Exception e) {
			logger.error("[handleIwashSettelent]Failed to init comm with server: " , e);
		}
		
		return res;
	}
	
	private Boolean handleSettlement() {
		boolean res = false;
		
		try {
			OctopusStub stub = BackendServerComm.getOctopusStub();
			UploadSettlementFile req = new UploadSettlementFile();
			UploadOctSettlementFileReq reqObj = new UploadOctSettlementFileReq();
			
			req.setReq(reqObj);
			
			for(SettlementFile file : TransactionManager.getOctSettlement().getSettlementFile()) {
				reqObj.addFiles(createFileItem(file.getFileName()));
				
				OctSettlementFileInfo info = new OctSettlementFileInfo();
				info.setDeviceNo(file.getDeviceId());
				info.setFileName(file.getFileName());
				info.setUuIds(file.getUuid());
				reqObj.addSettlementFiles(info);
				
				logger.info("[handleSettlement]Settlement file[ name: " + file.getFileName() + ", no of uuid: " + file.getUuid().length + " ]");
			}
			
			BackendServerComm.setGeneralInfo(reqObj);
			
			for(int i = 0; i <= MAX_RETRY_COUNT; i++) {
				logger.info("[handleSettlement]Rerty Count: "+ (i + 1));
				
				try {
					UploadSettlementFileResponse resp = stub.uploadSettlementFile(req);
					UploadOctSettlementFileResp respObj = resp.get_return();
					
					HeartbeatJob.updateSucessTimeMsToServer();
					
					if(respObj.getResult()) {
						for(OctSettlementFileInfo f : req.getReq().getSettlementFiles()) {
							OctopusComm.logger.info("[handleSettlement]MPS Success - " + f.getFileName() +" uploaded");
							File a = new File(OCT_UPLOAD_FOLDER + "/" + f.getFileName());
							FileUtils.moveFile(a, new File(OCT_UPLOAD_OUTDATED_FOLDER + "/" + a.getName()));
						}
						return true;
						
					}else {
						OctopusComm.logger.error("[handleSettlement]MTP - Uploaded Fail, error message: [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
						logger.error("[handleSettlement]Failed to upload settlement file to server: [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
					}
					
				} catch(Exception e) {
					if (i < MAX_RETRY_COUNT) {
						OctopusComm.logger.error("[handleSettlement]MTP - Uploaded Fail. Retry After " + RETRY_DURATION_SEC + "s : ",	e);
						logger.error("[handleSettlement]Failed to upload settlement file to server. Retry After " + RETRY_DURATION_SEC + "s : ",	e);

						try {
							Thread.sleep(RETRY_DURATION_SEC * 1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}

					} else {
						logger.error("[handleSettlement]Failed to upload settlement file to server, cancel current job: ", e);
					}
				}
			}
			// End of for loop
			
			if (BackendServerComm.IS_WIRELESS_NETWORK) {
				logger.info("[handleSettlement]Try to reconnect mobile network.");
				ModemUtil.reconnect();
			}
			
			
		} catch(Exception e) {
			logger.error("[handleSettlement]Failed to init comm with server: " , e);
		}
		
		return res;
	}

}
