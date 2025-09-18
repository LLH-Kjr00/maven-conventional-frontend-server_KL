package com.cmt.vending.server.job;

import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmt.vending.util.ReflectionUtil;
import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.model.ProductCategoryInfo;
import com.cmt.vending.server.model.ProductInfo;
import com.cmt.vending.server.model.ProductPeriodInfo;
import com.cmt.vending.server.model.RFIDInfo;
import com.cmt.vending.server.model.RewardConfigInfo;
import com.cmt.vending.server.model.ScheInfo;
import com.cmt.vending.server.model.VmInfo;
import com.cmt.vending.server.model.VsCellInfo;
import com.cmt.vending.server.model.VsVmInfo;
import com.cmt.vending.server.operation.BackendServerComm;
import com.cmt.vending.server.operation.ResourceManager;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.ws.GetVmInfo;
import com.cmt.vending.ws.GetVmInfoResponse;
import com.cmt.vending.ws.VendingStub;
import com.cmt.vending.ws.obj.xsd.GetVmInfoReq;
import com.cmt.vending.ws.obj.xsd.GetVmInfoResp;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GetVmInfoJob implements Runnable, Job {
	
	private static final Logger logger = LogManager.getLogger(GetVmInfoJob.class);
	
	private static boolean isExecuted = false;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		BackendServerComm.startJob(this);
	}


	@Override
	public void run() {
		if (!isExecuted) {
			isExecuted = true;
			logger.info("[GetVmInfoJob-run]Start sync the latest data from server.");
			
			getData();
			isExecuted = false;
		} else {
			logger.info("[GetVmInfoJob-run]Syncing data. Ignore current job");
		}
	}
	
	private void getData() {
		
		try {
			VendingStub stub = BackendServerComm.getVendingStub();
			GetVmInfo req = new GetVmInfo();
			GetVmInfoReq reqObj = new GetVmInfoReq();
			req.setReq(reqObj);
			
			BackendServerComm.setGeneralInfo(reqObj);
			
			try {
				GetVmInfoResponse resp = stub.getVmInfo(req);
				GetVmInfoResp respObj = resp.get_return();
				
				HeartbeatJob.updateSucessTimeMsToServer(); 
				
				if (respObj.getResult()) {
					logger.info("[getData]Download vm data from server successfully. Start to analysis data.");
					
					logger.info("[getData]Setting VsVmInfo");
					VsVmInfo newVmSetting = new VsVmInfo();
					ReflectionUtil.copyProperties(newVmSetting, respObj);
					
					// Set RFID (Who has vip discount)
					if (respObj.getRfidList() != null) {
						logger.info("[getData]Total num of RFID List: " + respObj.getRfidList().length);
						for (int i = 0; i < respObj.getRfidList().length; i++) {
							RFIDInfo info = new RFIDInfo();
							ReflectionUtil.copyProperties(info, respObj.getRfidList()[i]);
							newVmSetting.getRfids().add(info);
						}
					}
					// Set Reward Config
					if (respObj.getRewardConfig() != null) {
						logger.info("[getData]Total num of Reward Config: " + respObj.getRewardConfig().length);
						for (int i = 0; i < respObj.getRewardConfig().length; i++) {
							if (respObj.getRewardConfig()[i] != null) {
								RewardConfigInfo rewardConfig = new RewardConfigInfo();
								ReflectionUtil.copyProperties(rewardConfig, respObj.getRewardConfig()[i]);
								newVmSetting.getRewardConfigs().add(rewardConfig);
							}
						}
					}
					
					// Set Schedule
					if (respObj.getSche() != null) {
						logger.info("[getData]Setting Schedule");
						ScheInfo sche = new ScheInfo();
						ReflectionUtil.copyProperties(sche, respObj.getSche());
						newVmSetting.setScheduler(sche);
					}
						
					
					// set product list
					logger.info("[getData]Setting VsCellInfo");
					VsCellInfo newCellInfos = new VsCellInfo();
					
					if (respObj.getVm() != null) {
						VmInfo info = new VmInfo();
						ReflectionUtil.copyProperties(info, respObj.getVm());
						newVmSetting.setInfo(info);
						
						if (respObj.getVm().getCells() != null) {
							for (int i = 0; i < respObj.getVm().getCells().length; i++) {
								if (respObj.getVm().getCells()[i] != null) {
									CellInfo cellInfo = new CellInfo();
									
									ReflectionUtil.copyProperties(cellInfo, respObj.getVm().getCells()[i]);
									cellInfo.setEnabled(respObj.getVm().getCells()[i].getEnabled());
									
									if (respObj.getVm().getCells()[i].getProduct() != null) {
										ProductInfo productInfo = new ProductInfo();
										ReflectionUtil.copyProperties(productInfo,
												respObj.getVm().getCells()[i].getProduct());
										productInfo.setEnable(respObj.getVm().getCells()[i].getProduct().getEnabled());
										
										if (respObj.getVm().getCells()[i].getProduct().getPeriods() != null) {
											for (int j = 0; j < respObj.getVm().getCells()[i].getProduct()
													.getPeriods().length; j++) {
												if (respObj.getVm().getCells()[i].getProduct().getPeriods()[j] != null) {
													ProductPeriodInfo periodInfo = new ProductPeriodInfo();
													ReflectionUtil.copyProperties(periodInfo,
															respObj.getVm().getCells()[i].getProduct().getPeriods()[j]);
													productInfo.getProductPeriodInfo().add(periodInfo);
												}
											}
											productInfo.getProductPeriodInfo().sort((ProductPeriodInfo o1,
													ProductPeriodInfo o2) -> (int) (o1.getEffDateMs() - o2.getEffDateMs()));
										}
										
										if (respObj.getVm().getCells()[i].getProduct().getCategory() != null) {
											ProductCategoryInfo catInfo = new ProductCategoryInfo();
											ReflectionUtil.copyProperties(catInfo,
													respObj.getVm().getCells()[i].getProduct().getCategory());
											productInfo.setProductCategoryInfo(catInfo);
										}

										cellInfo.setProductInfo(productInfo);
									}
									
									newCellInfos.getCellInfo().add(cellInfo);
							
								}
							}
							
							// Sort the cell based on display sequence setting
							newCellInfos.getCellInfo().sort(new Comparator<CellInfo>() {
								@Override
								public int compare(CellInfo o1, CellInfo o2) {
									int diff = o1.getDisplaySeq() - o2.getDisplaySeq();
									return diff == 0 ? o1.getItemNo() - o2.getItemNo() : diff;
								}
							});
							
							for (int i = 0; i < newCellInfos.getCellInfo().size(); i++) {
								CellInfo cellInfo = newCellInfos.getCellInfo().get(i);
								logger.info("Item No: " + cellInfo.getItemNo()
										+ ", Max Qty: " + cellInfo.getMaxQty() + ", Stock Qty: " + cellInfo.getQty());
							}

						}
					}
					
					// Save the latest vending machine information
					ResourceManager.saveInfo(newVmSetting, ResourceManager.INFO_VM_CONF);
					LocalDataManager.setVmInfo(newVmSetting);
					
					ResourceManager.saveInfo(newCellInfos, ResourceManager.INFO_PRODUCTS);
					LocalDataManager.setCellInfo(newCellInfos);
					
					
					// Set Video playlist
					logger.info("[getData]Setting playList");
					LocalDataManager.getPlayList().getPlayList().clear();
					if (respObj.getVideoList() != null) {
						logger.info("[getData] Total num of Idle Play List: " + respObj.getVideoList().length);
						for (int i = 0; i < respObj.getVideoList().length; i++) {
							logger.info("[getData] Add Play List: " + respObj.getVideoList()[i]);
							LocalDataManager.getPlayList().getPlayList().add(respObj.getVideoList()[i]);
						}

						ResourceManager.saveInfo(LocalDataManager.getPlayList(), ResourceManager.INFO_PLAY_LIST);
					}
					
					// Refresh UI and download media
					BackendServerComm.startJob(new RefreshVMCDataJob());
					BackendServerComm.startJob(new GetOtherMediaJob());
					
					return;
					
				} else {
					logger.error("[getData]Failed to get vm info from server: [" + respObj.getErrorCode() + "] "+ respObj.getErrorMsg());
				}
				
			}catch(Exception e) {
				logger.error("[getData]Failed to get latest vm data from the server: ", e);
			}
			
		} catch(Exception e) {
			logger.error("[getData]Failed to init comm with server: " , e);
		}
		
		return ;
	}

}
