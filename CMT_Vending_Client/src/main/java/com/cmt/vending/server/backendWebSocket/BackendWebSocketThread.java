package com.cmt.vending.server.backendWebSocket;

import com.cmt.vending.server.LocalServer;
import com.cmt.vending.server.operation.BackendServerComm;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.WebSocketContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;


public class BackendWebSocketThread implements Runnable {

    private static final Logger logger = LogManager.getLogger(BackendWebSocketThread.class);

    @Override
    public void run() {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        BackendWebSocketClient client = new BackendWebSocketClient();

        while(!client.isConnected()) {
            logger.info("[BackendWebSocketThread-run]Trying to connect backend websocket.");
            try {
                logger.info("[BackendWebSocketThread-run]Backend Websocket connected.");
                container.connectToServer(client, new URI("wss://" + BackendServerComm.API_HOST +  ":" + BackendServerComm.WS_PORT + "/" + BackendServerComm.INSTANCE_WS + "/ws/Vending?" + LocalServer.getLocalServerConfig().getVmId()));
                container.setDefaultMaxSessionIdleTimeout(1800000);
            }
            catch(Throwable e) {
                logger.error("[BackendWebSocketThread-run]Failed to connect backend websocket:", e);
            }
            finally {
                try {
                    Thread.sleep(10000);					// Waiting for 10 seconds
                } catch(Throwable e) {

                }
            }
        }
    }

}
