package com.cmt.vending.server.vmc.mq;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Observable;

public class AliveObservable extends Observable {
    protected Logger logger = LogManager.getLogger(getClass());

    @Getter @Setter
    private boolean alive = true;

    public void setData(boolean data){
        if(data != this.alive) {
            this.alive = data;
            this.setChanged();
            this.notifyObservers();
        }
    }
}
