package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OctSettlementList {
	private List<SettlementFile> settlementFile = new Vector<>();

	public List<SettlementFile> getSettlementFile() {
		return settlementFile;
	}

	public void setSettlementFile(List<SettlementFile> settlementFile) {
		this.settlementFile = settlementFile;
	}
}
