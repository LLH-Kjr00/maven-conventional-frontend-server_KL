package com.cmt.vending.server.vmc;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

//import javax.comm.CommPortIdentifier;
//import javax.comm.PortInUseException;
//import javax.comm.SerialPort;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.server.payment.AlipayPayment;
import com.cmt.vending.server.payment.OctopusPayment;
import com.cmt.vending.server.payment.WechatPayment;
import gnu.io.NRSerialPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;


import gnu.io.RXTXPort;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.config.VmcConfig;
import com.cmt.vending.server.payment.Payment;

import javax.xml.bind.DatatypeConverter;

public abstract class AbstractVmc {
	protected Logger logger = LogManager.getLogger("vmc");
	
	protected VmcConfig config;
	
	protected HashMap<Integer, Payment> supportedPayment = new HashMap<Integer, Payment>(); 
	
	protected RXTXPort serialPort;
	protected InputStream in;
	protected OutputStream out;
	private final long sendDuration = 100;

	@Getter
	protected long lastResponseMs;	// Last response time with vending machine
	public static final long DEFAULT_VMC_TIMEOUT = 30000;
	
	public AbstractVmc(VmcConfig config){
		this.config = config;
	}

	protected static String formatHexString(byte[] bytes) {
		return formatHexString(bytes, true);
	}

	public static String formatHexString(byte[] bytes, boolean appendSpace) {
		String hexString = DatatypeConverter.printHexBinary(bytes);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hexString.length() / 2; i++) {
			sb.append(hexString.subSequence(i * 2, i * 2 + 2));
			if(appendSpace){
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	public boolean openPort() {
		String comm = config.getCOMM_DEV() + config.getCOMM_PORT();
		int baudRate = config.getBAUD_RATE();
		logger.info("[openPort]Start to open port [ " + comm + " ] with baud rate: " + baudRate);
		boolean res = false;
		try {
//			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(comm);
//			serialPort = (SerialPort) portIdentifier.open(comm, 3000);
//			serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

//			SerialPort serialPort = SerialPort.getCommPort(comm);

			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(comm);
			serialPort = portIdentifier.open(comm, 3000);
			serialPort.setSerialPortParams(baudRate, RXTXPort.DATABITS_8, RXTXPort.STOPBITS_1, RXTXPort.PARITY_NONE);


			logger.info("[openPort]BaudRate: " + serialPort.getBaudRate());
			logger.info("[openPort]DataBits: " + serialPort.getDataBits());
			logger.info("[openPort]StopBits: " + serialPort.getStopBits());
			logger.info("[openPort]Parity: " + serialPort.getParity());
			logger.info("[openPort]FlowControl: " + serialPort.getFlowControlMode());

			this.in = serialPort.getInputStream();
			this.out = serialPort.getOutputStream();
			
			res = true;
		} catch (PortInUseException e) {
			logger.error("[openPort]Port is used by other application", e);
		} catch (Exception e) {
			logger.error("[openPort]Failed to open COM-port: " + comm, e);
		}

		return res;
	}

	public Object getCurTemp() {
		// TODO Auto-generated method stub
		return null;
	}

	public void cleanup() {
		try {
			this.in.close();
			this.out.close();
			this.serialPort.close();
		} catch (Exception e) {
			logger.error("Failed to close COM-port: " + serialPort.getName(), e);
		}
//		TODO close octopus
//		this.getPayment(OctopusPayment.CODE).closeComm();
	}

	public abstract void init();
	public abstract void checkColumn(int itemNo);
	public abstract void vendProduct();

	protected synchronized void sendCommand(byte[] command) {
		try {
			logger.info("[sendCommand]Send CMD: " + formatHexString(command));

			if(out != null) {
				out.write(command, 0, command.length);
				out.flush();
			}

			Thread.sleep(sendDuration);
		} catch (Exception e) {
			logger.error("[sendCommand]Failed to send command to vmc...", e);
		}
	}


	/**
	 * Load supported payment methods from local data
	 */
	public void loadSupportedPayment(){
		logger.info("[loadSupportedPayment]Initiate Supported payment");

		OctopusPayment oct = new OctopusPayment();
		oct.setEnable(true);
		this.addPayment(oct.getPaymentCode(), oct);

		if (LocalDataManager.getVmInfo().getInfo().getPaymentMethods() == null) return;

		for(int i = 0; i < LocalDataManager.getVmInfo().getInfo().getPaymentMethods().length; i++) {
			int paymentCode = LocalDataManager.getVmInfo().getInfo().getPaymentMethods()[i];
			switch (paymentCode) {
				case WechatPayment.CODE:
					WechatPayment wechat = new WechatPayment();
					wechat.setEnable(true);
					this.addPayment(wechat.getPaymentCode(), wechat);
					break;
				case AlipayPayment.CODE:
					AlipayPayment ali = new AlipayPayment();
					ali.setEnable(true);
					this.addPayment(ali.getPaymentCode(), ali);
					break;
				default :
					logger.error("[loadSupportedPayment]Invalid payment code: "+paymentCode);
			}
		}
	}
	/**
	 * Get all supported payments
	 * @return
	 */
	public HashMap<Integer, Payment> getSupportedPayment (){
		return this.supportedPayment;
	}
	/**
	 * Get payment object by the key
	 * @param key
	 * @return
	 */
	public Payment getPayment(int key) {
		return this.supportedPayment.get(key);
	}
	/**
	 * Add payment object
	 * @param key
	 * @param method
	 */
	public void addPayment(int key, Payment method) {
		this.supportedPayment.put(key, method);
	}
	/**
	 * Check if the supported payment contains the key
	 * @param key
	 * @return
	 */
	public boolean checkPayment(int key) {
		return this.supportedPayment.containsKey(key);
	}
	/**
	 * Set a payment object as enabled
	 * @param key
	 */
	public void setPaymentEnableAsTrue(int key) {
		Payment object = this.supportedPayment.get(key);
		if (object != null) {
			object.setEnable(true);
		}
	}
	
}
