package com.cmt.vending.ui.response;

import java.util.Locale;

import com.cmt.vending.util.LangUtil;

public class ErrorResp extends Response {
	private String errorCode;
	private String error;
	private String errorChi;
	
	public ErrorResp(String errorCode) {
		this.error = LangUtil.getI18nMsg(errorCode, Locale.ENGLISH);
		this.errorChi = LangUtil.getI18nMsg(errorCode, Locale.CHINESE);
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorChi() {
		return errorChi;
	}

	public void setErrorChi(String errorChi) {
		this.errorChi = errorChi;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}

