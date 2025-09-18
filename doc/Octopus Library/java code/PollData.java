package com.cmt.octopus;

/**
 * @author CMT
 * Copyright (c) 2016 Clever Motion Technology.
 * All rights reserved. 
 * Powered by Clever Motion Technology Limited
 */
public class PollData {
	/**
	 * Original returned data by Octopus API call
	 */
	private String returnData;

	private int remainingValue;
	private String cardId;
	private String customerInfo;
	/**
	 * Only available for SubCom=[1|2]
	 * IDm
	 */
	private String idm;
	
	/**
	 * Only available for SubCom=2
	 */
	private String transactions;

	
	public PollData() {
		super();
	}

	public PollData(String returnData, int remainingValue, String cardId,
			String customerInfo, String idm, String transactions) {
		super();
		this.returnData = returnData;
		this.remainingValue = remainingValue;
		this.cardId = cardId;
		this.customerInfo = customerInfo;
		this.idm = idm;
		this.transactions = transactions;
	}
	
	public int processData(){
		int result = -1;		// 0 - Success, 1 - Octopus data is empty, 2 - Octopus data not processed
		
		if (returnData.isEmpty()){
			result = 1;
		} else {
			String[] temp = returnData.split(",");
			if(temp.length == 2){	// subcom = 0
				cardId = temp[0];
				customerInfo = temp[1];
				result = 0;
			} else if(temp.length == 3){	// subcom = 1
				cardId = temp[0];
				customerInfo = temp[1];
				idm = temp[2];
				result = 0;
			} else {	// subcom = 2
				cardId = temp[0];
				customerInfo = temp[1];
				idm = temp[2];
				String temp2 = temp[3];
				for (int i = 4;i<temp.length;i++){
					temp2 += ","+temp[i];
				}
				transactions = temp2;
				result = 0;
			}
			result = 2;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return this.returnData;
	}

	public String getReturnData() {
		return returnData;
	}

	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}

	public int getRemainingValue() {
		return remainingValue;
	}

	public void setRemainingValue(int remainingValue) {
		this.remainingValue = remainingValue;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}

	public String getIdm() {
		return idm;
	}

	public void setIdm(String idm) {
		this.idm = idm;
	}

	public String getTransactions() {
		return transactions;
	}

	public void setTransactions(String transactions) {
		this.transactions = transactions;
	}
}
