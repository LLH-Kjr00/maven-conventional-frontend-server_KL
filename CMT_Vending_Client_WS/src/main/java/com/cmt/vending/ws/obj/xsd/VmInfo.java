
/**
 * VmInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.cmt.vending.ws.obj.xsd;
            

            /**
            *  VmInfo bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class VmInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = VmInfo
                Namespace URI = http://obj.ws.vending.cmt.com/xsd
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for Cells
                        * This was an Array!
                        */

                        
                                    protected com.cmt.vending.ws.obj.xsd.CellInfo[] localCells ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCellsTracker = false ;

                           public boolean isCellsSpecified(){
                               return localCellsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.cmt.vending.ws.obj.xsd.CellInfo[]
                           */
                           public  com.cmt.vending.ws.obj.xsd.CellInfo[] getCells(){
                               return localCells;
                           }

                           
                        


                               
                              /**
                               * validate the array for Cells
                               */
                              protected void validateCells(com.cmt.vending.ws.obj.xsd.CellInfo[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Cells
                              */
                              public void setCells(com.cmt.vending.ws.obj.xsd.CellInfo[] param){
                              
                                   validateCells(param);

                               localCellsTracker = true;
                                      
                                      this.localCells=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.cmt.vending.ws.obj.xsd.CellInfo
                             */
                             public void addCells(com.cmt.vending.ws.obj.xsd.CellInfo param){
                                   if (localCells == null){
                                   localCells = new com.cmt.vending.ws.obj.xsd.CellInfo[]{};
                                   }

                            
                                 //update the setting tracker
                                localCellsTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localCells);
                               list.add(param);
                               this.localCells =
                             (com.cmt.vending.ws.obj.xsd.CellInfo[])list.toArray(
                            new com.cmt.vending.ws.obj.xsd.CellInfo[list.size()]);

                             }
                             

                        /**
                        * field for Description
                        */

                        
                                    protected java.lang.String localDescription ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDescriptionTracker = false ;

                           public boolean isDescriptionSpecified(){
                               return localDescriptionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDescription(){
                               return localDescription;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Description
                               */
                               public void setDescription(java.lang.String param){
                            localDescriptionTracker = true;
                                   
                                            this.localDescription=param;
                                    

                               }
                            

                        /**
                        * field for EmailReceiptFlag
                        */

                        
                                    protected java.lang.String localEmailReceiptFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEmailReceiptFlagTracker = false ;

                           public boolean isEmailReceiptFlagSpecified(){
                               return localEmailReceiptFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEmailReceiptFlag(){
                               return localEmailReceiptFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EmailReceiptFlag
                               */
                               public void setEmailReceiptFlag(java.lang.String param){
                            localEmailReceiptFlagTracker = true;
                                   
                                            this.localEmailReceiptFlag=param;
                                    

                               }
                            

                        /**
                        * field for Enabled
                        */

                        
                                    protected boolean localEnabled ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEnabledTracker = false ;

                           public boolean isEnabledSpecified(){
                               return localEnabledTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getEnabled(){
                               return localEnabled;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Enabled
                               */
                               public void setEnabled(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localEnabledTracker =
                                       true;
                                   
                                            this.localEnabled=param;
                                    

                               }
                            

                        /**
                        * field for ExtraParams
                        * This was an Array!
                        */

                        
                                    protected com.cmt.vending.ws.obj.xsd.ExtraParam[] localExtraParams ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExtraParamsTracker = false ;

                           public boolean isExtraParamsSpecified(){
                               return localExtraParamsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.cmt.vending.ws.obj.xsd.ExtraParam[]
                           */
                           public  com.cmt.vending.ws.obj.xsd.ExtraParam[] getExtraParams(){
                               return localExtraParams;
                           }

                           
                        


                               
                              /**
                               * validate the array for ExtraParams
                               */
                              protected void validateExtraParams(com.cmt.vending.ws.obj.xsd.ExtraParam[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param ExtraParams
                              */
                              public void setExtraParams(com.cmt.vending.ws.obj.xsd.ExtraParam[] param){
                              
                                   validateExtraParams(param);

                               localExtraParamsTracker = true;
                                      
                                      this.localExtraParams=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.cmt.vending.ws.obj.xsd.ExtraParam
                             */
                             public void addExtraParams(com.cmt.vending.ws.obj.xsd.ExtraParam param){
                                   if (localExtraParams == null){
                                   localExtraParams = new com.cmt.vending.ws.obj.xsd.ExtraParam[]{};
                                   }

                            
                                 //update the setting tracker
                                localExtraParamsTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localExtraParams);
                               list.add(param);
                               this.localExtraParams =
                             (com.cmt.vending.ws.obj.xsd.ExtraParam[])list.toArray(
                            new com.cmt.vending.ws.obj.xsd.ExtraParam[list.size()]);

                             }
                             

                        /**
                        * field for FavIconImageId
                        */

                        
                                    protected int localFavIconImageId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFavIconImageIdTracker = false ;

                           public boolean isFavIconImageIdSpecified(){
                               return localFavIconImageIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getFavIconImageId(){
                               return localFavIconImageId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FavIconImageId
                               */
                               public void setFavIconImageId(int param){
                            localFavIconImageIdTracker = true;
                                   
                                            this.localFavIconImageId=param;
                                    

                               }
                            

                        /**
                        * field for FavTitle
                        */

                        
                                    protected java.lang.String localFavTitle ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFavTitleTracker = false ;

                           public boolean isFavTitleSpecified(){
                               return localFavTitleTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFavTitle(){
                               return localFavTitle;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FavTitle
                               */
                               public void setFavTitle(java.lang.String param){
                            localFavTitleTracker = true;
                                   
                                            this.localFavTitle=param;
                                    

                               }
                            

                        /**
                        * field for FavTitleChi
                        */

                        
                                    protected java.lang.String localFavTitleChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFavTitleChiTracker = false ;

                           public boolean isFavTitleChiSpecified(){
                               return localFavTitleChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFavTitleChi(){
                               return localFavTitleChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FavTitleChi
                               */
                               public void setFavTitleChi(java.lang.String param){
                            localFavTitleChiTracker = true;
                                   
                                            this.localFavTitleChi=param;
                                    

                               }
                            

                        /**
                        * field for IntangibleProductDesc
                        */

                        
                                    protected java.lang.String localIntangibleProductDesc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIntangibleProductDescTracker = false ;

                           public boolean isIntangibleProductDescSpecified(){
                               return localIntangibleProductDescTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIntangibleProductDesc(){
                               return localIntangibleProductDesc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IntangibleProductDesc
                               */
                               public void setIntangibleProductDesc(java.lang.String param){
                            localIntangibleProductDescTracker = true;
                                   
                                            this.localIntangibleProductDesc=param;
                                    

                               }
                            

                        /**
                        * field for IntangibleProductDescChi
                        */

                        
                                    protected java.lang.String localIntangibleProductDescChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIntangibleProductDescChiTracker = false ;

                           public boolean isIntangibleProductDescChiSpecified(){
                               return localIntangibleProductDescChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIntangibleProductDescChi(){
                               return localIntangibleProductDescChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IntangibleProductDescChi
                               */
                               public void setIntangibleProductDescChi(java.lang.String param){
                            localIntangibleProductDescChiTracker = true;
                                   
                                            this.localIntangibleProductDescChi=param;
                                    

                               }
                            

                        /**
                        * field for ModelNo
                        */

                        
                                    protected java.lang.String localModelNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localModelNoTracker = false ;

                           public boolean isModelNoSpecified(){
                               return localModelNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getModelNo(){
                               return localModelNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ModelNo
                               */
                               public void setModelNo(java.lang.String param){
                            localModelNoTracker = true;
                                   
                                            this.localModelNo=param;
                                    

                               }
                            

                        /**
                        * field for PaymentMethods
                        * This was an Array!
                        */

                        
                                    protected int[] localPaymentMethods ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPaymentMethodsTracker = false ;

                           public boolean isPaymentMethodsSpecified(){
                               return localPaymentMethodsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int[]
                           */
                           public  int[] getPaymentMethods(){
                               return localPaymentMethods;
                           }

                           
                        


                               
                              /**
                               * validate the array for PaymentMethods
                               */
                              protected void validatePaymentMethods(int[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param PaymentMethods
                              */
                              public void setPaymentMethods(int[] param){
                              
                                   validatePaymentMethods(param);

                               localPaymentMethodsTracker = true;
                                      
                                      this.localPaymentMethods=param;
                              }

                               
                             

                        /**
                        * field for PromotionImageId
                        */

                        
                                    protected int localPromotionImageId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPromotionImageIdTracker = false ;

                           public boolean isPromotionImageIdSpecified(){
                               return localPromotionImageIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getPromotionImageId(){
                               return localPromotionImageId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PromotionImageId
                               */
                               public void setPromotionImageId(int param){
                            localPromotionImageIdTracker = true;
                                   
                                            this.localPromotionImageId=param;
                                    

                               }
                            

                        /**
                        * field for PromotionImageIdChi
                        */

                        
                                    protected int localPromotionImageIdChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPromotionImageIdChiTracker = false ;

                           public boolean isPromotionImageIdChiSpecified(){
                               return localPromotionImageIdChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getPromotionImageIdChi(){
                               return localPromotionImageIdChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PromotionImageIdChi
                               */
                               public void setPromotionImageIdChi(int param){
                            localPromotionImageIdChiTracker = true;
                                   
                                            this.localPromotionImageIdChi=param;
                                    

                               }
                            

                        /**
                        * field for RecommendCat1ImageId
                        */

                        
                                    protected int localRecommendCat1ImageId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecommendCat1ImageIdTracker = false ;

                           public boolean isRecommendCat1ImageIdSpecified(){
                               return localRecommendCat1ImageIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getRecommendCat1ImageId(){
                               return localRecommendCat1ImageId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecommendCat1ImageId
                               */
                               public void setRecommendCat1ImageId(int param){
                            localRecommendCat1ImageIdTracker = true;
                                   
                                            this.localRecommendCat1ImageId=param;
                                    

                               }
                            

                        /**
                        * field for RecommendCat1ImageIdChi
                        */

                        
                                    protected int localRecommendCat1ImageIdChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecommendCat1ImageIdChiTracker = false ;

                           public boolean isRecommendCat1ImageIdChiSpecified(){
                               return localRecommendCat1ImageIdChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getRecommendCat1ImageIdChi(){
                               return localRecommendCat1ImageIdChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecommendCat1ImageIdChi
                               */
                               public void setRecommendCat1ImageIdChi(int param){
                            localRecommendCat1ImageIdChiTracker = true;
                                   
                                            this.localRecommendCat1ImageIdChi=param;
                                    

                               }
                            

                        /**
                        * field for RecommendCat2ImageId
                        */

                        
                                    protected int localRecommendCat2ImageId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecommendCat2ImageIdTracker = false ;

                           public boolean isRecommendCat2ImageIdSpecified(){
                               return localRecommendCat2ImageIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getRecommendCat2ImageId(){
                               return localRecommendCat2ImageId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecommendCat2ImageId
                               */
                               public void setRecommendCat2ImageId(int param){
                            localRecommendCat2ImageIdTracker = true;
                                   
                                            this.localRecommendCat2ImageId=param;
                                    

                               }
                            

                        /**
                        * field for RecommendCat2ImageIdChi
                        */

                        
                                    protected int localRecommendCat2ImageIdChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecommendCat2ImageIdChiTracker = false ;

                           public boolean isRecommendCat2ImageIdChiSpecified(){
                               return localRecommendCat2ImageIdChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getRecommendCat2ImageIdChi(){
                               return localRecommendCat2ImageIdChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecommendCat2ImageIdChi
                               */
                               public void setRecommendCat2ImageIdChi(int param){
                            localRecommendCat2ImageIdChiTracker = true;
                                   
                                            this.localRecommendCat2ImageIdChi=param;
                                    

                               }
                            

                        /**
                        * field for RecommendCat3ImageId
                        */

                        
                                    protected int localRecommendCat3ImageId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecommendCat3ImageIdTracker = false ;

                           public boolean isRecommendCat3ImageIdSpecified(){
                               return localRecommendCat3ImageIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getRecommendCat3ImageId(){
                               return localRecommendCat3ImageId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecommendCat3ImageId
                               */
                               public void setRecommendCat3ImageId(int param){
                            localRecommendCat3ImageIdTracker = true;
                                   
                                            this.localRecommendCat3ImageId=param;
                                    

                               }
                            

                        /**
                        * field for RecommendCat3ImageIdChi
                        */

                        
                                    protected int localRecommendCat3ImageIdChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecommendCat3ImageIdChiTracker = false ;

                           public boolean isRecommendCat3ImageIdChiSpecified(){
                               return localRecommendCat3ImageIdChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getRecommendCat3ImageIdChi(){
                               return localRecommendCat3ImageIdChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecommendCat3ImageIdChi
                               */
                               public void setRecommendCat3ImageIdChi(int param){
                            localRecommendCat3ImageIdChiTracker = true;
                                   
                                            this.localRecommendCat3ImageIdChi=param;
                                    

                               }
                            

                        /**
                        * field for Services
                        * This was an Array!
                        */

                        
                                    protected com.cmt.vending.ws.obj.xsd.ServiceInfo[] localServices ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localServicesTracker = false ;

                           public boolean isServicesSpecified(){
                               return localServicesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.cmt.vending.ws.obj.xsd.ServiceInfo[]
                           */
                           public  com.cmt.vending.ws.obj.xsd.ServiceInfo[] getServices(){
                               return localServices;
                           }

                           
                        


                               
                              /**
                               * validate the array for Services
                               */
                              protected void validateServices(com.cmt.vending.ws.obj.xsd.ServiceInfo[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Services
                              */
                              public void setServices(com.cmt.vending.ws.obj.xsd.ServiceInfo[] param){
                              
                                   validateServices(param);

                               localServicesTracker = true;
                                      
                                      this.localServices=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.cmt.vending.ws.obj.xsd.ServiceInfo
                             */
                             public void addServices(com.cmt.vending.ws.obj.xsd.ServiceInfo param){
                                   if (localServices == null){
                                   localServices = new com.cmt.vending.ws.obj.xsd.ServiceInfo[]{};
                                   }

                            
                                 //update the setting tracker
                                localServicesTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localServices);
                               list.add(param);
                               this.localServices =
                             (com.cmt.vending.ws.obj.xsd.ServiceInfo[])list.toArray(
                            new com.cmt.vending.ws.obj.xsd.ServiceInfo[list.size()]);

                             }
                             

                        /**
                        * field for TempFanFlag
                        */

                        
                                    protected java.lang.String localTempFanFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTempFanFlagTracker = false ;

                           public boolean isTempFanFlagSpecified(){
                               return localTempFanFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTempFanFlag(){
                               return localTempFanFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TempFanFlag
                               */
                               public void setTempFanFlag(java.lang.String param){
                            localTempFanFlagTracker = true;
                                   
                                            this.localTempFanFlag=param;
                                    

                               }
                            

                        /**
                        * field for TempMax
                        */

                        
                                    protected java.math.BigDecimal localTempMax ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTempMaxTracker = false ;

                           public boolean isTempMaxSpecified(){
                               return localTempMaxTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getTempMax(){
                               return localTempMax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TempMax
                               */
                               public void setTempMax(java.math.BigDecimal param){
                            localTempMaxTracker = true;
                                   
                                            this.localTempMax=param;
                                    

                               }
                            

                        /**
                        * field for TempMin
                        */

                        
                                    protected java.math.BigDecimal localTempMin ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTempMinTracker = false ;

                           public boolean isTempMinSpecified(){
                               return localTempMinTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getTempMin(){
                               return localTempMin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TempMin
                               */
                               public void setTempMin(java.math.BigDecimal param){
                            localTempMinTracker = true;
                                   
                                            this.localTempMin=param;
                                    

                               }
                            

                        /**
                        * field for TempOperMode
                        */

                        
                                    protected int localTempOperMode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTempOperModeTracker = false ;

                           public boolean isTempOperModeSpecified(){
                               return localTempOperModeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getTempOperMode(){
                               return localTempOperMode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TempOperMode
                               */
                               public void setTempOperMode(int param){
                            localTempOperModeTracker = true;
                                   
                                            this.localTempOperMode=param;
                                    

                               }
                            

                        /**
                        * field for TempTarget
                        */

                        
                                    protected java.math.BigDecimal localTempTarget ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTempTargetTracker = false ;

                           public boolean isTempTargetSpecified(){
                               return localTempTargetTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getTempTarget(){
                               return localTempTarget;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TempTarget
                               */
                               public void setTempTarget(java.math.BigDecimal param){
                            localTempTargetTracker = true;
                                   
                                            this.localTempTarget=param;
                                    

                               }
                            

                        /**
                        * field for Vip
                        */

                        
                                    protected boolean localVip ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVipTracker = false ;

                           public boolean isVipSpecified(){
                               return localVipTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getVip(){
                               return localVip;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Vip
                               */
                               public void setVip(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localVipTracker =
                                       true;
                                   
                                            this.localVip=param;
                                    

                               }
                            

                        /**
                        * field for VipDiscountAmount
                        */

                        
                                    protected java.math.BigDecimal localVipDiscountAmount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVipDiscountAmountTracker = false ;

                           public boolean isVipDiscountAmountSpecified(){
                               return localVipDiscountAmountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getVipDiscountAmount(){
                               return localVipDiscountAmount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VipDiscountAmount
                               */
                               public void setVipDiscountAmount(java.math.BigDecimal param){
                            localVipDiscountAmountTracker = true;
                                   
                                            this.localVipDiscountAmount=param;
                                    

                               }
                            

                        /**
                        * field for VipDiscountPercentage
                        */

                        
                                    protected java.math.BigDecimal localVipDiscountPercentage ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVipDiscountPercentageTracker = false ;

                           public boolean isVipDiscountPercentageSpecified(){
                               return localVipDiscountPercentageTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getVipDiscountPercentage(){
                               return localVipDiscountPercentage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VipDiscountPercentage
                               */
                               public void setVipDiscountPercentage(java.math.BigDecimal param){
                            localVipDiscountPercentageTracker = true;
                                   
                                            this.localVipDiscountPercentage=param;
                                    

                               }
                            

                        /**
                        * field for VipDiscountType
                        */

                        
                                    protected int localVipDiscountType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVipDiscountTypeTracker = false ;

                           public boolean isVipDiscountTypeSpecified(){
                               return localVipDiscountTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getVipDiscountType(){
                               return localVipDiscountType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VipDiscountType
                               */
                               public void setVipDiscountType(int param){
                            localVipDiscountTypeTracker = true;
                                   
                                            this.localVipDiscountType=param;
                                    

                               }
                            

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName);
               return factory.createOMElement(dataSource,parentQName);
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://obj.ws.vending.cmt.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":VmInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "VmInfo",
                           xmlWriter);
                   }

               
                   }
                if (localCellsTracker){
                                       if (localCells!=null){
                                            for (int i = 0;i < localCells.length;i++){
                                                if (localCells[i] != null){
                                                 localCells[i].serialize(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","cells"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "http://obj.ws.vending.cmt.com/xsd", "cells", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "http://obj.ws.vending.cmt.com/xsd", "cells", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localDescriptionTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "description", xmlWriter);
                             

                                          if (localDescription==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDescription);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEmailReceiptFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "emailReceiptFlag", xmlWriter);
                             

                                          if (localEmailReceiptFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEmailReceiptFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEnabledTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "enabled", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("enabled cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnabled));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localExtraParamsTracker){
                                       if (localExtraParams!=null){
                                            for (int i = 0;i < localExtraParams.length;i++){
                                                if (localExtraParams[i] != null){
                                                 localExtraParams[i].serialize(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","extraParams"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "http://obj.ws.vending.cmt.com/xsd", "extraParams", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "http://obj.ws.vending.cmt.com/xsd", "extraParams", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localFavIconImageIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "favIconImageId", xmlWriter);
                             
                                               if (localFavIconImageId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFavIconImageId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFavTitleTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "favTitle", xmlWriter);
                             

                                          if (localFavTitle==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFavTitle);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFavTitleChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "favTitleChi", xmlWriter);
                             

                                          if (localFavTitleChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFavTitleChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIntangibleProductDescTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "intangibleProductDesc", xmlWriter);
                             

                                          if (localIntangibleProductDesc==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIntangibleProductDesc);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIntangibleProductDescChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "intangibleProductDescChi", xmlWriter);
                             

                                          if (localIntangibleProductDescChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIntangibleProductDescChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localModelNoTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "modelNo", xmlWriter);
                             

                                          if (localModelNo==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localModelNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPaymentMethodsTracker){
                             if (localPaymentMethods!=null) {
                                   namespace = "http://obj.ws.vending.cmt.com/xsd";
                                   for (int i = 0;i < localPaymentMethods.length;i++){
                                        
                                                   if (localPaymentMethods[i]!=java.lang.Integer.MIN_VALUE) {
                                               
                                                writeStartElement(null, namespace, "paymentMethods", xmlWriter);

                                            
                                                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPaymentMethods[i]));
                                                xmlWriter.writeEndElement();
                                            
                                                } else {
                                                   
                                                           // write null attribute
                                                            namespace = "http://obj.ws.vending.cmt.com/xsd";
                                                            writeStartElement(null, namespace, "paymentMethods", xmlWriter);
                                                            writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                            xmlWriter.writeEndElement();
                                                       
                                                }

                                   }
                             } else {
                                 
                                         // write the null attribute
                                        // write null attribute
                                           writeStartElement(null, "http://obj.ws.vending.cmt.com/xsd", "paymentMethods", xmlWriter);

                                           // write the nil attribute
                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                           xmlWriter.writeEndElement();
                                    
                             }

                        } if (localPromotionImageIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "promotionImageId", xmlWriter);
                             
                                               if (localPromotionImageId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPromotionImageId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPromotionImageIdChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "promotionImageIdChi", xmlWriter);
                             
                                               if (localPromotionImageIdChi==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPromotionImageIdChi));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRecommendCat1ImageIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "recommendCat1ImageId", xmlWriter);
                             
                                               if (localRecommendCat1ImageId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat1ImageId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRecommendCat1ImageIdChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "recommendCat1ImageIdChi", xmlWriter);
                             
                                               if (localRecommendCat1ImageIdChi==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat1ImageIdChi));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRecommendCat2ImageIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "recommendCat2ImageId", xmlWriter);
                             
                                               if (localRecommendCat2ImageId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat2ImageId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRecommendCat2ImageIdChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "recommendCat2ImageIdChi", xmlWriter);
                             
                                               if (localRecommendCat2ImageIdChi==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat2ImageIdChi));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRecommendCat3ImageIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "recommendCat3ImageId", xmlWriter);
                             
                                               if (localRecommendCat3ImageId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat3ImageId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRecommendCat3ImageIdChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "recommendCat3ImageIdChi", xmlWriter);
                             
                                               if (localRecommendCat3ImageIdChi==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat3ImageIdChi));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localServicesTracker){
                                       if (localServices!=null){
                                            for (int i = 0;i < localServices.length;i++){
                                                if (localServices[i] != null){
                                                 localServices[i].serialize(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","services"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "http://obj.ws.vending.cmt.com/xsd", "services", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "http://obj.ws.vending.cmt.com/xsd", "services", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localTempFanFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "tempFanFlag", xmlWriter);
                             

                                          if (localTempFanFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTempFanFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTempMaxTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "tempMax", xmlWriter);
                             

                                          if (localTempMax==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempMax));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTempMinTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "tempMin", xmlWriter);
                             

                                          if (localTempMin==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempMin));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTempOperModeTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "tempOperMode", xmlWriter);
                             
                                               if (localTempOperMode==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempOperMode));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTempTargetTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "tempTarget", xmlWriter);
                             

                                          if (localTempTarget==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempTarget));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVipTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "vip", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("vip cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVip));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVipDiscountAmountTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "vipDiscountAmount", xmlWriter);
                             

                                          if (localVipDiscountAmount==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVipDiscountAmount));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVipDiscountPercentageTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "vipDiscountPercentage", xmlWriter);
                             

                                          if (localVipDiscountPercentage==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVipDiscountPercentage));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVipDiscountTypeTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "vipDiscountType", xmlWriter);
                             
                                               if (localVipDiscountType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVipDiscountType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://obj.ws.vending.cmt.com/xsd")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace,attName,attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localCellsTracker){
                             if (localCells!=null) {
                                 for (int i = 0;i < localCells.length;i++){

                                    if (localCells[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                          "cells"));
                                         elementList.add(localCells[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                          "cells"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                          "cells"));
                                        elementList.add(localCells);
                                    
                             }

                        } if (localDescriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "description"));
                                 
                                         elementList.add(localDescription==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
                                    } if (localEmailReceiptFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "emailReceiptFlag"));
                                 
                                         elementList.add(localEmailReceiptFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEmailReceiptFlag));
                                    } if (localEnabledTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "enabled"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnabled));
                            } if (localExtraParamsTracker){
                             if (localExtraParams!=null) {
                                 for (int i = 0;i < localExtraParams.length;i++){

                                    if (localExtraParams[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                          "extraParams"));
                                         elementList.add(localExtraParams[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                          "extraParams"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                          "extraParams"));
                                        elementList.add(localExtraParams);
                                    
                             }

                        } if (localFavIconImageIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "favIconImageId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFavIconImageId));
                            } if (localFavTitleTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "favTitle"));
                                 
                                         elementList.add(localFavTitle==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFavTitle));
                                    } if (localFavTitleChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "favTitleChi"));
                                 
                                         elementList.add(localFavTitleChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFavTitleChi));
                                    } if (localIntangibleProductDescTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "intangibleProductDesc"));
                                 
                                         elementList.add(localIntangibleProductDesc==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIntangibleProductDesc));
                                    } if (localIntangibleProductDescChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "intangibleProductDescChi"));
                                 
                                         elementList.add(localIntangibleProductDescChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIntangibleProductDescChi));
                                    } if (localModelNoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "modelNo"));
                                 
                                         elementList.add(localModelNo==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localModelNo));
                                    } if (localPaymentMethodsTracker){
                            if (localPaymentMethods!=null){
                                  for (int i = 0;i < localPaymentMethods.length;i++){
                                      
                                          elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                                                                       "paymentMethods"));
                                          elementList.add(
                                          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPaymentMethods[i]));

                                      

                                  }
                            } else {
                              
                                    elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                              "paymentMethods"));
                                    elementList.add(null);
                                
                            }

                        } if (localPromotionImageIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "promotionImageId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPromotionImageId));
                            } if (localPromotionImageIdChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "promotionImageIdChi"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPromotionImageIdChi));
                            } if (localRecommendCat1ImageIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "recommendCat1ImageId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat1ImageId));
                            } if (localRecommendCat1ImageIdChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "recommendCat1ImageIdChi"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat1ImageIdChi));
                            } if (localRecommendCat2ImageIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "recommendCat2ImageId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat2ImageId));
                            } if (localRecommendCat2ImageIdChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "recommendCat2ImageIdChi"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat2ImageIdChi));
                            } if (localRecommendCat3ImageIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "recommendCat3ImageId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat3ImageId));
                            } if (localRecommendCat3ImageIdChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "recommendCat3ImageIdChi"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecommendCat3ImageIdChi));
                            } if (localServicesTracker){
                             if (localServices!=null) {
                                 for (int i = 0;i < localServices.length;i++){

                                    if (localServices[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                          "services"));
                                         elementList.add(localServices[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                          "services"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                          "services"));
                                        elementList.add(localServices);
                                    
                             }

                        } if (localTempFanFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "tempFanFlag"));
                                 
                                         elementList.add(localTempFanFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempFanFlag));
                                    } if (localTempMaxTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "tempMax"));
                                 
                                         elementList.add(localTempMax==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempMax));
                                    } if (localTempMinTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "tempMin"));
                                 
                                         elementList.add(localTempMin==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempMin));
                                    } if (localTempOperModeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "tempOperMode"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempOperMode));
                            } if (localTempTargetTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "tempTarget"));
                                 
                                         elementList.add(localTempTarget==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempTarget));
                                    } if (localVipTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "vip"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVip));
                            } if (localVipDiscountAmountTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "vipDiscountAmount"));
                                 
                                         elementList.add(localVipDiscountAmount==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVipDiscountAmount));
                                    } if (localVipDiscountPercentageTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "vipDiscountPercentage"));
                                 
                                         elementList.add(localVipDiscountPercentage==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVipDiscountPercentage));
                                    } if (localVipDiscountTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "vipDiscountType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVipDiscountType));
                            }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static VmInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            VmInfo object =
                new VmInfo();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"VmInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (VmInfo)com.cmt.vending.ws.obj.xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                        java.util.ArrayList list1 = new java.util.ArrayList();
                    
                        java.util.ArrayList list5 = new java.util.ArrayList();
                    
                        java.util.ArrayList list12 = new java.util.ArrayList();
                    
                        java.util.ArrayList list21 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","cells").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list1.add(null);
                                                              reader.next();
                                                          } else {
                                                        list1.add(com.cmt.vending.ws.obj.xsd.CellInfo.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone1 = false;
                                                        while(!loopDone1){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone1 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","cells").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list1.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list1.add(com.cmt.vending.ws.obj.xsd.CellInfo.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone1 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setCells((com.cmt.vending.ws.obj.xsd.CellInfo[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.cmt.vending.ws.obj.xsd.CellInfo.class,
                                                                list1));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","description").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","emailReceiptFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEmailReceiptFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","enabled").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"enabled" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEnabled(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","extraParams").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list5.add(null);
                                                              reader.next();
                                                          } else {
                                                        list5.add(com.cmt.vending.ws.obj.xsd.ExtraParam.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone5 = false;
                                                        while(!loopDone5){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone5 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","extraParams").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list5.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list5.add(com.cmt.vending.ws.obj.xsd.ExtraParam.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone5 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setExtraParams((com.cmt.vending.ws.obj.xsd.ExtraParam[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.cmt.vending.ws.obj.xsd.ExtraParam.class,
                                                                list5));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","favIconImageId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFavIconImageId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setFavIconImageId(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFavIconImageId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","favTitle").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFavTitle(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","favTitleChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFavTitleChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","intangibleProductDesc").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIntangibleProductDesc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","intangibleProductDescChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIntangibleProductDescChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","modelNo").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setModelNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","paymentMethods").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                              nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                              if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                  list12.add(String.valueOf(java.lang.Integer.MIN_VALUE));
                                                       
                                                  reader.next();
                                              } else {
                                            list12.add(reader.getElementText());
                                            }
                                            //loop until we find a start element that is not part of this array
                                            boolean loopDone12 = false;
                                            while(!loopDone12){
                                                // Ensure we are at the EndElement
                                                while (!reader.isEndElement()){
                                                    reader.next();
                                                }
                                                // Step out of this element
                                                reader.next();
                                                // Step to next element event.
                                                while (!reader.isStartElement() && !reader.isEndElement())
                                                    reader.next();
                                                if (reader.isEndElement()){
                                                    //two continuous end elements means we are exiting the xml structure
                                                    loopDone12 = true;
                                                } else {
                                                    if (new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","paymentMethods").equals(reader.getName())){
                                                         
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list12.add(String.valueOf(java.lang.Integer.MIN_VALUE));
                                                                   
                                                              reader.next();
                                                          } else {
                                                        list12.add(reader.getElementText());
                                                        }
                                                    }else{
                                                        loopDone12 = true;
                                                    }
                                                }
                                            }
                                            // call the converter utility  to convert and set the array
                                            
                                            object.setPaymentMethods((int[])
                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                            int.class,list12));
                                                
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","promotionImageId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPromotionImageId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setPromotionImageId(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setPromotionImageId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","promotionImageIdChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPromotionImageIdChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setPromotionImageIdChi(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setPromotionImageIdChi(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","recommendCat1ImageId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecommendCat1ImageId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setRecommendCat1ImageId(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRecommendCat1ImageId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","recommendCat1ImageIdChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecommendCat1ImageIdChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setRecommendCat1ImageIdChi(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRecommendCat1ImageIdChi(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","recommendCat2ImageId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecommendCat2ImageId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setRecommendCat2ImageId(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRecommendCat2ImageId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","recommendCat2ImageIdChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecommendCat2ImageIdChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setRecommendCat2ImageIdChi(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRecommendCat2ImageIdChi(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","recommendCat3ImageId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecommendCat3ImageId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setRecommendCat3ImageId(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRecommendCat3ImageId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","recommendCat3ImageIdChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecommendCat3ImageIdChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setRecommendCat3ImageIdChi(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRecommendCat3ImageIdChi(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","services").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list21.add(null);
                                                              reader.next();
                                                          } else {
                                                        list21.add(com.cmt.vending.ws.obj.xsd.ServiceInfo.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone21 = false;
                                                        while(!loopDone21){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone21 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","services").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list21.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list21.add(com.cmt.vending.ws.obj.xsd.ServiceInfo.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone21 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setServices((com.cmt.vending.ws.obj.xsd.ServiceInfo[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.cmt.vending.ws.obj.xsd.ServiceInfo.class,
                                                                list21));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","tempFanFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTempFanFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","tempMax").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTempMax(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","tempMin").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTempMin(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","tempOperMode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTempOperMode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setTempOperMode(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setTempOperMode(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","tempTarget").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTempTarget(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","vip").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"vip" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVip(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","vipDiscountAmount").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVipDiscountAmount(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","vipDiscountPercentage").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVipDiscountPercentage(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","vipDiscountType").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVipDiscountType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setVipDiscountType(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setVipDiscountType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    