

/**
 * Payment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /*
     *  Payment java interface
     */

    public interface Payment {
          

        /**
          * Auto generated method signature
          * 
                    * @param tngGetQrCode0
                
         */

         
                     public com.cmt.vending.ws.TngGetQrCodeResponse tngGetQrCode(

                        com.cmt.vending.ws.TngGetQrCode tngGetQrCode0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param tngGetQrCode0
            
          */
        public void starttngGetQrCode(

            com.cmt.vending.ws.TngGetQrCode tngGetQrCode0,

            final com.cmt.vending.ws.PaymentCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param redemptionCheckCode2
                
         */

         
                     public com.cmt.vending.ws.RedemptionCheckCodeResponse redemptionCheckCode(

                        com.cmt.vending.ws.RedemptionCheckCode redemptionCheckCode2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param redemptionCheckCode2
            
          */
        public void startredemptionCheckCode(

            com.cmt.vending.ws.RedemptionCheckCode redemptionCheckCode2,

            final com.cmt.vending.ws.PaymentCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param tngIsPaymentSuccess4
                
         */

         
                     public com.cmt.vending.ws.TngIsPaymentSuccessResponse tngIsPaymentSuccess(

                        com.cmt.vending.ws.TngIsPaymentSuccess tngIsPaymentSuccess4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param tngIsPaymentSuccess4
            
          */
        public void starttngIsPaymentSuccess(

            com.cmt.vending.ws.TngIsPaymentSuccess tngIsPaymentSuccess4,

            final com.cmt.vending.ws.PaymentCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    