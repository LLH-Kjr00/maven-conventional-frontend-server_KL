package com.cmt.vending.server.model;

import java.util.ArrayList;
import java.util.List;

public class UIRowInfo {
	private List<UICellInfo> cells = new ArrayList<UICellInfo>();
	
	public void setCells(List<UICellInfo> cells) {
		this.cells = cells;
	}
	public List<UICellInfo> getCells() {
		return cells;
	}


}
