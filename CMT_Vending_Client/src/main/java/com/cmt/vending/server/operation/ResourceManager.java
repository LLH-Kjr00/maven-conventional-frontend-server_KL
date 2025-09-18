package com.cmt.vending.server.operation;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import com.cmt.vending.server.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ResourceManager {
	private static JAXBContext context = null;
	
	private static final Logger logger = LogManager.getLogger(ResourceManager.class);
	
	public static String INFO_FOLDER = "/opt/vending/RESOURCE/INFO/";
	public static String MEDIA_FOLDER = "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media";
	public static String PRODUCT_ICON_FOLDER =  "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/productIcon";
	public static String PRODUCT_IMAGE_FOLDER = "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/productImage";
	public static String PRODUCT_VIDEO_FOLDER = "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/productPlaylist";
	public static String TAB_ICON_FOLDER = "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/tabIcon";
	public static String PLAYLIST_VIDEO_FOLDER = "/home/cmt/CMT/tomcat/webapps/UI/dist/public/assets/media/playlist";

	public static final String INFO_VM_CONF				= "vm.xml";
	public static final String INFO_ALERT_LOG			= "alert.xml";
	public static final String INFO_TRAN_HISTORY 		= "trans_history.xml";
	public static final String INFO_TRAN_UUID 			= "trans_uuid.xml";
	public static final String INFO_SETTLEMENT_FILE 	= "settlement.xml";
	public static final String INFO_PRODUCTS			= "products.xml";
	public static final String INFO_PLAY_LIST 			= "playList.xml";
	public static final String INFO_VM_REQUEST_LOG 		= "request.xml";
	public static final String INFO_UPLOAD_LOG			= "log.xml";
	public static final String INFO_RECEIPT_NO 			= "receipt_no.xml";
	public static final String INFO_VIDEO_DOWNLOAD_LOG 	= "video_download.xml";
	public static final String INFO_GROUP_CONF			= "vm_group.xml";
	public static final String INFO_OCT_TRAN_HISTORY	= "oct_tran_history.xml";
	
	public static final String FIRMWARE_FOLDER = "/opt/vending/firmware";
	public static final String FIRMWARE_LOG = "history.xml";

	public static void printResourceInfo() {
		logger.info("INFO_FOLDER: " + INFO_FOLDER);
		logger.info("PRODUCT_ICON_FOLDER: " + PRODUCT_ICON_FOLDER);
		logger.info("PRODUCT_IMAGE_FOLDER : " + PRODUCT_IMAGE_FOLDER);
		logger.info("PRODUCT_VIDEO_FOLDER : " + PRODUCT_VIDEO_FOLDER);
		logger.info("TAB_ICON_FOLDER: " + TAB_ICON_FOLDER);
		logger.info("PLAYLIST_VIDEO_FOLDER: " + PLAYLIST_VIDEO_FOLDER);
	}
	
	public static Object getInfo(String fileName) {
		return ResourceManager.getDataFromLocalStorage(INFO_FOLDER, fileName);
	}

	/**
	 * Load local data
	 * @param folderName 目標資料夾
	 * @param fileName 檔案名稱
	 * @return 
	 */
	public static Object getDataFromLocalStorage(String folderName, String fileName){
		File f = new File(folderName + "/" + fileName);
		
		logger.info("[getDataFromLocalStorage]Get data from local storage: " + f.getAbsolutePath());
		
		if(f.exists()) {
			logger.info("[getDataFromLocalStorage]File exists, load data from that file");
			try {
				return getContext().createUnmarshaller().unmarshal(f);
			} catch (JAXBException e) {
				logger.error("[getDataFromLocalStorage]Failed to load data from local storage: ", e);
			}
		}
		else {
			logger.info("[getDataFromLocalStorage]File not exist");
		}
		
		return null;
	}
	
	private static JAXBContext getContext() {
		if(context == null) {
			try {
				context = JAXBContext.newInstance(
						AlertHistory.class,
						CellInfo.class,
						FirmwareUpgradeHistory.class, 
						IdlePlayList.class,
						MetaData.class,
						OctSettlementList.class,
						ReceiptNo.class,
						SettlementFile.class,
						TranHistory.class,
						TranUUID.class,
						VideoDownloadLogHistory.class,
						VmInfo.class,
						VmRequestLogHistory.class,
						VsCellInfo.class,
						VsVmInfo.class, 
						VsCellInfo.class, 
						OctopusTranHistory.class,
						VsGroupInfo.class
					);
			} catch (Exception e) {
				logger.error("[getContext]Failed to init JAXB context: ", e);
			}
		}
		return context;
	}
	
	public static void saveInfo(Object obj, String fileName) {
		ResourceManager.saveDataToLocalStorage(obj, INFO_FOLDER, fileName);
	}

	public static void saveDataToLocalStorage(Object obj, String folderName, String fileName) {
		File folder = new File(folderName);
		if(!folder.exists()) {
			logger.info("[saveDataToLocalStorage]Folder is not exist, create folder: " + folder.getAbsolutePath());
			folder.mkdirs();
		}
		
		logger.info("[saveDataToLocalStorage]Save data to local storage: " + folderName + "/" + fileName);
		Marshaller marshaller;
		
		try {
			marshaller = getContext().createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(obj, new File(folderName + "/" + fileName));
		}
		catch(Exception e) {
			logger.error("[saveDataToLocalStorage]Failed to save data to local storage: ", e);
		}
		
	}
}
