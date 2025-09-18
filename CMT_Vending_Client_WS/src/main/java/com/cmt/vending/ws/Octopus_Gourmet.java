

/**
 * Octopus_Gourmet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /*
     *  Octopus_Gourmet java interface
     */

    public interface Octopus_Gourmet {
          

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

            final com.cmt.vending.ws.Octopus_GourmetCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    