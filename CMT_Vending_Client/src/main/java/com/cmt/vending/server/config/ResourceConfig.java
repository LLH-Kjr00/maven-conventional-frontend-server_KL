package com.cmt.vending.server.config;

import com.cmt.vending.server.LocalServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.cmt.vending.server.operation.ResourceManager;

public class ResourceConfig  extends Properties {
    public void initProp() throws FileNotFoundException, IOException {
        this.load(new FileInputStream(new File(LocalServer.RESOURCE_PROPERTIES_FILE_PATH)));

        ResourceManager.INFO_FOLDER = getProperty("RESOURCE.INFO_FOLDER", "/opt/vending/RESOURCE/INFO/");
        ResourceManager.MEDIA_FOLDER = getProperty("RESOURCE.MEDIA_FOLDER", "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media");
        ResourceManager.PRODUCT_ICON_FOLDER = getProperty("RESOURCE.PRODUCT_ICON_FOLDER", "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/productIcon");
        ResourceManager.PRODUCT_IMAGE_FOLDER = getProperty("RESOURCE.PRODUCT_IMAGE_FOLDER", "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/productImage");
        ResourceManager.PRODUCT_VIDEO_FOLDER = getProperty("RESOURCE.PLAYLIST_VIDEO_FOLDER", "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/productPlaylist");
        ResourceManager.TAB_ICON_FOLDER = getProperty("RESOURCE.TAB_ICON_FOLDER", "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/tabIcon");
        ResourceManager.PLAYLIST_VIDEO_FOLDER = getProperty("RESOURCE.PLAYLIST_VIDEO_FOLDER", "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/playlist");

    }

    public void printConfig() {
        ResourceManager.printResourceInfo();
    }

}
