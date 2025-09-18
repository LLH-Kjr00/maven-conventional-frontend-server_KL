package com.cmt.octopus;

public class PollDeductReturn {
	private int deductAmt;
	
	private RwlReturn pollReturn;
	private RwlReturn deductReturn;
	private RwlReturn extraInfoReturn;
	
	private boolean sameCard;

	public PollDeductReturn() {
		this(0);
	}	
	
	public PollDeductReturn(int deductAmt) {
		super();
		this.deductAmt = deductAmt;
		this.sameCard= true; 
	}

	@Override
	public String toString() {
		return "PollDeductReturn[" + deductAmt + ", " + isPollSuccess() + ", " + isDeductSuccess() + ", " + isGetExtraInfoSuccess() + "]";
	}
	
	public boolean isDeduct() {
		return deductAmt > 0;
	}

	public boolean isPollSuccess() {
		return pollReturn != null && pollReturn.getReturnCode() <= 100000;
	}

	public boolean isDeductSuccess() {
		return isPollSuccess() && deductReturn != null
				&& deductReturn.getReturnCode() <= 100000;
	}

	public boolean isGetExtraInfoSuccess() {
		return isPollSuccess() && extraInfoReturn != null
				&& extraInfoReturn.getReturnCode() == 0;
	}

	public RwlReturn getPollReturn() {
		return pollReturn;
	}

	public void setPollReturn(RwlReturn pollReturn) {
		this.pollReturn = pollReturn;
	}

	public RwlReturn getDeductReturn() {
		return deductReturn;
	}

	public void setDeductReturn(RwlReturn deductReturn) {
		this.deductReturn = deductReturn;
	}

	public RwlReturn getExtraInfoReturn() {
		return extraInfoReturn;
	}

	public void setExtraInfoReturn(RwlReturn extraInfoReturn) {
		this.extraInfoReturn = extraInfoReturn;
	}

	public int getDeductAmt() {
		return deductAmt;
	}

	public void setDeductAmt(int deductAmt) {
		this.deductAmt = deductAmt;
	}

	public boolean isSameCard() {
		return sameCard;
	}

	public void setSameCard(boolean sameCard) {
		this.sameCard = sameCard;
	}

}
