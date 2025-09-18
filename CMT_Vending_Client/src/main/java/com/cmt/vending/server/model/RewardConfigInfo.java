package com.cmt.vending.server.model;

public class RewardConfigInfo {
	private long effDttm;
	private long expDttm;
	private int rewardPeriod;
	private int qtyX;

	public long getEffDttm() {
		return effDttm;
	}

	public void setEffDttm(long effDttm) {
		this.effDttm = effDttm;
	}

	public long getExpDttm() {
		return expDttm;
	}

	public void setExpDttm(long expDttm) {
		this.expDttm = expDttm;
	}

	public int getRewardPeriod() {
		return rewardPeriod;
	}

	public void setRewardPeriod(int rewardPeriod) {
		this.rewardPeriod = rewardPeriod;
	}

	public int getQtyX() {
		return qtyX;
	}

	public void setQtyX(int qtyX) {
		this.qtyX = qtyX;
	}

}
