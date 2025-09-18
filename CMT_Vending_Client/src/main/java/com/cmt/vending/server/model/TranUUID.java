package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TranUUID {
	private List<String> uuid = new Vector<>();

	public List<String> getUuid() {
		return uuid;
	}

	public void setUuid(List<String> uuid) {
		this.uuid = uuid;
	}
}
