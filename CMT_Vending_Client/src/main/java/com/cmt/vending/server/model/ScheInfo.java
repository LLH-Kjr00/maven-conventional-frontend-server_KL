package com.cmt.vending.server.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Daily Job schedule setting:
 * 1. Transaction Upload Job (MPS file)
 * 2. Meta File Download Job (Octopus)
 * 3. Interim Blacklist Download Job (Octopus)
 * 4. Heartbeat Job
 * 5. Firmware Upgrade
 */
@XmlRootElement
public class ScheInfo {
	private String fwUpgradeEnableFlag;
	private String fwUpgradeSche;
	private int fwUpgradeRetryCount;
	private int fwUpgradeRetryDuration;
	
	private int heartbeatIntervalMin;
	private int heartbeatRetryCount;
	private int heartbeatRetryDuration;

	private String octInterimBlkListSche;
	private int octInterimBlkListRetryCount;
	private int octInterimBlkListRetryDuration;

	private String octMetaFileSche;
	private int octMetaFileRetryCount;
	private int octMetaFileRetryDuration;
	
	private String octTranSche;
	private int octTranRetryCount;
	private int octTranRetryDuration;
	
	public String getFwUpgradeSche() {
		return fwUpgradeSche;
	}

	public void setFwUpgradeSche(String fwUpgradeSche) {
		this.fwUpgradeSche = fwUpgradeSche;
	}

	public int getFwUpgradeRetryCount() {
		return fwUpgradeRetryCount;
	}

	public void setFwUpgradeRetryCount(int fwUpgradeRetryCount) {
		this.fwUpgradeRetryCount = fwUpgradeRetryCount;
	}

	public String getFwUpgradeEnableFlag() {
		return fwUpgradeEnableFlag;
	}

	public void setFwUpgradeEnableFlag(String fwUpgradeEnableFlag) {
		this.fwUpgradeEnableFlag = fwUpgradeEnableFlag;
	}

	public int getFwUpgradeRetryDuration() {
		return fwUpgradeRetryDuration;
	}

	public void setFwUpgradeRetryDuration(int fwUpgradeRetryDuration) {
		this.fwUpgradeRetryDuration = fwUpgradeRetryDuration;
	}

	public int getHeartbeatRetryDuration() {
		return heartbeatRetryDuration;
	}

	public void setHeartbeatRetryDuration(int heartbeatRetryDuration) {
		this.heartbeatRetryDuration = heartbeatRetryDuration;
	}

	public int getHeartbeatRetryCount() {
		return heartbeatRetryCount;
	}

	public void setHeartbeatRetryCount(int heartbeatRetryCount) {
		this.heartbeatRetryCount = heartbeatRetryCount;
	}

	public int getHeartbeatIntervalMin() {
		return heartbeatIntervalMin;
	}

	public void setHeartbeatIntervalMin(int heartbeatIntervalMin) {
		this.heartbeatIntervalMin = heartbeatIntervalMin;
	}

	public String getOctInterimBlkListSche() {
		return octInterimBlkListSche;
	}

	public void setOctInterimBlkListSche(String octInterimBlkListSche) {
		this.octInterimBlkListSche = octInterimBlkListSche;
	}

	public int getOctInterimBlkListRetryDuration() {
		return octInterimBlkListRetryDuration;
	}

	public void setOctInterimBlkListRetryDuration(int octInterimBlkListRetryDuration) {
		this.octInterimBlkListRetryDuration = octInterimBlkListRetryDuration;
	}

	public int getOctInterimBlkListRetryCount() {
		return octInterimBlkListRetryCount;
	}

	public void setOctInterimBlkListRetryCount(int octInterimBlkListRetryCount) {
		this.octInterimBlkListRetryCount = octInterimBlkListRetryCount;
	}

	public String getOctMetaFileSche() {
		return octMetaFileSche;
	}

	public void setOctMetaFileSche(String octMetaFileSche) {
		this.octMetaFileSche = octMetaFileSche;
	}

	public int getOctMetaFileRetryDuration() {
		return octMetaFileRetryDuration;
	}

	public void setOctMetaFileRetryDuration(int octMetaFileRetryDuration) {
		this.octMetaFileRetryDuration = octMetaFileRetryDuration;
	}

	public int getOctMetaFileRetryCount() {
		return octMetaFileRetryCount;
	}

	public void setOctMetaFileRetryCount(int octMetaFileRetryCount) {
		this.octMetaFileRetryCount = octMetaFileRetryCount;
	}

	public String getOctTranSche() {
		return octTranSche;
	}

	public void setOctTranSche(String octTranSche) {
		this.octTranSche = octTranSche;
	}

	public int getOctTranRetryDuration() {
		return octTranRetryDuration;
	}

	public void setOctTranRetryDuration(int octTranRetryDuration) {
		this.octTranRetryDuration = octTranRetryDuration;
	}

	public int getOctTranRetryCount() {
		return octTranRetryCount;
	}

	public void setOctTranRetryCount(int octTranRetryCount) {
		this.octTranRetryCount = octTranRetryCount;
	}

}
