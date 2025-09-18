package com.cmt.vending.server.vmc.mq;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Observable;

public class ColumnObservable extends Observable {

    protected Logger logger = LogManager.getLogger(getClass());
    @Getter
    private int colNo;
    @Getter
    private boolean available;

    public void setData(int colNo, boolean available) {
        this.colNo = colNo;
        this.available = available;
        this.setChanged();
        this.notifyObservers();
    }
}
