package com.cmt.vending.ui.response;

import java.util.Locale;

import com.cmt.vending.util.LangUtil;

public class OctMsgResp extends Response {
	private String messageChi = null;
	private String message = null;
	private boolean newDialog = false;
	private boolean resetCountdown = false;
	private boolean lockDialog = false;
	private boolean readerNormal = true;

	private boolean retry = false; // For octopus v3 only
	private int waitTime = 0; // For octopus v3 only

	public OctMsgResp() {
	}
	
	public OctMsgResp(String msgCode, boolean newDialog) {
		this.newDialog = newDialog;
		this.message  = LangUtil.getI18nMsg(msgCode, Locale.ENGLISH);
		this.messageChi = LangUtil.getI18nMsg(msgCode, Locale.CHINESE);
	}

	
	public OctMsgResp(int errorCode, String cardNo, boolean newDialog) {
		this.newDialog = newDialog;
		this.message = getOctopusErrorMessage(errorCode, cardNo,  Locale.ENGLISH);
		this.messageChi = getOctopusErrorMessage(errorCode, cardNo,  Locale.CHINESE);
	}
	public OctMsgResp(int errorCode, String cardNo, boolean newDialog, boolean readerNormal) {
		this.newDialog = newDialog;
		this.readerNormal = readerNormal;
		this.message = getOctopusErrorMessage(errorCode, cardNo,  Locale.ENGLISH);
		this.messageChi = getOctopusErrorMessage(errorCode, cardNo,  Locale.CHINESE);
	}
	
	public static OctMsgResp retry(String cardNo, boolean newDialog) {
		OctMsgResp resp = new OctMsgResp();
		resp.setNewDialog(newDialog);
		resp.setMessage((cardNo != null ? "\n" + String.format(LangUtil.getI18nMsg("Octopus.Retry", Locale.ENGLISH), cardNo) : ""));
		resp.setMessageChi((cardNo != null ? "\n" + String.format(LangUtil.getI18nMsg("Octopus.Retry", Locale.CHINESE), cardNo) : ""));
		
		return resp;
	}

	/**
	 * For Octopus 3
	 * @param errorMsg
	 * @param errorMsgChi
	 * @return
	 */
	public static OctMsgResp retry3( String errorMsg, String errorMsgChi) {
		OctMsgResp resp = new OctMsgResp();
		resp.setNewDialog(true);
		if (errorMsg != null){
			resp.setMessage(errorMsg+"<br>" +String.format(LangUtil.getI18nMsg("Octopus3.Retry", Locale.ENGLISH)));
			resp.setMessageChi(errorMsgChi+"<br>" +String.format(LangUtil.getI18nMsg("Octopus3.Retry", Locale.CHINESE)));
		} else {
			resp.setMessage(String.format(LangUtil.getI18nMsg("Octopus3.Retry", Locale.ENGLISH)));
			resp.setMessageChi(String.format(LangUtil.getI18nMsg("Octopus3.Retry", Locale.CHINESE)));
		}

		resp.setRetry(true);

		return resp;
	}

	/**
	 * For Octopus 3
	 * @param errorMsg
	 * @param errorMsgChi
	 * @return
	 */
	public static OctMsgResp processingError(String errorMsg, String errorMsgChi ){
		OctMsgResp resp = new OctMsgResp();
		resp.setNewDialog(true);
		resp.setMessage(errorMsg);
		resp.setMessageChi(errorMsgChi);
		resp.setLockDialog(true);

		return resp;
	}

	/**
	 * For Octopus 3
	 * @param
	 * @param
	 * @return
	 */
	public static OctMsgResp otherError(String errorMsg, String errorMsgChi){
		OctMsgResp resp = new OctMsgResp();
		resp.setReaderNormal(false);
		resp.setMessage(errorMsg);
		resp.setMessageChi(errorMsgChi);

		return resp;
	}

	/**
	 * For Octopus 3
	 * @param
	 * @param
	 * @return
	 */
	public static OctMsgResp lostConnection() {
		OctMsgResp resp = new OctMsgResp();
		resp.setReaderNormal(false);
		resp.setMessage(String.format(LangUtil.getI18nMsg("Octopus3.lostConnection", Locale.ENGLISH)));
		resp.setMessageChi(String.format(LangUtil.getI18nMsg("Octopus3.lostConnection", Locale.CHINESE)));

		return resp;
	}

	/**
	 * For Octopus 3
	 * @param
	 * @param
	 * @return
	 */
	public static OctMsgResp lostConnectionButRetry(){
		OctMsgResp resp = new OctMsgResp();
		resp.setNewDialog(true);
		resp.setMessage(String.format(LangUtil.getI18nMsg("Octopus3.lostConnection", Locale.ENGLISH)) + ", "+String.format(LangUtil.getI18nMsg("Octopus3.Retry", Locale.ENGLISH)));
		resp.setMessageChi(String.format(LangUtil.getI18nMsg("Octopus3.lostConnection", Locale.CHINESE)) + ", "+String.format(LangUtil.getI18nMsg("Octopus3.Retry", Locale.CHINESE)));

		resp.setRetry(true);
		return resp;
	}

	/**
	 * For Octopus 3
	 * @param
	 * @param
	 * @return
	 */
	public static OctMsgResp waitingTime(int time) {
		OctMsgResp resp = new OctMsgResp();
		resp.setWaitTime(time);
		return resp;
	}

	public String getMessageChi() {
		return messageChi;
	}

	public void setMessageChi(String messageChi) {
		this.messageChi = messageChi;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String messageEng) {
		this.message = messageEng;
	}

	public boolean isResetCountdown() {
		return resetCountdown;
	}

	public void setResetCountdown(boolean resetCountdown) {
		this.resetCountdown = resetCountdown;
	}
	
	public boolean isLockDialog() {
		return lockDialog;
	}

	public void setLockDialog(boolean lockDialog) {
		this.lockDialog = lockDialog;
	}

	public void setReaderNormal(boolean lockDialog) {
		this.lockDialog = lockDialog;
	}

	public static String getOctopusErrorMessage(int errorCode, String cardNo, Locale locale) {
		switch(errorCode) {
			case 100016:
			case 100017:
			case 100020:
			case 100032:
				return LangUtil.getI18nMsg("Octopus.TapAgain", locale) + (cardNo != null ? "\n" + String.format(LangUtil.getI18nMsg("Octopus.Retry", locale), cardNo) : "");
			case 100034:
				return LangUtil.getI18nMsg("Octopus.TapAgain", locale) + (cardNo != null ? "\n" + String.format(LangUtil.getI18nMsg("Octopus.Retry", locale), cardNo) : "");
				//return LayoutUtil.label.getString("Octopus.TapAgain") + (cardNo != null ? "\n" + String.format(LayoutUtil.label.getString("Octopus.Retry"), cardNo) : "");
			case 100019:
			case 100021:
			case 100024:
			case 100035:
				return LangUtil.getI18nMsg("Octopus.InvalidOctopus", locale) + (cardNo != null ? "\n" + String.format(LangUtil.getI18nMsg("Octopus.Retry", locale), cardNo) : "");
				// return LayoutUtil.label.getString("Octopus.InvalidOctopus") + (cardNo != null? "\n" + String.format(LayoutUtil.label.getString("Octopus.Retry"), cardNo) : "");
			case 100022:
			case 100025:
				return LangUtil.getI18nMsg("Octopus.IncompleteTx", locale) + (cardNo != null ? "\n" + String.format(LangUtil.getI18nMsg("Octopus.Retry", locale), cardNo) : "");
				//return LayoutUtil.label.getString("Octopus.IncompleteTx") + (cardNo != null ? "\n" + String.format(LayoutUtil.label.getString("Octopus.Retry"), cardNo) : "");
			case 100048:
				return LangUtil.getI18nMsg("Octopus.InsufficientValue", locale) + (cardNo != null ? "\n" + String.format(LangUtil.getI18nMsg("Octopus.Retry", locale), cardNo) : "");
				//return LayoutUtil.label.getString("Octopus.InsufficientValue") + (cardNo != null ? "\n" + String.format(LayoutUtil.label.getString("Octopus.Retry"), cardNo) : "");
			case 100049:
				return LangUtil.getI18nMsg("Octopus.ExceedLimit", locale) + (cardNo != null ? "\n" + String.format(LangUtil.getI18nMsg("Octopus.Retry", locale), cardNo) : "");
				//return LayoutUtil.label.getString("Octopus.ExceedLimit") + (cardNo != null ? "\n" + String.format(LayoutUtil.label.getString("Octopus.Retry"), cardNo) : "");
			default: 
				return String.format(LangUtil.getI18nMsg("Octopus.Error", locale), errorCode);
			   //return String.format(LayoutUtil.label.getString("Octopus.Error"), errorCode);
		}
	}

	public boolean isNewDialog() {
		return newDialog;
	}

	public void setNewDialog(boolean newDialog) {
		this.newDialog = newDialog;
	}


	public void setRetry(boolean retry) {this.retry = retry;}
	public void setWaitTime(int waitTime){this.waitTime = waitTime;}
}
