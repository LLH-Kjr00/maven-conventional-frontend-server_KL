package com.cmt.vending.server.job;

import java.io.File;
import java.util.Date;
import java.util.concurrent.Callable;

import com.cmt.vending.server.operation.*;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.model.FirmwareUpgradeHistory;
import com.cmt.vending.server.model.MetaData;
import com.cmt.vending.ws.CheckFirmware;
import com.cmt.vending.ws.CheckFirmwareResponse;
import com.cmt.vending.ws.ReportFirmwareUpgradeResult;
import com.cmt.vending.ws.ReportFirmwareUpgradeResultResponse;
import com.cmt.vending.ws.VendingStub;
import com.cmt.vending.ws.obj.xsd.FirmwareInfo;
import com.cmt.vending.ws.obj.xsd.FirmwareUpgradeReq;
import com.cmt.vending.ws.obj.xsd.FirmwareUpgradeResp;
import com.cmt.vending.ws.obj.xsd.FirmwareUpgradeResultReq;
import com.cmt.vending.ws.obj.xsd.FirmwareUpgradeResultResp;

public class FirmwareUpgradeJob  implements Callable<Boolean>, Job {
	private static final Logger logger = LogManager.getLogger("schedule");
	private static FirmwareUpgradeHistory history;
	
	private static boolean isExecuted = false;				// Whether any firmware upgrade job is processing
	
	private static boolean RESTART_FLAG = false;			// Whether restart the app after upgrade
	private static boolean HOUSE_KEEPING_FLAG = false;		// Whether do the house keeping after upgrade
	private static boolean REBOOT_FLAG = false;				// Whether reboot the machine after upgrade
	
	public static int RETRY_DURATION_SEC = 30;
	public static int MAX_RETRY_COUNT = 1;
	
	/**
	 * Get the current version number
	 * @return
	 */
	public static String getCurrentFirmwareVersion() {
		if (history == null) {
			history = (FirmwareUpgradeHistory) ResourceManager.getDataFromLocalStorage(ResourceManager.FIRMWARE_FOLDER, ResourceManager.FIRMWARE_LOG);
		}
		if (history == null) {
			history = new FirmwareUpgradeHistory();
			history.setCurrentVersionCode(LocalServer.VERSION_CODE);
			ResourceManager.saveDataToLocalStorage(history, ResourceManager.FIRMWARE_FOLDER, ResourceManager.FIRMWARE_LOG);
		}
		return history.getCurrentVersionCode();
	}


	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		// Making sure that no transaction is processing
		try {
			while (TransactionManager.IS_TRAN_PROCESS) {
				Thread.sleep(1000);
			}
			BackendServerComm.startJob(this);
		}catch (Exception e) {
			logger.error("[FirmwareUpgradeJob-execute]Error in waiting to upgrade firmware: ", e);
		}
		
	}

	@Override
	public Boolean call() throws Exception {
		boolean res = false;

		if (!isExecuted) {
			
			isExecuted = true;
			RESTART_FLAG = false;
			REBOOT_FLAG = false;			
			HOUSE_KEEPING_FLAG = false;	
			logger.info("[FirmwareUpgradeJob-call]Start to check firmware version.");
			
			// Get the current version number from the history file
			logger.info("[FirmwareUpgradeJob-call]Current Version Code: " + getCurrentFirmwareVersion() );

			res = checkVersion(null);
			isExecuted = false;
			
		} else {
			logger.info("[FirmwareUpgradeJob-call]Firmware Upgrading, Ignore current job. ");
		}
		return res;
	}
	
	/**
	 * Unzip the upgrade package and execute installation
	 * @param info
	 * @return
	 */
	private boolean unzipAndExecuteUpgradePackage(FirmwareInfo info) {
		boolean res = ZipUtil.unzip(
				new File(ResourceManager.FIRMWARE_FOLDER + File.separator + info.getFmVersion() + ".zip"),
				ResourceManager.FIRMWARE_FOLDER);
		
		// If unzip the upgrade package successfully
		if (res) {
			// Disconnect UI web socket
			UIWebSocketEndpoint.cleanUp();
	
			// Add this upgrade to the history
			MetaData data = (MetaData) ResourceManager.getDataFromLocalStorage(
					ResourceManager.FIRMWARE_FOLDER + File.separator + info.getFmVersion(), "meta.xml");
			history.setCurrentVersionCode(data.getVersionNo());
			history.getHistory().add(data);
			ResourceManager.saveDataToLocalStorage(history, ResourceManager.FIRMWARE_FOLDER, ResourceManager.FIRMWARE_LOG);
	
			if (data.getRestartApplicationFlag().equals("Y")) RESTART_FLAG = true;
			if (data.getOctopusHousekeepingFlag().equals("Y"))HOUSE_KEEPING_FLAG = true;	
			if (data.getRebootOperatingSystemFlag().equals("Y")) REBOOT_FLAG = true;
	
			// Execute the install.sh in upgrade package
			int exitVal = 0;
			File install = new File(ResourceManager.FIRMWARE_FOLDER + File.separator + info.getFmVersion()+ File.separator + "install.sh");
			if (install.exists()) {
				install.setExecutable(true);
				exitVal = RuntimeUtil.runtimeExecInt(install.getAbsolutePath());
			}
	
			// If the installation result is not 0, set the upgrade result as false;
			if (exitVal != 0) res = false;
	
		// If failed to unzip the upgrade package 
		} else {
			logger.error("[downloadUpgradePackage]Failed to unzip firmware");
			
			// Delete the downloaded package
			File zipFile = new File(ResourceManager.FIRMWARE_FOLDER + File.separator + info.getFmVersion() + ".zip");
			zipFile.delete();
			File zipFileFinished = new File(ResourceManager.FIRMWARE_FOLDER + File.separator+ info.getFmVersion() + ".zip_finished");
			zipFileFinished.delete();
		}
		
		return res;
	}
	
	/**
	 * Download upgrade package
	 * @param info
	 * @return
	 */
	private boolean downloadUpgradePackage(FirmwareInfo info) {
		boolean res = false;
		
		logger.info("[downloadUpgradePackage]Start download upgrade firmware[" + info.getFmVersion()+ "] from server.");
		logger.info("[downloadUpgradePackage]Firmware call [" + String.valueOf(info.getMediaId())+ "] on the server.");
		
		try {
			File indicatorFile = new File(ResourceManager.FIRMWARE_FOLDER+"/"+info.getFmVersion() + ".zip_finish");
			File realFile = new File(ResourceManager.FIRMWARE_FOLDER+"/"+info.getFmVersion() + ".zip");
			
			// If the upgrade pacakge file exist already
			if (indicatorFile.exists() && realFile.length() > 0) return true;
			
			res = SFTPComm.download(String.valueOf(info.getMediaId()), ResourceManager.FIRMWARE_FOLDER,info.getFmVersion() + ".zip", false);
			
		} catch(Exception e) {
			logger.error("[downloadUpgradePackage]Error in downloading upgrade package: ", e);
		}

		return res;
	}
	
	/**
	 * Check Version number and decide if need to upgrade or not
	 * @param targetVersionNo
	 * @return
	 */
	private boolean checkVersion(String targetVersionNo) {
		boolean res = false;
		String errorMsg = "";

		try {
			// Initialize request object
			VendingStub stub = BackendServerComm.getVendingStub();
			CheckFirmware req = new CheckFirmware();
			FirmwareUpgradeReq reqObj = new FirmwareUpgradeReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			reqObj.setVersionNo(history.getCurrentVersionCode());
			reqObj.setTargetVersionNo(targetVersionNo);
			
			for (int i = 0; i <= MAX_RETRY_COUNT; i++) {
				logger.info("[checkVersion]Retry Count: " + (i + 1));

				try {
					CheckFirmwareResponse resp = stub.checkFirmware(req);
					FirmwareUpgradeResp respObj = resp.get_return();
					
					HeartbeatJob.updateSucessTimeMsToServer();
					
					if (respObj.getResult()) {
						
						if (respObj.getFmInfo() == null) {
							logger.info("[checkVersion]Current firmware is the latest, no need to upgrade.");
							return true;
						} else {
							if (targetVersionNo != null) {
								logger.info("[checkVersion]Need to download target version as dependency: "+ targetVersionNo);
							} else {
								logger.info("[checkVersion]Current firmware is not the latest, need to upgrade.");
							}
												
							FirmwareInfo info = respObj.getFmInfo();
							logger.info("[checkVersion]Firware version: " + info.getFmVersion());
							logger.info("[checkVersion]Dependency: " + info.getFmDependance());
							logger.info("[checkVersion]Change History: " + info.getChangeHistory());
							logger.info("[checkVersion]Deploy Datetime: " + DateUtil.formatDate(new Date(info.getDeployDttm())));
							logger.info("[checkVersion]Remark: " + info.getRemark());

							// If there is dependency (previous version of firmware)
							if (!StringUtil.isEmpty(info.getFmDependance())) {
								String[] versions = info.getFmDependance().split(",");
								for (int index = 0; index < versions.length; index++) {
									// If the previous version of firmware is not installed -> install
									if (!history.isUpgraded(versions[index])) {
										logger.info("[checkVersion]Target version [ " + versions[index]
												+ " ]is not applied, start to download.");
										res = checkVersion(versions[index]);

										// Upgrade failed -> break;
										if (!res) break;
									// If the previous version of firmware is installed
									} else {
										logger.info("[checkVersion]Target version [" + versions[index] + "] is applied.");
										res = true;
									}
								}
							} else {
								res = true;
							}

							// If ready to download -> download
							if (res) res = downloadUpgradePackage(info);
							else {
								errorMsg = "Not ready to uprgade since dependency downlaod fialed.";
								reportUpgradeResult(info, res, errorMsg);
								continue;
							} 
							
							// If download successful -> upzip and install
							if (res) res = unzipAndExecuteUpgradePackage(info);
							else {
								errorMsg = "Download upgrade package failed.";
								reportUpgradeResult(info, res, errorMsg);
								continue;
							} 
							
							// If Unzip and install fail
							if (!res)  {
								errorMsg = "Unzip or Execution of upgrade pacakge failed";
								reportUpgradeResult(info, res, errorMsg);
								continue;
							}

							// Report the upgrade result (success)
							reportUpgradeResult(info, res, errorMsg);
							
							// If the upgrade result is successful and this is not installing dependency
							if (res && targetVersionNo == null) {
								if (HOUSE_KEEPING_FLAG && OctopusComm.isOctNormal) {
									logger.info("[checkVersion]Octopus House Keeping.");
									OctopusComm.HouseKeeping();
								}

								if (REBOOT_FLAG) {
									logger.info("[checkVersion]Reboot system now.");
									RuntimeUtil.rebootCommand();
									
								} else if (RESTART_FLAG) {
									try {
										if (LocalServer.getVmc() != null) {
											LocalServer.getVmc().cleanup();
										}
									} catch (Exception e) {
										logger.error("[checkVersion]Failed to clean up vending machine: ", e);
									} finally {
										logger.info("[checkVersion]Restart application.");
										RuntimeUtil.restartCommand();
									}
								}
							}

						}
						
					// If the back end refuse the request -> retry
					} else {
						logger.info("[checkVersion]Request of firmware checking aborted, [" + respObj.getErrorCode() + "] "
								+ respObj.getErrorMsg());
						res = false;
					}

					// If this is the installation of dependency or the res is true
					// If any trial is successful, the function will end here
					if (targetVersionNo != null || res) return res;
					
				// Any error occur in connection with back end
				} catch (Exception e) {
					if (i < MAX_RETRY_COUNT) {
						logger.error("[checkVersion]Failed to check firmware version. Retry After " + RETRY_DURATION_SEC + "s : ",	e);

						try {
							Thread.sleep(RETRY_DURATION_SEC * 1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}

					} else {
						logger.error("[checkVersion]Failed to check firmware version, cancel current job: ", e);
					}
				}
			}
			// End of for loop

			// Reconnect network since upgrade failed
			if (BackendServerComm.IS_WIRELESS_NETWORK) {
				logger.info("[checkVersion]Try to reconnect mobile network.");
				ModemUtil.reconnect();
			}
		} catch (Exception e) {
			logger.error("[checkVersion]Failed to init comm with server: ", e);
		}

		return res;
	}
	
	/**
	 * Report the upgrade result to the back end server
	 * @param info
	 * @param res
	 * @param errorMsg
	 */
	private void reportUpgradeResult(FirmwareInfo info, boolean res, String errorMsg) {
		try {
			FirmwareUpgradeResultReq reqObj2 = new FirmwareUpgradeResultReq();
			ReportFirmwareUpgradeResult req2 = new ReportFirmwareUpgradeResult();
			req2.setReq(reqObj2);
			BackendServerComm.setGeneralInfo(reqObj2);
			reqObj2.setFmId(info.getFmId());
			reqObj2.setStatus(res ? "S" : "F");
			reqObj2.setRemark(errorMsg);

			VendingStub stub = BackendServerComm.getVendingStub();
			ReportFirmwareUpgradeResultResponse resp2 = stub.reportFirmwareUpgradeResult(req2);
			FirmwareUpgradeResultResp respObj2 = resp2.get_return();

			if (respObj2.getResult()) {
				HeartbeatJob.updateSucessTimeMsToServer();
				logger.info("[reportUpgradeResult]Report upgrade result successfully.");
			} else {
				logger.error("[reportUpgradeResult]Request of report result aborted, [" + respObj2.getErrorCode()+ "] " + respObj2.getErrorMsg());
			}
		} catch (Exception e) {
			logger.error("[reportUpgradeResult]Failed to report result to server: ", e);
		}
	}
}
