package com.cmt.vending.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReceiptNo {
	int octReceiptNo = 1;
	int wechatReceiptNo = 1;
	int alipayReceiptNo = 1;

	public int getOctReceiptNo() {
		return octReceiptNo;
	}

	public void setOctReceiptNo(int octReceiptNo) {
		this.octReceiptNo = octReceiptNo;
	}
	
	public int getWechatReceiptNo() {
		return wechatReceiptNo;
	}

	public void setWechatReceiptNo(int wechatReceiptNo) {
		this.wechatReceiptNo = wechatReceiptNo;
	}

	public int getAlipayReceiptNo() {
		return alipayReceiptNo;
	}

	public void setAlipayReceiptNo(int alipayReceiptNo) {
		this.alipayReceiptNo = alipayReceiptNo;
	}
	
}
