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
import com.cmt.vending.ws.DownloadInterimBlacklist;
import com.cmt.vending.ws.DownloadInterimBlacklistResponse;
import com.cmt.vending.ws.OctopusStub;
import com.cmt.vending.ws.obj.xsd.DownloadOctInterimBlacklistReq;
import com.cmt.vending.ws.obj.xsd.DownloadOctInterimBlacklistResp;

public class DownloadOctBlackListJob implements Callable<Boolean>, Job{
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
			logger.info("[DownloadOctMetaFileJob-call]Start to download octopus blacklist file.");
			
			res  = downloadBlacklist();
			isExecuted = false;
		} else {
			logger.info("[DownloadOctMetaFileJob-call]Downloading blacklist file, Ignore current job");
		}
		
		return res;
	}
	
	private Boolean downloadBlacklist() {
		boolean res = false;
		
		File folder = new File(OCTOPUS_META_FILE_FOLDER);
		String currentVersion = "IBKL-000";
		File currentBlacklist = null;
		
		// BALCKLIST EXIST, GET CURRENT FILE NAME AS VERSION CODE
		String[] names = folder.list(new FilenameFilter() {
	        @Override
	        public boolean accept(File dir, String name) {
	            return name.startsWith("IBKL");
	        }
	    });
		if(names.length > 0) {
			currentBlacklist = new File(OCTOPUS_META_FILE_FOLDER + "/" + names[0]);
			currentVersion = names[0];
		}
		logger.info("[downloadBlacklist]Current Blacklist Version: " + currentVersion);
		
		try {
			OctopusStub stub = BackendServerComm.getOctopusStub();
			DownloadInterimBlacklist req = new DownloadInterimBlacklist();
			DownloadOctInterimBlacklistReq reqObj = new DownloadOctInterimBlacklistReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			reqObj.setCurrentVersion(currentVersion);
			
			for(int i = 0; i <= MAX_RETRY_COUNT; i++) {
				logger.info("[downloadBlacklist]Retry Count: " + (i + 1));
				
				try {
					DownloadInterimBlacklistResponse resp = stub.downloadInterimBlacklist(req);
					DownloadOctInterimBlacklistResp respObj = resp.get_return();
					
					HeartbeatJob.updateSucessTimeMsToServer();
					
					if(respObj.getResult()) {
						if(respObj.getFile() != null) {
							logger.info("[downloadBlacklist]Name: " + respObj.getFile().getName());
							logger.info("[downloadBlacklist]Size: " + respObj.getFile().getSize());
							logger.info("[downloadBlacklist]MD5: " + respObj.getFile().getMd5());
							
							try {
					            MessageDigest md = MessageDigest.getInstance("MD5");		
					            byte[] content = org.apache.commons.io.IOUtils.toByteArray(respObj.getFile().getContent().getInputStream());
					            byte[] messageDigest = md.digest(content);
					            
					            if(respObj.getFile().getMd5().equalsIgnoreCase(DatatypeConverter.printHexBinary(messageDigest))) {
					            		
				            		if(currentBlacklist != null) {
				            			File a = currentBlacklist;
				            			FileUtils.moveFile(a, new File(OCTOPUS_META_FILE_BACKUP_FOLDER + "/" + a.getName()));
				            			logger.info("[downloadBlacklist]Move current blacklist to: " + OCTOPUS_META_FILE_BACKUP_FOLDER + "/" + a.getName());
				            		}
				            		
		
				            		Path file = Paths.get(OCTOPUS_META_FILE_FOLDER + "/" + respObj.getFile().getName());
				            		Files.write(file, content);
				            		logger.info("[downloadBlacklist]Save new blacklist to: " + OCTOPUS_META_FILE_FOLDER + "/" + respObj.getFile().getName());
				     
				            		OctopusComm.logger.info("[downloadBlacklist]IBKL Success - " + respObj.getFile().getName() + " downloaded");
				            		OctopusComm.HouseKeeping();
				            		
				            		return true;
				            		
					            }else {
					            	logger.info("[downloadBlacklist]MD5 CHECKING: FAIL");
				            		throw new Exception("MD5 FAIL");
					            }
							} catch(NoSuchAlgorithmException e) {
					            logger.error("[downloadBlacklist]No Such Algorithm Error: ", e);
					        }
							
						}else {
							OctopusComm.logger.info("[downloadBlacklist]IBKL Success - already have the latest file");
							logger.info("[downloadBlacklist]Current blacklist file is the latest, no need to download.");
							return true;
						}
						
					} else {
						OctopusComm.logger.error("[downloadBlacklist]IBKL Fail - Download failed, error message: [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
						logger.error("[downloadBlacklist]Failed to download octopus blacklist file: [" + respObj.getErrorCode() + "] " + respObj.getErrorMsg());
						res = false;
					}
					
				} catch(Exception e) {
					if (i < MAX_RETRY_COUNT) {
						OctopusComm.logger.error("[downloadBlacklist]IBKL Fail - Download failed. Retry After " + RETRY_DURATION_SEC + "s : ",	e);
						logger.error("[downloadBlacklist]Failed to download octopus blacklist file. Retry After " + RETRY_DURATION_SEC + "s : ",	e);

						try {
							Thread.sleep(RETRY_DURATION_SEC * 1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
					} else {
						logger.error("[downloadBlacklist]Failed to download octopus blacklist file, cancel current job: ", e);
					}
				}
			}
			// End of for loop
			
			if (BackendServerComm.IS_WIRELESS_NETWORK) {
				logger.info("[downloadBlacklist]Try to reconnect mobile network.");
				ModemUtil.reconnect();
			}
			
		} catch(Exception e) {
			logger.error("[downloadBlacklist]Failed to init comm with server: ", e);
		}
		
		return res;
	}
	
	
}
