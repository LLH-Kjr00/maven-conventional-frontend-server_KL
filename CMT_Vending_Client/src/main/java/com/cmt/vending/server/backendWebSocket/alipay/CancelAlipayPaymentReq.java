package com.cmt.vending.server.backendWebSocket.alipay;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.backendWebSocket.BackendWebSocketObject;
import com.cmt.vending.server.model.TranInfo;

public class CancelAlipayPaymentReq extends BackendWebSocketObject {
	
	private int vmId;
	private TranInfo tranInfo = null;
	
	public CancelAlipayPaymentReq(TranInfo tranInfo) {
		super(0, "CANCEL_ALIPAY_PAYMENT");
		this.setVmId(LocalServer.getLocalServerConfig().getVmId());
		this.setTranInfo(tranInfo);
		
	}

	public TranInfo getTranInfo() {
		return tranInfo;
	}

	public void setTranInfo(TranInfo tranInfo) {
		this.tranInfo = tranInfo;
	}

	public int getVmId() {
		return vmId;
	}

	public void setVmId(int vmId) {
		this.vmId = vmId;
	}
	
}
