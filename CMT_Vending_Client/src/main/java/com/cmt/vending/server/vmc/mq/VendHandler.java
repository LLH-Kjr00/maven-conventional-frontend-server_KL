package com.cmt.vending.server.vmc.mq;

import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VendHandler implements Runnable {

    protected Logger logger = LogManager.getLogger(getClass());

    private MiQuanOne vmc;
    private VendObservable observable;
    @Setter
    private boolean vending = true;
    private boolean terminate = false;
    private int eventCode = 0;
    @Setter
    private int errorCode = 0;

    public VendHandler(MiQuanOne vmc, VendObservable observable) {
        this.vmc = vmc;
        this.observable = observable;
    }
    public void run() {
        long timeout = System.currentTimeMillis() + 30000;                        // 30s
        do {
            try {
                this.vmc.getVendStatus();
                Thread.sleep(1000);
            } catch (Throwable t) {

            }
        } while (vending && timeout > System.currentTimeMillis() && !terminate);    // 出貨中，非超時，非強制中止

        this.observable.setData(errorCode == 0, this.errorCode);

    }
}
