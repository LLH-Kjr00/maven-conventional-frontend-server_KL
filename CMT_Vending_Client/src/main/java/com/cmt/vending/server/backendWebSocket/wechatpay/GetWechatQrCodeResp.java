package com.cmt.vending.server.backendWebSocket.wechatpay;

import com.cmt.vending.server.backendWebSocket.BackendWebSocketObject;
import com.cmt.vending.server.model.TranInfo;

public class GetWechatQrCodeResp extends BackendWebSocketObject {
	
	private boolean isSuccess = true;
	private String errorCode;
	private String qrCode;
	private int timeout;
	private TranInfo tranInfo;
	
	public GetWechatQrCodeResp(int ack) {
		super(ack, "GET_WECHAT_PAY_QR_CODE_RESP");
	}
	
	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public TranInfo getTranInfo() {
		return tranInfo;
	}

	public void setTranInfo(TranInfo tranInfo) {
		this.tranInfo = tranInfo;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
