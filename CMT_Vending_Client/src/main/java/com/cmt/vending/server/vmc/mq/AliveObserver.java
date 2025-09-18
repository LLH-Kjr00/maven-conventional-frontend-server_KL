package com.cmt.vending.server.vmc.mq;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.job.SendAlertJob;
import com.cmt.vending.server.model.CellInfo;
import com.cmt.vending.server.model.VsCellInfo;
import com.cmt.vending.server.operation.LocalDataManager;
import com.cmt.vending.server.operation.TransactionManager;
import com.cmt.vending.ui.webSocket.UIWebSocketEndpoint;
import com.cmt.vending.ui.webSocket.UIWebSocketHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

public class AliveObserver  implements Observer {
    protected Logger logger = LogManager.getLogger(getClass());

    public void update(Observable o, Object arg) {
        this.handle(((AliveObservable) o).isAlive());
    }

    public void handle(boolean res) {

        if(res) {
            SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_VMC_DEVICE, "F->S"));

            if (!TransactionManager.IS_TRAN_PROCESS && LocalDataManager.getVmInfo().getInfo().isEnabled()) {
                boolean needToUpdateUI = false;

                // Check column
                VsCellInfo cellInfos = LocalDataManager.getCellInfo();
                for (int i = 0; i < cellInfos.getCellInfo().size(); i++) {
                    CellInfo cellInfo = cellInfos.getCellInfo().get(i);

                    if (!cellInfo.isColumnNormal() && cellInfo.isEnabled()
                            && cellInfo.getProductInfo().isEnable()
                            && cellInfo.getCurrentPeriodInfo() != null
                            && cellInfo.getQty() > 0) {
                        LocalServer.getVmc().checkColumn(cellInfo.getItemNo());

                        if (cellInfo.isColumnNormal()) {
                            needToUpdateUI = true;
                        }
                    }
                }

                if (needToUpdateUI) {
                    UIWebSocketEndpoint.pushMessage(UIWebSocketHandler.getVmInfoResult(null));
                }
            }
        } else {
            SendAlertJob.addAlert(SendAlertJob.createAlert(SendAlertJob.ALERT_TYPE_VMC_DEVICE, "S->F"));
        }
    }
}
