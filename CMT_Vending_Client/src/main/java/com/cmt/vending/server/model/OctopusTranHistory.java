package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OctopusTranHistory {
	
	private List<OctTranRecord> records = new Vector<>();

	public List<OctTranRecord> getRecords() {
		return records;
	}

	public void setRecords(List<OctTranRecord> records) {
		this.records = records;
	}
	
}

