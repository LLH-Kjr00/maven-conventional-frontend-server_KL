package com.cmt.vending.server.vmc.tcn.api3;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import com.cmt.vending.server.config.VmcConfig;
import com.cmt.vending.server.vmc.AbstractVmc;

public class TcnApiThree extends AbstractVmc  implements SerialPortEventListener, Runnable {
	
	public TcnApiThree (VmcConfig config) {
		super(config);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serialEvent(SerialPortEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkColumn(int itemNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vendProduct() {
		// TODO Auto-generated method stub
		
	}

}
