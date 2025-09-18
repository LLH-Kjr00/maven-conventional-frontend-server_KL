package com.cmt.vending.server.payment;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.backendWebSocket.BackendWebSocketClient;
import com.cmt.vending.server.backendWebSocket.alipay.CancelAlipayPaymentReq;
import com.cmt.vending.server.backendWebSocket.alipay.GetAlipayQrCodeReq;
import com.cmt.vending.server.backendWebSocket.wechatpay.CancelWechatPaymentReq;
import com.cmt.vending.server.backendWebSocket.wechatpay.CancelWechatPaymentResp;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.ui.response.TranCompleteResp;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;
import com.cmt.vending.util.GsonUtil;

import java.math.BigDecimal;

public class AlipayPayment extends Payment {
    public static final int CODE = 5;
    public static final String NAME = "ALIPAY";
    public AlipayPayment() {
        super(CODE, NAME);
    }

    @Override
    public void pay(BigDecimal price, BigDecimal vipPrice) {
        this.getAlipayQrCode();
    }

    public void getAlipayQrCode() {
        logger.info("[getAlipayQrCode]Start to get QR code.");
        TransactionManager.CURRENT_TX.setRemark(LocalDataManager.getCellInfoByItemNo(TransactionManager.CURRENT_TX.getItemNo()).getCurrentPeriodInfo().getName());
        BackendWebSocketClient.sendMessage(GsonUtil.toJson(new GetAlipayQrCodeReq(TransactionManager.CURRENT_TX), false, true), 10000);
    }

    @Override
    public void paySuccess() {
        logger.info("[AlipayPayment-paySuccess]User pay by alipay successfully");
        TransactionManager.addTran(TransactionManager.CURRENT_TX);

        if(TransactionManager.CURRENT_TX.getTranTypeId() == TransactionManager.TRAN_TYPE_SALE) {
            // UI show the receipt
            UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getTranCompleteResult(new TranCompleteResp(TransactionManager.CURRENT_TX)));

            // Vend the product
            LocalServer.getVmc().vendProduct();

            // Send the transaction
            TransactionManager.sendTran();
        }
    }

    @Override
    public void payFail() {
        if(TransactionManager.CURRENT_TX.getPayStatusCode() != TransactionManager.PAYMENT_STATUS_SUCCESS) {
            BackendWebSocketClient.sendMessage(GsonUtil.toJson(new CancelAlipayPaymentReq(TransactionManager.CURRENT_TX), false, true), 10000);
        }
    }

    @Override
    public void payCancel() {
        if(TransactionManager.CURRENT_TX.getPayStatusCode() != TransactionManager.PAYMENT_STATUS_SUCCESS) {
        BackendWebSocketClient.sendMessage(GsonUtil.toJson(new CancelAlipayPaymentReq(TransactionManager.CURRENT_TX), false, true), 10000);
        UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getUnselectProductPaymentResult());	
        }
    }

    @Override
    public void continuePayment() {

    }

    @Override
    public void stopPayment() {

    }
}
