package com.cmt.octopus;

/**
 * @author CMT
 * Copyright (c) 2016 Clever Motion Technology.
 * All rights reserved. 
 * Powered by Clever Motion Technology Limited
 */
public class ExtraInfoData {
	public static String BY_CASH = "1";
	public static String BY_EFT = "2";
	public static String BY_REFUND = "3";
	public static String BY_AAVS = "4";
	public static String BY_ONLINE = "5";
	
	/**
	 * Original returned data by Octopus API call
	 */
	private String returnData;

	/**
	 * YYYY-MM-DD 2008-09-22
	 */
	private String lastAddValueDate;

	private String lastAddValueType;

	private String lastAddValueDeviceId;

	public ExtraInfoData() {
		super();
	}

	public ExtraInfoData(String returnData, String lastAddValueDate,
			String lastAddValueType, String lastAddValueDeviceId) {
		super();
		this.returnData = returnData;
		this.lastAddValueDate = lastAddValueDate;
		this.lastAddValueType = lastAddValueType;
		this.lastAddValueDeviceId = lastAddValueDeviceId;
	}

	public int processData() {
		int result = -1; // 0 - Success, 1 - Octopus data is empty

		if (returnData == null || returnData.isEmpty()) {
			result = 1;
		} else {
			String[] temp = returnData.split(",");
			if (temp.length == 3) { // uiCom = 0, uiParam = 1
				lastAddValueDate = temp[0];
				lastAddValueType = temp[1];
				lastAddValueDeviceId = temp[2];
				result = 0;
			}
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

	public String getLastAddValueDate() {
		return lastAddValueDate;
	}

	public void setLastAddValueDate(String lastAddValueDate) {
		this.lastAddValueDate = lastAddValueDate;
	}

	public String getLastAddValueType() {
		return lastAddValueType;
	}

	public void setLastAddValueType(String lastAddValueType) {
		this.lastAddValueType = lastAddValueType;
	}

	public String getLastAddValueDeviceId() {
		return lastAddValueDeviceId;
	}

	public void setLastAddValueDeviceId(String lastAddValueDeviceId) {
		this.lastAddValueDeviceId = lastAddValueDeviceId;
	}
	
	public boolean isAddValueTypeCash() {
		return BY_CASH.equals(lastAddValueType);
	}
	
	public boolean isAddValueTypeEtf() {
		return BY_EFT.equals(lastAddValueType);
	}
	
	public boolean isAddValueTypeRefund() {
		return BY_REFUND.equals(lastAddValueType);
	}
	
	public boolean isAddValueTypeAavs() {
		return BY_AAVS.equals(lastAddValueType);
	}
	
	public boolean isAddValueTypeOnline() {
		return BY_ONLINE.equals(lastAddValueType);
	}

}
