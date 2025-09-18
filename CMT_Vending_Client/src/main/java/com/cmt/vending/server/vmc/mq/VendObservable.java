package com.cmt.vending.server.vmc.mq;

import lombok.Getter;

import java.util.Observable;

public class VendObservable extends Observable {

    @Getter
    private boolean success = false;
    @Getter
    private Integer errorCode = -1;

    public void setData(boolean success, Integer errorCode) {
        this.success = success;
        this.errorCode = errorCode;
        this.setChanged();
        this.notifyObservers();
    }

}
