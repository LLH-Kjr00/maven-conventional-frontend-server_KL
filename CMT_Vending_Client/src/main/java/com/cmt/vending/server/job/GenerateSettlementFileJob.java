package com.cmt.vending.server.job;

import java.io.File;


import com.cmt.vending.server.operation.*;
import com.cmt.vending.server.payment.OctopusPayment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cmt.octopus.RwlReturn;
import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.config.LocalServerConfig;
import com.cmt.vending.server.model.SettlementFile;

public class GenerateSettlementFileJob implements Runnable, Job{
	
	private static Logger logger = LogManager.getLogger("schedule");

	public static String OCT_UPLOAD_FOLDER = "/opt/octopus/upload";

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		if(LocalServer.getLocalServerConfig().getRegion().equals(LocalServerConfig.REGION_HK))  {
			BackendServerComm.startJob(this);
		}
		
	}

	@Override
	public void run() {
		logger.info("[GenerateSettlementFileJob-call]Start to generate octopus settlement file.");

		if (OctopusPayment.octconfig.getVERSION() == 3){
			logger.info("[GenerateSettlementFileJob-call]The octopus version is 3. So the settlement file will not be exported to this machine");
			if (LocalServer.getVmc().checkPayment(OctopusPayment.CODE)) {
				OctopusPayment octopusObject = (OctopusPayment) LocalServer.getVmc().getPayment(OctopusPayment.CODE);
				octopusObject.settle3();
				return;
			}
		}

		RwlReturn settlementFile = OctopusComm.xFile();
		File settlement = new File(OCT_UPLOAD_FOLDER + "/" + settlementFile.getReturnData());
		logger.info("[GenerateSettlementFileJob-call]Current settlement file: " + settlement.getAbsolutePath());
		
		if(!settlement.isDirectory() && settlement.exists()) {
			SettlementFile file = new SettlementFile();
			file.setUuid(TransactionManager.getTranUUID().getUuid().toArray(new String[TransactionManager.getTranUUID().getUuid().size()]));
			file.setFileName(settlementFile.getReturnData().toString());
			String currentDeviceId = OctopusComm.getDeviceNo();
			file.setDeviceId(currentDeviceId);
			
			// Add this settlement file into record
			TransactionManager.getOctSettlement().getSettlementFile().add(file);
			
			// Clear uuid list after generate Settlement File
			TransactionManager.getTranUUID().getUuid().clear();
			ResourceManager.saveInfo(TransactionManager.getTranUUID(), ResourceManager.INFO_TRAN_UUID);
		}
		
		// When there is no settlement file generated now, there might be previous settlement files not uploaded
		// Therefore, we still need to run the upload settlement file job.
		try {
			boolean res = (boolean) BackendServerComm.startJob(new UploadSettlementFileJob()).get();
			if(res) {
				TransactionManager.getOctSettlement().getSettlementFile().clear();
			}else {
				logger.error("[GenerateSettlementFileJob-call]Failed to upload settlement to server, save it to local storage.");
			}
		} catch (Exception e) {
			logger.error("[GenerateSettlementFileJob-call]Failed to upload settlement to server, save it to local storage.", e);
		}
		ResourceManager.saveInfo(TransactionManager.getOctSettlement(), ResourceManager.INFO_SETTLEMENT_FILE);
	}

}
