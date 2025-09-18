package com.cmt.vending.server.listener;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.backendWebSocket.BackendWebSocketThread;
import com.cmt.vending.server.job.FirmwareUpgradeJob;
import com.cmt.vending.server.job.HeartbeatJob;
import com.cmt.vending.server.job.SendAlertJob;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.server.operation.Scheduler;
import com.cmt.vending.server.operation.TransactionManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * The listener to listener the servlet container (Jetty, or Tomcat)
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger(ApplicationListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Application Start");

        // Step 1
        LocalServer.loadConfig();

        // Setp 2
        BackendServerComm.startJob(new FirmwareUpgradeJob());

        // Step 3-9
        LocalServer.loadLocalData();

        // Step 10
        Scheduler.startScheduler();

        // Step 11 - 12
        LocalServer.initVMC();

        // Step 13
        TransactionManager.sendTran();

        // Step 14
        SendAlertJob.startJob(new SendAlertJob());

        // Step 15
        try {
            BackendServerComm.startJob(new HeartbeatJob());
        } catch (Throwable e) {
            logger.error("Failed to complete heartbeat job", e);
        }

        new Thread(new BackendWebSocketThread()).start();

        logger.info("Application Complete Init.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Application Destroyed");
    }
}
