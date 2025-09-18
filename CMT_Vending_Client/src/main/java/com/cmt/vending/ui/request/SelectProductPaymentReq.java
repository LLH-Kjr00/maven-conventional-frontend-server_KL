package com.cmt.vending.ui.request;

public class SelectProductPaymentReq extends Request {
	private String paymentCode = null;
	private int itemNo = 0;
	
	public String getPaymentCode() {
		return paymentCode;
	}
	public int getItemNo() {
		return itemNo;
	}

}
