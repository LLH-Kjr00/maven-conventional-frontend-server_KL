package com.cmt.vending.ui.webSocket;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.operation.Octopus3Comm;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.payment.OctopusPayment;
import com.cmt.vending.ui.request.*;
import com.cmt.vending.util.GsonUtil;
import com.cmt.vending.util.RuntimeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.websocket.api.Callback;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketOpen;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.time.Duration;

@WebSocket
public class UIWebSocketEndpoint {
    private static final Logger logger = LogManager.getLogger(UIWebSocketEndpoint.class);
    private static Session session = null;
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {

        System.out.println("[onClose]UI Websocket Close: " + reason);
        logger.info("[onClose]UI Websocket Close: " + reason);

        try {
            if (session != null) {
                session.close();
            }
        } catch (Throwable e) {
            logger.error("[onClose]Failed to close UI websocket connection: ", e);
        }
    }

    @OnWebSocketError
    public void onError(Throwable t) {
        System.out.println("[onError]UI Websocket Error: " + t.getMessage());
        logger.error("[onError]UI Websocket Error: ", t.getMessage());
    }

    @OnWebSocketOpen
    public void onConnect(Session session) {
        System.out.println("[onConnect]UI Websocket Opened");
        logger.info("[onConnect]UI Websocket Opened");

        session.setIdleTimeout(Duration.ofMinutes(30));

        cleanUp();

        UIWebSocketEndpoint.session = session;
    }

    @OnWebSocketMessage
    public void onMessage(String message) {

        logger.info("[onMessage]UI Websocket Message from UI: " + message);
        ReturnResult result = null;
        try {
            Request request = GsonUtil.populateFromString(message, Request.class);

            try {
                switch (request.getAction()) {
                    case "GET_VM_INFO":
                        result = UIWebSocketHandler.getVmInfoResult(GsonUtil.populateFromString(message, VmInfoReq.class));
                        break;
                    case "SELECT_PRODUCT":
                        result = UIWebSocketHandler.getSelectProductResult(GsonUtil.populateFromString(message, SelectProductReq.class));
                        break;
                    case "UNSELECT_PRODUCT":
                        result = UIWebSocketHandler.getUnselectProductResult(GsonUtil.populateFromString(message, Request.class));
                        break;
                    case "SELECT_PRODUCT_PAYMENT":
                        result = UIWebSocketHandler.getSelectProductPaymentResult(GsonUtil.populateFromString(message, SelectProductPaymentReq.class));
                        break;
                    case "UNSELECT_PRODUCT_PAYMENT":
                        if(TransactionManager.CURRENT_PAYMENT_METHOD != null) {
                            TransactionManager.CURRENT_PAYMENT_METHOD.payCancel();
                        }
                        break;
                    case "OCT_ENQUIRY":
                        result = UIWebSocketHandler.getOctEnquiryResult(GsonUtil.populateFromString(message, Request.class));
                        break;
                    case "OCT_ENQUIRY_CANCEL":
                        if (LocalServer.getVmc().checkPayment(OctopusPayment.CODE)) {
                            OctopusPayment octopusObject = (OctopusPayment) LocalServer.getVmc().getPayment(OctopusPayment.CODE);
                            octopusObject.cancelEnquiry();
                        }
                        break;
                    case "REBOOT":
                        RuntimeUtil.rebootCommand();
                        break;
                    case "POWER_OFF":
                        Runtime.getRuntime().exec("sudo shutdown now -h");
                        break;
                    case "OCT_VERSION":
                        // TODO get the octopus version
                        break;
                    case "OCT_2":
                        if (LocalServer.getVmc().checkPayment(OctopusPayment.CODE)) {
                            OctopusPayment octopusObject = (OctopusPayment) LocalServer.getVmc().getPayment(OctopusPayment.CODE);
                            octopusObject.changeVersion(2);
                        }
                        Runtime.getRuntime().exec("sudo shutdown now -h");
                        break;
                    case "OCT_3":
                        if (LocalServer.getVmc().checkPayment(OctopusPayment.CODE)) {
                            OctopusPayment octopusObject = (OctopusPayment) LocalServer.getVmc().getPayment(OctopusPayment.CODE);
                            octopusObject.changeVersion(3);
                        }
                        Runtime.getRuntime().exec("sudo shutdown now -h");
                        break;
                    case "OCT_3_RETRY":
                        TransactionManager.CURRENT_PAYMENT_METHOD.continuePayment();
                        break;
                    case "OCT_3_NOT_RETRY":
                        TransactionManager.CURRENT_PAYMENT_METHOD.stopPayment();
                        break;
                    case "OCT_3_SCHEME_ENQUIRY":
                        if (LocalServer.getVmc().checkPayment(OctopusPayment.CODE)) {
                            OctopusPayment octopusObject = (OctopusPayment) LocalServer.getVmc().getPayment(OctopusPayment.CODE);
                            octopusObject.discountSchemeEnquiry();
                        }
                        break;
                    case "OCT_3_CUSTOM_MESSAGE":
                        if (LocalServer.getVmc().checkPayment(OctopusPayment.CODE)) {
                            OctopusPayment octopusObject = (OctopusPayment) LocalServer.getVmc().getPayment(OctopusPayment.CODE);
                            octopusObject.setCustomMessageId(GsonUtil.populateFromString(message, Octopus3CustomMessageReq.class).getId());
                        }
                        break;
                    default:
                        logger.error("[onMessage]Unknown Request: " + request.getAction());
                }

            } catch (Throwable e) {
                logger.error("[onMessage]Error during handling UI Websocket request: ", e);
            }

            if (result != null) pushMessage(result);
        }catch(Throwable e) {
            logger.error("[onMessage]Failed to populate UI Websocket Message UI to String: ", e);
        }
    }

    /**
     * Push Message to UI
     * @param result
     */
    public synchronized static void pushMessage(ReturnResult result) {
        logger.info("[pushMessage]UI Websocket Message Pushed to UI: " + result.toJsonString());
        if (session != null && session.isOpen()) {
            try {
                session.sendText(result.toJsonString(), Callback.NOOP);
            }catch(Throwable e) {
                logger.error("[pushMessage]Failed to send message to UI: ", e);
            }
        } else {
            logger.info("[pushMessage]UI Websocket Session Closed. Unable to Push Message.");
        }
    }

    /**
     * Close the old session
     */
    public static void cleanUp() {
        try {
            if(UIWebSocketEndpoint.session != null) {
                UIWebSocketEndpoint.session.close();
                UIWebSocketEndpoint.session = null;
                Thread.sleep(1000);
            }
        } catch (Throwable e) {
            logger.error("[cleanUp]Failed to close UI Websocket connection: ", e);
        }
    }
}
