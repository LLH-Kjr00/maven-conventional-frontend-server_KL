package com.cmt.octopus;

/**
 * @author CMT
 * Copyright (c) 2016 Clever Motion Technology.
 * All rights reserved. 
 * Powered by Clever Motion Technology Limited
 */
public class PollExData {
	/**
	 * Original returned data by Octopus API call
	 */
	private String returnData;

	private int remainingValue;
	private String oldCardId;
	private String newCardId;
	private String customerInfo;
	
	/**
	 * Only available for SubCom=[1|2]
	 * IDm
	 */
	private String oldIdm;
	private String newIdm;
	
	
	/**
	 * Only available for SubCom=2
	 */
	private String transactions;

	
	public PollExData() {
		super();
	}

	public PollExData(String returnData, int remainingValue, String oldCardId,
			String newCardId, String customerInfo, String oldIdm,
			String newIdm, String transactions) {
		super();
		this.returnData = returnData;
		this.remainingValue = remainingValue;
		this.oldCardId = oldCardId;
		this.newCardId = newCardId;
		this.customerInfo = customerInfo;
		this.oldIdm = oldIdm;
		this.newIdm = newIdm;
		this.transactions = transactions;
	}



	public int processData(){
		int result = -1;		// 0 - Success, 1 - Octopus data is empty, 2 - Octopus data not processed
		
		if (returnData == null || returnData.isEmpty()){
			result = 1;
		} else {
			String[] temp = returnData.split(",");
			if(temp.length == 3){	// subcom = 0
				oldCardId = temp[0];
				newCardId = temp[1];
				customerInfo = temp[2];
				result = 0;
			} else if(temp.length == 5){	// subcom = 1
				oldCardId = temp[0];
				oldIdm = temp[1];
				newCardId = temp[2];
				customerInfo = temp[3];
				newIdm = temp[4];
				result = 0;
			} else {	// subcom = 2
				oldCardId = temp[0];
				oldIdm = temp[1];
				newCardId = temp[2];
				customerInfo = temp[3];
				newIdm = temp[4];
				String temp2 = temp[5];
				for (int i = 6; i < temp.length; i++){
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

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}


	public String getTransactions() {
		return transactions;
	}

	public void setTransactions(String transactions) {
		this.transactions = transactions;
	}

	public String getOldCardId() {
		return oldCardId;
	}

	public void setOldCardId(String oldCardId) {
		this.oldCardId = oldCardId;
	}

	public String getNewCardId() {
		return newCardId;
	}

	public void setNewCardId(String newCardId) {
		this.newCardId = newCardId;
	}

	public String getOldIdm() {
		return oldIdm;
	}

	public void setOldIdm(String oldIdm) {
		this.oldIdm = oldIdm;
	}

	public String getNewIdm() {
		return newIdm;
	}

	public void setNewIdm(String newIdm) {
		this.newIdm = newIdm;
	}
}
