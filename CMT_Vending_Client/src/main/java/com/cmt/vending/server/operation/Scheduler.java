package com.cmt.vending.server.operation;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;
import static org.quartz.TriggerBuilder.newTrigger;

import com.cmt.vending.server.job.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Scheduler {
	private static Logger logger = LogManager.getLogger("schedule");
	private static org.quartz.Scheduler scheduler;
	
	
	/**
	 * Start general schedule including :
	 * 1. Transaction Upload Job (MPS file)
	 * 2. Meta File Download Job (Octopus)
	 * 3. Interim Blacklist Download Job (Octopus)
	 * 4. Heartbeat Job
	 * 5. Firmware Upgrade
	 */
	public static void startScheduler() {
		if(LocalDataManager.getVmInfo().getScheduler() != null) {
			HeartbeatJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getHeartbeatRetryDuration();
			HeartbeatJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getHeartbeatRetryCount();
	
			DownloadOctMetaFileJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getOctMetaFileRetryDuration();
			DownloadOctMetaFileJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getOctMetaFileRetryCount();
	
			DownloadOctBlackListJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getOctInterimBlkListRetryDuration();
			DownloadOctBlackListJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getOctInterimBlkListRetryCount();
	
			UploadSettlementFileJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getOctTranRetryDuration();
			UploadSettlementFileJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getOctTranRetryCount();
	
			FirmwareUpgradeJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getFwUpgradeRetryDuration();
			FirmwareUpgradeJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getFwUpgradeRetryCount();
		}
			
		logger.info("[startScheduler] Start init scheduler");
		
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			
			addHeartbeatJob();
			addGetVmInfoJob();
			addDownloadOctMetaFileJob();
			addDownloadOctBlackListJob();
			addGenerateSettlementFileJob();
			addSendTranJob();
			addSendAlertJob();
			addRebootJob();
			addFirmwareUpgradeJob();
			addSettlementIuc285Job();
			
		} catch (Throwable e) {
			logger.error("[startScheduler] Failed to start scheduler: ", e);
		}
	}
	
	public static void updateScheduler() {
		HeartbeatJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getHeartbeatRetryDuration();
		HeartbeatJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getHeartbeatRetryCount();

		DownloadOctMetaFileJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getOctMetaFileRetryDuration();
		DownloadOctMetaFileJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getOctMetaFileRetryCount();

		DownloadOctBlackListJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getOctInterimBlkListRetryDuration();
		DownloadOctBlackListJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getOctInterimBlkListRetryCount();

		UploadSettlementFileJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getOctTranRetryDuration();
		UploadSettlementFileJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getOctTranRetryCount();

		FirmwareUpgradeJob.RETRY_DURATION_SEC = LocalDataManager.getVmInfo().getScheduler().getFwUpgradeRetryDuration();
		FirmwareUpgradeJob.MAX_RETRY_COUNT = LocalDataManager.getVmInfo().getScheduler().getFwUpgradeRetryCount();

		try {
			scheduler.deleteJob(jobKey("HeartbeatJob", "group1"));
			addHeartbeatJob();

			scheduler.deleteJob(jobKey("GetVmInfoJobTrigger", "group2"));
			addGetVmInfoJob();
	
			scheduler.deleteJob(jobKey("DownloadOctMetaFileJob", "group4"));
			addDownloadOctMetaFileJob();
			
			scheduler.deleteJob(jobKey("DownloadOctBlackListJob", "group5"));
			addDownloadOctBlackListJob();
			
			scheduler.deleteJob(jobKey("GenerateSettlementFileJob", "group6"));
			addGenerateSettlementFileJob();
			
			scheduler.deleteJob(jobKey("SendTranJob", "group7"));
			addSendTranJob();
			
			scheduler.deleteJob(jobKey("SendAlertJob", "group8"));
			addSendAlertJob();
			
			scheduler.deleteJob(jobKey("RebootJob", "group9"));
			addRebootJob();
			
			scheduler.deleteJob(jobKey("FirmwareUpgradeJob", "group10"));
			addFirmwareUpgradeJob();
		}
		catch(Throwable e) {
			logger.error("[updateScheduler]Failed to update scheduler, ", e);
		}
	}

	
	public static void addHeartbeatJob() throws SchedulerException {
		JobDetail heartbeatJob = newJob(HeartbeatJob.class).withIdentity("HeartbeatJob", "group1").build();
		int heartbeatSchedule = LocalDataManager.getVmInfo().getScheduler() == null ? 0 : LocalDataManager.getVmInfo().getScheduler().getHeartbeatIntervalMin();
		logger.info("[Scheduler] HeartbeatJob: " + "0 0/" + heartbeatSchedule + " * * * ?");

		Trigger heartbeatTrigger = newTrigger().withIdentity("HeartbeatJobTrigger", "group1").startNow().withSchedule(cronSchedule("0 0/" + heartbeatSchedule + " * * * ?")).build();
		try {
			logger.info(scheduler.scheduleJob(heartbeatJob, heartbeatTrigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(heartbeatTrigger.getKey(), heartbeatTrigger);
		}
	}

	public static void addGetVmInfoJob() throws SchedulerException {
		JobDetail getVmInfoJob = newJob(GetVmInfoJob.class).withIdentity("GetVmInfoJob", "group2").build();
		logger.info("[Scheduler] GetVmInfoJob: " + "0 0 0 ? * * *");

		Trigger getVmInfoJobTrigger = newTrigger().withIdentity("GetVmInfoJobTrigger", "group2").startNow().withSchedule(cronSchedule("0 0 0 ? * * *")).build();
		try {
			logger.info(scheduler.scheduleJob(getVmInfoJob, getVmInfoJobTrigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(getVmInfoJobTrigger.getKey(), getVmInfoJobTrigger);
		}
	}
	
	
	public static void addDownloadOctMetaFileJob() throws SchedulerException {
		JobDetail downloadOctMetaFileJob = newJob(DownloadOctMetaFileJob.class).withIdentity("DownloadOctMetaFileJob", "group4").build();
		String octMetaSchedule = LocalDataManager.getVmInfo().getScheduler() == null ? "07:50" : LocalDataManager.getVmInfo().getScheduler().getOctMetaFileSche();
		String[] temp = octMetaSchedule.split(":");
		logger.info("[Scheduler] DownloadOctMetaFileJob: " + "0 " + Integer.parseInt(temp[1]) + " " + Integer.parseInt(temp[0]) + " 1/1 * ?");
		Trigger downloadOctMetaFileTrigger = newTrigger().withIdentity("DownloadOctMetaFileJobTrigger", "group4").startNow()
				.withSchedule(cronSchedule("0 " + Integer.parseInt(temp[1]) + " " + Integer.parseInt(temp[0]) + " 1/1 * ?")).build();
		try {
			logger.info(scheduler.scheduleJob(downloadOctMetaFileJob, downloadOctMetaFileTrigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(downloadOctMetaFileTrigger.getKey(), downloadOctMetaFileTrigger);
		}
	}
	
	public static void addDownloadOctBlackListJob() throws SchedulerException {
		JobDetail downloadOctBlackListJob = newJob(DownloadOctBlackListJob.class).withIdentity("DownloadOctBlackListJob", "group5").build();
		String octBlackListSchedule = LocalDataManager.getVmInfo().getScheduler() == null ? "40:00" : LocalDataManager.getVmInfo().getScheduler().getOctInterimBlkListSche();
		String[] temp = octBlackListSchedule.split(":");
		logger.info("[Scheduler] DownloadOctBlackListJob: " + Integer.parseInt(temp[1]) + " " + Integer.parseInt(temp[0]) + " 0/1 * * ?");
		Trigger downloadOctBlackListTrigger = newTrigger().withIdentity("DownloadOctBlackListJobTrigger", "group5").startNow()
				.withSchedule(cronSchedule(Integer.parseInt(temp[1]) + " " + Integer.parseInt(temp[0]) + " 0/1 * * ?")).build();
		try {
			logger.info(scheduler.scheduleJob(downloadOctBlackListJob, downloadOctBlackListTrigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(downloadOctBlackListTrigger.getKey(), downloadOctBlackListTrigger);
		}
	}
	
	public static void addGenerateSettlementFileJob() throws SchedulerException {

		JobDetail generateSettlementFileJob = newJob(GenerateSettlementFileJob.class).withIdentity("GenerateSettlementFileJob", "group6").build();
		String generateSettlementFileSchedule = LocalDataManager.getVmInfo().getScheduler() == null ? "22:00" : LocalDataManager.getVmInfo().getScheduler().getOctTranSche();
		String[] temp = generateSettlementFileSchedule.split(":");
		logger.info("[Scheduler] GenerateSettlementFileJob: 0 " + Integer.parseInt(temp[1]) + " " + Integer.parseInt(temp[0]) + " 1/1 * ?");
		Trigger generateSettlementFileTrigger = newTrigger().withIdentity("GenerateSettlementFileJobTrigger", "group6").startNow()
				.withSchedule(cronSchedule("0 " + Integer.parseInt(temp[1]) + " " + Integer.parseInt(temp[0]) + " 1/1 * ?")).build();
		try {
			logger.info(scheduler.scheduleJob(generateSettlementFileJob, generateSettlementFileTrigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(generateSettlementFileTrigger.getKey(), generateSettlementFileTrigger);
		}
	}
	
	public static void addSendTranJob() throws SchedulerException {
		JobDetail sendTranJob = newJob(SendTranJob.class).withIdentity("SendTranJob", "group7").build();
		logger.debug("[Scheduler] SendTranJob: 0 20 0 1/1 * ?");	// At 00:20:00am, every day starting on the 1st, every month
		Trigger sendTranTrigger = newTrigger().withIdentity("SendTranJobTrigger", "group7").startNow().withSchedule(cronSchedule("0 20 0 1/1 * ?")).build();
		try {
			logger.debug(scheduler.scheduleJob(sendTranJob, sendTranTrigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(sendTranTrigger.getKey(), sendTranTrigger);
		}
	}
	
	public static void addSendAlertJob() throws SchedulerException {
		JobDetail sendAlertJob = newJob(SendAlertJob.class).withIdentity("SendAlertJob", "group8").build();
		logger.info("[Scheduler] SendAlertJob: 0 25 0 1/1 * ?"); 		// At 00:25:00am, every day starting on the 1st, every month
		Trigger sendAlertTrigger = newTrigger().withIdentity("SendAlertJobTrigger", "group8").startNow().withSchedule(cronSchedule("0 25 0 1/1 * ?")).build();
		try {
			logger.info(scheduler.scheduleJob(sendAlertJob, sendAlertTrigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(sendAlertTrigger.getKey(), sendAlertTrigger);
		}
	}
	
	public static void addRebootJob() throws SchedulerException {
		JobDetail rebootJob = newJob(RebootVMJob.class).withIdentity("RebootJob", "group9").build();
		logger.info("[Scheduler] RebootJob: 0 0 4 1/1 * ?");
		Trigger rebootTrigger = newTrigger().withIdentity("RebootTrigger", "group9").startNow().withSchedule(cronSchedule("0 0 4 1/1 * ?")).build();
		try {
			logger.info(scheduler.scheduleJob(rebootJob, rebootTrigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(rebootTrigger.getKey(), rebootTrigger);
		}
	}

	public static void addFirmwareUpgradeJob() throws SchedulerException {
		JobDetail firmwareUpgradeJob = newJob(FirmwareUpgradeJob.class).withIdentity("FirmwareUpgradeJob", "group10").build();
		String firmwareUpgradeSchedule = LocalDataManager.getVmInfo().getScheduler() == null ? "03:00" : LocalDataManager.getVmInfo().getScheduler().getFwUpgradeSche();
		String[] temp = firmwareUpgradeSchedule.split(":");
		logger.info("[Scheduler] FirmwareUpgradeJob: 0 " + Integer.parseInt(temp[1]) + " "+ Integer.parseInt(temp[0]) + " 1/1 * ?");
		Trigger firmwareUpgradeTrigger = newTrigger().withIdentity("FirmwareUpgradeJobTrigger", "group10").startNow()
				.withSchedule(cronSchedule("0 " + Integer.parseInt(temp[1]) + " "+ Integer.parseInt(temp[0]) + " 1/1 * ?")).build();
		try {
			logger.info(scheduler.scheduleJob(firmwareUpgradeJob, firmwareUpgradeTrigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(firmwareUpgradeTrigger.getKey(), firmwareUpgradeTrigger);
		}
	}
	

	public static void addSettlementIuc285Job() throws SchedulerException {
		JobDetail settlementIuc285Job = newJob(SettlementIuc285Job.class).withIdentity("SendTranJob", "group14").build();
		logger.info("[Scheduler] SettlementIuc285Job: 0 30 0 1/1 * ?");
		Trigger settlementIuc285Trigger = newTrigger().withIdentity("SettlementIuc285JobTrigger", "group14").startNow().withSchedule(cronSchedule("0 30 0 1/1 * ?")).build();
		try {
			logger.info(scheduler.scheduleJob(settlementIuc285Job, settlementIuc285Trigger));
		} catch (Throwable e) {
			scheduler.rescheduleJob(settlementIuc285Trigger.getKey(), settlementIuc285Trigger);
		}
	}
	
	
	

}
