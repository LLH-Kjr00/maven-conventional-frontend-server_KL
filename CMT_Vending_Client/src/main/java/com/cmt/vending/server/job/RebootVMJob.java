package com.cmt.vending.server.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.util.RuntimeUtil;
import com.cmt.vending.server.operation.TransactionManager;

public class RebootVMJob implements Runnable, Job  {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

	private static Logger logger = LogManager.getLogger(RebootVMJob.class);

	@Override
	public void run() {
		logger.info("[RebootVmJob-run]Start to execute reboot vm job.");
		logger.info("[RebootVmJob-run]Check network status.");

		Socket sock = new Socket();
		InetSocketAddress addr = new InetSocketAddress("google.com", 80);

		try {
			sock.connect(addr, 8000);
			logger.info("[RebootVmJob-run]System's network connection  is fine so no need to restarting Ubuntu");
		} catch (IOException e) {
			logger.info("[RebootVmJob-run]System's network connection is not reachable.");
			SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_STAT, "02"));
			reboot();
		} finally {
			try {
				sock.close();
			} catch (IOException e) {

			}
		}

	}

	private void reboot () {
		if (LocalServer.getLocalServerConfig().getEnv() != "PRD" ) return;

		try {
			while (TransactionManager.IS_TRAN_PROCESS ) {
				Thread.sleep(200);
			}

			RuntimeUtil.rebootCommand();
		} catch (Exception e) {
			logger.error("[reboot]Error in waiting to reboot: ", e);
		}

	}

}
