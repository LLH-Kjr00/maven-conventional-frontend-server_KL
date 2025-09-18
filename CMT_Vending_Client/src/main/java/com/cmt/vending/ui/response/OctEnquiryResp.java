package com.cmt.vending.ui.response;

import com.cmt.vending.server.model.OctEnquiryHistory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OctEnquiryResp extends Response{

    private String cardID;
    private String cardType;
    private BigDecimal remainingValue;
    private List<OctEnquiryHistory> historys = new ArrayList<OctEnquiryHistory>();

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public BigDecimal getRemainingValue() {
        return remainingValue;
    }

    public void setRemainingValue(BigDecimal remainingValue) {
        this.remainingValue = remainingValue;
    }

    public List<OctEnquiryHistory> getHistorys() {
        return historys;
    }

    public void setHistorys(List<OctEnquiryHistory> historys) {
        this.historys = historys;
    }
}
