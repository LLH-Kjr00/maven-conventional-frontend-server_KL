package com.cmt.octopus;

/**
 * @author CMT
 * Copyright (c) 2016 Clever Motion Technology.
 * All rights reserved. 
 * Powered by Clever Motion Technology Limited
 */
public class TimeVerData {
	private int DevID;		/* Device ID */
	private int OperID;		/* Operator ID */
	private int DevTime;	/* Device Time */
	private int CompID;		/* Company ID */
	private int KeyVer;		/* Key Version */
	private int EODVer;		/* EOD Version */
	private int BLVer;		/* Blacklist Version */
	private int FIRMVer;	/* Firmware Version */
	private int CCHSVer;	/* CCHS MSG ID */
	private int CSSer;		/* CS Serial #, Loc ID */
	private int IntBLVer;	/* Interim Blacklist Version */
	private int	FuncBLVer;	/* Functional Blacklist Version */

	public TimeVerData() {
		super();
	}
	
	@Override
	public String toString() {
		return "TimeVer Data[" + DevID + ", " + OperID + ", " +DevTime+ ", " + CompID + ", " + KeyVer + ", " + EODVer + ", " + BLVer + ", " + FIRMVer + ", " + CCHSVer + ", " + CSSer + ", " + IntBLVer +  ", " + FuncBLVer +"]";
	}
	
	public void setDevID(int DevID){ this.DevID = DevID; }
	public void setOperID(int OperID){ this.OperID = OperID; }
	public void setDevTime(int DevTime){ this.DevTime = DevTime; }
	public void setCompID(int CompID){ this.CompID = CompID; }
	public void setKeyVer(int KeyVer){ this.KeyVer = KeyVer; }
	public void setEODVer(int EODVer){ this.EODVer = EODVer; }
	public void setBLVer(int BLVer){ this.BLVer = BLVer; }
	public void setFIRMVer(int FIRMVer){ this.FIRMVer = FIRMVer; }
	public void setCCHSVer(int CCHSVer){ this.CCHSVer = CCHSVer; }
	public void setCSSer(int CSSer){ this.CSSer = CSSer; }
	public void setIntBLVer(int IntBLVer){ this.IntBLVer = IntBLVer; }
	public void setFuncBLVer(int FuncBLVer){ this.FuncBLVer = FuncBLVer; }
	
	public int getDevID(){ return this.DevID; }
	public int getOperID(){ return this.OperID; }
	public int getDevTime(){ return this.DevTime; }
	public int getCompID(){ return this.CompID; }
	public int getKeyVer(){ return this.KeyVer; }
	public int getEODVer(){ return this.EODVer; }
	public int getBLVer(){ return this.BLVer; }
	public int getFIRMVer(){ return this.FIRMVer; }
	public int getCCHSVer(){ return this.CCHSVer; }
	public int getCSSer(){ return this.CSSer; }
	public int getIntBLVer(){ return this.IntBLVer; }
	public int getFuncBLVer(){ return this.FuncBLVer; }
}
