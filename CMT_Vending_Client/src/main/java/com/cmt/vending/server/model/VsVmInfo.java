package com.cmt.vending.server.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Information of this Vending Machine 
 */
@XmlRootElement
public class VsVmInfo {
	private int vmId;
	private long vmVersionServerMs;
	private long serverTimeMs;
	
	private String remark;
	
	private VmInfo info;
	
	// The scheduled job configurations
	private ScheInfo scheduler;
	
	// The card enjoying vip discount
	private List<RFIDInfo> rfids = new ArrayList<RFIDInfo>();	
	
	// Reward (N give 1)
	private List<RewardConfigInfo> rewardConfigs = new ArrayList<RewardConfigInfo>();
	
	public void setVmId(int vmId) {
		this.vmId = vmId;
	}
	public int getVmId() {
		return vmId;
	}
	
	public void setVmVersionServerMs(long vmVersionServerMs) {
		this.vmVersionServerMs = vmVersionServerMs;
	}
	public long getVmVersionServerMs() {
		return vmVersionServerMs;
	}
	
	public void setServerTimeMs(long serverTimeMs) {
		this.serverTimeMs = serverTimeMs;
	}
	public long getServerTimeMs() {
		return serverTimeMs;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	
	public void setInfo(VmInfo info) {
		this.info = info;
	}
	public VmInfo getInfo() {
		return info;
	}

	public void setScheduler(ScheInfo scheduler) {
		this.scheduler = scheduler;
	}
	public ScheInfo getScheduler() {
		return scheduler;
	}

	public List<RFIDInfo> getRfids() {
		return rfids;
	}

	public void setRfids(List<RFIDInfo> rfids) {
		this.rfids = rfids;
	}

	public List<RewardConfigInfo> getRewardConfigs() {
		return rewardConfigs;
	}

	public void setRewardConfigs(List<RewardConfigInfo> rewardConfigs) {
		this.rewardConfigs = rewardConfigs;
	}

	public RewardConfigInfo getCurrentRewardConfig() {
		if(this.rewardConfigs != null && this.rewardConfigs.size() > 0) {
			for(RewardConfigInfo config : this.rewardConfigs) {
				if(config.getEffDttm() <= System.currentTimeMillis() && System.currentTimeMillis() <= config.getExpDttm()) {
					return config;
				}
			}
		}
		
		return null;
	}

}
