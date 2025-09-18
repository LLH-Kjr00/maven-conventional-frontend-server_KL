package com.cmt.vending.server.backendWebSocket.alipay;

import com.cmt.vending.server.backendWebSocket.BackendWebSocketObject;
import com.cmt.vending.server.model.TranInfo;

public class CancelAlipayPaymentResp extends BackendWebSocketObject {
	private TranInfo tranInfo;
	
	public CancelAlipayPaymentResp(int ack) {
		super(ack, "CANCEL_ALIPAY_PAYMENT_RESP");
	}

	public TranInfo getTranInfo() {
		return tranInfo;
	}

	public void setTranInfo(TranInfo tranInfo) {
		this.tranInfo = tranInfo;
	}

}
