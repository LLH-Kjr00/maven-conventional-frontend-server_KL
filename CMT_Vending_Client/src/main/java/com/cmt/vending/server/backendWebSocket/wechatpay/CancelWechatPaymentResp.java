package com.cmt.vending.server.backendWebSocket.wechatpay;

import com.cmt.vending.server.model.TranInfo;
import com.cmt.vending.server.backendWebSocket.BackendWebSocketObject;

public class CancelWechatPaymentResp extends BackendWebSocketObject {
	private TranInfo tranInfo;
	
	public CancelWechatPaymentResp(int ack) {
		super(ack, "CANCEL_WECHAT_PAYMENT_RESP");
	}

	public TranInfo getTranInfo() {
		return tranInfo;
	}

	public void setTranInfo(TranInfo tranInfo) {
		this.tranInfo = tranInfo;
	}

}
