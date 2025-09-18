package com.cmt.vending.server.model;

import java.math.BigDecimal;

/**
 * More detailed information of a product in a certain period
 */
public class ProductPeriodInfo {
	private String brandName;
	private String brandNameChi;
	private String name;
	private String nameChi;

	private long effDateMs;
	private long expDateMs;
	
	private int imageId;
	private int imageSmallId;		// Icon
	private int videoId;

	private BigDecimal price;
	
	private String wgtVolume;
	private String wgtVolumeChi;
	private String nutrition;
	private String nutritionChi;
	private String description;
	private String descriptionChi;
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getBrandNameChi() {
		return brandNameChi;
	}
	public void setBrandNameChi(String brandNameChi) {
		this.brandNameChi = brandNameChi;
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


	public long getEffDateMs() {
		return effDateMs;
	}
	public void setEffDateMs(long effDateMs) {
		this.effDateMs = effDateMs;
	}

	public long getExpDateMs() {
		return expDateMs;
	}
	public void setExpDateMs(long expDateMs) {
		this.expDateMs = expDateMs;
	}

	

	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getImageSmallId() {
		return imageSmallId;
	}
	public void setImageSmallId(int imageSmallId) {
		this.imageSmallId = imageSmallId;
	}

	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
	public String getWgtVolume() {
		return wgtVolume;
	}
	public void setWgtVolume(String wgtVolume) {
		this.wgtVolume = wgtVolume;
	}

	public String getWgtVolumeChi() {
		return wgtVolumeChi;
	}
	public void setWgtVolumeChi(String wgtVolumeChi) {
		this.wgtVolumeChi = wgtVolumeChi;
	}
	
	public String getNutrition() {
		return nutrition;
	}
	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}

	public String getNutritionChi() {
		return nutritionChi;
	}
	public void setNutritionChi(String nutritionChi) {
		this.nutritionChi = nutritionChi;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionChi() {
		return descriptionChi;
	}
	public void setDescriptionChi(String descriptionChi) {
		this.descriptionChi = descriptionChi;
	}


}
