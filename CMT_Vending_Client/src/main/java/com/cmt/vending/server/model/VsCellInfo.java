package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VsCellInfo {
	private List<CellInfo> cellInfo = new Vector<>();

	public List<CellInfo> getCellInfo() {
		return cellInfo;
	}

	public void setCellInfo(List<CellInfo> cellInfo) {
		this.cellInfo = cellInfo;
	}
}
