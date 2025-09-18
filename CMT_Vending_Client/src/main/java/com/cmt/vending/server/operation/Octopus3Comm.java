package com.cmt.vending.server.operation;

import com.octopuscards.ocrl.OcrlJNI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

public class Octopus3Comm {
    public static final Logger logger = LogManager.getLogger("octopus");

    public static boolean isOctNormal = true;

    private static OcrlJNI ocrljni = null;

    final static String jsonTransRequest = "{\"command\":\"trans.request\",\"transactionData\": {\"type\":\"%s\",\"transactionValue\":%d,\"receiptNumber\":\"%s\"}}\0";
    final static String jsonCardEnquiryRequest = "{\"command\":\"trans.request\",\"transactionData\": {\"type\":\"card.enquiry\",\"receiptNumber\":\"%s\"}}\0";
    final static String jsonSettleRequest = "{\"command\":\"trans.request\",\"transactionData\": {\"type\":\"settle\"}}\0";
    final static String jsonTransPerform = "{\"command\":\"trans.perform\",\"transactionId\":\"%s\"}\0";
    final static String jsonTransCancel = "{\"command\":\"trans.cancel\",\"transactionId\":\"%s\"}\0";
    final static String jsonGetConfig = "{\"command\":\"config.get\"}\0";

    final static String jsonDiscountSchemeEnquiry = "{\"command\":\"scheme.enquiry\"}\0";
    final static String jsonCustomMessage = "{\"command\":\"display.img\",\"resId\":\"%s\"}\0";

    private static Gson gson = new Gson();
    private static byte[] rspbuffer = new byte[4096];


    public static synchronized  OcrlJNI getOcrljni(){
        if(ocrljni == null) {
            logger.info("Init OcrlJNI(Octopus3.0).");
            ocrljni = new OcrlJNI();
        }

        return ocrljni;
    }

    public static synchronized int connect(String port){

        logger.info("connect Call:\t\t" + port );
        int returnCode  = getOcrljni().connect(port);
        if (returnCode == 0){
            isOctNormal = true;
        } else {
            isOctNormal = false;
        }
        logger.info("connect Return:\t\t" + returnCode);
        return returnCode;
    }

    public static  synchronized void disconnect(){
        getOcrljni().disconnect();
    }

    public static synchronized String deduct(int amount) {
        String receiptNum = DateTimeFormatter.ofPattern("yyyymmddHHMMss", Locale.ENGLISH).format(LocalDateTime.now());
        String request = String.format(jsonTransRequest, "deduct", amount, receiptNum);
        return sendRecv(request);
    }

    public static synchronized String cardEnquiry() {
        String receiptNum = DateTimeFormatter.ofPattern("yyyymmddHHMMss", Locale.ENGLISH).format(LocalDateTime.now());
        String request = String.format(jsonCardEnquiryRequest, receiptNum);
        return sendRecv(request);
    }

    public static synchronized String settle(){
        return sendRecv(jsonSettleRequest);
    }

    public static void getConfig() {
        String resp = sendRecv(jsonGetConfig);
        if (resp != null)
            logger.info(resp);
    }

    public static synchronized  String getDiscountScheme(){
        String request = sendRecv(jsonDiscountSchemeEnquiry);
        return sendRecv(request);
    }
    public static synchronized  void displayCustomMessage(String id){
        String cmd = String.format(jsonCustomMessage, id);
        String resp = sendRecv(cmd);
        if (resp != null)
            logger.info(resp);

    }

    public static String sendRecv(String json) {
        logger.info("cmdExchange Call:\t\t" + json );
        int ret = getOcrljni().cmdExchange(json.getBytes(StandardCharsets.UTF_8), rspbuffer, rspbuffer.length);
        logger.info("cmdExchange return:\t\t" + ret );

        if (ret == -1 || ret == -2){
            disconnect();
            return null;
        }

        if (ret == -6){
            logger.error("Multi-thread Error.");
            // TODO proper handling
            return null;
        }

        // convert UTF8 to java String
        int i;
        for (i = 0; i < rspbuffer.length && rspbuffer[i] != 0; i++)
            ;
        return new String(rspbuffer, 0, i, StandardCharsets.UTF_8);
    }

    public static String performAction(String transID) {
        String cmd = String.format(jsonTransPerform, transID);
        return sendRecv(cmd);
    }

    public static String cancelAction(String transID) {
        String cmd = String.format(jsonTransCancel, transID);
        return sendRecv(cmd);
    }

}
