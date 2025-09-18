package com.cmt.vending.server;

import com.cmt.vending.server.config.LocalServerConfig;
import com.cmt.vending.server.config.NetworkConfig;
import com.cmt.vending.server.config.ResourceConfig;
import com.cmt.vending.server.config.VmcConfig;
import com.cmt.vending.server.gpio.GPIOCtrl;
import com.cmt.vending.server.job.SendAlertJob;
import com.cmt.vending.server.job.UploadVideoDownloadLogJob;
import com.cmt.vending.server.job.UploadVmRequestLogJob;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.server.vmc.AbstractVmc;
import com.cmt.vending.server.vmc.jy.JyApiOne;
import com.cmt.vending.server.vmc.mq.MiQuanOne;
import com.cmt.vending.server.vmc.tcn.api3.TcnApiThree;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocalServer {
    private static final Logger logger = LogManager.getLogger(LocalServer.class);

    public static String VERSION_CODE = "00000";

    public static final String VM_PROPERTIES_FILE_PATH = "/opt/vending/vm.properties";
    public static final String NETWORK_PROPERTIES_FILE_PATH = "/opt/vending/network.properties";
    public static final String RESOURCE_PROPERTIES_FILE_PATH = "/opt/vending/resource.properties";
    public static final String VMC_PROPERTIES_FILE_PATH = "/opt/vending/vmc.properties";
    public static final String OCT_PROPERTIES_FILE_PATH = "/opt/vending/oct.properties";

    @Getter
    private static LocalServerConfig localServerConfig = null;
    @Getter
    private static NetworkConfig networkConfig = null;
    @Getter
    private static ResourceConfig resourceConfig = null;
    @Getter
    private static VmcConfig vmcConfig = null;

    @Getter
    private static AbstractVmc vmc = null;

    /**
     * Load configuration from the local storage
     * @return
     */
    public static void loadConfig() {
        logger.info("[loadConfig]Start to load configuration");
        System.out.println("[loadConfig]Start to load configuration");
        localServerConfig = new LocalServerConfig();
        networkConfig = new NetworkConfig();
        resourceConfig = new ResourceConfig();
        vmcConfig = new VmcConfig();

        try {
            logger.info("[loadConfig]Loading Client Config ( "+ VM_PROPERTIES_FILE_PATH + " )" );
            System.out.println("[loadConfig]Loading Client Config ( "+ VM_PROPERTIES_FILE_PATH + " )" );
            localServerConfig.initProp();

            logger.info("[loadConfig]Loading Network Config ( "+ NETWORK_PROPERTIES_FILE_PATH + " )");
            networkConfig.initProp();

            logger.info("[loadConfig]Loading Resource Config ( "+ RESOURCE_PROPERTIES_FILE_PATH + " )");
            resourceConfig.initProp();

            logger.info("[loadConfig]Loading Global Config ( "+ VMC_PROPERTIES_FILE_PATH + " )");
            vmcConfig.initProp();

        } catch (Exception e) {
            logger.error("[loadConfig]Error in loading configuration: ", e);
        }

        setModelFromGpio(); 


        localServerConfig.printConfig();
        networkConfig.printConfig();
        resourceConfig.printConfig();
        vmcConfig.printConfig();

    }

    
    /**
     * Set the model of the vending machine from gpio value using the old gpio lib (does not work in Oct3.0)
     */
     private static void setModelFromGpio(){
        byte pinB = 0;
        try {
            GPIOCtrl gpioCtrl = new GPIOCtrl();
            pinB = gpioCtrl.GetPin();
        } catch (Throwable e) {
            logger.error("[setModelFromGpio]Failed to get GPIO: ", e);
        }

        int gpioValue = Integer.parseInt(Integer.toHexString(pinB & 0xFF), 16);
        logger.info("[setModelFromGpio]GPIO Value: " + gpioValue);

        /**
        switch (gpioValue) {
			case 127:// GPIO 7 Pin 8
				localServerConfig.setModel(LocalServerConfig.MODEL_DJ_2);
				//getVmcConfig().setBaudRate(9600);
				break;
			case 191:// GPIO 6 Pin 6
				if(!localServerConfig.getModel().equals(LocalServerConfig.MODEL_BANDAI_1)) {
					logger.info("Get model ["+localServerConfig.getModel() + "], GPIO 6 Pin 6 , Not BANDAI, Init as JY_1");
					localServerConfig.setModel(LocalServerConfig.MODEL_JY_1);
				}else {
					logger.info("Get model ["+localServerConfig.getModel() + "],GPIO 6 Pin 6 , BANDAI, Init as BANDAI_1");
					localServerConfig.setModel(LocalServerConfig.MODEL_BANDAI_1);
				}
				//getVmcConfig().setBaudRate(9600);
				break;
			case 223:// GPIO 5 Pin 4
				localServerConfig.setModel(LocalServerConfig.MODEL_DJ_1);			// red,	For Advboom
				//getVmcConfig().setBaudRate(9600);
				break;
			case 239:// GPIO 4 Pin 2
				localServerConfig.setModel(LocalServerConfig.MODEL_MQ_1);
				//getVmcConfig().setBaudRate(9600);
				break;
			case 247:// GPIO 3 Pin 7
				localServerConfig.setModel(LocalServerConfig.MODEL_TCN_2);		 	// purple	
				break;
			case 251:// GPIO 2 Pin 5			
				break;
			case 253:// GPIO 1 Pin 3
				localServerConfig.setModel(LocalServerConfig.MODEL_TCN_3);
				break;
			case 254:// GPIO 0 Pin 1
				localServerConfig.setModel(LocalServerConfig.MODEL_XY_1);			// green, For Little Store
				//getVmcConfig().setBaudRate(57600);
				//localServerConfig.setGraphicMode(false);
				break;
			case 255:// no pin connected
			default:
				localServerConfig.setModel(LocalServerConfig.MODEL_XY_1);			// NO JUMPER
				//getVmcConfig().setBaudRate(57600);
				break;
		}
                 */

        
        switch (gpioValue) {
            case 191:// Pin 6
                localServerConfig.setModel(LocalServerConfig.MODEL_JY_1);
                break;
            case 239:// Pin 2
                localServerConfig.setModel(LocalServerConfig.MODEL_MQ_1);
                break;
            case 253:// Pin 3
                localServerConfig.setModel(LocalServerConfig.MODEL_TCN_3);
                break;
            default:
                logger.error("[setModelFromGpio]Unknown GPIO Value " + gpioValue + " so the model is keep as setting in vm.properties: " + localServerConfig.getModel() );
                break;
        }
    
    
    }
    /**
     * Loading data from the local storage (e.g. product, playlist)
     */
    public static void loadLocalData() {
        logger.info("[loadConfig]Start to load data from RESOURCE Folder.");

        // Get vending machine information from local storage
        LocalDataManager.getVmInfo();
        LocalDataManager.getCellInfo();
        LocalDataManager.getPlayList();

        // Get Alert from local storage
        SendAlertJob.getAlertHistory();

        // Get Transaction History from local storage
        TransactionManager.getTranHistory();
        TransactionManager.getTranUUID();

        // Get Vm Request history
        UploadVmRequestLogJob.getVmRequestLogHistory();

        // Get video download history
        UploadVideoDownloadLogJob.getVideoDownloadLogHistory();

    }

    /**
     * Initialize vending machine based on the model
     */
    public static void initVMC() {
        logger.info("[initVMC]Start to initialize vending machine.");

        if (localServerConfig.getModel().equals(LocalServerConfig.MODEL_TCN_3)) {
            vmc = new TcnApiThree(getVmcConfig());
        } else if(localServerConfig.getModel().equals(LocalServerConfig.MODEL_JY_1)) {
            vmc = new JyApiOne(getVmcConfig());
        } else if(localServerConfig.getModel().equals(LocalServerConfig.MODEL_MQ_1)) {
            vmc = new MiQuanOne(getVmcConfig());
        } else {
            logger.error("[initVMC]Invalid machine model");
            return;
        }
        vmc.init();
        vmc.loadSupportedPayment();
    }

    public static void main(String[] args) {
        loadConfig();
    }

}
