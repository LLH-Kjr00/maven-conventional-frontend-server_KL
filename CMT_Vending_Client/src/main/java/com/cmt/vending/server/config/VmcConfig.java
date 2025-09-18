package com.cmt.vending.server.config;

import com.cmt.vending.server.LocalServer;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class VmcConfig extends Properties {
    private static final Logger logger = LogManager.getLogger(VmcConfig.class);

    @Getter
    private String COMM_DEV = "/dev/ttyS";
    @Getter
    private String COMM_PORT = "4";
    @Getter
    private int BAUD_RATE = 9600;

    public void initProp() throws FileNotFoundException, IOException {
        this.load(new FileInputStream(new File(LocalServer.VMC_PROPERTIES_FILE_PATH)));

        this.COMM_DEV = this.getProperty("VMC.COMM_DEV", "/dev/ttyS");
        this.COMM_PORT = this.getProperty("VMC.COMM_PORT", "4");
        this.BAUD_RATE = Integer.parseInt(this.getProperty("VMC.BAUD_RATE", "9600"));

    }

    public void printConfig() {
        logger.info("VMC.COMM_DEV: "+this.COMM_DEV );
        logger.info("VMC.COMM_PORT: "+this.COMM_PORT );
        logger.info("VMC.BAUD_RATE: "+this.BAUD_RATE );
    }

    public void setBaudRate(int baudRate) {
		this.BAUD_RATE = baudRate;
	}
}
