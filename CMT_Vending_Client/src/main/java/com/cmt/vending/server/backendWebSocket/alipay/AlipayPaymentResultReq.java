package com.cmt.vending.server.backendWebSocket.alipay;

import com.cmt.vending.server.backendWebSocket.BackendWebSocketObject;
import com.cmt.vending.server.model.TranInfo;

public class AlipayPaymentResultReq extends BackendWebSocketObject {
	
	private boolean result;
	private String errorCode;
	private String errorMsg;
	private TranInfo tranInfo;

	public AlipayPaymentResultReq() {
		super(0, "ALIPAY_PAYMENT_RESULT");
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public TranInfo getTranInfo() {
		return tranInfo;
	}

	public void setTranInfo(TranInfo tranInfo) {
		this.tranInfo = tranInfo;
	}

	
}
