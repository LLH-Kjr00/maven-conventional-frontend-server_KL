
/**
 * PaymentCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /**
     *  PaymentCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PaymentCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PaymentCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PaymentCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for tngGetQrCode method
            * override this method for handling normal response from tngGetQrCode operation
            */
           public void receiveResulttngGetQrCode(
                    com.cmt.vending.ws.TngGetQrCodeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tngGetQrCode operation
           */
            public void receiveErrortngGetQrCode(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for redemptionCheckCode method
            * override this method for handling normal response from redemptionCheckCode operation
            */
           public void receiveResultredemptionCheckCode(
                    com.cmt.vending.ws.RedemptionCheckCodeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from redemptionCheckCode operation
           */
            public void receiveErrorredemptionCheckCode(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for tngIsPaymentSuccess method
            * override this method for handling normal response from tngIsPaymentSuccess operation
            */
           public void receiveResulttngIsPaymentSuccess(
                    com.cmt.vending.ws.TngIsPaymentSuccessResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from tngIsPaymentSuccess operation
           */
            public void receiveErrortngIsPaymentSuccess(java.lang.Exception e) {
            }
                


    }
    