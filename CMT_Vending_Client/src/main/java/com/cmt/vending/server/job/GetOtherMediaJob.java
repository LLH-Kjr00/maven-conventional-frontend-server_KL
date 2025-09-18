package com.cmt.vending.server.job;

import java.io.File;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.model.ProductCategoryInfo;
import com.cmt.vending.server.model.ProductPeriodInfo;
import com.cmt.vending.server.model.VsCellInfo;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.server.operation.SFTPComm;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;
import com.cmt.vending.ws.obj.xsd.VideoDownloadLogInfo;

public class GetOtherMediaJob implements Runnable {

	private static Logger logger = LogManager.getLogger(GetOtherMediaJob.class);
	
	private static boolean isExecuted = false;
	
	@Override
	public void run() {
		if (!isExecuted) {
			isExecuted = true;
			logger.info("[GetOtherMediaJob-run]Start to download media including product image, playlist video.");
			
			downloadOtherMedia();
			isExecuted = false;
		} else {
			logger.info("[GetOtherMediaJob-run]Downloading media. Ignore current job");
		}	
	}
		
	private boolean downloadProductMedia() {
		boolean anydownload = false;
		VsCellInfo cellInfos = LocalDataManager.getCellInfo();
		
		try {
			Iterator<CellInfo> iterator = cellInfos.getCellInfo().iterator();
			while (iterator.hasNext()) {
				CellInfo cellInfo = iterator.next();
				
				// Download the product category icon (tab icon)
				ProductCategoryInfo category = cellInfo.getProductInfo().getProductCategoryInfo();
				if (category != null) {
					if (category.getIcon() > 0) {
						boolean download = false;
						download = SFTPComm.download(String.valueOf(category.getIcon()), ResourceManager.TAB_ICON_FOLDER, false);
						if (download) anydownload = true;
					}
				}
				
				// Download the product icon and image
				for (ProductPeriodInfo period : cellInfo.getProductInfo().getProductPeriodInfo()) {
					
					if (period.getImageId() > 0) {
						boolean download = false;
						download = SFTPComm.download(String.valueOf(period.getImageId()), ResourceManager.PRODUCT_IMAGE_FOLDER, false);
						if (download) anydownload = true;
					}

					if (period.getImageSmallId() > 0) {
						boolean download = false;
						download = SFTPComm.download(String.valueOf(period.getImageSmallId()), ResourceManager.PRODUCT_ICON_FOLDER, false);
						if (download) anydownload = true;
					}
					
					if (period.getVideoId() > 0) {
						boolean download = false;
						download = SFTPComm.download(String.valueOf(period.getVideoId()), ResourceManager.PRODUCT_VIDEO_FOLDER, false);
						if (download) anydownload = true;
					}
				}
			}
			
		} catch (Exception e) {
			logger.error("[downloadProductMedia]Error in downloading product media: ", e);
		}
		
		return anydownload;
	}

	private boolean downloadPlaylistVideo() {
		boolean anydownload = false;
		
		try {
			for (int id : LocalDataManager.getPlayList().getPlayList()) {
				// Check if id exist, if exist -> next
				File indicatorFile = new File(ResourceManager.PLAYLIST_VIDEO_FOLDER+"/"+String.valueOf(id) + "_finish");
				File realFile = new File(ResourceManager.PLAYLIST_VIDEO_FOLDER+"/"+String.valueOf(id));
				if (indicatorFile.exists() && realFile.length() > 0) continue;
				
				boolean download = false;
				download = SFTPComm.download(String.valueOf(id), ResourceManager.PLAYLIST_VIDEO_FOLDER, true);
				if (download) anydownload = true;
				
				// Add the download to the record
				try{
	        		VideoDownloadLogInfo info = new VideoDownloadLogInfo();
					info.setAdvId(id);
					info.setStatus(download? "S": "F");
					UploadVideoDownloadLogJob.getVideoDownloadLogHistory().getHistory().add(info);
		        } catch(Exception e) {
		        	logger.error("[download]Failed to add video download log: ", e);
		        }
			}

			// Create upload download job
			BackendServerComm.startJob(new UploadVideoDownloadLogJob());
			
		} catch (Exception e) {
			logger.error("[downloadPlaylistVideo]Error in downloading playlist video: ", e);
		}
		
		return anydownload;
	}
	
	private void downloadOtherMedia() {
		boolean refreshUI = false;
		
		boolean download = downloadProductMedia();
		if (download) {
			BackendServerComm.startJob(new UploadVmRequestLogJob());
			refreshUI = true;
		} 
		
		download = downloadPlaylistVideo();
		if (download) refreshUI = true;

		// If there is any new downloaded image, refresh the UI.
		try {
			if (refreshUI) {
				while (TransactionManager.IS_TRAN_PROCESS) {
					Thread.sleep(200);
				}
				UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVmInfoResult(null));
			}
		} catch(Exception e) {
			logger.error("[downloadOtherMedia]Error in waiting to push message to websocket handler to refresh UI: ", e);
		}
		
	}

	
}
