package com.cmt.vending.ui.response;

import com.cmt.vending.util.LangUtil;

import java.util.Locale;

public class QRCodeResp extends Response{
    private String qrCode;
    private int timeout;
    private String messageChi = null;
    private String message = null;

    public QRCodeResp(String qrCode, int timeout) {
        this.qrCode = qrCode;
        this.timeout = timeout;
    }

    public QRCodeResp(String msgCode, String errorCode) {
        this.message = String.format(LangUtil.getI18nMsg(msgCode, Locale.ENGLISH), errorCode);
        this.messageChi = String.format(LangUtil.getI18nMsg(msgCode, Locale.CHINESE), errorCode);
    }
}
