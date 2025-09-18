package com.cmt.vending.server.backendWebSocket.wechatpay;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.model.TranInfo;
import com.cmt.vending.server.backendWebSocket.BackendWebSocketObject;

public class GetWechatQrCodeReq extends BackendWebSocketObject {

	private int vmId;
	private TranInfo tranInfo = null;
	
	public GetWechatQrCodeReq(TranInfo tranInfo) {
		super(0, "GET_WECHAT_PAY_QR_CODE");
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
