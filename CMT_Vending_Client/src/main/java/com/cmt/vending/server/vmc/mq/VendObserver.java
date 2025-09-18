package com.cmt.vending.server.vmc.mq;

import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.ui.response.VendFailResp;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

public class VendObserver implements Observer {

    protected Logger logger = LogManager.getLogger(getClass());

    @Override
    public void update(Observable o, Object arg) {
        this.handle(((VendObservable) o).isSuccess(), ((VendObservable) o).getErrorCode());
    }

    protected void handle(boolean res, int errorCode) {
        // If there is error code
        if(errorCode != 0) {
            logger.info("[handle]Vending Fail errorCode: " + errorCode + ",receipt no: " + TransactionManager.CURRENT_TX.getReceiptNo());
            UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVendFailResult(new VendFailResp("VEND_FAIL", TransactionManager.CURRENT_TX.getReceiptNo(), String.valueOf(60000 + errorCode))));
        }
        // Refresh the UI
        UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVmInfoResult(null));

        TransactionManager.IS_TRAN_PROCESS = false;

        // Save the stock number
        CellInfo stock = LocalDataManager.getCellInfoByItemNo(TransactionManager.CURRENT_TX.getItemNo());
        int remainQty = stock.getQty() - 1;
        stock.setQty(remainQty);
        ResourceManager.saveInfo(LocalDataManager.getCellInfo(), ResourceManager.INFO_PRODUCTS);

        // If the stock number is zero -> report backend
        if (remainQty == 0) {
            TransactionManager.addTran(TransactionManager.createOutOfStockTran(TransactionManager.CURRENT_TX.getCellId(), TransactionManager.CURRENT_TX.getItemNo()));
            TransactionManager.sendTran();
        }

    }
}
