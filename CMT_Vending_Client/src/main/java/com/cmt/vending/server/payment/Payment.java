package com.cmt.vending.server.payment;

import java.math.BigDecimal;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.operation.TransactionManager;

public abstract class Payment {
	protected Logger logger = LogManager.getLogger(Payment.class);

	protected int paymentCode = -1;
	protected String paymentName;
	
	protected boolean enable = false;
	
	public Payment(int code, String name) {
		this.paymentCode = code;
		this.paymentName = name;
	}
	
	public int getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public abstract void pay(BigDecimal price, BigDecimal vipPrice);

	public abstract void paySuccess();

	public abstract void payFail();

	public abstract void payCancel();
	
	public void handle() {
		logger.info("[handle] User select payment: " + paymentName);
		TransactionManager.CURRENT_PAYMENT_METHOD = this;
		TransactionManager.IS_TRAN_SUCCESS = false;
		TransactionManager.CURRENT_TX.setPayMethodCode(this.paymentCode);
		TransactionManager.CURRENT_TX.setTranUuid(UUID.randomUUID().toString());
		
		this.pay(TransactionManager.CURRENT_TX.getPrice(), TransactionManager.CURRENT_TX.getVipPrice());
	}

	public abstract void continuePayment();
	public abstract void stopPayment();

}
