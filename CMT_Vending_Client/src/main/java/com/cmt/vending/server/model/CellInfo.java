package com.cmt.vending.server.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@XmlRootElement
public class CellInfo {
	private static Logger logger = LogManager.getLogger(CellInfo.class);
	
	private int cellId;
	private int itemNo;
	private int maxQty;
	private int displaySeq;
	
	private boolean enabled;
	private boolean columnNormal;
	private boolean outOfStock;

	private boolean laundryLock;		// For JY1
	private ProductInfo productInfo;
	
	private int qty;
	
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

	public int getMaxQty() {
		return maxQty;
	}
	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	public int getDisplaySeq() {
		return displaySeq;
	}
	public void setDisplaySeq(int displaySeq) {
		this.displaySeq = displaySeq;
	}

	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isColumnNormal() {
		return columnNormal;
	}
	public void setColumnNormal(boolean columnNormal) {
		this.columnNormal = columnNormal;
	}
	
	public boolean isOutOfStock() {
		return outOfStock;
	}
	public void setOutOfStock(boolean outOfStock) {
		this.outOfStock = outOfStock;
	}
	
	public ProductInfo getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public void setLaundryLock(boolean laundryLock){this.laundryLock = laundryLock;}
	public boolean isLaundryLock(){return laundryLock;}


	/**
	 * Get the period info today
	 * @return
	 */
	public ProductPeriodInfo getCurrentPeriodInfo() {
		ProductPeriodInfo info = null;
		try {
			List<ProductPeriodInfo> list = this.getProductInfo().getProductPeriodInfo();
			
			for (int i=0; i < list.size(); i++) {
				info = list.get(i);
				
				if (info.getExpDateMs() > 0) {
					if (info.getEffDateMs() <= System.currentTimeMillis() && (System.currentTimeMillis() <= info.getExpDateMs()))
						return info;
				} else if (info.getEffDateMs() <= System.currentTimeMillis()) {
					return info;
				}
			}
			return info;

		} catch(Throwable e) {
			logger.error("[getCurrentPeriodInfo]Failed to get current period info [cell id: " + this.itemNo + "]", e);
		}
		
		return info;
	}
	
}
