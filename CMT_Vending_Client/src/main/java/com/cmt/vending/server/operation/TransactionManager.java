package com.cmt.vending.server.operation;

import java.util.Date;
import java.util.UUID;

import com.cmt.vending.server.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.job.SendTranJob;
import com.cmt.vending.server.payment.OctopusPayment;
import com.cmt.vending.server.payment.Payment;

public class TransactionManager {
	private static Logger logger = LogManager.getLogger(TransactionManager.class);
	
	// Transaction Type Code
	public static final int TRAN_TYPE_SALE = 1;
	public static final int TRAN_TYPE_OUT_OF_STOCK = 2;
	public static final int TRAN_TYPE_FREE_VEND = 6;
	public static final int TRAN_TYPE_REWARD = 8;
	
	// Transaction Result Code
	public static final int PAYMENT_STATUS_SUCCESS = 1;


	private static TranHistory history = null;
	private static TranUUID uuid = null;
	private static OctSettlementList settlement = null;
	
	public static boolean IS_TRAN_PROCESS = false;	
	public static boolean IS_TRAN_SUCCESS = false;
	public static TranInfo CURRENT_TX = null;
	public static Payment CURRENT_PAYMENT_METHOD = null;
	
	
	public static TranHistory getTranHistory() {
		if(history == null) {
			history = (TranHistory) ResourceManager.getInfo(ResourceManager.INFO_TRAN_HISTORY);
		}
		
		if(history == null) {
			history = new TranHistory();
		}
		
		return history;
	}
	
	public static TranUUID getTranUUID() {
		if(uuid == null) {
			uuid = (TranUUID) ResourceManager.getInfo(ResourceManager.INFO_TRAN_UUID);
		}
		
		if(uuid == null) {
			uuid = new TranUUID();
		}
		
		return uuid;
	}
	
	public static OctSettlementList getOctSettlement() {
		if(settlement == null) {
			settlement = (OctSettlementList) ResourceManager.getInfo(ResourceManager.INFO_SETTLEMENT_FILE);
		}
		
		if(settlement == null) {
			settlement = new OctSettlementList();
		}
		
		return settlement;
	}

	public static void addTran(TranInfo tran) {
		logger.info("[addTran]Add new Tran: ItemNo: " + tran.getItemNo() + 
				", UUID: " + tran.getTranUuid() + 
				", Type: " + tran.getTranTypeId() + 
				", TranDttm: " + new Date(tran.getTranDttmMs()) + 
				", TranDttmMs: " + tran.getTranDttmMs() + 
				", payment_code: " + tran.getPayMethodCode() + 
				", pay_status: " + tran.getPayStatusCode());
		
		history.getTran().add(tran);
	
		// If this is octopus transaction and the payment is successful and the version of octopus is 2-> add uuid
		if(tran.getPayMethodCode() == OctopusPayment.CODE && tran.getPayStatusCode() == PAYMENT_STATUS_SUCCESS && OctopusPayment.octconfig.getVERSION() == 2) {
			uuid.getUuid().add(tran.getTranUuid());
			ResourceManager.saveInfo(uuid, ResourceManager.INFO_TRAN_UUID);
		}
		ResourceManager.saveInfo(history, ResourceManager.INFO_TRAN_HISTORY);
	}
	
	/**
	 * Send transaction record to the back end server
	 */
	public static void sendTran() {
		
		try {
			Boolean res = (boolean) BackendServerComm.startJob(new SendTranJob()).get();
			
			if (res) history.getTran().clear();
		} catch(Exception e) {
			logger.error("[SendAlertJob-execute]Error in execution of send transaction job: ", e);
		}
	}
	
	
	public static TranInfo createSaleTran(CellInfo product, int qty) {
		TranInfo info = new TranInfo();
		info.setTranTypeId(TRAN_TYPE_SALE);
		info.setCellId(product.getCellId());
		info.setItemNo(product.getItemNo());
		info.setProductId(product.getProductInfo().getProductId());
		info.setQty(qty);
		
		return info;
	}

	public static TranInfo createFreeTran(CellInfo product, int qty){
		TranInfo info = new TranInfo();
		info.setTranTypeId(TRAN_TYPE_FREE_VEND);
		info.setCellId(product.getCellId());
		info.setItemNo(product.getItemNo());
		info.setProductId(product.getProductInfo().getProductId());
		info.setQty(qty);
		TransactionManager.CURRENT_TX.setTranUuid(UUID.randomUUID().toString());
		TransactionManager.CURRENT_TX.setTranDttmMs(System.currentTimeMillis());
		TransactionManager.CURRENT_TX.setStockQty(product.getQty() -1 );

		return info;
	}

	public static TranInfo createOutOfStockTran(int cellId, int itemNo){
		TranInfo info = new TranInfo();
		info.setTranTypeId(TRAN_TYPE_OUT_OF_STOCK);
		info.setCellId(cellId);
		info.setItemNo(itemNo);
		info.setTranUuid(UUID.randomUUID().toString());
		info.setTranDttmMs(System.currentTimeMillis());

		return info;
	}
	
}
