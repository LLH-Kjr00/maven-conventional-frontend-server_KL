package com.cmt.vending.server.vmc.mq;

import com.cmt.vending.server.job.SendAlertJob;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.payment.OctopusPayment;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.config.VmcConfig;
import com.cmt.vending.server.vmc.AbstractVmc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

import net.digger.util.crc.CRC;

public class MiQuanOne extends AbstractVmc  implements SerialPortEventListener {
	protected Logger logger = LogManager.getLogger("vmc");
	
	public MiQuanOne(VmcConfig config) {
		super(config);
	}

	private final byte ADDRESS = (byte) 0x01;
	private final byte CMD_GET_ID = (byte) 0x01;            // Get VMC ID
	private final byte CMD_POLL = (byte) 0x03;              // POLL
	private final byte CMD_COLUMN_STATUS = (byte) 0x04;     // Get Column Status;
	private final byte CMD_VEND = (byte) 0x05;              // Vend Product

	private final byte STATUS_VEND_COMPLETE = (byte) 0x02;

	private VendHandler handler;
	protected AliveObservable aliveObservable = new AliveObservable();
	protected VendObservable vendObservable = new VendObservable();
	protected ColumnObservable columnObservable = new ColumnObservable();
	protected LinkedHashMap<Integer, Boolean> columnStatus = new LinkedHashMap<>();

	private List<Integer> currentCheckColumns = new ArrayList<Integer>();

	protected void setAliveObserver(AliveObserver observer) {
		if(observer != null) {
			this.aliveObservable.deleteObservers();
			this.aliveObservable.addObserver(observer);
		}
	}

	public void setColumnObserver(ColumnObserver observer) {
		if(observer != null) {
			this.columnObservable.deleteObservers();
			this.columnObservable.addObserver(observer);
		}
	}

	public void setVendObserver(VendObserver observer) {
		if(observer != null) {
			this.vendObservable.deleteObservers();
			this.vendObservable.addObserver(observer);
		}
	}

	@Override
	public void init() {
		logger.info("[init]Initiate VMC now: MQ_1");

		logger.info("[init]Initiate the vending machine");
		boolean portOpened = false;
		boolean alert = false;

		do {
			portOpened = openPort();

			if (portOpened) {
				try {
					serialPort.addEventListener(this);

				} catch (TooManyListenersException e1) {
					logger.error("[init]Failed to add event listener to VMC", e1);
					return;
				}
				serialPort.notifyOnDataAvailable(true);
				logger.info("[init]Initiate complete");

				this.setAliveObserver(new AliveObserver());
				this.setColumnObserver(new ColumnObserver());
				this.setVendObserver(new VendObserver());
			} else {
				if (!alert) {
					SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_VMC_DEVICE, "Not Started At Init"));
					alert = true;
				}
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					logger.error("[init]Error in Sleep", e);
				}
			}
		} while(!portOpened);

		this.enableHeartbeat();

		if (alert){
			SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_VMC_DEVICE, "F->S"));
		}

	}

	@Override
	public void serialEvent(SerialPortEvent spe) {
		long ms = System.currentTimeMillis();

		logger.info("[serialEvent]Last response time: " + lastResponseMs + ", Current response time: " + ms + ", EventType:" + spe.getEventType());
		lastResponseMs = ms;

		int data;
		int recvLen = 0;
		byte[] cRecv = new byte[20];
		byte[] response = null;

		try {
			while (((data = in.read()) > -1)) {
				if (recvLen == 0) {
					if ((byte) data == 0x00) {
						cRecv[recvLen++] = (byte) data;
					}
				} else {
					cRecv[recvLen++] = (byte) data;
				}

				if (recvLen == 20) {
					response = new byte[recvLen];
					for (int i = 0; i < recvLen; i++) {
						response[i] = cRecv[i];
					}
					break;
				}
			}
			logger.info("[serialEvent]ReceiveResponse: " + AbstractVmc.formatHexString(response));

			final byte[] subArray = Arrays.copyOfRange(response, 0, 18);
			final byte[] crc = this.getCRC(subArray);

			if(crc[0] == response[18] && crc[1] == response[19]) {
				switch (response[1]) {
					case CMD_VEND:
						logger.info("[serialEvent]VMC vend product now.");
						this.handler = new VendHandler(this, this.vendObservable);
						new Thread(this.handler).start();
						break;
					case CMD_COLUMN_STATUS:
						if(!this.currentCheckColumns.isEmpty()) {
							final Integer column = this.currentCheckColumns.remove(0);
							this.columnObservable.setData(column, response[2] == (byte) 0xAA);
							break;
						}
					case CMD_POLL:
						this.updateVendStatus(response[2], response[4]);
						break;
					default:
						break;
				}
			}
		} catch (Exception e) {
			logger.error("[serialEvent]Failed to receive data from vmc", e);
		}


	}

	protected void enableHeartbeat() {
		new Thread(() -> {
			do {
				try {
					this.getDeviceStatus();
					long tm = System.currentTimeMillis();
					this.aliveObservable.setData(!(tm - lastResponseMs > DEFAULT_VMC_TIMEOUT));
					Thread.sleep(60000);
				} catch (Exception e) {
					logger.error("[enableHeartbeat]Error :", e);
				}
			} while (true);
		}).start();
	}

	private void updateVendStatus(byte status, byte errorCode) {
		this.handler.setErrorCode(errorCode);

		// If the status is complete -> set vending as false
		if(status == STATUS_VEND_COMPLETE) {
			this.handler.setVending(false);
		}
	}


	@Override
	/**
	 * Command to check column status
	 */
	public void checkColumn(int itemNo) {
		this.currentCheckColumns.add(itemNo);
		final byte[] data = generateCommand(new byte[] { ADDRESS, CMD_COLUMN_STATUS, (byte) (itemNo - 1), 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00  });
		this.sendCommand(data);
	}

	/**
	 * Command to vend product
	 */
	@Override
	public void vendProduct() {
		int itemNo = TransactionManager.CURRENT_TX.getItemNo();
		final byte[] data = generateCommand(new byte[] { ADDRESS, CMD_VEND, (byte) (itemNo - 1), 0x03, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00  });
		this.sendCommand(data);
		
	}

	/**
	 * Command to get the vending machine status
	 */
	protected void getDeviceStatus() {
		final byte[] data = generateCommand(new byte[] { ADDRESS, CMD_GET_ID, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 });
		this.sendCommand(data);
	}

	/**
	 * Command to get the vending result
	 */
	public void getVendStatus() {
		final byte[] data = generateCommand(new byte[] { ADDRESS, CMD_POLL, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 });
		this.sendCommand(data);
	}

	private byte[] generateCommand(byte[] data) {
		final byte[] crc = getCRC(data);
		final byte[] request = new byte[20];

		System.arraycopy(data, 0, request, 0, data.length);
		System.arraycopy(crc, 0, request, data.length, crc.length);

		return request;
	}

	private byte[] getCRC(byte[] data) {
		long crc = CRC.calculate(CRC.CRC16_Modbus, data);

		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putLong(crc);

		final byte[] result = buffer.array();

		return new byte[] { result[0], result[1] };
	}
}

