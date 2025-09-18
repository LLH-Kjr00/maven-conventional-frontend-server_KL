package com.cmt.vending.server.model;

public class OctEnquiryHistory {

    private boolean sameDevice = false;
    private String tranDttm;
    private String amount;
    private String devId;

    public boolean isSameDevice() {
        return sameDevice;
    }

    public void setSameDevice(boolean sameDevice) {
        this.sameDevice = sameDevice;
    }

    public String getTranDttm() {
        return tranDttm;
    }

    public void setTranDttm(String tranDttm) {
        this.tranDttm = tranDttm;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }
}
