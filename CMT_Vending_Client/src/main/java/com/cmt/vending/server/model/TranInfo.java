package com.cmt.vending.server.model;

import lombok.Setter;

import java.math.BigDecimal;

public class TranInfo {
	private String tranUuid;
	private long tranDttmMs;
	private int tranTypeId;

	private String vmcStatusCode;
	private int payMethodCode;
	private int payStatusCode;

	private int productId;
	private int cellId;
	private int itemNo;
	private int qty;
	private BigDecimal price;
	private BigDecimal vipPrice;	
	private BigDecimal discount;
	private BigDecimal amount;
	private BigDecimal remainingValue;
	private String payRefNo;
	private String octDeviceNo;
	private String octCardNo;		// Type 1 or not 1
	private String octCardType;		// Type 1 or not 1
	private int octReceiptNo;
	private String octLavDate;
	private int octLavType;			// add value type 1,2,4
	private String octLavDeviceNo;
	private int stockQty;
	private String remark;


	
//	private Integer promotionDtlId;

	private String transactionId; // For Octopus3.0

	@Setter
	private String[] schemeName;
	@Setter
	private BigDecimal discountAmount;


	/**
	 * Format [YY] + [VM_ID] + [VM_RECEIPT_NO]
	 */
	private String receiptNo;		

//	private String cardId;
//	private String expiryDate;
//	private String respCode;
//	private String terminalId;
//	private String merchantId;
//	private String emvData;
//	private String cardLabel;
//	private String cardType;
//	private String hostType;
//	private String hostLabel;
//	private String invoiceNo;
//	private BigDecimal orgBalance;
//	private String batchNo;
//	private String approvalCode;
//	private String retrievalRefNo;
//	private String currencyCode;
//	private String additionalTranInfo;
//	private String tranInfo;
//	private String entryMode;
//	private String batchInfo;
//	private String netsReceiptNo;
//	private String couponAndVoucher;
//	private String merchantNameAndLoc;
//	private String additionalPrintingFlag;
//	private String cardHolderName;
//	private String payOrderNo;
	
	
	
	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getTranUuid() {
		return tranUuid;
	}

	public void setTranUuid(String tranUuid) {
		this.tranUuid = tranUuid;
	}

	public long getTranDttmMs() {
		return tranDttmMs;
	}

	public void setTranDttmMs(long tranDttmMs) {
		this.tranDttmMs = tranDttmMs;
	}

	public int getTranTypeId() {
		return tranTypeId;
	}

	public void setTranTypeId(int tranTypeId) {
		this.tranTypeId = tranTypeId;
	}

	public String getVmcStatusCode() {
		return vmcStatusCode;
	}

	public void setVmcStatusCode(String vmcStatusCode) {
		this.vmcStatusCode = vmcStatusCode;
	}

	public int getPayMethodCode() {
		return payMethodCode;
	}

	public void setPayMethodCode(int payMethodCode) {
		this.payMethodCode = payMethodCode;
	}

	public int getPayStatusCode() {
		return payStatusCode;
	}

	public void setPayStatusCode(int payStatusCode) {
		this.payStatusCode = payStatusCode;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCellId() {
		return cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRemainingValue() {
		return remainingValue;
	}

	public void setRemainingValue(BigDecimal remainingValue) {
		this.remainingValue = remainingValue;
	}

	public String getPayRefNo() {
		return payRefNo;
	}

	public void setPayRefNo(String payRefNo) {
		this.payRefNo = payRefNo;
	}

	public String getOctDeviceNo() {
		return octDeviceNo;
	}

	public void setOctDeviceNo(String octDeviceNo) {
		this.octDeviceNo = octDeviceNo;
	}

	public String getOctCardNo() {
		return octCardNo;
	}

	public void setOctCardNo(String octCardNo) {
		this.octCardNo = octCardNo;
	}

	public int getOctReceiptNo() {
		return octReceiptNo;
	}

	public void setOctReceiptNo(int octReceiptNo) {
		this.octReceiptNo = octReceiptNo;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOctLavDate() {
		return octLavDate;
	}

	public void setOctLavDate(String octLavDate) {
		this.octLavDate = octLavDate;
	}

	public int getOctLavType() {
		return octLavType;
	}

	public void setOctLavType(int octLavType) {
		this.octLavType = octLavType;
	}

	public String getOctLavDeviceNo() {
		return octLavDeviceNo;
	}

	public void setOctLavDeviceNo(String octLavDeviceNo) {
		this.octLavDeviceNo = octLavDeviceNo;
	}

	public String getOctCardType() {
		return octCardType;
	}

	public void setOctCardType(String octCardType) {
		this.octCardType = octCardType;
	}
	
	public BigDecimal getVipPrice() {
		return this.vipPrice;
	}

	public void setVipPrice(BigDecimal vipPrice) {
		this.vipPrice = vipPrice;
	}

	public void setTransactionId(String transactionId){this.transactionId = transactionId;}

}
