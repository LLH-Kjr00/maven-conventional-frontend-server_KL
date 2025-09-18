package com.cmt.vending.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReceiptUtil {
	private static final Logger logger = LogManager.getLogger(ReceiptUtil.class);
	
	public static int getReceiptNoInt(String receiptNo) {

		int rn = 0;
		
		if(StringUtil.isEmpty(receiptNo)) {
			return 0;
		}
		
		if(receiptNo.startsWith("000")) {
			rn = Integer.parseInt(receiptNo.substring(3));
		}
		else if(receiptNo.startsWith("00")) {
			rn = Integer.parseInt(receiptNo.substring(2));
		}
		else if(receiptNo.startsWith("0")) {
			rn = Integer.parseInt(receiptNo.substring(1));
		}
		else {
			rn = Integer.parseInt(receiptNo);
		}

		return rn;
	}
	
}
