package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FirmwareUpgradeHistory {
	
	private String currentVersionCode = "0";
	private List<MetaData> history = new Vector<MetaData>();
	
	public List<MetaData> getHistory() {
		return history;
	}

	public void setHistory(List<MetaData> history) {
		this.history = history;
	}

	public String getCurrentVersionCode() {
		return currentVersionCode;
	}

	public void setCurrentVersionCode(String currentVersionCode) {
		this.currentVersionCode = currentVersionCode;
	}
	
	/**
	 * Check if the versionCode is in the history
	 * If yes -> this version of firmware is installed already
	 * @param versionCode
	 * @return
	 */
	public boolean isUpgraded(String versionCode) {
		if(!history.isEmpty()) {
			for(MetaData info : history) {
				if(info.getVersionNo().equals(versionCode)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
