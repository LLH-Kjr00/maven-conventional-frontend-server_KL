package com.cmt.octopus;

/**
 * @author CMT
 * Copyright (c) 2016 Clever Motion Technology.
 * All rights reserved. 
 * Powered by Clever Motion Technology Limited
 */
public class XFileData {
	/**
	 * Original returned data by Octopus API call
	 */
	private String returnData;

	public XFileData() {
		super();
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
}
