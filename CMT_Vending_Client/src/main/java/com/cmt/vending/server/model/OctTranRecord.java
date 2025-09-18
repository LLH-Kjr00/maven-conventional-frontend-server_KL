package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

public class OctTranRecord {
	private String cardNo;
	private List<Long> tranDttms = new Vector<>();
	
	public OctTranRecord() {
		
	}

	public OctTranRecord(String cardNo) {
		super();
		this.cardNo = cardNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public List<Long> getTranDttms() {
		return tranDttms;
	}

	public void setTranDttms(List<Long> tranDttms) {
		this.tranDttms = tranDttms;
	}

}
