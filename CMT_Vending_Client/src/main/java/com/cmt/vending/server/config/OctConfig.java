package com.cmt.vending.server.config;

import com.cmt.vending.server.LocalServer;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class OctConfig extends Properties {

    @Getter
    private String COMM_DEV_3 = "/dev/ttyS";
    @Getter
    private String COMM_PORT_3 = "3";
    @Getter @Setter
    private int VERSION = 3;

    public void initProp() throws FileNotFoundException, IOException {
        this.load(new FileInputStream(new File(LocalServer.OCT_PROPERTIES_FILE_PATH)));

        this.COMM_DEV_3 = this.getProperty("OCT3.COMM_DEV", "/dev/ttyS");
        this.COMM_PORT_3 = this.getProperty("OCT3.COMM_PORT", "4");
        this.VERSION = Integer.parseInt(this.getProperty("OCT.VERSION", "3"));
    }
}
