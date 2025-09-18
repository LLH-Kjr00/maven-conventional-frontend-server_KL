package com.cmt.vending.server.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TranHistory {
	private List<TranInfo> tran = new Vector<>();

	public List<TranInfo> getTran() {
		return tran;
	}

	public void setTran(List<TranInfo> tran) {
		this.tran = tran;
	}

}
