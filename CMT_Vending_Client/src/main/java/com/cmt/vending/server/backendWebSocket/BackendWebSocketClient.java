package com.cmt.vending.server.backendWebSocket;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.backendWebSocket.alipay.AlipayPaymentResultReq;
import com.cmt.vending.server.backendWebSocket.alipay.AlipayPaymentResultResp;
import com.cmt.vending.server.backendWebSocket.alipay.CancelAlipayPaymentResp;
import com.cmt.vending.server.backendWebSocket.alipay.GetAlipayQrCodeResp;
import com.cmt.vending.server.backendWebSocket.wechatpay.CancelWechatPaymentResp;
import com.cmt.vending.server.backendWebSocket.wechatpay.GetWechatQrCodeResp;
import com.cmt.vending.server.backendWebSocket.wechatpay.WechatPaymentResultReq;
import com.cmt.vending.server.backendWebSocket.wechatpay.WechatPaymentResultResp;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.payment.AlipayPayment;
import com.cmt.vending.server.payment.WechatPayment;
import com.cmt.vending.ui.response.QRCodeResp;
import com.cmt.vending.ui.webSocket.ReturnResult;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;
import com.cmt.vending.util.DateUtil;
import com.cmt.vending.util.GsonUtil;
import com.cmt.vending.util.ReflectionUtil;
import jakarta.websocket.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ClientEndpoint
public class BackendWebSocketClient {
    private static final Logger logger = LogManager.getLogger(BackendWebSocketClient.class);
    private static Session session = null;

    public static int sequenceNumber = 1;
    private static Map<Integer, Boolean> responseMap = new HashMap<Integer, Boolean>();

    private AlipayPaymentResultReq alipayResult = null;
    private WechatPaymentResultReq wechatResult = null;

    private boolean connected = false;
    public boolean isConnected() {
        return connected;
    }


    public static void sendMessage(String message) {
        logger.info("[sendMessage][ " + BackendWebSocketClient.session + " ]" + message);
        synchronized (session) {
            session.getAsyncRemote().sendText(message);
            sequenceNumber++;
        }
    }

    public static void sendMessage(String message, int waitingTime) {
        logger.info("[sendMessage][ " + BackendWebSocketClient.session + " ]" + message);
        int tempSeq = BackendWebSocketClient.sequenceNumber;
        try {
            responseMap.put(tempSeq, false);
            BackendWebSocketClient.sendMessage(message);

            // Waiting the backend server to respond with the request
            long timeout = System.currentTimeMillis() + waitingTime;
            do {
                try {
                    Thread.sleep(100);
                }
                catch(Throwable t) {

                }
            } while(!responseMap.get(tempSeq) && timeout > System.currentTimeMillis());

            if(!responseMap.get(tempSeq)) {
                try {
                    logger.info("[sendMessage]Cannot receive response, reconnect Backend Websocket and retry after 5s");
                    BackendWebSocketClient.close();
                } catch(Throwable t) {

                }
            }

        }
        catch(Throwable t) {
            logger.error("[sendMessage]Failed to sendMessage ", t);
        }

        responseMap.remove(tempSeq);
    }

    @OnOpen
    public void onOpen(Session session){
        synchronized (session){
            logger.info("[onOpen]Client WebSocket to the Backend [ id: " + session.getQueryString() + ", session: " + session + " ] is opening.");
            BackendWebSocketClient.session = session;
            this.connected = true;
            sequenceNumber = 1;
        }
    }

    @OnMessage
    public void onMessage(String message, Session session){
        try {
            logger.info("[onMessage]Receive request from Backend server [ " + BackendWebSocketClient.session + " ], Message: " + message);

            BackendWebSocketObject dataObj = GsonUtil.populateFromString(message, BackendWebSocketObject.class);

            if(dataObj.getAck() == 0 || responseMap.containsKey(dataObj.getAck())) {
                switch(dataObj.getAction()) {
                    case "GET_WECHAT_PAY_QR_CODE_RESP":
                        GetWechatQrCodeResp wechatRespObj = GsonUtil.populateFromString(message, GetWechatQrCodeResp.class);
                        responseMap.put(wechatRespObj.getAck(), true);

                        if (TransactionManager.CURRENT_PAYMENT_METHOD.getPaymentCode() != WechatPayment.CODE) {
                            logger.error("[onMessage]The current transaction is not WeChat (payment method mismatch).");
                            return;
                        }
                        if (wechatRespObj.getTranInfo() != null &&
                                !TransactionManager.CURRENT_TX.getTranUuid().equals(wechatRespObj.getTranInfo().getTranUuid())) {
                            logger.error("[onMessage]WeChat tranUuid mismatch.");
                            return;
                        }
                        if (wechatRespObj.getTranInfo() == null) {
                            logger.warn("[onMessage]WeChat QR code response has null tranInfo (proceeding without copying properties).");
                        }

                        if(wechatRespObj.isSuccess()) {
                            if (wechatRespObj.getTranInfo() != null) {
                                ReflectionUtil.copyProperties(TransactionManager.CURRENT_TX, wechatRespObj.getTranInfo());
                            }

                            UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getWechatQrCodeResult(
                                    new QRCodeResp(wechatRespObj.getQrCode(), wechatRespObj.getTimeout())));
                        } else {
                            ReturnResult result = ReturnResult.newFailInstance("WECHAT_QR_CODE");
                            result.setDataObj(new QRCodeResp("ERR60001", wechatRespObj.getErrorCode()));
                            UIWebSocketEndpoint.pushMessage(result);
                        }
                        break;

                    case "WECHAT_PAYMENT_RESULT":
                        this.wechatResult = GsonUtil.populateFromString(message, WechatPaymentResultReq.class);
                        sendMessage(GsonUtil.toJson(new WechatPaymentResultResp(wechatResult.getSeq())));

                        if(this.wechatResult != null && this.wechatResult.getTranInfo().getTranUuid().equals(TransactionManager.CURRENT_TX.getTranUuid())) {
                            if(this.wechatResult.isResult()) {
                                logger.info("[onMessage]Wechat payment success.");
                                ReflectionUtil.copyProperties(TransactionManager.CURRENT_TX, this.wechatResult.getTranInfo());
                                TransactionManager.CURRENT_TX.setRemark(DateUtil.formatDateTime(new Date(TransactionManager.CURRENT_TX.getTranDttmMs()), true));
                                TransactionManager.CURRENT_TX.setReceiptNo(WechatPayment.CODE + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).substring(3) + String.format("%04d", LocalDataManager.getVmInfo().getVmId()) + String.format("%04d", LocalDataManager.getWechatReceiptNoCurrent(true)));
                                TransactionManager.CURRENT_TX.setPayStatusCode(TransactionManager.PAYMENT_STATUS_SUCCESS);
                                TransactionManager.IS_TRAN_SUCCESS = true;
                                logger.info("[onMessage]Complete Wechat transaction");

                                TransactionManager.CURRENT_TX.setStockQty(LocalDataManager.getCellInfoByItemNo(TransactionManager.CURRENT_TX.getItemNo()).getQty()-1);
                                TransactionManager.CURRENT_TX.setVmcStatusCode(DatatypeConverter.printHexBinary(new byte[]{(byte)0xFF}));

                                LocalServer.getVmc().getPayment(WechatPayment.CODE).paySuccess();
                            } else {
                                logger.error("[onMessage]Failed to check Wechat payment success from server: [" + this.wechatResult.getErrorCode() + "] " + this.wechatResult.getErrorMsg());
                                logger.error("[onMessage]Incomplete Wechat transaction");
                            }
                            this.wechatResult = null;
                        }
                        break;


                    case "GET_ALI_PAY_QR_CODE_RESP":
                        GetAlipayQrCodeResp alipayRespObj = GsonUtil.populateFromString(message, GetAlipayQrCodeResp.class);
                        responseMap.put(alipayRespObj.getAck(), true);

                        if (TransactionManager.CURRENT_PAYMENT_METHOD.getPaymentCode() != AlipayPayment.CODE) {
                            logger.error("[onMessage]The current transaction is not Alipay (payment method mismatch).");
                            return;
                        }
                        if (alipayRespObj.getTranInfo() != null &&
                                !TransactionManager.CURRENT_TX.getTranUuid().equals(alipayRespObj.getTranInfo().getTranUuid())) {
                            logger.error("[onMessage]Alipay tranUuid mismatch.");
                            return;
                        }
                        if (alipayRespObj.getTranInfo() == null) {
                            logger.warn("[onMessage]Alipay QR code response has null tranInfo (proceeding without copying properties).");
                        }

                        if(alipayRespObj.isSuccess()) {
                            if (alipayRespObj.getTranInfo() != null) {
                                ReflectionUtil.copyProperties(TransactionManager.CURRENT_TX, alipayRespObj.getTranInfo());
                            }

                            UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getAlipayQrCodeResult(
                                    new QRCodeResp(alipayRespObj.getQrCode(), alipayRespObj.getTimeout())));
                        } else {
                            ReturnResult result = ReturnResult.newFailInstance("ALIPAY_QR_CODE");
                            result.setDataObj(new QRCodeResp("ERR60001", alipayRespObj.getErrorCode()));
                            UIWebSocketEndpoint.pushMessage(result);
                        }
                        break;

                    case "ALIPAY_PAYMENT_RESULT":
                        this.alipayResult = GsonUtil.populateFromString(message, AlipayPaymentResultReq.class);
                        sendMessage(GsonUtil.toJson(new AlipayPaymentResultResp(alipayResult.getSeq())));

                        if(this.alipayResult != null && this.alipayResult.getTranInfo().getTranUuid().equals(TransactionManager.CURRENT_TX.getTranUuid())) {
                            if(this.alipayResult.isResult()) {
                                logger.info("[onMessage]Alipay payment success.");
                                ReflectionUtil.copyProperties(TransactionManager.CURRENT_TX, this.alipayResult.getTranInfo());
                                TransactionManager.CURRENT_TX.setRemark(DateUtil.formatDateTime(new Date(TransactionManager.CURRENT_TX.getTranDttmMs()), true));
                                TransactionManager.CURRENT_TX.setReceiptNo(AlipayPayment.CODE + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).substring(3) + String.format("%04d", LocalDataManager.getVmInfo().getVmId()) + String.format("%04d", LocalDataManager.getAlipayReceiptNoCurrent(true)));
                                TransactionManager.CURRENT_TX.setPayStatusCode(TransactionManager.PAYMENT_STATUS_SUCCESS);
                                TransactionManager.IS_TRAN_SUCCESS = true;
                                logger.info("[onMessage]Complete Alipay transaction");

                                TransactionManager.CURRENT_TX.setStockQty(LocalDataManager.getCellInfoByItemNo(TransactionManager.CURRENT_TX.getItemNo()).getQty()-1);
                                TransactionManager.CURRENT_TX.setVmcStatusCode(DatatypeConverter.printHexBinary(new byte[]{(byte)0xFF}));

                                LocalServer.getVmc().getPayment(AlipayPayment.CODE).paySuccess();
                            } else {
                                logger.error("[onMessage]Failed to check alipay payment success from server: [" + this.alipayResult.getErrorCode() + "] " + this.alipayResult.getErrorMsg());
                                logger.error("[onMessage]Incomplete Alipay transaction");
                            }
                            this.alipayResult = null;
                        }
                        break;
                    case "CANCEL_ALIPAY_PAYMENT_RESP":
                        CancelAlipayPaymentResp cancelAlipayRespObj = GsonUtil.populateFromString(message, CancelAlipayPaymentResp.class);
                        responseMap.put(cancelAlipayRespObj.getAck(), true);
                        break;
                    case "CANCEL_WECHAT_PAYMENT_RESP":
                        CancelWechatPaymentResp cancelWechatRespObj = GsonUtil.populateFromString(message, CancelWechatPaymentResp.class);
                        responseMap.put(cancelWechatRespObj.getAck(), true);
                        break;
                }
                
            }
        }
        catch(Throwable t) {
            logger.error("[onMessage]Failed to populate string to json: ", t);
        }
    }

    @OnClose
    public void onClose(){
        synchronized (session){
            logger.info("[onClose]Backend Websocket [ " + BackendWebSocketClient.session + " ] closed.");
            connected = false;
            BackendWebSocketClient.session = null;
            new Thread(new BackendWebSocketThread()).start();
        }


    }

    @OnError
    public void onError(Session session, Throwable t) {
        logger.error("[onError]Error occurred during Backend Websocket connection [ " + BackendWebSocketClient.session + " ]:", t);
    }


    public static void close() throws IOException {
        if(BackendWebSocketClient.session.isOpen()){
            BackendWebSocketClient.session.close();
        }
    }

}
