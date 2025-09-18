package com.cmt.octopus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestXFile {
	static RwlAdapter adapter = new RwlAdapter();
	
	public static void main(String[] args) throws ParseException {
		RwlReturn rwlReturn = new RwlReturn();

		rwlReturn = adapter.InitComm(0, 115200, 0);
		System.out.println("InitComm() executed, return: "+rwlReturn.getReturnCode());
		System.out.println(getLog("InitComm", rwlReturn));
		
		
		rwlReturn = adapter.XFile();
		System.out.println("XFile() executed, return: "+rwlReturn.getReturnCode());
		XFileData xFileData = (XFileData)rwlReturn.getReturnData();
		System.out.println("File name: "+xFileData.getReturnData());
		
		rwlReturn = adapter.Reset();
		System.out.println("Reset() executed, return: "+rwlReturn.getReturnCode());
		
		rwlReturn = adapter.PortClose();
		System.out.println("PortClose() executed, return: "+rwlReturn.getReturnCode());
	}
	
	static String getLog(String function, RwlReturn returnObj){
		String result;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String currentTime = dateFormat.format(cal.getTime());
		result = currentTime + " | " + function + " | " + returnObj.getReturnCode();
		return result;
	}
}
