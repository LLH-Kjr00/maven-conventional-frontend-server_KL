package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductInfo {
	private int productId;
	private boolean enable;
	
//	private boolean healthfood;
//	private boolean hot;
//	private boolean newProduct;
//	private int likeCount;
	
	private ProductCategoryInfo productCategoryInfo;
	private List<ProductPeriodInfo> productPeriodInfo = new Vector<ProductPeriodInfo>();
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public ProductCategoryInfo getProductCategoryInfo() {
		return productCategoryInfo;
	}
	public void setProductCategoryInfo(ProductCategoryInfo productCategoryInfo) {
		this.productCategoryInfo = productCategoryInfo;
	}
	
	public List<ProductPeriodInfo> getProductPeriodInfo() {
		return productPeriodInfo;
	}
	public void setProductPeriodInfo(List<ProductPeriodInfo> productPeriodInfo) {
		this.productPeriodInfo = productPeriodInfo;
	}

}
