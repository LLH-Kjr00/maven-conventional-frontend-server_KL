package com.cmt.vending.ui.request;

public class VmInfoReq extends Request {
	private boolean groupByProduct = true;

	public boolean isGroupByProduct() {
		return groupByProduct;
	}
}
