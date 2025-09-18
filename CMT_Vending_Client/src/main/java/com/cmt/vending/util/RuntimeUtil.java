package com.cmt.vending.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.LocalServer;

/**
 * Util to handle terminal command
 */
public class RuntimeUtil {
	private static Logger logger = LogManager.getLogger(RuntimeUtil.class);
	
	public static int runtimeExecInt(String command) {
		logger.info("[runtimeExecInt]Execute command:" + command);
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			return p.exitValue();
		} catch (Throwable  e) {
			logger.error("[runtimeExecInt]", e);
		}
		return -1;
	}
	
	public static String runtimeExec(String command) {
		logger.info("[runtimeExec] Execute command: " + command);
		StringBuilder output = new StringBuilder();
		Process p;

		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();

			// Read standard output
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
				String line;
				while ((line = reader.readLine()) != null) {
					if (!line.isEmpty()) {
						if (output.length() > 0) {
							output.append(System.lineSeparator());
						}
						output.append(line);
					}
				}
			}

			// If no output, check error stream
			if (output.length() <= 0) {
				try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
					String line;
					while ((line = errorReader.readLine()) != null) {
						if (!line.isEmpty()) {
							if (output.length() > 0) {
								output.append(System.lineSeparator());
							}
							output.append(line);
						}
					}
				}
			}
		} catch (IOException e) {
			logger.error("[runtimeExec] IOException: ", e);
		} catch (InterruptedException e) {
			logger.error("[runtimeExec] InterruptedException: ", e);
			Thread.currentThread().interrupt(); // Restore interrupt status
		}

		return output.toString();
	}

	
	public static String runtimeExec(String[] command) {
		return runtimeExec(command[2]);
	}
	
	public static void rebootCommand(){
		try {
			//command out the following section that does pretty much only annoyance 
			/**
			 * if (LocalServer.getLocalServerConfig().getEnv().equals("DEV")) {
				logger.info("[shutdownCommand]In development mode, cannot reboot");
				return;
			}
			 */
			Runtime.getRuntime().exec("sudo reboot");
		} catch (IOException e) {
			logger.error("[rebootCommand]Failed to reboot: ",e);
		}
	}
	
	public static void restartCommand() {
		try {
			Runtime.getRuntime().exec("sudo /opt/vending/script/restart_tomcat.sh");
		} catch (IOException e) {
			logger.error("[restartCommand]Failed to restart: ",e);
		}
	}
	
	public static void shutdownCommand() {
		try {
			//command out the following section that does pretty much only annoyance 
			/**
			 * if (LocalServer.getLocalServerConfig().getEnv().equals("DEV")) {
				logger.info("[shutdownCommand]In development mode, cannot reboot");
				return;
			}
			 */
			Runtime.getRuntime().exec("sudo shutdown now");
		} catch (IOException e) {
			logger.error("[rebootCommand]Failed to shutdown now: ",e);
		}
	}
}