package com.cmt.octopus;

/**
 * @author CMT
 * Copyright (c) 2016 Clever Motion Technology.
 * All rights reserved. 
 * Powered by Clever Motion Technology Limited
 */
public class RwlAdapter {
	static {
		System.loadLibrary("Rwlcmt");
  	}

	public native RwlReturn InitComm(int port, int baud, int controllerId);
	public native RwlReturn TxnAmt(int v, int rv, char led, char sound);
	public native RwlReturn TimeVer();
	public native RwlReturn Poll(char sub_com, char timeout);
	public native RwlReturn PollEx(char sub_com, char timeout);	//New Function
	public native RwlReturn Deduct(int value, int AI1, int AI2, int defer);
	public native RwlReturn XFile();
	public native RwlReturn Reset();
	public native RwlReturn WriteID(int id);
	public native RwlReturn HouseKeeping();
	public native RwlReturn PortClose();
	public native RwlReturn GetExtraInfo(int ui_com, int ui_param);	//New Function
}
