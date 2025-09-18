package com.cmt.vending.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZipUtil {
	private static Logger logger = LogManager.getLogger(ZipUtil.class);
	
	public static boolean unzip(File zipFile, String targetFolder) {
		boolean res = false;
		byte[] buffer = new byte[1024];
		
		File folder = new File(targetFolder);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		try {
			ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry ze = zis.getNextEntry();
	    	
		    	while(ze!=null){
		     	   File newFile = new File(targetFolder + File.separator + ze.getName());
		     	   logger.info("[unzip]Unzip file : " + newFile.getAbsolutePath());
		
		     	   new File(newFile.getParent()).mkdirs();
		
		     	   if(!ze.isDirectory()) {
		     		   newFile.createNewFile();
			     	   FileOutputStream fos = new FileOutputStream(newFile);
			     	   int len;
			     	   while ((len = zis.read(buffer)) > 0) {
			     		   fos.write(buffer, 0, len);
			     	   }
			     	   fos.close();
		     	   }
		     	   ze = zis.getNextEntry();
		    	}
		    	
	    	zis.closeEntry();
	     	zis.close();
	     	logger.debug("[unzip]Unzip file successfully.");
	     	res = true;
		}
		catch(Throwable e) {
			logger.error("[unzip]Failed to unzip file to " + folder.getAbsolutePath(), e);
		}
		
		return res;
	}
}
