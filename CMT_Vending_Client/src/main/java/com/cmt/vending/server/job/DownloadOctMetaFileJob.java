package com.cmt.vending.server.job;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.config.LocalServerConfig;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.util.ModemUtil;
import com.cmt.vending.server.operation.OctopusComm;
import com.cmt.vending.ws.DownloadMetaFile;
import com.cmt.vending.ws.DownloadMetaFileResponse;
import com.cmt.vending.ws.OctopusStub;
import com.cmt.vending.ws.obj.xsd.DownloadOctMetaFileReq;
import com.cmt.vending.ws.obj.xsd.DownloadOctMetaFileResp;

public class DownloadOctMetaFileJob implements Callable<Boolean>, Job{
	
	private static final Logger logger = LogManager.getLogger("schedule");
	
	private static boolean isExecuted = false;
	
	public static int RETRY_DURATION_SEC = 60;
	public static int MAX_RETRY_COUNT = 3;
	
	public static String OCTOPUS_META_FILE_FOLDER = "/opt/octopus/download";
	public static String OCTOPUS_META_FILE_BACKUP_FOLDER = "/opt/octopus/download_outdated";
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		if(LocalServer.getLocalServerConfig().getRegion().equals(LocalServerConfig.REGION_HK))  {
			BackendServerComm.startJob(this);
		}
		
	}
	@Override
	public Boolean call() throws Exception {
		boolean res = false;
		
		if (!isExecuted) {
			
			isExecuted = true;
			logger.info("[DownloadOctMetaFileJob-call]Start to download octopus meta file.");
			
			res  = downloadMetafile();
			isExecuted = false;
		} else {
			logger.info("[DownloadOctMetaFileJob-call]Downloading meta file, Ignore current job");
		}
		
		return res;
		
	}
	
	private Boolean downloadMetafile() {
		boolean res = false;
		
		File folder = new File(OCTOPUS_META_FILE_FOLDER);
		String currentVersion = "OTP-000";
		File currentMetaFile = null;
		
		// META FILE EXIST, GET CURRENT FILE NAME AS VERSION CODE
		String[] names = folder.list(new FilenameFilter() {
	        @Override
	        public boolean accept(File dir, String name) {
	            return name.startsWith("OTP");
	        }
	    });
		if(names.length > 0) {
			currentVersion = names[0];
			currentMetaFile = new File(OCTOPUS_META_FILE_FOLDER + "/" + names[0]);
		}
		logger.info("[downloadMetafile]Current Meta File Version: " + currentVersion);
		
		try {
			OctopusStub stub = BackendServerComm.getOctopusStub();
			DownloadMetaFile req = new DownloadMetaFile();
			DownloadOctMetaFileReq reqObj = new DownloadOctMetaFileReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			reqObj.setCurrentVersion(currentVersion);
			
			for(int i = 0; i <= MAX_RETRY_COUNT; i++) {
				logger.info("[downloadMetafile]Retry Count: " + (i + 1));
				
				try {
					DownloadMetaFileResponse resp = stub.downloadMetaFile(req);
					DownloadOctMetaFileResp respObj = resp.get_return();
					
					HeartbeatJob.updateSucessTimeMsToServer();
					
					if (respObj.getResult()) {
						if (respObj.getFile() != null) {
							logger.info("[downloadMetafile]Name: " + respObj.getFile().getName());
							logger.info("[downloadMetafile]Size: " + respObj.getFile().getSize());
							logger.info("[downloadMetafile]MD5: " + respObj.getFile().getMd5());
							
							try {
					            MessageDigest md = MessageDigest.getInstance("MD5");		
					            byte[] content = org.apache.commons.io.IOUtils.toByteArray(respObj.getFile().getContent().getInputStream());
					            byte[] messageDigest = md.digest(content);
					            
					            if(respObj.getFile().getMd5().equalsIgnoreCase(DatatypeConverter.printHexBinary(messageDigest))) {
					            		
					            		// Move the out-dated meta file to the backup folder
					            		if(currentMetaFile != null) {
					            			File a = currentMetaFile;
					            			FileUtils.moveFile(a, new File(OCTOPUS_META_FILE_BACKUP_FOLDER + "/" + a.getName()));
					            			logger.info("[downloadMetafile]Move current meta data to: " + OCTOPUS_META_FILE_BACKUP_FOLDER + "/" + a.getName());
					            		}
					            	
					            		// Save new version of meta file to the local storage
					            		Path file = Paths.get(OCTOPUS_META_FILE_FOLDER + "/" + respObj.getFile().getName());
					            		Files.write(file, content);
					            		
					            		logger.info("[downloadMetafile]Save new meta data to: " + OCTOPUS_META_FILE_FOLDER + "/" + respObj.getFile().getName());
					            		OctopusComm.logger.info("[downloadMetafile]OTP Success - " + respObj.getFile().getName() + " downloaded");
					            		OctopusComm.HouseKeeping();
					            		
					            		return true;
					            } else {
					            		logger.info("[downloadMetafile]MD5 CHECKING: FAIL");
					            		throw new Exception("MD5 FAIL");
					            }
					       
							} catch (NoSuchAlgorithmException e) {
					            logger.error("[downloadMetafile]No Such Algorithm Error: ", e);
					        }
							
						} else {
							OctopusComm.logger.info("[downloadMetafile]OTP Success - already have the latest file");
							logger.info("[downloadMetafile]Current meta file is the latest, no need to download.");
							return true;
						}
						
					} else {
						OctopusComm.logger.error("[downloadMetafile]OTP Fail - Download failed, error message: [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
						logger.error("[downloadMetafile]Failed to download octopus meta file: [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
						res = false;
					}
					
				} catch(Exception e){
					if (i < MAX_RETRY_COUNT) {
						OctopusComm.logger.error("[downloadMetafile]OTP Fail - Download failed. Retry After " + RETRY_DURATION_SEC + "s : ",	e);
						logger.error("[downloadMetafile]Failed to download octopus meta file. Retry After " + RETRY_DURATION_SEC + "s : ",	e);

						try {
							Thread.sleep(RETRY_DURATION_SEC * 1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
					} else {
						logger.error("[downloadMetafile]Failed to download octopus meta file, cancel current job: ", e);
					}
				}
			}
			// End of for loop
			
			if (BackendServerComm.IS_WIRELESS_NETWORK) {
				logger.info("[downloadMetafile]Try to reconnect mobile network.");
				ModemUtil.reconnect();
			}
		}catch(Exception e) {
			logger.error("[downloadMetafile]Failed to init comm with server: ", e);
		}
		
		return res;
	}
}
