

/**
 * Octopus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /*
     *  Octopus java interface
     */

    public interface Octopus {
          

        /**
          * Auto generated method signature
          * 
                    * @param uploadSettlementFile0
                
         */

         
                     public com.cmt.vending.ws.UploadSettlementFileResponse uploadSettlementFile(

                        com.cmt.vending.ws.UploadSettlementFile uploadSettlementFile0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param uploadSettlementFile0
            
          */
        public void startuploadSettlementFile(

            com.cmt.vending.ws.UploadSettlementFile uploadSettlementFile0,

            final com.cmt.vending.ws.OctopusCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param downloadInterimBlacklist2
                
         */

         
                     public com.cmt.vending.ws.DownloadInterimBlacklistResponse downloadInterimBlacklist(

                        com.cmt.vending.ws.DownloadInterimBlacklist downloadInterimBlacklist2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param downloadInterimBlacklist2
            
          */
        public void startdownloadInterimBlacklist(

            com.cmt.vending.ws.DownloadInterimBlacklist downloadInterimBlacklist2,

            final com.cmt.vending.ws.OctopusCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param downloadMetaFile4
                
         */

         
                     public com.cmt.vending.ws.DownloadMetaFileResponse downloadMetaFile(

                        com.cmt.vending.ws.DownloadMetaFile downloadMetaFile4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param downloadMetaFile4
            
          */
        public void startdownloadMetaFile(

            com.cmt.vending.ws.DownloadMetaFile downloadMetaFile4,

            final com.cmt.vending.ws.OctopusCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    