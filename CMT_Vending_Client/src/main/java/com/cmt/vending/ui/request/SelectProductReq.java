package com.cmt.vending.ui.request;

import java.math.BigDecimal;

public class SelectProductReq extends Request {
	private int productId = 0;
	private BigDecimal price = BigDecimal.ZERO;
	private BigDecimal vipPrice = BigDecimal.ZERO;

	public int getProductId() {
		return productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getVipPrice() {
		return vipPrice;
	}

	
}
