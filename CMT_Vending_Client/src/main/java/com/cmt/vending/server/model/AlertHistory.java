package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

import com.cmt.vending.ws.obj.xsd.AlertInfo;

@XmlRootElement
public class AlertHistory {
	private List<AlertInfo> alert = new Vector<>();

	public List<AlertInfo> getAlert() {
		return alert;
	}

	public void setAlert(List<AlertInfo> alert) {
		this.alert = alert;
	}

}
