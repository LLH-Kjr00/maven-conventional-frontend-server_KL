package com.cmt.vending.server.backendWebSocket.alipay;

import com.cmt.vending.server.backendWebSocket.BackendWebSocketObject;

public class AlipayPaymentResultResp extends BackendWebSocketObject {
	public AlipayPaymentResultResp(int ack) {
		super(ack, "ALIPAY_PAYMENT_RESULT_RESP");
	}
	
}
