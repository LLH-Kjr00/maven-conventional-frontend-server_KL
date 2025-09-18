package com.cmt.vending.ui.response;

import com.cmt.vending.util.LangUtil;

import java.util.Locale;

public class VendWaitingWashMachineSuccessResp  extends Response {
    private String messageChi = null;
    private String message = null;

    public VendWaitingWashMachineSuccessResp (String msgCode) {
        this.message  = LangUtil.getI18nMsg(msgCode, Locale.ENGLISH);
        this.messageChi = LangUtil.getI18nMsg(msgCode, Locale.CHINESE);
    }
}
