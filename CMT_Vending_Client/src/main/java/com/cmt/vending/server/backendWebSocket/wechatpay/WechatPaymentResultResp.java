package com.cmt.vending.server.backendWebSocket.wechatpay;

import com.cmt.vending.server.backendWebSocket.BackendWebSocketObject;

public class WechatPaymentResultResp extends BackendWebSocketObject {
	public WechatPaymentResultResp(int ack) {
		super(ack, "WECHAT_PAYMENT_RESULT_RESP");
	}
	
}
