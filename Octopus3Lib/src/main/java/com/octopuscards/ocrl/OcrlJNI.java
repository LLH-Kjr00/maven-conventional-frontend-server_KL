package com.octopuscards.ocrl;

public class OcrlJNI {

    static {
        System.loadLibrary("jniocrl");
    }

    public native int connect(String comm);

    public native void disconnect();

    public native int cmdExchange(byte[] reqJson, byte[] respJson, int len);

}