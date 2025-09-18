

/**
 * Eight_Laundry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /*
     *  Eight_Laundry java interface
     */

    public interface Eight_Laundry {
          

        /**
          * Auto generated method signature
          * 
                    * @param sendInuseStatus0
                
         */

         
                     public com.cmt.vending.ws.SendInuseStatusResponse sendInuseStatus(

                        com.cmt.vending.ws.SendInuseStatus sendInuseStatus0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendInuseStatus0
            
          */
        public void startsendInuseStatus(

            com.cmt.vending.ws.SendInuseStatus sendInuseStatus0,

            final com.cmt.vending.ws.Eight_LaundryCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getLogoMediaId2
                
         */

         
                     public com.cmt.vending.ws.GetLogoMediaIdResponse getLogoMediaId(

                        com.cmt.vending.ws.GetLogoMediaId getLogoMediaId2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getLogoMediaId2
            
          */
        public void startgetLogoMediaId(

            com.cmt.vending.ws.GetLogoMediaId getLogoMediaId2,

            final com.cmt.vending.ws.Eight_LaundryCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sendPaidStatus4
                
         */

         
                     public com.cmt.vending.ws.SendPaidStatusResponse sendPaidStatus(

                        com.cmt.vending.ws.SendPaidStatus sendPaidStatus4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendPaidStatus4
            
          */
        public void startsendPaidStatus(

            com.cmt.vending.ws.SendPaidStatus sendPaidStatus4,

            final com.cmt.vending.ws.Eight_LaundryCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getItemStatus6
                
         */

         
                     public com.cmt.vending.ws.GetItemStatusResponse getItemStatus(

                        com.cmt.vending.ws.GetItemStatus getItemStatus6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getItemStatus6
            
          */
        public void startgetItemStatus(

            com.cmt.vending.ws.GetItemStatus getItemStatus6,

            final com.cmt.vending.ws.Eight_LaundryCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    