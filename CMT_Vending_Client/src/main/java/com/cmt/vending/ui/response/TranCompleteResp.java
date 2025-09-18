package com.cmt.vending.ui.response;

import com.cmt.vending.server.model.TranInfo;
import com.cmt.vending.server.operation.BackendServerComm;

public class TranCompleteResp extends Response{
	private TranInfo tranInfo = null;
	private String qrCode = null;

	private String printData = null;

	private String printDataChi = null;

	public TranCompleteResp(TranInfo info) {
		this.tranInfo = info;
		this.qrCode = BackendServerComm.generateReceiptQrCode(info.getTranUuid());
	}

	public TranCompleteResp(TranInfo info, String printDataEng, String printDataChi) {
		this.tranInfo = info;
		this.qrCode = BackendServerComm.generateReceiptQrCode(info.getTranUuid());
		this.printData = printDataEng;
		this.printDataChi = printDataChi;
	}
	
}
