package com.cmt.vending.ui.response;

import com.cmt.vending.util.LangUtil;
import lombok.Setter;

import java.util.Locale;

public class OctEnquiryMsgResp  extends Response {


    @Setter
    private String messageChi = null;
    @Setter
    private String message = null;
    @Setter
    private boolean retry = false;
    @Setter
    private boolean lockDialog = false;

    public OctEnquiryMsgResp () {
    }
    public OctEnquiryMsgResp (String msgCode) {
        this.message  = LangUtil.getI18nMsg(msgCode, Locale.ENGLISH);
        this.messageChi = LangUtil.getI18nMsg(msgCode, Locale.CHINESE);
    }

    public OctEnquiryMsgResp ( String errorMessage, String errorMessageChi) {
        this.message  = errorMessage;
        this.messageChi = errorMessageChi ;
    }

    public OctEnquiryMsgResp(int errorCode) {
        this.message = OctMsgResp.getOctopusErrorMessage(errorCode, null,  Locale.ENGLISH);
        this.messageChi = OctMsgResp.getOctopusErrorMessage(errorCode, null,  Locale.CHINESE);
    }


    public static OctEnquiryMsgResp retry3( String errorMsg) {
        OctEnquiryMsgResp resp = new OctEnquiryMsgResp();
        resp.setMessage(errorMsg+"\n" +String.format(LangUtil.getI18nMsg("Octopus3.Retry", Locale.ENGLISH)));
        resp.setMessageChi(errorMsg+"\n" +String.format(LangUtil.getI18nMsg("Octopus3.Retry", Locale.CHINESE)));
        resp.setRetry(true);

        return resp;
    }
}
