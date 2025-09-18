package com.cmt.vending.server.config;

import com.cmt.vending.server.LocalServer;

import lombok.Getter;
import lombok.Setter;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LocalServerConfig extends Properties {
    private static final Logger logger = LogManager.getLogger(LocalServerConfig.class);

    public static final String MODEL_XY_1 = "XY-1"; // 興元 1
	public static final String MODEL_XY_2 = "XY-2"; // 興元 2
	public static final String MODEL_MDB = "MDB";
	public static final String MODEL_TCN_3 = "TCN-3"; // 中吉 3
	public static final String MODEL_TCN_2 = "TCN-2"; // 中吉 2
	public static final String MODEL_DJ_1 = "DJ-1"; // 東吉 1
	public static final String MODEL_DJ_2 = "DJ-2"; // 東吉 2
	public static final String MODEL_JY_1 = "JY_1"; // 聚英 relay board
	public static final String MODEL_MQ_1 = "MQ_1"; // 米泉 
	public static final String MODEL_YY_F1 = "YY-F1"; // 雲印 F1
	public static final String MODEL_YY_T2 = "YY-T2"; // 雲印 T2
    public static final String MODEL_BANDAI_1 = "BANDAI_1"; //BANDAI 1

    public static final String ENV_PRD = "PRD";
    public static final String REGION_HK = "HK";

    @Getter
    private int vmId = 1;
    @Getter @Setter
    private String model = MODEL_MQ_1;
    @Getter
    private String region = REGION_HK;
    @Getter
    private String env = ENV_PRD;
    @Getter
    private String client = "SVM";

    public void initProp() throws FileNotFoundException, IOException {
        this.load(new FileInputStream(new File(LocalServer.VM_PROPERTIES_FILE_PATH)));
        this.vmId = Integer.parseInt(getProperty("VM.ID", "1"));
        this.model = getProperty("VM.MODEL", LocalServerConfig.MODEL_MQ_1);
        this.env = getProperty("VM.ENVIRONMENT", LocalServerConfig.ENV_PRD);
        this.region = getProperty("VM.REGION", LocalServerConfig.REGION_HK);
        this.client = getProperty("VM.CLIENT", "SVM");
    }

    public void printConfig() {
        logger.info("VM.ID: "+this.vmId );
        logger.info("VM.MODEL: "+this.model );
        logger.info("VM.ENVIRONMENT: "+this.env );
        logger.info("VM.REGION: "+this.region );
        logger.info("VM.CLIENT: "+this.client );
    }
}
