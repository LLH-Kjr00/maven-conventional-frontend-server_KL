package com.cmt.vending.ui.response;

import com.cmt.vending.util.LangUtil;

import java.util.Locale;

public class VendWaitingWashMachineResp extends Response {
    private String messageChi = null;
    private String message = null;
    private int count = 0;

    public VendWaitingWashMachineResp() {
    }

    public VendWaitingWashMachineResp(String msgCode, int c) {
        this.message  = LangUtil.getI18nMsg(msgCode, Locale.ENGLISH);
        this.messageChi = LangUtil.getI18nMsg(msgCode, Locale.CHINESE);
        this.count =c;
    }
}
