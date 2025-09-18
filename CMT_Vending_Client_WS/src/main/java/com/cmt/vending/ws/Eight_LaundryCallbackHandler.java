
/**
 * Eight_LaundryCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /**
     *  Eight_LaundryCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class Eight_LaundryCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public Eight_LaundryCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public Eight_LaundryCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for sendInuseStatus method
            * override this method for handling normal response from sendInuseStatus operation
            */
           public void receiveResultsendInuseStatus(
                    com.cmt.vending.ws.SendInuseStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendInuseStatus operation
           */
            public void receiveErrorsendInuseStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLogoMediaId method
            * override this method for handling normal response from getLogoMediaId operation
            */
           public void receiveResultgetLogoMediaId(
                    com.cmt.vending.ws.GetLogoMediaIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLogoMediaId operation
           */
            public void receiveErrorgetLogoMediaId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendPaidStatus method
            * override this method for handling normal response from sendPaidStatus operation
            */
           public void receiveResultsendPaidStatus(
                    com.cmt.vending.ws.SendPaidStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendPaidStatus operation
           */
            public void receiveErrorsendPaidStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getItemStatus method
            * override this method for handling normal response from getItemStatus operation
            */
           public void receiveResultgetItemStatus(
                    com.cmt.vending.ws.GetItemStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getItemStatus operation
           */
            public void receiveErrorgetItemStatus(java.lang.Exception e) {
            }
                


    }
    