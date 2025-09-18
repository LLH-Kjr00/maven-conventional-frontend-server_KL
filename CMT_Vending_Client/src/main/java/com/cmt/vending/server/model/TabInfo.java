package com.cmt.vending.server.model;

import java.util.ArrayList;
import java.util.List;

public class TabInfo {
	// English Label
	private String label;
	
	// Chinese Label
	private String labelChi;
	
	//  Icon Image (file name is a number), AllTab does not have icon image
	private Integer icon;
	
	// Rows for this tab (each row shows a certain number of product icons)
	private List<UIRowInfo> rows = new ArrayList<UIRowInfo>();
	
	private int cellPerRow = 3; 
	
	/**
	 * Constructor
	 */
	public TabInfo() {
		this.rows.add(new UIRowInfo()); 			
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	
	public void setLabelChi(String labelChi) {
		this.labelChi = labelChi;
	}
	public String getLabelChi() {
		return labelChi;
	}
	
	public void setIcon(Integer icon) {
		this.icon = icon;
	}
	public Integer getIcon() {
		return icon;
	}

	public void setRows(List<UIRowInfo> rows) {
		this.rows = rows;
	}
	public List<UIRowInfo> getRows() {
		return rows;
	}
	public UIRowInfo getLastRow() {
		if(!this.rows.isEmpty()) {
			return this.rows.get(this.rows.size() - 1);
		}
		else {
			return null;
		}
	}
	
	public void setCellPerRow(int cellPerRow) {
		this.cellPerRow = cellPerRow;
	}
	public int getCellPerRow() {
		return cellPerRow;
	}



}
