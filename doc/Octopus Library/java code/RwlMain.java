package com.cmt.octopus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RwlMain {
	static RwlAdapter adapter = new RwlAdapter();
	
	public static void main(String[] args) throws ParseException {
		RwlReturn rwlReturn = new RwlReturn();

		rwlReturn = adapter.InitComm(0, 115200, 0);
		System.out.println("InitComm() executed, return: "+rwlReturn.getReturnCode());
		System.out.println(getLog("InitComm", rwlReturn));
		/*
		char led = 2, sound = 0;
		rwlReturn = adapter.TxnAmt(1, 200, led, sound);
		System.out.println("TxnAmt() executed, return: "+rwlReturn.getReturnCode());
		*/
		rwlReturn = adapter.TimeVer();
		System.out.println("TimeVer() executed, return: "+rwlReturn.getReturnCode());
		TimeVerData timeVerData = (TimeVerData)rwlReturn.getReturnData();
		System.out.println("TimeVerData:" + timeVerData);
		System.out.println("DEV ID:" + timeVerData.getDevID());
		System.out.println("Oper ID:" + timeVerData.getOperID());
		System.out.println("Comp ID:" + timeVerData.getCompID());
		System.out.println("DEV Time:" + timeVerData.getDevTime());
		System.out.println("Key Ver:" + timeVerData.getKeyVer());
		System.out.println("EOD Ver:" + timeVerData.getEODVer());
		System.out.println("BlackList Version: "+timeVerData.getBLVer());
		System.out.println("FIRM Version:" + timeVerData.getFIRMVer());
		System.out.println("CCHSVer:" + timeVerData.getCCHSVer());
		System.out.println("CSSer:" + timeVerData.getCSSer());
		System.out.println("Internal BlackList Version: "+timeVerData.getIntBLVer());
		System.out.println("FuncBLVer:" + timeVerData.getFuncBLVer());
		
		char sub_com, timeout;
		long s, e;
		sub_com = 0;
		PollExData pollData;
		
		timeout = 1;
		for(int i = 11; i>=0 ; i--){
			timeout = (char)i;
		s = System.currentTimeMillis();
		rwlReturn = adapter.PollEx(sub_com, timeout);
		e = System.currentTimeMillis();
		System.out.println("Polled: " + (e - s) + " ms, timeout is " + (int)timeout);
		System.out.println("PollEx() executed, return: "+rwlReturn.getReturnCode() + ", sub_com:" + sub_com); // remain value or error code
		pollData = (PollExData)rwlReturn.getReturnData();
		pollData.processData(); // split raw data 
		System.out.println("Old Card ID: "+pollData.getOldCardId());
		System.out.println("New Card ID: "+pollData.getNewCardId());
		System.out.println("Customer Info: "+pollData.getCustomerInfo());
		System.out.println();
		}
		
		
		sub_com = 1;
		timeout = 1;
		for(int i = 11; i>=0 ; i--){
			timeout = (char)i;
		s = System.currentTimeMillis();
		rwlReturn = adapter.PollEx(sub_com, timeout);
		e = System.currentTimeMillis();
		System.out.println("Polled: " + (e - s) + " ms, timeout is " + (int)timeout);
		System.out.println("PollEx() executed, return: "+rwlReturn.getReturnCode() + ", sub_com:" + sub_com); // remain value or error code
		pollData = (PollExData)rwlReturn.getReturnData();
		pollData.processData(); // split raw data 
		System.out.println("Old Card ID: "+pollData.getOldCardId());
		System.out.println("New Card ID: "+pollData.getNewCardId());
		System.out.println("Customer Info: "+pollData.getCustomerInfo());
		System.out.println("Old IDm:" + pollData.getOldIdm());
		System.out.println("New IDm:" + pollData.getNewIdm());
		System.out.println();
		}
		
		
		sub_com = 2;
		timeout = 1;
		for(int i = 11; i>=0 ; i--){
			timeout = (char)i;
		s = System.currentTimeMillis();
		rwlReturn = adapter.PollEx(sub_com, timeout);
		e = System.currentTimeMillis();
		System.out.println("Polled: " + (e - s) + " ms, timeout is " + (int)timeout);
		System.out.println("PollEx() executed, return: "+rwlReturn.getReturnCode() + ", sub_com:" + sub_com); // remain value or error code
		PollExData pollExData = (PollExData)rwlReturn.getReturnData();
		pollExData.processData(); // split raw data 
		System.out.println("Old Card ID: "+pollExData.getOldCardId());
		System.out.println("New Card ID: "+pollExData.getNewCardId());
		System.out.println("Customer Info: "+pollExData.getCustomerInfo());
		System.out.println("Old IDm:" + pollExData.getOldIdm());
		System.out.println("New IDm:" + pollExData.getNewIdm());
		System.out.println("Trans:" + pollExData.getTransactions());
		if(pollExData.getTransactions() == null) {
			System.out.println("Transactions: " + pollExData.getTransactions());
		}
		else {
			int index = 0;
			String dateString = "2000-01-01";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(dateString);
			String[] transactions = pollExData.getTransactions().split(",");
			for(int j=0; j<transactions.length; j++) {
				System.out.println("Transaction [" + index + "]");
				System.out.println("SP Type: " + transactions[j++]);
				System.out.println("Transaction Amt: " + transactions[j++]);
				System.out.println("Transaction Time: " + new Date(date.getTime() + Long.parseLong(transactions[j++])*1000));
				System.out.println("Machine ID: " + transactions[j++]);
				System.out.println("Service ID: " + transactions[j]);
				System.out.println();
				index++;
			}
		}
		System.out.println();
		}
		
		
		char uiCom = 0;
		char uiParm = 1;
		rwlReturn = adapter.GetExtraInfo(uiCom, uiParm);
		System.out.println("GetExtraInfo() executed, return: "+rwlReturn.getReturnCode());
		ExtraInfoData extraInfoData = (ExtraInfoData)rwlReturn.getReturnData();
		extraInfoData.processData();
		System.out.println("returnData:" + extraInfoData.getReturnData());
		System.out.println("lastAddValueDate:" + extraInfoData.getLastAddValueDate());
		System.out.println("lastAddValueType:" + extraInfoData.getLastAddValueType());
		System.out.println("lastAddValueDeviceId:" + extraInfoData.getLastAddValueDeviceId());
		
/*		
		char[] AI = {12, 34, 00, 00, 00, 12, 34};	// Additional Information for the transaction. (refer to pdf, A3 Part 4.6)
		rwlReturn = adapter.Deduct(1, AI, 0);		// value in $0.1, Additional Information, defer release flag (1 - Defer card release, 0 - Release card after deduct)
		System.out.println("Deduct() executed, return: "+rwlReturn.getReturnCode()); // remain value or error code
*/		
		
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
