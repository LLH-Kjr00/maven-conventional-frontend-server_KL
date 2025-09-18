package com.cmt.vending.ui.response;

import com.cmt.vending.util.LangUtil;

import java.util.Locale;

public class VendWaitingWashMachineFailResp extends Response {

    private String messageChi = null;
    private String message = null;

    public VendWaitingWashMachineFailResp(String msgCode, String receiptNo, String errorCode) {
        this.message  = String.format(LangUtil.getI18nMsg(msgCode, Locale.ENGLISH), receiptNo, errorCode);
        this.messageChi = String.format(LangUtil.getI18nMsg(msgCode, Locale.CHINESE), receiptNo, errorCode);
    }

}

