package com.cmt.vending.server.backendWebSocket;

public class BackendWebSocketObject {
    private int seq;
    private int ack;
    private String action;

    public BackendWebSocketObject(int ack, String action) {
        this.setSeq(BackendWebSocketClient.sequenceNumber);
        this.setAck(ack);
        this.setAction(action);
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getAck() {
        return ack;
    }

    public void setAck(int ack) {
        this.ack = ack;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
