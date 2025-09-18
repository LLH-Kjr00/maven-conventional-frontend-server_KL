package com.cmt.vending.ui.response;

import lombok.Setter;

public class OctDiscountSchemeResp extends Response{

    @Setter
    String[][] result;

    public OctDiscountSchemeResp(){

    }

    public OctDiscountSchemeResp(String errorMsg, String errorMsgChi){
        this.result = new String[][] {{errorMsg, errorMsgChi}};
    }

    public OctDiscountSchemeResp(String[][] result){
        this.result = result;
    }
}
