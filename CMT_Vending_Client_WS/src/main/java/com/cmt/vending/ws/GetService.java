

/**
 * GetService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cmt.vending.ws;

    /*
     *  GetService java interface
     */

    public interface GetService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getVmGroupId0
                
         */

         
                     public com.cmt.vending.ws.GetVmGroupIdResponse getVmGroupId(

                        com.cmt.vending.ws.GetVmGroupId getVmGroupId0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getVmGroupId0
            
          */
        public void startgetVmGroupId(

            com.cmt.vending.ws.GetVmGroupId getVmGroupId0,

            final com.cmt.vending.ws.GetServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getSoldoutMediaId2
                
         */

         
                     public com.cmt.vending.ws.GetSoldoutMediaIdResponse getSoldoutMediaId(

                        com.cmt.vending.ws.GetSoldoutMediaId getSoldoutMediaId2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSoldoutMediaId2
            
          */
        public void startgetSoldoutMediaId(

            com.cmt.vending.ws.GetSoldoutMediaId getSoldoutMediaId2,

            final com.cmt.vending.ws.GetServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    