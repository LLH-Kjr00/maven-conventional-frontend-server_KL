package com.cmt.octopus;

/**
 * @author CMT
 * Copyright (c) 2016 Clever Motion Technology.
 * All rights reserved. 
 * Powered by Clever Motion Technology Limited
 */
public class RwlReturn {
	private int returnCode = -1;
	private Object returnData;
	
	public RwlReturn() {
	}

	public RwlReturn(int returnCode, Object returnData) {
		super();
		this.returnCode = returnCode;
		this.returnData = returnData;
	}
	
	/**
	 * Not applicable for Poll(), Deduct() and AddValue()
	 * @return
	 */
	public boolean isSuccessful() {
		return this.returnCode == RwlCons.RETURN_SUCCESSFUL_CODE;
	}

	@Override
	public String toString() {
		return "RwlReturn[" + returnCode + ", " + returnData + "]";
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}

}
