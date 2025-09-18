package com.cmt.vending.server.model;

// The card which has vip discount
public class RFIDInfo {
	private int acId;
	private String cardNo;
	private int cardType; 		// 1: Octopus
	private String name;
	private String nameChi;
	private long effDate;
	private long expDate;
	
	public int getAcId() {
		return acId;
	}
	public void setAcId(int acId) {
		this.acId = acId;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameChi() {
		return nameChi;
	}
	public void setNameChi(String nameChi) {
		this.nameChi = nameChi;
	}
	public long getEffDate() {
		return effDate;
	}
	public void setEffDate(long effDate) {
		this.effDate = effDate;
	}
	public long getExpDate() {
		return expDate;
	}
	public void setExpDate(long expDate) {
		this.expDate = expDate;
	}
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	
}
