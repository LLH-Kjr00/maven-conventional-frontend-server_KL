package com.cmt.vending.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MetaData {
	private String versionNo;
	private String changeHistory;
	private String dependance;

	private String octopusHousekeepingFlag;
	private String restartApplicationFlag;
	private String rebootOperatingSystemFlag;
	
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public String getChangeHistory() {
		return changeHistory;
	}
	public void setChangeHistory(String changeHistory) {
		this.changeHistory = changeHistory;
	}

	public String getDependance() {
		return dependance;
	}
	public void setDependance(String dependance) {
		this.dependance = dependance;
	}
	
	public String getRestartApplicationFlag() {
		return restartApplicationFlag;
	}
	public void setRestartApplicationFlag(String restartApplicationFlag) {
		this.restartApplicationFlag = restartApplicationFlag;
	}
	
	public String getRebootOperatingSystemFlag() {
		return rebootOperatingSystemFlag;
	}
	public void setRebootOperatingSystemFlag(String rebootOperatingSystemFlag) {
		this.rebootOperatingSystemFlag = rebootOperatingSystemFlag;
	}

	public String getOctopusHousekeepingFlag() {
		return octopusHousekeepingFlag;
	}
	public void setOctopusHousekeepingFlag(String octopusHousekeepingFlag) {
		this.octopusHousekeepingFlag = octopusHousekeepingFlag;
	}
}
