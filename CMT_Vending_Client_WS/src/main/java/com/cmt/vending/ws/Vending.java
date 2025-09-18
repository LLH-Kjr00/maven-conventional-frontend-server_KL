

/**
 * Vending.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /*
     *  Vending java interface
     */

    public interface Vending {
          

        /**
          * Auto generated method signature
          * 
                    * @param checkFirmware0
                
         */

         
                     public com.cmt.vending.ws.CheckFirmwareResponse checkFirmware(

                        com.cmt.vending.ws.CheckFirmware checkFirmware0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param checkFirmware0
            
          */
        public void startcheckFirmware(

            com.cmt.vending.ws.CheckFirmware checkFirmware0,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param validateService2
                
         */

         
                     public com.cmt.vending.ws.ValidateServiceResponse validateService(

                        com.cmt.vending.ws.ValidateService validateService2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param validateService2
            
          */
        public void startvalidateService(

            com.cmt.vending.ws.ValidateService validateService2,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sendReceipt4
                
         */

         
                     public com.cmt.vending.ws.SendReceiptResponse sendReceipt(

                        com.cmt.vending.ws.SendReceipt sendReceipt4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendReceipt4
            
          */
        public void startsendReceipt(

            com.cmt.vending.ws.SendReceipt sendReceipt4,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param reportFirmwareUpgradeResult6
                
         */

         
                     public com.cmt.vending.ws.ReportFirmwareUpgradeResultResponse reportFirmwareUpgradeResult(

                        com.cmt.vending.ws.ReportFirmwareUpgradeResult reportFirmwareUpgradeResult6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param reportFirmwareUpgradeResult6
            
          */
        public void startreportFirmwareUpgradeResult(

            com.cmt.vending.ws.ReportFirmwareUpgradeResult reportFirmwareUpgradeResult6,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sendAlert8
                
         */

         
                     public com.cmt.vending.ws.SendAlertResponse sendAlert(

                        com.cmt.vending.ws.SendAlert sendAlert8)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendAlert8
            
          */
        public void startsendAlert(

            com.cmt.vending.ws.SendAlert sendAlert8,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param logVmRequest10
                
         */

         
                     public com.cmt.vending.ws.LogVmRequestResponse logVmRequest(

                        com.cmt.vending.ws.LogVmRequest logVmRequest10)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param logVmRequest10
            
          */
        public void startlogVmRequest(

            com.cmt.vending.ws.LogVmRequest logVmRequest10,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param heartbeat12
                
         */

         
                     public com.cmt.vending.ws.HeartbeatResponse heartbeat(

                        com.cmt.vending.ws.Heartbeat heartbeat12)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param heartbeat12
            
          */
        public void startheartbeat(

            com.cmt.vending.ws.Heartbeat heartbeat12,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateStock14
                
         */

         
                     public com.cmt.vending.ws.UpdateStockResponse updateStock(

                        com.cmt.vending.ws.UpdateStock updateStock14)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateStock14
            
          */
        public void startupdateStock(

            com.cmt.vending.ws.UpdateStock updateStock14,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param logVideoDownload16
                
         */

         
                     public com.cmt.vending.ws.LogVideoDownloadResponse logVideoDownload(

                        com.cmt.vending.ws.LogVideoDownload logVideoDownload16)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param logVideoDownload16
            
          */
        public void startlogVideoDownload(

            com.cmt.vending.ws.LogVideoDownload logVideoDownload16,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param uploadLogFiles18
                
         */

         
                     public com.cmt.vending.ws.UploadLogFilesResponse uploadLogFiles(

                        com.cmt.vending.ws.UploadLogFiles uploadLogFiles18)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param uploadLogFiles18
            
          */
        public void startuploadLogFiles(

            com.cmt.vending.ws.UploadLogFiles uploadLogFiles18,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getVmInfo20
                
         */

         
                     public com.cmt.vending.ws.GetVmInfoResponse getVmInfo(

                        com.cmt.vending.ws.GetVmInfo getVmInfo20)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getVmInfo20
            
          */
        public void startgetVmInfo(

            com.cmt.vending.ws.GetVmInfo getVmInfo20,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sendTran22
                
         */

         
                     public com.cmt.vending.ws.SendTranResponse sendTran(

                        com.cmt.vending.ws.SendTran sendTran22)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendTran22
            
          */
        public void startsendTran(

            com.cmt.vending.ws.SendTran sendTran22,

            final com.cmt.vending.ws.VendingCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    