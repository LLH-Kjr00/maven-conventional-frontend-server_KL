package com.cmt.vending.util;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;


import com.cmt.vending.server.operation.BackendServerComm;
import com.sun.management.OperatingSystemMXBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JvmUtil {
	public static final DecimalFormat DF = new DecimalFormat("0.00");
	public static final long FACTOR = 1024 * 1024;
	private static Logger logger = LogManager.getLogger(BackendServerComm.class);
	
	public static String getMemoryUsage(){
		String s = "";
		
		Runtime rt = Runtime.getRuntime();
		try {
			long usedMemory = rt.totalMemory() - rt.freeMemory();
			long totalFree = rt.maxMemory() - usedMemory;
			
			long total = (totalFree + usedMemory) / FACTOR;
			long used = usedMemory / FACTOR;
			long free = total - used;

			double usedPerc = (double)used / total;
			double freePerc = 1d - usedPerc;
			String usedPercStr = DF.format(usedPerc * 100);
			String freePercStr = DF.format(freePerc * 100);
			s = usedPercStr + "," + freePercStr + "," + used + "," + free + "," + total;
		} catch (Exception e) {
			logger.error("Failed to get memory usage", e);
		}
		
		return s;
	}
	
	public static long getSwapSpaceUsedInMb() {
		long res = 0;
		
		try {
			OperatingSystemMXBean osMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
			res = (osMXBean.getTotalSwapSpaceSize()  - osMXBean.getFreeSwapSpaceSize()) / FACTOR;
		} catch (Exception e) {
			logger.error("Failed to get swap space used!", e);
		}
		
		return res;
	}
	
	public static String getSwapSpaceUsage(){
		String s = "";
		try {
			OperatingSystemMXBean osMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
			s = DF.format(osMXBean.getFreeSwapSpaceSize() / FACTOR)					//amount of free swap space in megabytes.
					+ "," + DF.format(osMXBean.getTotalSwapSpaceSize() / FACTOR)	//amount of total free swap space in megabytes.
					+ "," + DF.format(osMXBean.getCommittedVirtualMemorySize() / FACTOR);	//the amount of virtual memory that is guaranteed to be available to the running process in bytes, or -1 if this operation is not supported.
		} catch (Exception e) {
			logger.error("Failed to swap space usage.", e);
		}
		
		return s;
	}
	
	public static String getCpuUsage(){
		String s = "";
		try {
			OperatingSystemMXBean osMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
			s = DF.format(osMXBean.getProcessCpuLoad())				//"recent cpu usage" for the Java Virtual Machine process.
					+ "," + DF.format(osMXBean.getSystemCpuLoad())		//"recent cpu usage" for the whole system.
					+ "," + DF.format(osMXBean.getSystemLoadAverage())	//system load average for the last minute.
					+ "," + osMXBean.getProcessCpuTime() / 1000000000;	//CPU time used by the process on which the Java virtual machine is running in second.
		} catch (Exception e) {
			logger.error("Failed to get cpu usage.", e);
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		String m = getMemoryUsage();
		System.out.println("Memory usage:" + m);
		m = getSwapSpaceUsage();
		System.out.println("Swap Space Usage:" + m);
		String u = getCpuUsage();
		System.out.println("CPU Usage:" + u);
	}
}
