package com.cmt.vending.util;

import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;

import com.cmt.vending.server.job.HeartbeatJob;

public class ModemUtil extends RuntimeUtil {
    private static Logger logger = LogManager.getLogger(ModemUtil.class);

    public static Integer getSignalQuality() {
        // TODO complete get signal quality function
        if (!isNmcliInstalled()) {
            handleInstallnmcli();
        }
        String pout = runtimeExec("nmcli -t -f TYPE,STATE connection show --active");
        // Check if the output is empty
        if (pout.isEmpty()) {
            return 0;
        }

        // Split the output to determine the connection type
        String[] parts = pout.split(":");
        String connectionType = parts[0]; // Get the first part which is the TYPE

		// check signal strength if the connection is wifi-based
        if (connectionType.toLowerCase().contains("wifi")) {
            logger.info("[getSignalQuality]Current connection: " + connectionType + " returning measured value");
            // If the connection is Wi-Fi, get the signal quality
            String signalOutput = runtimeExec("nmcli -t -f IN-USE,SIGNAL dev wifi");
            String[] signalParts = signalOutput.split(":");

            // Check if we have a valid signal output
            if (signalParts.length > 1 && signalParts[0].equals("*")) {
                return Integer.parseInt(signalParts[1]);
            } else {
                return 0;
            }

		// check signal strength if the connection is mobile data-based (gsm and lte are category for mobile data)
        } else if (connectionType.toLowerCase().contains("gsm") || connectionType.toLowerCase().contains("lte")) {
            logger.info("[getSignalQuality]Current connection: " + connectionType + " returning measured value");
            // If the connection is a mobile network, get the signal quality
            String signalOutput = runtimeExec("mmcli -m 0 | grep 'signal quality'");
            String[] signalParts = signalOutput.split(":");

            // Check if we have a valid signal output
            if (signalParts.length > 1 && signalParts[0].equals("*")) {
                return Integer.parseInt(signalParts[1]);
            } else {
                return 0;
            }
		// no need to check for ethernet connection since it is the best that it can be already	
        } else if (connectionType.toLowerCase().contains("ethernet")) {
            logger.info("[getSignalQuality]Current connection: " + connectionType + " returning fixed value");

            // For wired connection, return a fixed value
            return 100;
        } else {
            logger.error("[getSignalQuality]Current connection: " + connectionType + " returning null value");

            return null;
        }
    }


    private static boolean isNmcliInstalled() {
        String command = "nmcli --version";
        String output = runtimeExec(command);
        // Check if output contains "nmcli" indicating it is installed
        return output.toLowerCase().contains("nmcli");
    }


    private static boolean handleInstallnmcli() {
        if (!isNmcliInstalled()) {
            logger.warn("[handleInstallnmcli]nmcli is not installed. Installing now...");
            return installNetworkManager();

        }
        return true;

    }

    private static boolean installNetworkManager() {
        String installCommand = "sudo apt update && sudo apt install -y network-manager";
        // Execute the installation command
        String output = runtimeExec(installCommand);
        logger.info("[installNetworkManager] Installation output: " + output);

        // Check if the installation was successful
        return isNmcliInstalled(); // Recheck if nmcli is installed
    }

    public static void reconnect() {
        logger.info("[reconnect]Try to reconnect mobile network by rebooting");
        new Thread(new Runnable() {
            @Override
            public void run() {
                HeartbeatJob.checkSuccessTimeMsToServer();
            }

        }).start();
    }

    /**private static String handleSignalQualityResult(String rawOutput) {
    	String output = "";
    	String keyword = "uint32 ";
    	int rawIndexOf = rawOutput.indexOf(keyword, rawOutput.indexOf(keyword) + 1);
    	String signalFail = "-";
    	logger.debug(rawIndexOf);
    	if (rawIndexOf >= 0) {
    		output = rawOutput.substring(rawIndexOf + keyword.length());
    		output = output.substring(0,  output.indexOf("\n"));
    		logger.info("Signal Quality: " + output + " from ModemHandler.");
    		
    	} else {
    		logger.error(rawOutput);
    		output = signalFail;
    	}
    	return output;
    

    }
    	**/
}