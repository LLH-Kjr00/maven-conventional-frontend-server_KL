package com.cmt.vending.server.model;

import java.math.BigDecimal;

public class UICellInfo {
	private int productId;
	
	private Integer icon;
	private Integer image;
	private Integer video;
	
	private BigDecimal price;
	private BigDecimal vipPrice;
	
	private String name;
	private String nameChi;
	
	private String nutrition;
	private String nutritionChi;
	private String description;
	private String descriptionChi;
	
	private boolean enabled;
	private boolean notInUse;
	
	public void setProductId(int productId) {
		this.productId = productId;
	}	
	public int getProductId() {
		return productId;
	}

	public void setIcon(Integer icon) {
		this.icon = icon;
	}
	public Integer getIcon() {
		return icon;
	}
	
	public void setImage(Integer image) {
		this.image = image;
	}
	public Integer getImage() {
		return image;
	}
	
	public void setVideo(Integer video) {
		this.video = video;
	}
	public Integer getVideo() {
		return video;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setVipPrice(BigDecimal vipPrice) {
		this.vipPrice = vipPrice;
	}
	public BigDecimal getVipPrice() {
		return vipPrice;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setNameChi(String nameChi) {
		this.nameChi = nameChi;
	}
	public String getNameChi() {
		return nameChi;
	}
	
	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}
	public String getNutrition() {
		return nutrition;
	}
	
	public void setNutritionChi(String nutritionChi) {
		this.nutritionChi = nutritionChi;
	}
	public String getNutritionChi() {
		return nutritionChi;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}

	public void setDescriptionChi(String descriptionChi) {
		this.descriptionChi = descriptionChi;
	}
	public String getDescriptionChi() {
		return descriptionChi;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setNotInUse(boolean notInUse) {
		this.notInUse = notInUse;
	}
	public boolean isNotInUse() {
		return notInUse;
	}
	
	@Override
	public String toString() {
		return "[productId=" + productId + ", icon=" + icon + ", image=" + image + ", video=" + video
				+ ", price=" + price + ", vipPrice=" + vipPrice +  ", name=" + name + ", nameChi=" + nameChi
				+ ", nutrition=" + nutrition + ", nutritionChi=" + nutritionChi
				+ ", description=" + description + ", descriptionChi=" + descriptionChi + ", enabled=" + enabled
				+ ", notInUse="+ notInUse +"]";
	}
}
