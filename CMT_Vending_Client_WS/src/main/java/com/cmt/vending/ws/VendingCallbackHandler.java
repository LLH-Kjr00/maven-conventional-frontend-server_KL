
/**
 * VendingCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /**
     *  VendingCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class VendingCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public VendingCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public VendingCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for checkFirmware method
            * override this method for handling normal response from checkFirmware operation
            */
           public void receiveResultcheckFirmware(
                    com.cmt.vending.ws.CheckFirmwareResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkFirmware operation
           */
            public void receiveErrorcheckFirmware(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for validateService method
            * override this method for handling normal response from validateService operation
            */
           public void receiveResultvalidateService(
                    com.cmt.vending.ws.ValidateServiceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validateService operation
           */
            public void receiveErrorvalidateService(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendReceipt method
            * override this method for handling normal response from sendReceipt operation
            */
           public void receiveResultsendReceipt(
                    com.cmt.vending.ws.SendReceiptResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendReceipt operation
           */
            public void receiveErrorsendReceipt(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for reportFirmwareUpgradeResult method
            * override this method for handling normal response from reportFirmwareUpgradeResult operation
            */
           public void receiveResultreportFirmwareUpgradeResult(
                    com.cmt.vending.ws.ReportFirmwareUpgradeResultResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from reportFirmwareUpgradeResult operation
           */
            public void receiveErrorreportFirmwareUpgradeResult(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendAlert method
            * override this method for handling normal response from sendAlert operation
            */
           public void receiveResultsendAlert(
                    com.cmt.vending.ws.SendAlertResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendAlert operation
           */
            public void receiveErrorsendAlert(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for logVmRequest method
            * override this method for handling normal response from logVmRequest operation
            */
           public void receiveResultlogVmRequest(
                    com.cmt.vending.ws.LogVmRequestResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logVmRequest operation
           */
            public void receiveErrorlogVmRequest(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for heartbeat method
            * override this method for handling normal response from heartbeat operation
            */
           public void receiveResultheartbeat(
                    com.cmt.vending.ws.HeartbeatResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from heartbeat operation
           */
            public void receiveErrorheartbeat(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateStock method
            * override this method for handling normal response from updateStock operation
            */
           public void receiveResultupdateStock(
                    com.cmt.vending.ws.UpdateStockResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateStock operation
           */
            public void receiveErrorupdateStock(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for logVideoDownload method
            * override this method for handling normal response from logVideoDownload operation
            */
           public void receiveResultlogVideoDownload(
                    com.cmt.vending.ws.LogVideoDownloadResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logVideoDownload operation
           */
            public void receiveErrorlogVideoDownload(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for uploadLogFiles method
            * override this method for handling normal response from uploadLogFiles operation
            */
           public void receiveResultuploadLogFiles(
                    com.cmt.vending.ws.UploadLogFilesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from uploadLogFiles operation
           */
            public void receiveErroruploadLogFiles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVmInfo method
            * override this method for handling normal response from getVmInfo operation
            */
           public void receiveResultgetVmInfo(
                    com.cmt.vending.ws.GetVmInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVmInfo operation
           */
            public void receiveErrorgetVmInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendTran method
            * override this method for handling normal response from sendTran operation
            */
           public void receiveResultsendTran(
                    com.cmt.vending.ws.SendTranResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendTran operation
           */
            public void receiveErrorsendTran(java.lang.Exception e) {
            }
                


    }
    