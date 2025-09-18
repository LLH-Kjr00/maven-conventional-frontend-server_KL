package com.cmt.vending.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VsGroupInfo {
	private int groupId;
	
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getGroupId() {
		return this.groupId;
	}

	
}
