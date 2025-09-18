package com.cmt.vending.ui.webSocket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.cmt.vending.server.payment.AlipayPayment;
import com.cmt.vending.server.payment.WechatPayment;
import com.cmt.vending.ui.response.*;
import com.cmt.vending.util.StringUtil;
import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.model.ProductCategoryInfo;
import com.cmt.vending.server.model.ProductPeriodInfo;
import com.cmt.vending.server.model.TabInfo;
import com.cmt.vending.server.model.UICellInfo;
import com.cmt.vending.server.model.UIRowInfo;
import com.cmt.vending.server.payment.OctopusPayment;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.ui.request.Request;
import com.cmt.vending.ui.request.SelectProductPaymentReq;
import com.cmt.vending.ui.request.SelectProductReq;
import com.cmt.vending.ui.request.VmInfoReq;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * For generating responses from UI request or sending different messages
 */
public class UIWebSocketHandler {
	private static final Logger logger = LogManager.getLogger(UIWebSocketHandler.class);
	private static int seq = 0;
	
	private static boolean groupByProduct = true;
	
	/**
	 * Handle GET_VM_INFO Request
	 * @param request
	 * @return
	 */
	public static ReturnResult getVmInfoResult(VmInfoReq request) {
		if(request != null) {
			groupByProduct = request.isGroupByProduct();
		}
		
		VmInfoResp resp = new VmInfoResp(++seq);
		
		// Set AllTab
		resp.setAllTab(new TabInfo());
		resp.getAllTab().setLabel("All");
		resp.getAllTab().setLabelChi("所有產品");
		
		// Set playlist
		resp.setGlobalVideo(LocalDataManager.getPlayList().getPlayList());
		
		// Set Tab and Cell(product column) Information
		Map<Integer, TabInfo> temp = new LinkedHashMap<Integer, TabInfo>();
		List<Integer> record = new ArrayList<Integer>();					// To store the product ID
		List<CellInfo> cellInfos = LocalDataManager.getCellInfo().getCellInfo();		// A list of cell(product column) information

		if (cellInfos != null) {
			// Iterate the cells (product columns)
			for (int i = 0; i< cellInfos.size(); i++) {
				CellInfo cellInfo = cellInfos.get(i);
				if (!cellInfo.isEnabled()) continue;
				
				// If the same product is shown by the same UI cell
				if (groupByProduct) {
					// Get the category of this product column
					ProductCategoryInfo category = cellInfo.getProductInfo().getProductCategoryInfo();
					
					TabInfo tab = null;
					if (category != null) {
						// Check if the temp contains this category already
						// If not , add it to temp
						if(!temp.containsKey(category.getCatId())) {
							tab = new TabInfo();
							tab.setLabel(category.getName());
							tab.setLabelChi(category.getNameChi());
							tab.setIcon(category.getIcon() < 0 ? null : category.getIcon());
							temp.put(category.getCatId(), tab);
						}
						else {
							tab = temp.get(category.getCatId());
						}
					}
					
					if (tab != null && !record.contains(cellInfo.getProductInfo().getProductId())&& cellInfo.getCurrentPeriodInfo() != null) {
	
						ProductPeriodInfo periodInfo = cellInfo.getCurrentPeriodInfo();
						UICellInfo uiCell = toUICellInfo(cellInfo.getItemNo(), cellInfo.getProductInfo().getProductId(), periodInfo);
						
						// Add this UI Cell to this tab
						if (tab.getLastRow() != null) {
							if (tab.getLastRow().getCells().size() == tab.getCellPerRow()) {
								tab.getRows().add(new UIRowInfo());
							}
						} else {
							tab.getRows().add(new UIRowInfo());
						}
						tab.getLastRow().getCells().add(uiCell);
						
						// Add this UI Cell to all tab page
						if (resp.getAllTab().getLastRow() != null) {
							if (resp.getAllTab().getLastRow().getCells().size() == resp.getAllTab().getCellPerRow()) {
								resp.getAllTab().getRows().add(new UIRowInfo());
							}
						} else {
							resp.getAllTab().getRows().add(new UIRowInfo());
						}
						resp.getAllTab().getLastRow().getCells().add(uiCell);
						
						// Put this product ID into record
						record.add(uiCell.getProductId());
					}
				
				// If the same products are not grouped into one UI cell
				} else {
					ProductPeriodInfo periodInfo = cellInfo.getCurrentPeriodInfo();
					if (periodInfo != null) {
						UICellInfo uiCell = toUICellInfo(cellInfo.getItemNo(), cellInfo.getProductInfo().getProductId(), periodInfo);
						
						// Add this UI Cell to all tab page
						if (resp.getAllTab().getLastRow() != null) {
							if (resp.getAllTab().getLastRow().getCells().size() == resp.getAllTab().getCellPerRow()) {
								resp.getAllTab().getRows().add(new UIRowInfo());
							}
						} else {
							resp.getAllTab().getRows().add(new UIRowInfo());
						}
						resp.getAllTab().getLastRow().getCells().add(uiCell);
					}
				}
			}
			
			resp.setTabs(new ArrayList<TabInfo>());	
			for (Iterator<Integer> it =  temp.keySet().iterator();it.hasNext();){
				Object key = it.next();
				resp.getTabs().add(temp.get(key));
			}
		}
		
		// The result for this request must be successful
		ReturnResult result = ReturnResult.newSuccessInstance("GET_VM_INFO");
		result.setDataObj(resp);
		return result;
		
	}

	/**
	 * Transform Product Column Information to UI Cell
	 * @param itemNo
	 * @param productId
	 * @param periodInfo
	 * @return
	 */
	private static UICellInfo toUICellInfo(int itemNo, int productId, ProductPeriodInfo periodInfo) {
		UICellInfo uiCell = new UICellInfo();
		 
		// If groupByProduct: product id = productIf; else : product id = item no (column no)
		uiCell.setProductId(groupByProduct ? productId : itemNo);
		uiCell.setIcon(periodInfo.getImageSmallId() < 0 ? null : periodInfo.getImageSmallId());
		uiCell.setImage(periodInfo.getImageId() < 0 ? null : periodInfo.getImageId());
		uiCell.setVideo(periodInfo.getVideoId()< 0 ? null : periodInfo.getVideoId());
		uiCell.setPrice(periodInfo.getPrice());
		
		// Calculate VIP Price
		BigDecimal vipPrice = periodInfo.getPrice();
		if(LocalDataManager.getVmInfo().getInfo().isVip()) {
			try {
				if(LocalDataManager.getVmInfo().getInfo().getVipDiscountType() == 1) {
					vipPrice = periodInfo.getPrice().subtract(LocalDataManager.getVmInfo().getInfo().getVipDiscountAmount());
				}
				else {
					vipPrice = periodInfo.getPrice().multiply(LocalDataManager.getVmInfo().getInfo().getVipDiscountPercentage().divide(new BigDecimal(100))).setScale(1, RoundingMode.DOWN);
				}
				logger.info("[toUICellInfo]Set VIP Price "+ vipPrice + " to product of item " + itemNo);
				uiCell.setVipPrice(vipPrice.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : vipPrice);
			} catch(Exception e) {
				logger.error("[toUICellInfo]Failed to get Vip Price. Set it to 0: ", e);
				uiCell.setVipPrice(BigDecimal.ZERO);
			}	
		}
		
		uiCell.setName(periodInfo.getName());
		uiCell.setNameChi(periodInfo.getNameChi());
		 
		// If the product has nutrition information, the ui should show nutrition instead of description
		if(StringUtil.isEmpty(periodInfo.getNutrition()) && StringUtil.isEmpty(periodInfo.getNutritionChi())){
			uiCell.setDescription(periodInfo.getDescription());
			uiCell.setDescriptionChi(periodInfo.getDescriptionChi());
		}
		else {
			uiCell.setNutrition(periodInfo.getNutrition());
			uiCell.setNutritionChi(periodInfo.getNutritionChi());
		}
		
		uiCell.setEnabled(false);
		
		// If the vending machine is enabled
		if (LocalDataManager.getVmInfo().getInfo().isEnabled()) {
			if (groupByProduct) {
				List<CellInfo> cells = LocalDataManager.getCellInfosByProductId(productId);
				for(CellInfo info : cells) {
					// For any one cell(column) sharing the same product, if it's column is normal, and it's enabled and it has quantity -> set it as enabled
					if ((info.isColumnNormal()  || LocalServer.getLocalServerConfig().getEnv().equals("DEV")) && info.isEnabled() && info.getQty() > 0) {
						uiCell.setEnabled(true);
						break;
					}
				}
			} else {
				CellInfo cell = LocalDataManager.getCellInfoByItemNo(itemNo);
				if ((cell != null && (cell.isColumnNormal() || LocalServer.getLocalServerConfig().getEnv().equals("DEV")) && cell.isEnabled() && cell.getQty() > 0) ) {
					uiCell.setEnabled(true);
				}
			}
		}
		
		logger.info("[toUICellInfo]Cell Item:  " + itemNo + ", UI Cell : " +uiCell.toString());
		return uiCell;
	}

	public static ReturnResult getSelectProductResult (SelectProductReq request) {
		List<CellInfo> cellInfos = groupByProduct ? LocalDataManager.getCellInfosByProductId(request.getProductId()) : new ArrayList<CellInfo>();
		ReturnResult result = null;

		// If the ui not grouping product by product id: add the item with that productId (actually it is item no) the cell info
		if(!groupByProduct) {
			cellInfos.add(LocalDataManager.getCellInfoByItemNo(request.getProductId()));
		}
		
		if (cellInfos != null && !cellInfos.isEmpty()) {
			for(int i = 0 ; i < cellInfos.size(); i++) {
				CellInfo info = cellInfos.get(i);
				
				if (info.isEnabled() && info.getProductInfo().isEnable() && info.getCurrentPeriodInfo() != null) {
					info.setColumnNormal(false);
					LocalServer.getVmc().checkColumn(info.getItemNo());
					
					if (info.isColumnNormal() || (LocalServer.getLocalServerConfig().getEnv().equals("DEV"))) {
						result = ReturnResult.newSuccessInstance(request.getAction());
						SelectProductResp resp = new SelectProductResp(++seq);
						result.setDataObj(resp);
						
						// If the price is not equal to zero
						if(request.getPrice().compareTo(BigDecimal.ZERO) == 1) {
							TransactionManager.IS_TRAN_PROCESS = true;
							TransactionManager.IS_TRAN_SUCCESS = false;
							TransactionManager.CURRENT_PAYMENT_METHOD = null;
							
							// Create transaction. Set the price  shown in UI
							TransactionManager.CURRENT_TX = TransactionManager.createSaleTran(info, 1);
							TransactionManager.CURRENT_TX.setPrice(request.getPrice());
							TransactionManager.CURRENT_TX.setAmount(request.getPrice());
							TransactionManager.CURRENT_TX.setVipPrice(request.getVipPrice());
							
							logger.info("[getSelectProductResult]New transaction: [ uuid: " + TransactionManager.CURRENT_TX .getTranUuid() +
									", cellId: " + TransactionManager.CURRENT_TX .getCellId() +
									", itemNo: " + TransactionManager.CURRENT_TX .getItemNo() +
									", productId: " + TransactionManager.CURRENT_TX .getProductId() +
									", qty: " + TransactionManager.CURRENT_TX.getQty() +
									", price: " + TransactionManager.CURRENT_TX .getPrice() +
									", vipPrice: " + TransactionManager.CURRENT_TX.getVipPrice() +
									", amount: " + TransactionManager.CURRENT_TX .getAmount());
							return result;
							
						//  Free vending
						} else {
							TransactionManager.IS_TRAN_SUCCESS = true;
							TransactionManager.CURRENT_TX = TransactionManager.createFreeTran(info, 1);
							TransactionManager.addTran(TransactionManager.CURRENT_TX);
							
							// TODO : Free Vending Send Message to UI
							LocalServer.getVmc().vendProduct();
							// TODO : Send Transaction to server
						}
						
						
					}
				} 
			}
			// After iterate all column about this product, none of columns is normal -> return motor not working error
			result = ReturnResult.newFailInstance(request.getAction());
			result.setDataObj(new ErrorResp("ERR20002"));
			
		} else {
			// If no relate cell -> return no product exist error
			result = ReturnResult.newFailInstance(request.getAction());
			result.setDataObj(new ErrorResp("ERR20001"));
		}
		
		return result;
	}
	
	public static ReturnResult getUnselectProductResult(Request request) {
		TransactionManager.IS_TRAN_PROCESS = false;
		
		ReturnResult result = ReturnResult.newSuccessInstance(request.getAction());
		result.setDataObj(new Response(++seq));
		
		return result;
	}

	public static ReturnResult getSelectProductPaymentResult(SelectProductPaymentReq request) {
		
		switch(request.getPaymentCode()) {
			case "octopus":
				LocalServer.getVmc().getPayment(OctopusPayment.CODE).handle();
				break;
			case "wechat":
				LocalServer.getVmc().getPayment(WechatPayment.CODE).handle();
				break;
			case "alipay":
				LocalServer.getVmc().getPayment(AlipayPayment.CODE).handle();
				break;
			default:
				ReturnResult result = ReturnResult.newFailInstance("ERR30001");
				result.setDataObj(new ErrorResp("ERR30001")); 
				return result;
		}

		ReturnResult result = ReturnResult.newSuccessInstance(request.getAction());
		result.setDataObj(new Response(++seq));
		return result;
	}

	public static ReturnResult getUnselectProductPaymentResult () {
		ReturnResult result = ReturnResult.newSuccessInstance("UNSELECT_PRODUCT_PAYMENT");
		result.setDataObj(new Response(++seq));
		return result;
	}


	public static ReturnResult getOctEnquiryResult (Request req){
		OctopusPayment octopusPaymentObject = (OctopusPayment)LocalServer.getVmc().getPayment(OctopusPayment.CODE);
		if (octopusPaymentObject != null){
			octopusPaymentObject.enquiry();
			return null;
		} else {
			ReturnResult result = ReturnResult.newFailInstance("ERR40001");
			result.setDataObj(new ErrorResp("ERR40001"));
			return result;
		}
	}

	public static ReturnResult getOctCancelEnquiryResult(){
		ReturnResult result = ReturnResult.newSuccessInstance("OCT_ENQUIRY_CANCEL");
		result.setDataObj(new Response(++seq));
		return result;
	}
	public static ReturnResult getOctMessage(OctMsgResp resp) {
		ReturnResult result = ReturnResult.newSuccessInstance("OCT_TRAN_STATUS");
		result.setDataObj(resp);
		return result;
	}

	public static ReturnResult getOctEnquiryMessage(OctEnquiryMsgResp resp){
		ReturnResult result = ReturnResult.newSuccessInstance("OCT_ENQUIRY_STATUS");
		result.setDataObj(resp);
		return result;
	}

	public static  ReturnResult getOctSchemeEnquiryMessage(OctDiscountSchemeResp resp){
		ReturnResult result = ReturnResult.newSuccessInstance("OCT_3_SCHEME_ENQUIRY");
		result.setDataObj(resp);
		return result;
	}
	public static ReturnResult getAlipayQrCodeResult(QRCodeResp resp) {
		ReturnResult result = ReturnResult.newSuccessInstance("ALIPAY_QR_CODE");
		result.setDataObj(resp);
		return result;
	}

	public static ReturnResult getWechatQrCodeResult(QRCodeResp resp) {
		ReturnResult result = ReturnResult.newSuccessInstance("WECHAT_QR_CODE");
		result.setDataObj(resp);
		return result;
	}

	public static ReturnResult getTranCompleteResult(TranCompleteResp resp) {
		ReturnResult result = ReturnResult.newSuccessInstance("TRAN_COMPLETE");
		result.setDataObj(resp);
		return result;
	}

	public static ReturnResult getVendWaitingResult(VendWaitingResp resp) {
		ReturnResult result = ReturnResult.newSuccessInstance("VEND_WAITING");
		result.setDataObj(resp);
		return result;
	}
	public static ReturnResult getVendWaitingResult (VendWaitingWashMachineResp resp) {
		ReturnResult result = ReturnResult.newSuccessInstance("VEND_WAITING_WASHING_MACHINE");
		result.setDataObj(resp);
		return result;
	}

	public static ReturnResult getVendWaitingResult (VendWaitingWashMachineFailResp resp) {
		ReturnResult result = ReturnResult.newSuccessInstance("VEND_WASHING_MACHINE_FAIL");
		result.setDataObj(resp);
		return result;
	}

	public static ReturnResult getVendWaitingResult (VendWaitingWashMachineSuccessResp resp) {
		ReturnResult result = ReturnResult.newSuccessInstance("VEND_WASHING_MACHINE_SUCCESS");
		result.setDataObj(resp);
		return result;
	}
	public static ReturnResult getVendFailResult(VendFailResp resp) {
		ReturnResult result = ReturnResult.newSuccessInstance("VEND_FAIL");
		result.setDataObj(resp);
		return result;
	}
	
}
