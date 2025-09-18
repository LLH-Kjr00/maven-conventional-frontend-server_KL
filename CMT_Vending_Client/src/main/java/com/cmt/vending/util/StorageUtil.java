package com.cmt.vending.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StorageUtil {
	private static Logger logger = LogManager.getLogger(StorageUtil.class);
	
	private static String DEFAULT_PARTITION = "/";
	
	public static BigDecimal getUsedStorageAsPercentage() {
		return StorageUtil.getUsedStorageAsPercentage(StorageUtil.DEFAULT_PARTITION);
	}
	
	/**
	 * Get OS storage usage
	 * @param partition
	 * @return 
	 */
	public static BigDecimal getUsedStorageAsPercentage(String partition) {
		logger.info("[getUsedStorageAsPercentage]Try to get Storage Usage");
		try{
			//String command = String.format("df --output=pcent %s | tail -1", partition);
			//String result = RuntimeUtil.runtimeExec(new String[]{"/bin/sh", "-c", command});
			//String value = result.trim().replace("%", "");
			//BigDecimal value = RuntimeUtil.getStorageFromProcess_Command(command);

			//Author: Ken Lung, Time: 09/09/2025 
			//Action(s): Get the used space in % using Java Standard Library instead of command prompt 
			//Reason(s): It is too troublesome to insist on using command prompt, either it shows too many unnecessary info or it outright does not work

			Path path = Paths.get(partition);
			FileStore fileStore = Files.getFileStore(path);
			long totalSpace = fileStore.getTotalSpace();
            long usableSpace = fileStore.getUsableSpace();
            long usedSpace = totalSpace - usableSpace;

           	double usedSpacePercentage = ((double) usedSpace / totalSpace) * 100;
			//Format the double variable to show two decimal places after the decimal points in the log
			logger.info("[getUsedStorageAsPercentage] Current Storage Usage: " + String.format( "%.2f", usedSpacePercentage )+"%");
			return new BigDecimal(usedSpacePercentage);

		} 
		catch(Throwable e) {
			return new BigDecimal(0);
		}
	}
	
}
