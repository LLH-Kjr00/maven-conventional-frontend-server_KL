package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

import com.cmt.vending.ws.obj.xsd.VmRequestLogInfo;

@XmlRootElement
public class VmRequestLogHistory {
	private List<VmRequestLogInfo> history = new Vector<>();

	public List<VmRequestLogInfo> getHistory() {
		return history;
	}

	public void setHistory(List<VmRequestLogInfo> history) {
		this.history = history;
	}
}
