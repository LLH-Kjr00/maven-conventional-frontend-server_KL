package com.cmt.vending.server.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Information of product category
 */
@XmlRootElement
public class ProductCategoryInfo {
	private int catId;
	private String name;
	private String nameChi;
	private int icon;
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNameChi() {
		return nameChi;
	}
	public void setNameChi(String nameChi) {
		this.nameChi = nameChi;
	}

	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}


}
