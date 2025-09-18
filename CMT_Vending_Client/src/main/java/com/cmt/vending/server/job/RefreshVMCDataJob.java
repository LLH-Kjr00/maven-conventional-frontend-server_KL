package com.cmt.vending.server.job;

import java.util.Iterator;
import java.util.Map;

import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.payment.AlipayPayment;
import com.cmt.vending.server.payment.OctopusPayment;
import com.cmt.vending.server.payment.WechatPayment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.model.OctTranRecord;
import com.cmt.vending.server.model.RewardConfigInfo;
import com.cmt.vending.server.model.VsCellInfo;
import com.cmt.vending.server.payment.Payment;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.server.operation.Scheduler;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;

public class RefreshVMCDataJob implements Runnable{

	private static final Logger logger = LogManager.getLogger(RefreshVMCDataJob.class);
	
	public static boolean isExecuted = false;
	
	@Override
	public void run() {
		if (!isExecuted) {
			
			isExecuted = true;
			logger.info("[RefreshVMCDataJob-run]Start to refresh VMC Data.");
			
			refresh();
			isExecuted = false;
		} else {
			logger.info("[RefreshVMCDataJobdow-run]Refreshing. Ignore current job");
		}
	}

	private void refresh() {		
		// Set Payment Setting
		// Disable all existing payments
		for (Map.Entry<Integer, Payment>  entry: LocalServer.getVmc().getSupportedPayment().entrySet()) {
			Payment paymentObject = entry.getValue();
			if(paymentObject.getPaymentCode() != OctopusPayment.CODE ) paymentObject.setEnable(false);
		}
		for(int i = 0; i < LocalDataManager.getVmInfo().getInfo().getPaymentMethods().length; i++) {
			int paymentCode = LocalDataManager.getVmInfo().getInfo().getPaymentMethods()[i];
			// If existing payments include the payment method
			if (LocalServer.getVmc().checkPayment(paymentCode)) {
				LocalServer.getVmc().setPaymentEnableAsTrue(paymentCode);
			
			// If not -> create the payment, and enable it
			} else {
				switch (paymentCode) {
					case WechatPayment.CODE:
						WechatPayment wechat = new WechatPayment();
						wechat.setEnable(true);
						LocalServer.getVmc().addPayment(wechat.getPaymentCode(), wechat);
						break;
					case AlipayPayment.CODE:
						AlipayPayment ali = new AlipayPayment();
						ali.setEnable(true);
						LocalServer.getVmc().addPayment(ali.getPaymentCode(), ali);
						break;
					default :
						logger.error("[refresh]Invalid payment code from backend: "+paymentCode);
				}
			}
		}
		
		// Remove invalid reward record
		final RewardConfigInfo rewardConfig = LocalDataManager.getVmInfo().getCurrentRewardConfig();
		if(rewardConfig != null) {
			// For each card
			for(OctTranRecord record : LocalDataManager.getOctTranHistory().getRecords()) {
				Iterator<Long> iterator = record.getTranDttms().iterator();
				// For each record of this card
				while(iterator.hasNext()) {
					Long tranDttm = iterator.next();
					if(tranDttm < rewardConfig.getEffDttm()) {
						iterator.remove();
					}
				}
			}
			ResourceManager.saveInfo(LocalDataManager.getOctTranHistory(), ResourceManager.INFO_OCT_TRAN_HISTORY);
		}
		
		// Update Scheduler
		Scheduler.updateScheduler();
		
		// Check vending machine column status
		VsCellInfo cellInfos = LocalDataManager.getCellInfo();
		for(int i = 0 ; i < cellInfos.getCellInfo().size(); i++) {
			CellInfo cellInfo = cellInfos.getCellInfo().get(i);
			// If the cell (column) is enabled, product is enabled and valid
			if( cellInfo.isEnabled()
					&& cellInfo.getProductInfo().isEnable()
					&& cellInfo.getCurrentPeriodInfo() != null
					&& cellInfo.getQty() > 0 ) {
				LocalServer.getVmc().checkColumn(cellInfo.getItemNo());
			}
		}
		
		try {
			while (TransactionManager.IS_TRAN_PROCESS) {
				Thread.sleep(200);
			}
			UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVmInfoResult(null));
		} catch(Exception e) {
			logger.error("[refresh]Error in waiting to push message to websocket handler to refresh UI: ", e);
		}
	}


}
