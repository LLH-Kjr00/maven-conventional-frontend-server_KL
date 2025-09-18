package com.cmt.vending.server.vmc.mq;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

public class ColumnObserver implements Observer {
    protected Logger logger = LogManager.getLogger(getClass());

    @Override
    public void update(Observable o, Object arg) {
        final ColumnObservable observer= (ColumnObservable) o;
        this.handle(observer.getColNo(), observer.isAvailable());

    }

    protected void handle(int colNo, boolean available) {
        this.refreshCell(colNo, available);

        // Update the UI
        UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVmInfoResult(null));

        // If the column is not available
        if (!available) {
            new Thread(() -> {
                try {
                    // Check this column later
                    Thread.sleep(600000);
                    LocalServer.getVmc().checkColumn(colNo);

                } catch (Throwable t) {

                }
            }).start();
        }

    }

    private void refreshCell(int itemNo, boolean enable) {
        CellInfo cellInfo = LocalDataManager.getCellInfoByItemNo(itemNo);

        if (cellInfo != null) {
            cellInfo.setColumnNormal(enable);
        }
    }
}
