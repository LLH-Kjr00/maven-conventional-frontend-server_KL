package com.cmt.vending.server.operation;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.job.FirmwareUpgradeJob;
import com.cmt.vending.server.job.SendAlertJob;
import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.util.JvmUtil;
import com.cmt.vending.util.ModemUtil;
import com.cmt.vending.util.StorageUtil;
import com.cmt.vending.ws.*;
import com.cmt.vending.ws.obj.xsd.ExtraParam;
import com.cmt.vending.ws.obj.xsd.SendAlertReq;
import com.cmt.vending.ws.obj.xsd.WsReq;
import org.apache.axis2.AxisFault;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.Exception;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BackendServerComm {
    private static Logger logger = LogManager.getLogger(BackendServerComm.class);
    public static String API_HOST = "svm.365vending.net";
    public static String API_PORT = "443";
    public static String WS_PORT = "443";
    public static String INSTANCE = "svm";
    public static String INSTANCE_WS = "cmt";
    public static long API_TIMEOUT_MS = 30000;

    public static String TRUST_STORE = "/opt/vending/vendingclient.jks.PRD";
    public static String TRUST_STORE_PW = "";

    public static int NETWORK_DISABLE_DURATION_MIN = 90;	// If the machine has not accessed to the back end server more than NETWORK_DISABLE_DURATION_MIN -> reboot

    public static boolean IS_WIRELESS_NETWORK = false;

    public static int SPACE_USAGE_ALERT = 80;		// OS space usage percentage, if exceed -> send alert

    private static ExecutorService THREAD_POOL = Executors.newCachedThreadPool();

    private static VendingStub VENDING_STUB = null;
    private static OctopusStub OCTOPUS_STUB = null;
    private static PaymentStub PAYMENT_STUB = null;

    public static void printNetworkInfo() {
        logger.info("API_HOST: " + API_HOST);
        logger.info("API_PORT: " + API_PORT);
        logger.info("API_TIMEOUT_MS : " + API_TIMEOUT_MS);
        logger.info("INSTANCE: " + INSTANCE);
        logger.info("INSTANCE_WS: " + INSTANCE_WS);
        logger.info("TRUST_STORE: " + TRUST_STORE);
        logger.info("NETWORK_DISABLE_DURATION_MIN: "+ NETWORK_DISABLE_DURATION_MIN);
    }

    public static Future<?> startJob(Callable<?> job) {
        return THREAD_POOL.submit(job);
    }
    public static void startJob(Runnable job) {
        THREAD_POOL.submit(job);
    }

    public static VendingStub getVendingStub()  throws AxisFault {
        VENDING_STUB = new VendingStub("https://" + API_HOST + ":" + API_PORT + "/" + INSTANCE + "/services/Vending?wsdl");
        VENDING_STUB._getServiceClient().getOptions().setTimeOutInMilliSeconds(API_TIMEOUT_MS);

        return VENDING_STUB;
    }

    public static OctopusStub getOctopusStub() throws AxisFault {
        OCTOPUS_STUB = new OctopusStub("https://" + API_HOST + ":" + API_PORT + "/" + INSTANCE + "/services/Octopus?wsdl");
        OCTOPUS_STUB._getServiceClient().getOptions().setTimeOutInMilliSeconds(API_TIMEOUT_MS);

        return OCTOPUS_STUB;
    }
    public static Octopus_IwashStub getOctopusIwashStub() throws AxisFault {
        Octopus_IwashStub OctopusIwashStub = new Octopus_IwashStub("https://" + API_HOST + ":" + API_PORT + "/" + INSTANCE + "/services/Octopus_Iwash?wsdl");
        OctopusIwashStub._getServiceClient().getOptions().setTimeOutInMilliSeconds(API_TIMEOUT_MS);

        return OctopusIwashStub;
    }


    public static GetServiceStub getGetServiceStub() throws AxisFault {
        GetServiceStub ServiceStub = new GetServiceStub("https://" + API_HOST + ":" + API_PORT + "/" + INSTANCE + "/services/GetService?wsdl");
        ServiceStub._getServiceClient().getOptions().setTimeOutInMilliSeconds(API_TIMEOUT_MS);

        return ServiceStub;
    }

    /**
     * Stub for obtaining logo
     * @return
     * @throws AxisFault
     */
    public static Eight_LaundryStub get8LaundryStub() throws AxisFault {
        Eight_LaundryStub LaundryStub = new Eight_LaundryStub("https://" + API_HOST + ":" + API_PORT + "/" + INSTANCE + "/services/Eight_Laundry?wsdl");
        LaundryStub._getServiceClient().getOptions().setTimeOutInMilliSeconds(API_TIMEOUT_MS);

        return LaundryStub;
    }


    /**
     * Set general information to request object (e.g. whether get video list, current firmware version, signal strength)
     * @param reqObj
     * @throws Exception
     */
    public static void setGeneralInfo(WsReq reqObj) throws Exception{
        reqObj.setVmId(LocalServer.getLocalServerConfig().getVmId());
        reqObj.setRequestDttm(System.currentTimeMillis());
        reqObj.setRequestVideoList(true);											// Get video list
        reqObj.setVersionNo(FirmwareUpgradeJob.getCurrentFirmwareVersion());		// Current version number
        reqObj.setVmVersionMs(LocalDataManager.getVmInfo() == null? 0 : LocalDataManager.getVmInfo().getVmVersionServerMs());

        Integer result = ModemUtil.getSignalQuality();
        if (result.equals(0)){
            logger.warn("[setGeneralInfo]No active connections");
        }
        else if (result.equals(null)){
            logger.error("[setGeneralInfo]Unknown connection type");
            result = 0;

        }
            reqObj.setSignalStrength(Integer.valueOf(result)/10);
        

        // Check storage usage -> If excess -> Add this alert
        // To avoid dead loop for sendAlertJob -> If this request object is for sendAlertJob, not do the following
        if(!(reqObj instanceof SendAlertReq)) {
            reqObj.setStorageUsage(StorageUtil.getUsedStorageAsPercentage("/"));
            if(reqObj.getStorageUsage().floatValue() > SPACE_USAGE_ALERT) {
                SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_STORAGE, "" + reqObj.getStorageUsage().floatValue()));
            }
        }

        // Set CPU usage, memory usage and swap usage
        reqObj.setCpuUsage(JvmUtil.getCpuUsage());
        reqObj.setMemoryUsage(JvmUtil.getMemoryUsage());
        reqObj.setSwapUsage(JvmUtil.getSwapSpaceUsage());

        String jsonString = "";
        if(LocalServer.getVmc() != null) {
            //	Set product quantity
            for(CellInfo info : LocalDataManager.getCellInfo().getCellInfo()) {
                jsonString += "{ itemNo: " + info.getItemNo() + ", cell_status: " + (LocalDataManager.getVmInfo().getInfo().isEnabled() ? 1 : 0) + (info.isEnabled() ? 1 : 0) + (info.getProductInfo().isEnable() ? 1: 0) + (info.getCurrentPeriodInfo() != null ? 1 : 0)  + (info.isColumnNormal() ? 1 : 0) + ((info.getQty() != 0 ? 1 : 0)) + ", qty: " + info.getQty() + " },";
            }
        }
        else {
            reqObj.setVmStatus("{}");
        }

        // Set Current temperature
        if(LocalServer.getVmc().getCurTemp() != null) {
            ExtraParam temp = new ExtraParam();
            temp.setName("curTemp");
            temp.setVal(LocalServer.getVmc().getCurTemp().toString());

            reqObj.setExtraParams(new ExtraParam[] {temp});
        }
    }

    public static String generateReceiptQrCode(String uuid) {
        return "https://" + API_HOST + ":" + API_PORT + "/" + INSTANCE + "/tran?id=" + uuid;
    }
}
