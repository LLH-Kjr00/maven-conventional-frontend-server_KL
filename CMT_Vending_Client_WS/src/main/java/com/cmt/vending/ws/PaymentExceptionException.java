
/**
 * PaymentExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.cmt.vending.ws;

public class PaymentExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1488420795620L;
    
    private com.cmt.vending.ws.PaymentException faultMessage;

    
        public PaymentExceptionException() {
            super("PaymentExceptionException");
        }

        public PaymentExceptionException(java.lang.String s) {
           super(s);
        }

        public PaymentExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public PaymentExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.cmt.vending.ws.PaymentException msg){
       faultMessage = msg;
    }
    
    public com.cmt.vending.ws.PaymentException getFaultMessage(){
       return faultMessage;
    }
}
    