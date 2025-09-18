
/**
 * OctopusCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /**
     *  OctopusCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class OctopusCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public OctopusCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public OctopusCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for uploadSettlementFile method
            * override this method for handling normal response from uploadSettlementFile operation
            */
           public void receiveResultuploadSettlementFile(
                    com.cmt.vending.ws.UploadSettlementFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from uploadSettlementFile operation
           */
            public void receiveErroruploadSettlementFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for downloadInterimBlacklist method
            * override this method for handling normal response from downloadInterimBlacklist operation
            */
           public void receiveResultdownloadInterimBlacklist(
                    com.cmt.vending.ws.DownloadInterimBlacklistResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from downloadInterimBlacklist operation
           */
            public void receiveErrordownloadInterimBlacklist(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for downloadMetaFile method
            * override this method for handling normal response from downloadMetaFile operation
            */
           public void receiveResultdownloadMetaFile(
                    com.cmt.vending.ws.DownloadMetaFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from downloadMetaFile operation
           */
            public void receiveErrordownloadMetaFile(java.lang.Exception e) {
            }
                


    }
    