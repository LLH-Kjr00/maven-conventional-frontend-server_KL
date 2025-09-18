package com.cmt.vending.server.operation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.model.IdlePlayList;
import com.cmt.vending.server.model.OctTranRecord;
import com.cmt.vending.server.model.OctopusTranHistory;
import com.cmt.vending.server.model.ReceiptNo;
import com.cmt.vending.server.model.VsCellInfo;
import com.cmt.vending.server.model.VsGroupInfo;
import com.cmt.vending.server.model.VsVmInfo;

public class LocalDataManager {
	private static final Logger logger = LogManager.getLogger(LocalDataManager.class);
	
	private static VsGroupInfo groupInfo = null;
	private static VsVmInfo vmInfo = null;
	private static VsCellInfo cellInfo = null;
	private static IdlePlayList playList = null;
	private static OctopusTranHistory octTranHistory = null;		// For reward
	private static ReceiptNo receiptNo;
	
	public static void setGroupInfo (VsGroupInfo groupInfo) {
		LocalDataManager.groupInfo = groupInfo;
	}
	public static VsGroupInfo getGroupInfo() {
		if (groupInfo == null) {
			groupInfo = (VsGroupInfo) ResourceManager.getInfo(ResourceManager.INFO_GROUP_CONF);
		}
		
		if (groupInfo == null) {
			groupInfo = new VsGroupInfo();
		}
		return groupInfo;
	}
	
	public static void setVmInfo(VsVmInfo vmInfo) {
		LocalDataManager.vmInfo = vmInfo;
	}
	public static VsVmInfo getVmInfo() {
		// Get vending machine information from local storage
		if (vmInfo == null) {
			vmInfo = (VsVmInfo) ResourceManager.getInfo(ResourceManager.INFO_VM_CONF);
		}

		// If no vending machine information in local storage -> create a new VsVmInfo object
		if (vmInfo == null) {
			vmInfo = new VsVmInfo();
		}

		return vmInfo;
	}

	
	public static void setPlayList(IdlePlayList playList) {
		LocalDataManager.playList = playList;
	}
	public static IdlePlayList getPlayList() {
		if (playList == null) {
			playList = (IdlePlayList) ResourceManager.getInfo(ResourceManager.INFO_PLAY_LIST);
		}

		if (playList == null) {
			playList = new IdlePlayList();
		}

		return playList;
	}


	

	public static void setCellInfo(VsCellInfo cellInfo) {
		LocalDataManager.cellInfo = cellInfo;
	}
	public static VsCellInfo getCellInfo() {
		if (cellInfo == null) {
			cellInfo = (VsCellInfo) ResourceManager.getInfo(ResourceManager.INFO_PRODUCTS);
		}

		if (cellInfo == null) {
			cellInfo = new VsCellInfo();
		}

		return cellInfo;
	}
	
	/**
	 * Get Cell Info by Product Id. There might be more than one cells.
	 * @param productId
	 * @return
	 */
	public static List<CellInfo> getCellInfosByProductId(int productId) {
		List<CellInfo> infos = new ArrayList<CellInfo>();
		for (int i = 0; i < getCellInfo().getCellInfo().size(); i++) {
			CellInfo info = cellInfo.getCellInfo().get(i);
			if (info.getProductInfo().getProductId() == productId) {
				infos.add(info);
			}
		}

		return infos;
	}
	/**
	 * Get Cell Info by Column No.
	 * @param itemNo
	 * @return
	 */
	public static CellInfo getCellInfoByItemNo(int itemNo) {
		for (int i = 0; i < getCellInfo().getCellInfo().size(); i++) {
			CellInfo info = cellInfo.getCellInfo().get(i);
			if (info.getItemNo() == itemNo) {
				return info;
			}
		}

		return null;
	}
	
	public static OctopusTranHistory getOctTranHistory() {
		if(octTranHistory == null) {
			octTranHistory = (OctopusTranHistory) ResourceManager.getInfo(ResourceManager.INFO_OCT_TRAN_HISTORY);
		}
		
		if(octTranHistory == null) {
			octTranHistory = new OctopusTranHistory();
		}
		
		return octTranHistory;
	}
	public static OctTranRecord getOctTranRecordByCardNo(String cardNo) {
		for(OctTranRecord record : getOctTranHistory().getRecords()) {
			if(record.getCardNo().equals(cardNo)) {
				return record;
			}
		}
		
		return null;
	}
	
	public static ReceiptNo getReceiptNo() {
		if (receiptNo == null) {
			receiptNo = (ReceiptNo) ResourceManager.getInfo(ResourceManager.INFO_RECEIPT_NO);

			if (receiptNo == null) {
				receiptNo = new ReceiptNo();
			}
		}

		return receiptNo;
	}
	public static int getOctReceiptNoCurrent() {
		return getOctReceiptNoCurrent(false);
	}
	public static int getOctReceiptNoCurrent(boolean increase) {
		int current = getReceiptNo().getOctReceiptNo();

		if (increase) {
			int next = current + 1;
			if (next > 9999) {
				next = 1;
			}
			receiptNo.setOctReceiptNo(next);
			ResourceManager.saveInfo(receiptNo, ResourceManager.INFO_RECEIPT_NO);
		}

		return current;
	}

	public static int getAlipayReceiptNoCurrent(boolean increase) {
		int current = getReceiptNo().getAlipayReceiptNo();

		if (increase) {
			int next = current + 1;
			if (next > 9999) {
				next = 1;
			}
			receiptNo.setAlipayReceiptNo(next);
			ResourceManager.saveInfo(receiptNo, ResourceManager.INFO_RECEIPT_NO);
		}

		return current;
	}

	public static int getWechatReceiptNoCurrent(boolean increase) {
		int current = getReceiptNo().getWechatReceiptNo();

		if (increase) {
			int next = current + 1;
			if (next > 9999) {
				next = 1;
			}
			receiptNo.setWechatReceiptNo(next);
			ResourceManager.saveInfo(receiptNo, ResourceManager.INFO_RECEIPT_NO);
		}

		return current;
	}



	public static String formatReceiptNo(int paymentCode, int seq) {
		return paymentCode + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).substring(3)
				+ String.format("%04d", LocalServer.getLocalServerConfig().getVmId()) + String.format("%04d", seq);
	}
	
	/**
	 * Check if the product period is valid
	 * @param period
	 * @return
	 */
//	public static boolean isProductPeriodValid(ProductPeriodInfo period) {
//		if (period.getExpDateMs() > 0) {
//			return (period.getEffDateMs() <= System.currentTimeMillis())
//					&& (System.currentTimeMillis() <= period.getExpDateMs());
//		} else {
//			return period.getEffDateMs() <= System.currentTimeMillis();
//		}
//	}
	


}
