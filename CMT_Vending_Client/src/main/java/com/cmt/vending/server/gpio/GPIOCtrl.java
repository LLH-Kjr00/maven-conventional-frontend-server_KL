package com.cmt.vending.server.gpio;

public class GPIOCtrl  {
    static {
        //System.loadLibrary("gpiod");
        System.load("/opt/vending/libgpio.so");
    }

    public native byte GetPin();
}

