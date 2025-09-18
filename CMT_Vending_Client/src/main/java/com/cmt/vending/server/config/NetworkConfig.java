package com.cmt.vending.server.config;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.server.operation.SFTPComm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class NetworkConfig extends Properties {

    public void initProp() throws FileNotFoundException, IOException {
        this.load(new FileInputStream(new File(LocalServer.NETWORK_PROPERTIES_FILE_PATH)));
        // Default : SVM.PRD.HK.XXXXX
        BackendServerComm.API_HOST = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".API_HOST", "svm.365vending.net");
        BackendServerComm.API_PORT = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".API_PORT", "443");
        BackendServerComm.WS_PORT = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".WS_PORT", "443");
        BackendServerComm.INSTANCE = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".INSTANCE", "svm");
        BackendServerComm.INSTANCE_WS = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".INSTANCE_WS", "cmt");
        BackendServerComm.API_TIMEOUT_MS = Integer.parseInt(getProperty("NETWORK.API_TIMEOUT_MS", "30000"));

        SFTPComm.SFTP_HOST = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".API_HOST", "svm.365vending.net");
        SFTPComm.SFTP_PORT = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".SFTP_PORT", "22");
        SFTPComm.SFTP_USERNAME = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".SFTP_USERNAME", "vendingcmt");
        SFTPComm.SFTP_PW = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".SFTP_PW", "CMTech@2019*");
        SFTPComm.SFTP_DOWNLOAD_PATH = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".SFTP_DOWNLOAD_PATH", "/opt/vending-cmt/media");

        BackendServerComm.TRUST_STORE = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".TRUST_STORE", "/opt/vending/vendingclient.jks.PRD");
        BackendServerComm.TRUST_STORE_PW = getProperty(LocalServer.getLocalServerConfig().getClient() + "." + LocalServer.getLocalServerConfig().getEnv() + "." + LocalServer.getLocalServerConfig().getRegion() + ".TRUST_STORE_PW", "");
        

        BackendServerComm.NETWORK_DISABLE_DURATION_MIN = Integer.parseInt(getProperty("NETWORK.DISABLE_DURATION_MIN", "90"));

        BackendServerComm.IS_WIRELESS_NETWORK = !getProperty("NETWORK.PROVIDER", "").equals("");		// "" means no network provider -> IS_WIRELESS_NETWORK = false;

        //Add Server Cert
        System.setProperty("javax.net.ssl.trustStore", BackendServerComm.TRUST_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", BackendServerComm.TRUST_STORE_PW);
        System.setProperty("https.cipherSuites", "TLS_RSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA");
    }

    public void printConfig() {
        BackendServerComm.printNetworkInfo();
        SFTPComm.printSftpInfo();
    }
}
