package com.cmt.vending.ui.response;

import com.cmt.vending.util.LangUtil;

import java.util.Locale;

public class VendFailResp extends Response{
    private String messageChi = null;
    private String message = null;

    public VendFailResp(String msgCode, String string, String errorCode) {
        this.message  = String.format(LangUtil.getI18nMsg(msgCode, Locale.ENGLISH), string, errorCode);
        this.messageChi = String.format(LangUtil.getI18nMsg(msgCode, Locale.CHINESE), string, errorCode);
    }

}
