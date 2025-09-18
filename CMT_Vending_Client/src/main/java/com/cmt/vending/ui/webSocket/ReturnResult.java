package com.cmt.vending.ui.webSocket;

import com.cmt.vending.util.GsonUtil;
import com.cmt.vending.util.LangUtil;
import com.cmt.vending.util.StringUtil;

import java.util.Locale;

import jakarta.servlet.http.HttpServletRequest;

public class ReturnResult {
	private boolean success;
	private String msgCode;
	private String msg;
	private String[] msgParams;
	
	/**
	 * Result object which will not be converted to json
	 */
	private transient Object resultObj;
	
	/**
	 * Data object which will be converted to json
	 */
	private Object dataObj;

	private ReturnResult(boolean success, String msgCode, Object resultObj) {
		super();
		this.success = success;
		this.msgCode = msgCode;
		this.resultObj = resultObj;
		
		if(resultObj instanceof String) {
			msgParams = new String[]{resultObj.toString()};
		}
	}
	
	public static ReturnResult newSuccessInstance() {
		return newSuccessInstance(null, null);
	}
	
	public static ReturnResult newSuccessInstance(String msgCode) {
		return newSuccessInstance(msgCode, null);
	}
	
	
	public static ReturnResult newSuccessInstance(String msgCode, Object resultObj) {
		return new ReturnResult(true, msgCode, resultObj);
	}
	
	public static ReturnResult newFailInstance() {
		return newFailInstance(null, null);
	}
	
	public static ReturnResult newFailInstance(String msgCode) {
		return newFailInstance(msgCode, null);
	}
	
	public static ReturnResult newFailInstance(String msgCode, Object resultObj) {
		return new ReturnResult(false, msgCode, resultObj);
	}

	public boolean isSuccess() {
		return success;
	}
	
	public boolean isFailed() {
		return !isSuccess();
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrCode() {
		return msgCode;
	}

	public void setErrCode(String errCode) {
		this.msgCode = errCode;
	}
	
	public void setErrDetail(String errInfo) {
		this.setErrDetail(errInfo, null);
	}
	
	public void setErrDetail(String errInfo, Exception e) {
		if(e != null) {
			this.msg = e.getMessage();
		}
		
		if(StringUtil.isEmpty(errInfo)) {			
			return;
		}
		
		
		int idx = errInfo.indexOf('-');
		if(idx == -1) {
			this.msgCode = errInfo;
		}
		else {
			this.msgCode = errInfo.substring(0, idx);
			this.msg = errInfo.substring(idx + 1);
			
			if(e != null) {
				this.msg += ", " + e.getMessage() + "!";
			}
		}
	}

	public Object getResultObj() {
		return resultObj;
	}

	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}
	
	public String getI18nMsg(HttpServletRequest request) {
		if(StringUtil.isEmpty(this.msg)) {
			this.msg = StringUtil.format(LangUtil.getI18nMsg(this.msgCode, request), msgParams);
		}
		return this.msg;
	}
	
	public String getI18nMsg(Locale locale) {
		if(StringUtil.isEmpty(this.msg)) {
			this.msg = StringUtil.format(LangUtil.getI18nMsg(this.msgCode, locale), msgParams);
		}
		return this.msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "{res:" + success + ", msgCode:'" + msgCode + "'}";
	}
	
	public String toJsonString() {
		return toJsonString(false, true);
	}
	
	public String toJsonString(boolean withSecondDateFormat) {
		return toJsonString(false, withSecondDateFormat);
	}

	public String toJsonString(boolean dateOnly, boolean withSecondDateFormat) {
		return GsonUtil.toJson(this, dateOnly, withSecondDateFormat);
	}
	
	public String toJsonString(HttpServletRequest request) {
		return toJsonString(request, false, true);
	}
	
	public String toJsonString(HttpServletRequest request, boolean dateOnly, boolean withSecondDateFormat) {
		if(!StringUtil.isEmpty(this.msgCode)) {
			getI18nMsg(request);
		}
		
		return toJsonString(dateOnly, withSecondDateFormat);
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public Object getDataObj() {
		return dataObj;
	}

	public ReturnResult setDataObj(Object dataObj) {
		this.dataObj = dataObj;
		return this;
	}

	public String[] getMsgParams() {
		return msgParams;
	}

	public void setMsgParams(String[] msgParams) {
		this.msgParams = msgParams;
	}
	
	public void setMsgParam(String msgParam) {
		setMsgParams(new String[] {msgParam});
	}
}
