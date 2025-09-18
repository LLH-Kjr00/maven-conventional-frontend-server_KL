package com.cmt.vending.ui.response;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.payment.AlipayPayment;
import com.cmt.vending.server.payment.OctopusPayment;
import com.cmt.vending.server.payment.WechatPayment;

public class SelectProductResp extends Response {
	private boolean octopusPayment = false;
	private boolean aliPayment = false;
	private boolean wechatPayment = false;
	
	public SelectProductResp(int seq) {
		super(seq);
		if (LocalServer.getVmc().checkPayment(OctopusPayment.CODE)) {
			OctopusPayment octopusObject = (OctopusPayment) LocalServer.getVmc().getPayment(OctopusPayment.CODE);
			if (octopusObject.isEnable() && octopusObject.isNormal())octopusPayment = true;
		}
		if (LocalServer.getVmc().checkPayment(WechatPayment.CODE)) wechatPayment = true;
		if (LocalServer.getVmc().checkPayment(AlipayPayment.CODE)) aliPayment = true;
	}
}
