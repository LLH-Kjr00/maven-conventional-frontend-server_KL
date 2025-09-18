
/**
 * ServiceInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.cmt.vending.ws.obj.xsd;
            

            /**
            *  ServiceInfo bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ServiceInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ServiceInfo
                Namespace URI = http://obj.ws.vending.cmt.com/xsd
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for DefaultPrice
                        */

                        
                                    protected java.math.BigDecimal localDefaultPrice ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDefaultPriceTracker = false ;

                           public boolean isDefaultPriceSpecified(){
                               return localDefaultPriceTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getDefaultPrice(){
                               return localDefaultPrice;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DefaultPrice
                               */
                               public void setDefaultPrice(java.math.BigDecimal param){
                            localDefaultPriceTracker = true;
                                   
                                            this.localDefaultPrice=param;
                                    

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
                        * field for DescriptionChi
                        */

                        
                                    protected java.lang.String localDescriptionChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDescriptionChiTracker = false ;

                           public boolean isDescriptionChiSpecified(){
                               return localDescriptionChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDescriptionChi(){
                               return localDescriptionChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DescriptionChi
                               */
                               public void setDescriptionChi(java.lang.String param){
                            localDescriptionChiTracker = true;
                                   
                                            this.localDescriptionChi=param;
                                    

                               }
                            

                        /**
                        * field for DisplayOrder
                        */

                        
                                    protected int localDisplayOrder ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDisplayOrderTracker = false ;

                           public boolean isDisplayOrderSpecified(){
                               return localDisplayOrderTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getDisplayOrder(){
                               return localDisplayOrder;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DisplayOrder
                               */
                               public void setDisplayOrder(int param){
                            localDisplayOrderTracker = true;
                                   
                                            this.localDisplayOrder=param;
                                    

                               }
                            

                        /**
                        * field for EffDttmMs
                        */

                        
                                    protected long localEffDttmMs ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEffDttmMsTracker = false ;

                           public boolean isEffDttmMsSpecified(){
                               return localEffDttmMsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getEffDttmMs(){
                               return localEffDttmMs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EffDttmMs
                               */
                               public void setEffDttmMs(long param){
                            
                                       // setting primitive attribute tracker to true
                                       localEffDttmMsTracker =
                                       param != java.lang.Long.MIN_VALUE;
                                   
                                            this.localEffDttmMs=param;
                                    

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
                        * field for ExpDttmMs
                        */

                        
                                    protected long localExpDttmMs ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExpDttmMsTracker = false ;

                           public boolean isExpDttmMsSpecified(){
                               return localExpDttmMsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getExpDttmMs(){
                               return localExpDttmMs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ExpDttmMs
                               */
                               public void setExpDttmMs(long param){
                            localExpDttmMsTracker = true;
                                   
                                            this.localExpDttmMs=param;
                                    

                               }
                            

                        /**
                        * field for Field1EnableFlag
                        */

                        
                                    protected java.lang.String localField1EnableFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1EnableFlagTracker = false ;

                           public boolean isField1EnableFlagSpecified(){
                               return localField1EnableFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1EnableFlag(){
                               return localField1EnableFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1EnableFlag
                               */
                               public void setField1EnableFlag(java.lang.String param){
                            localField1EnableFlagTracker = true;
                                   
                                            this.localField1EnableFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field1Event
                        */

                        
                                    protected java.lang.String localField1Event ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1EventTracker = false ;

                           public boolean isField1EventSpecified(){
                               return localField1EventTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1Event(){
                               return localField1Event;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1Event
                               */
                               public void setField1Event(java.lang.String param){
                            localField1EventTracker = true;
                                   
                                            this.localField1Event=param;
                                    

                               }
                            

                        /**
                        * field for Field1Label
                        */

                        
                                    protected java.lang.String localField1Label ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1LabelTracker = false ;

                           public boolean isField1LabelSpecified(){
                               return localField1LabelTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1Label(){
                               return localField1Label;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1Label
                               */
                               public void setField1Label(java.lang.String param){
                            localField1LabelTracker = true;
                                   
                                            this.localField1Label=param;
                                    

                               }
                            

                        /**
                        * field for Field1LabelChi
                        */

                        
                                    protected java.lang.String localField1LabelChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1LabelChiTracker = false ;

                           public boolean isField1LabelChiSpecified(){
                               return localField1LabelChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1LabelChi(){
                               return localField1LabelChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1LabelChi
                               */
                               public void setField1LabelChi(java.lang.String param){
                            localField1LabelChiTracker = true;
                                   
                                            this.localField1LabelChi=param;
                                    

                               }
                            

                        /**
                        * field for Field1MandatoryFlag
                        */

                        
                                    protected java.lang.String localField1MandatoryFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1MandatoryFlagTracker = false ;

                           public boolean isField1MandatoryFlagSpecified(){
                               return localField1MandatoryFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1MandatoryFlag(){
                               return localField1MandatoryFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1MandatoryFlag
                               */
                               public void setField1MandatoryFlag(java.lang.String param){
                            localField1MandatoryFlagTracker = true;
                                   
                                            this.localField1MandatoryFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field1Remark
                        */

                        
                                    protected java.lang.String localField1Remark ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1RemarkTracker = false ;

                           public boolean isField1RemarkSpecified(){
                               return localField1RemarkTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1Remark(){
                               return localField1Remark;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1Remark
                               */
                               public void setField1Remark(java.lang.String param){
                            localField1RemarkTracker = true;
                                   
                                            this.localField1Remark=param;
                                    

                               }
                            

                        /**
                        * field for Field1RemarkChi
                        */

                        
                                    protected java.lang.String localField1RemarkChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1RemarkChiTracker = false ;

                           public boolean isField1RemarkChiSpecified(){
                               return localField1RemarkChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1RemarkChi(){
                               return localField1RemarkChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1RemarkChi
                               */
                               public void setField1RemarkChi(java.lang.String param){
                            localField1RemarkChiTracker = true;
                                   
                                            this.localField1RemarkChi=param;
                                    

                               }
                            

                        /**
                        * field for Field1Type
                        */

                        
                                    protected java.lang.String localField1Type ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1TypeTracker = false ;

                           public boolean isField1TypeSpecified(){
                               return localField1TypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1Type(){
                               return localField1Type;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1Type
                               */
                               public void setField1Type(java.lang.String param){
                            localField1TypeTracker = true;
                                   
                                            this.localField1Type=param;
                                    

                               }
                            

                        /**
                        * field for Field1ValidateMsg
                        */

                        
                                    protected java.lang.String localField1ValidateMsg ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1ValidateMsgTracker = false ;

                           public boolean isField1ValidateMsgSpecified(){
                               return localField1ValidateMsgTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1ValidateMsg(){
                               return localField1ValidateMsg;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1ValidateMsg
                               */
                               public void setField1ValidateMsg(java.lang.String param){
                            localField1ValidateMsgTracker = true;
                                   
                                            this.localField1ValidateMsg=param;
                                    

                               }
                            

                        /**
                        * field for Field1ValidateMsgChi
                        */

                        
                                    protected java.lang.String localField1ValidateMsgChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1ValidateMsgChiTracker = false ;

                           public boolean isField1ValidateMsgChiSpecified(){
                               return localField1ValidateMsgChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1ValidateMsgChi(){
                               return localField1ValidateMsgChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1ValidateMsgChi
                               */
                               public void setField1ValidateMsgChi(java.lang.String param){
                            localField1ValidateMsgChiTracker = true;
                                   
                                            this.localField1ValidateMsgChi=param;
                                    

                               }
                            

                        /**
                        * field for Field1ValidateRule
                        */

                        
                                    protected java.lang.String localField1ValidateRule ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField1ValidateRuleTracker = false ;

                           public boolean isField1ValidateRuleSpecified(){
                               return localField1ValidateRuleTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField1ValidateRule(){
                               return localField1ValidateRule;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field1ValidateRule
                               */
                               public void setField1ValidateRule(java.lang.String param){
                            localField1ValidateRuleTracker = true;
                                   
                                            this.localField1ValidateRule=param;
                                    

                               }
                            

                        /**
                        * field for Field2EnableFlag
                        */

                        
                                    protected java.lang.String localField2EnableFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2EnableFlagTracker = false ;

                           public boolean isField2EnableFlagSpecified(){
                               return localField2EnableFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2EnableFlag(){
                               return localField2EnableFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2EnableFlag
                               */
                               public void setField2EnableFlag(java.lang.String param){
                            localField2EnableFlagTracker = true;
                                   
                                            this.localField2EnableFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field2Event
                        */

                        
                                    protected java.lang.String localField2Event ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2EventTracker = false ;

                           public boolean isField2EventSpecified(){
                               return localField2EventTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2Event(){
                               return localField2Event;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2Event
                               */
                               public void setField2Event(java.lang.String param){
                            localField2EventTracker = true;
                                   
                                            this.localField2Event=param;
                                    

                               }
                            

                        /**
                        * field for Field2Label
                        */

                        
                                    protected java.lang.String localField2Label ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2LabelTracker = false ;

                           public boolean isField2LabelSpecified(){
                               return localField2LabelTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2Label(){
                               return localField2Label;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2Label
                               */
                               public void setField2Label(java.lang.String param){
                            localField2LabelTracker = true;
                                   
                                            this.localField2Label=param;
                                    

                               }
                            

                        /**
                        * field for Field2LabelChi
                        */

                        
                                    protected java.lang.String localField2LabelChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2LabelChiTracker = false ;

                           public boolean isField2LabelChiSpecified(){
                               return localField2LabelChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2LabelChi(){
                               return localField2LabelChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2LabelChi
                               */
                               public void setField2LabelChi(java.lang.String param){
                            localField2LabelChiTracker = true;
                                   
                                            this.localField2LabelChi=param;
                                    

                               }
                            

                        /**
                        * field for Field2MandatoryFlag
                        */

                        
                                    protected java.lang.String localField2MandatoryFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2MandatoryFlagTracker = false ;

                           public boolean isField2MandatoryFlagSpecified(){
                               return localField2MandatoryFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2MandatoryFlag(){
                               return localField2MandatoryFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2MandatoryFlag
                               */
                               public void setField2MandatoryFlag(java.lang.String param){
                            localField2MandatoryFlagTracker = true;
                                   
                                            this.localField2MandatoryFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field2Remark
                        */

                        
                                    protected java.lang.String localField2Remark ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2RemarkTracker = false ;

                           public boolean isField2RemarkSpecified(){
                               return localField2RemarkTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2Remark(){
                               return localField2Remark;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2Remark
                               */
                               public void setField2Remark(java.lang.String param){
                            localField2RemarkTracker = true;
                                   
                                            this.localField2Remark=param;
                                    

                               }
                            

                        /**
                        * field for Field2RemarkChi
                        */

                        
                                    protected java.lang.String localField2RemarkChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2RemarkChiTracker = false ;

                           public boolean isField2RemarkChiSpecified(){
                               return localField2RemarkChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2RemarkChi(){
                               return localField2RemarkChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2RemarkChi
                               */
                               public void setField2RemarkChi(java.lang.String param){
                            localField2RemarkChiTracker = true;
                                   
                                            this.localField2RemarkChi=param;
                                    

                               }
                            

                        /**
                        * field for Field2Type
                        */

                        
                                    protected java.lang.String localField2Type ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2TypeTracker = false ;

                           public boolean isField2TypeSpecified(){
                               return localField2TypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2Type(){
                               return localField2Type;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2Type
                               */
                               public void setField2Type(java.lang.String param){
                            localField2TypeTracker = true;
                                   
                                            this.localField2Type=param;
                                    

                               }
                            

                        /**
                        * field for Field2ValidateMsg
                        */

                        
                                    protected java.lang.String localField2ValidateMsg ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2ValidateMsgTracker = false ;

                           public boolean isField2ValidateMsgSpecified(){
                               return localField2ValidateMsgTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2ValidateMsg(){
                               return localField2ValidateMsg;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2ValidateMsg
                               */
                               public void setField2ValidateMsg(java.lang.String param){
                            localField2ValidateMsgTracker = true;
                                   
                                            this.localField2ValidateMsg=param;
                                    

                               }
                            

                        /**
                        * field for Field2ValidateMsgChi
                        */

                        
                                    protected java.lang.String localField2ValidateMsgChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2ValidateMsgChiTracker = false ;

                           public boolean isField2ValidateMsgChiSpecified(){
                               return localField2ValidateMsgChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2ValidateMsgChi(){
                               return localField2ValidateMsgChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2ValidateMsgChi
                               */
                               public void setField2ValidateMsgChi(java.lang.String param){
                            localField2ValidateMsgChiTracker = true;
                                   
                                            this.localField2ValidateMsgChi=param;
                                    

                               }
                            

                        /**
                        * field for Field2ValidateRule
                        */

                        
                                    protected java.lang.String localField2ValidateRule ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField2ValidateRuleTracker = false ;

                           public boolean isField2ValidateRuleSpecified(){
                               return localField2ValidateRuleTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField2ValidateRule(){
                               return localField2ValidateRule;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field2ValidateRule
                               */
                               public void setField2ValidateRule(java.lang.String param){
                            localField2ValidateRuleTracker = true;
                                   
                                            this.localField2ValidateRule=param;
                                    

                               }
                            

                        /**
                        * field for Field3EnableFlag
                        */

                        
                                    protected java.lang.String localField3EnableFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3EnableFlagTracker = false ;

                           public boolean isField3EnableFlagSpecified(){
                               return localField3EnableFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3EnableFlag(){
                               return localField3EnableFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3EnableFlag
                               */
                               public void setField3EnableFlag(java.lang.String param){
                            localField3EnableFlagTracker = true;
                                   
                                            this.localField3EnableFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field3Event
                        */

                        
                                    protected java.lang.String localField3Event ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3EventTracker = false ;

                           public boolean isField3EventSpecified(){
                               return localField3EventTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3Event(){
                               return localField3Event;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3Event
                               */
                               public void setField3Event(java.lang.String param){
                            localField3EventTracker = true;
                                   
                                            this.localField3Event=param;
                                    

                               }
                            

                        /**
                        * field for Field3Label
                        */

                        
                                    protected java.lang.String localField3Label ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3LabelTracker = false ;

                           public boolean isField3LabelSpecified(){
                               return localField3LabelTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3Label(){
                               return localField3Label;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3Label
                               */
                               public void setField3Label(java.lang.String param){
                            localField3LabelTracker = true;
                                   
                                            this.localField3Label=param;
                                    

                               }
                            

                        /**
                        * field for Field3LabelChi
                        */

                        
                                    protected java.lang.String localField3LabelChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3LabelChiTracker = false ;

                           public boolean isField3LabelChiSpecified(){
                               return localField3LabelChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3LabelChi(){
                               return localField3LabelChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3LabelChi
                               */
                               public void setField3LabelChi(java.lang.String param){
                            localField3LabelChiTracker = true;
                                   
                                            this.localField3LabelChi=param;
                                    

                               }
                            

                        /**
                        * field for Field3MandatoryFlag
                        */

                        
                                    protected java.lang.String localField3MandatoryFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3MandatoryFlagTracker = false ;

                           public boolean isField3MandatoryFlagSpecified(){
                               return localField3MandatoryFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3MandatoryFlag(){
                               return localField3MandatoryFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3MandatoryFlag
                               */
                               public void setField3MandatoryFlag(java.lang.String param){
                            localField3MandatoryFlagTracker = true;
                                   
                                            this.localField3MandatoryFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field3Remark
                        */

                        
                                    protected java.lang.String localField3Remark ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3RemarkTracker = false ;

                           public boolean isField3RemarkSpecified(){
                               return localField3RemarkTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3Remark(){
                               return localField3Remark;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3Remark
                               */
                               public void setField3Remark(java.lang.String param){
                            localField3RemarkTracker = true;
                                   
                                            this.localField3Remark=param;
                                    

                               }
                            

                        /**
                        * field for Field3RemarkChi
                        */

                        
                                    protected java.lang.String localField3RemarkChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3RemarkChiTracker = false ;

                           public boolean isField3RemarkChiSpecified(){
                               return localField3RemarkChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3RemarkChi(){
                               return localField3RemarkChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3RemarkChi
                               */
                               public void setField3RemarkChi(java.lang.String param){
                            localField3RemarkChiTracker = true;
                                   
                                            this.localField3RemarkChi=param;
                                    

                               }
                            

                        /**
                        * field for Field3Type
                        */

                        
                                    protected java.lang.String localField3Type ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3TypeTracker = false ;

                           public boolean isField3TypeSpecified(){
                               return localField3TypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3Type(){
                               return localField3Type;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3Type
                               */
                               public void setField3Type(java.lang.String param){
                            localField3TypeTracker = true;
                                   
                                            this.localField3Type=param;
                                    

                               }
                            

                        /**
                        * field for Field3ValidateMsg
                        */

                        
                                    protected java.lang.String localField3ValidateMsg ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3ValidateMsgTracker = false ;

                           public boolean isField3ValidateMsgSpecified(){
                               return localField3ValidateMsgTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3ValidateMsg(){
                               return localField3ValidateMsg;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3ValidateMsg
                               */
                               public void setField3ValidateMsg(java.lang.String param){
                            localField3ValidateMsgTracker = true;
                                   
                                            this.localField3ValidateMsg=param;
                                    

                               }
                            

                        /**
                        * field for Field3ValidateMsgChi
                        */

                        
                                    protected java.lang.String localField3ValidateMsgChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3ValidateMsgChiTracker = false ;

                           public boolean isField3ValidateMsgChiSpecified(){
                               return localField3ValidateMsgChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3ValidateMsgChi(){
                               return localField3ValidateMsgChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3ValidateMsgChi
                               */
                               public void setField3ValidateMsgChi(java.lang.String param){
                            localField3ValidateMsgChiTracker = true;
                                   
                                            this.localField3ValidateMsgChi=param;
                                    

                               }
                            

                        /**
                        * field for Field3ValidateRule
                        */

                        
                                    protected java.lang.String localField3ValidateRule ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField3ValidateRuleTracker = false ;

                           public boolean isField3ValidateRuleSpecified(){
                               return localField3ValidateRuleTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField3ValidateRule(){
                               return localField3ValidateRule;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field3ValidateRule
                               */
                               public void setField3ValidateRule(java.lang.String param){
                            localField3ValidateRuleTracker = true;
                                   
                                            this.localField3ValidateRule=param;
                                    

                               }
                            

                        /**
                        * field for Field4EnableFlag
                        */

                        
                                    protected java.lang.String localField4EnableFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4EnableFlagTracker = false ;

                           public boolean isField4EnableFlagSpecified(){
                               return localField4EnableFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4EnableFlag(){
                               return localField4EnableFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4EnableFlag
                               */
                               public void setField4EnableFlag(java.lang.String param){
                            localField4EnableFlagTracker = true;
                                   
                                            this.localField4EnableFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field4Event
                        */

                        
                                    protected java.lang.String localField4Event ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4EventTracker = false ;

                           public boolean isField4EventSpecified(){
                               return localField4EventTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4Event(){
                               return localField4Event;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4Event
                               */
                               public void setField4Event(java.lang.String param){
                            localField4EventTracker = true;
                                   
                                            this.localField4Event=param;
                                    

                               }
                            

                        /**
                        * field for Field4Label
                        */

                        
                                    protected java.lang.String localField4Label ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4LabelTracker = false ;

                           public boolean isField4LabelSpecified(){
                               return localField4LabelTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4Label(){
                               return localField4Label;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4Label
                               */
                               public void setField4Label(java.lang.String param){
                            localField4LabelTracker = true;
                                   
                                            this.localField4Label=param;
                                    

                               }
                            

                        /**
                        * field for Field4LabelChi
                        */

                        
                                    protected java.lang.String localField4LabelChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4LabelChiTracker = false ;

                           public boolean isField4LabelChiSpecified(){
                               return localField4LabelChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4LabelChi(){
                               return localField4LabelChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4LabelChi
                               */
                               public void setField4LabelChi(java.lang.String param){
                            localField4LabelChiTracker = true;
                                   
                                            this.localField4LabelChi=param;
                                    

                               }
                            

                        /**
                        * field for Field4MandatoryFlag
                        */

                        
                                    protected java.lang.String localField4MandatoryFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4MandatoryFlagTracker = false ;

                           public boolean isField4MandatoryFlagSpecified(){
                               return localField4MandatoryFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4MandatoryFlag(){
                               return localField4MandatoryFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4MandatoryFlag
                               */
                               public void setField4MandatoryFlag(java.lang.String param){
                            localField4MandatoryFlagTracker = true;
                                   
                                            this.localField4MandatoryFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field4Remark
                        */

                        
                                    protected java.lang.String localField4Remark ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4RemarkTracker = false ;

                           public boolean isField4RemarkSpecified(){
                               return localField4RemarkTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4Remark(){
                               return localField4Remark;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4Remark
                               */
                               public void setField4Remark(java.lang.String param){
                            localField4RemarkTracker = true;
                                   
                                            this.localField4Remark=param;
                                    

                               }
                            

                        /**
                        * field for Field4RemarkChi
                        */

                        
                                    protected java.lang.String localField4RemarkChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4RemarkChiTracker = false ;

                           public boolean isField4RemarkChiSpecified(){
                               return localField4RemarkChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4RemarkChi(){
                               return localField4RemarkChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4RemarkChi
                               */
                               public void setField4RemarkChi(java.lang.String param){
                            localField4RemarkChiTracker = true;
                                   
                                            this.localField4RemarkChi=param;
                                    

                               }
                            

                        /**
                        * field for Field4Type
                        */

                        
                                    protected java.lang.String localField4Type ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4TypeTracker = false ;

                           public boolean isField4TypeSpecified(){
                               return localField4TypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4Type(){
                               return localField4Type;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4Type
                               */
                               public void setField4Type(java.lang.String param){
                            localField4TypeTracker = true;
                                   
                                            this.localField4Type=param;
                                    

                               }
                            

                        /**
                        * field for Field4ValidateMsg
                        */

                        
                                    protected java.lang.String localField4ValidateMsg ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4ValidateMsgTracker = false ;

                           public boolean isField4ValidateMsgSpecified(){
                               return localField4ValidateMsgTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4ValidateMsg(){
                               return localField4ValidateMsg;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4ValidateMsg
                               */
                               public void setField4ValidateMsg(java.lang.String param){
                            localField4ValidateMsgTracker = true;
                                   
                                            this.localField4ValidateMsg=param;
                                    

                               }
                            

                        /**
                        * field for Field4ValidateMsgChi
                        */

                        
                                    protected java.lang.String localField4ValidateMsgChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4ValidateMsgChiTracker = false ;

                           public boolean isField4ValidateMsgChiSpecified(){
                               return localField4ValidateMsgChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4ValidateMsgChi(){
                               return localField4ValidateMsgChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4ValidateMsgChi
                               */
                               public void setField4ValidateMsgChi(java.lang.String param){
                            localField4ValidateMsgChiTracker = true;
                                   
                                            this.localField4ValidateMsgChi=param;
                                    

                               }
                            

                        /**
                        * field for Field4ValidateRule
                        */

                        
                                    protected java.lang.String localField4ValidateRule ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField4ValidateRuleTracker = false ;

                           public boolean isField4ValidateRuleSpecified(){
                               return localField4ValidateRuleTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField4ValidateRule(){
                               return localField4ValidateRule;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field4ValidateRule
                               */
                               public void setField4ValidateRule(java.lang.String param){
                            localField4ValidateRuleTracker = true;
                                   
                                            this.localField4ValidateRule=param;
                                    

                               }
                            

                        /**
                        * field for Field5EnableFlag
                        */

                        
                                    protected java.lang.String localField5EnableFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5EnableFlagTracker = false ;

                           public boolean isField5EnableFlagSpecified(){
                               return localField5EnableFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5EnableFlag(){
                               return localField5EnableFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5EnableFlag
                               */
                               public void setField5EnableFlag(java.lang.String param){
                            localField5EnableFlagTracker = true;
                                   
                                            this.localField5EnableFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field5Event
                        */

                        
                                    protected java.lang.String localField5Event ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5EventTracker = false ;

                           public boolean isField5EventSpecified(){
                               return localField5EventTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5Event(){
                               return localField5Event;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5Event
                               */
                               public void setField5Event(java.lang.String param){
                            localField5EventTracker = true;
                                   
                                            this.localField5Event=param;
                                    

                               }
                            

                        /**
                        * field for Field5Label
                        */

                        
                                    protected java.lang.String localField5Label ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5LabelTracker = false ;

                           public boolean isField5LabelSpecified(){
                               return localField5LabelTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5Label(){
                               return localField5Label;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5Label
                               */
                               public void setField5Label(java.lang.String param){
                            localField5LabelTracker = true;
                                   
                                            this.localField5Label=param;
                                    

                               }
                            

                        /**
                        * field for Field5LabelChi
                        */

                        
                                    protected java.lang.String localField5LabelChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5LabelChiTracker = false ;

                           public boolean isField5LabelChiSpecified(){
                               return localField5LabelChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5LabelChi(){
                               return localField5LabelChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5LabelChi
                               */
                               public void setField5LabelChi(java.lang.String param){
                            localField5LabelChiTracker = true;
                                   
                                            this.localField5LabelChi=param;
                                    

                               }
                            

                        /**
                        * field for Field5MandatoryFlag
                        */

                        
                                    protected java.lang.String localField5MandatoryFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5MandatoryFlagTracker = false ;

                           public boolean isField5MandatoryFlagSpecified(){
                               return localField5MandatoryFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5MandatoryFlag(){
                               return localField5MandatoryFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5MandatoryFlag
                               */
                               public void setField5MandatoryFlag(java.lang.String param){
                            localField5MandatoryFlagTracker = true;
                                   
                                            this.localField5MandatoryFlag=param;
                                    

                               }
                            

                        /**
                        * field for Field5Remark
                        */

                        
                                    protected java.lang.String localField5Remark ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5RemarkTracker = false ;

                           public boolean isField5RemarkSpecified(){
                               return localField5RemarkTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5Remark(){
                               return localField5Remark;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5Remark
                               */
                               public void setField5Remark(java.lang.String param){
                            localField5RemarkTracker = true;
                                   
                                            this.localField5Remark=param;
                                    

                               }
                            

                        /**
                        * field for Field5RemarkChi
                        */

                        
                                    protected java.lang.String localField5RemarkChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5RemarkChiTracker = false ;

                           public boolean isField5RemarkChiSpecified(){
                               return localField5RemarkChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5RemarkChi(){
                               return localField5RemarkChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5RemarkChi
                               */
                               public void setField5RemarkChi(java.lang.String param){
                            localField5RemarkChiTracker = true;
                                   
                                            this.localField5RemarkChi=param;
                                    

                               }
                            

                        /**
                        * field for Field5Type
                        */

                        
                                    protected java.lang.String localField5Type ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5TypeTracker = false ;

                           public boolean isField5TypeSpecified(){
                               return localField5TypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5Type(){
                               return localField5Type;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5Type
                               */
                               public void setField5Type(java.lang.String param){
                            localField5TypeTracker = true;
                                   
                                            this.localField5Type=param;
                                    

                               }
                            

                        /**
                        * field for Field5ValidateMsg
                        */

                        
                                    protected java.lang.String localField5ValidateMsg ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5ValidateMsgTracker = false ;

                           public boolean isField5ValidateMsgSpecified(){
                               return localField5ValidateMsgTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5ValidateMsg(){
                               return localField5ValidateMsg;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5ValidateMsg
                               */
                               public void setField5ValidateMsg(java.lang.String param){
                            localField5ValidateMsgTracker = true;
                                   
                                            this.localField5ValidateMsg=param;
                                    

                               }
                            

                        /**
                        * field for Field5ValidateMsgChi
                        */

                        
                                    protected java.lang.String localField5ValidateMsgChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5ValidateMsgChiTracker = false ;

                           public boolean isField5ValidateMsgChiSpecified(){
                               return localField5ValidateMsgChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5ValidateMsgChi(){
                               return localField5ValidateMsgChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5ValidateMsgChi
                               */
                               public void setField5ValidateMsgChi(java.lang.String param){
                            localField5ValidateMsgChiTracker = true;
                                   
                                            this.localField5ValidateMsgChi=param;
                                    

                               }
                            

                        /**
                        * field for Field5ValidateRule
                        */

                        
                                    protected java.lang.String localField5ValidateRule ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localField5ValidateRuleTracker = false ;

                           public boolean isField5ValidateRuleSpecified(){
                               return localField5ValidateRuleTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getField5ValidateRule(){
                               return localField5ValidateRule;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Field5ValidateRule
                               */
                               public void setField5ValidateRule(java.lang.String param){
                            localField5ValidateRuleTracker = true;
                                   
                                            this.localField5ValidateRule=param;
                                    

                               }
                            

                        /**
                        * field for ImageId
                        */

                        
                                    protected int localImageId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImageIdTracker = false ;

                           public boolean isImageIdSpecified(){
                               return localImageIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getImageId(){
                               return localImageId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ImageId
                               */
                               public void setImageId(int param){
                            localImageIdTracker = true;
                                   
                                            this.localImageId=param;
                                    

                               }
                            

                        /**
                        * field for ImageSmallId
                        */

                        
                                    protected int localImageSmallId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImageSmallIdTracker = false ;

                           public boolean isImageSmallIdSpecified(){
                               return localImageSmallIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getImageSmallId(){
                               return localImageSmallId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ImageSmallId
                               */
                               public void setImageSmallId(int param){
                            localImageSmallIdTracker = true;
                                   
                                            this.localImageSmallId=param;
                                    

                               }
                            

                        /**
                        * field for LupdDttmMs
                        */

                        
                                    protected long localLupdDttmMs ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLupdDttmMsTracker = false ;

                           public boolean isLupdDttmMsSpecified(){
                               return localLupdDttmMsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getLupdDttmMs(){
                               return localLupdDttmMs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LupdDttmMs
                               */
                               public void setLupdDttmMs(long param){
                            
                                       // setting primitive attribute tracker to true
                                       localLupdDttmMsTracker =
                                       param != java.lang.Long.MIN_VALUE;
                                   
                                            this.localLupdDttmMs=param;
                                    

                               }
                            

                        /**
                        * field for Name
                        */

                        
                                    protected java.lang.String localName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNameTracker = false ;

                           public boolean isNameSpecified(){
                               return localNameTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getName(){
                               return localName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Name
                               */
                               public void setName(java.lang.String param){
                            localNameTracker = true;
                                   
                                            this.localName=param;
                                    

                               }
                            

                        /**
                        * field for NameChi
                        */

                        
                                    protected java.lang.String localNameChi ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNameChiTracker = false ;

                           public boolean isNameChiSpecified(){
                               return localNameChiTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNameChi(){
                               return localNameChi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NameChi
                               */
                               public void setNameChi(java.lang.String param){
                            localNameChiTracker = true;
                                   
                                            this.localNameChi=param;
                                    

                               }
                            

                        /**
                        * field for PriceEditableFlag
                        */

                        
                                    protected java.lang.String localPriceEditableFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPriceEditableFlagTracker = false ;

                           public boolean isPriceEditableFlagSpecified(){
                               return localPriceEditableFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPriceEditableFlag(){
                               return localPriceEditableFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PriceEditableFlag
                               */
                               public void setPriceEditableFlag(java.lang.String param){
                            localPriceEditableFlagTracker = true;
                                   
                                            this.localPriceEditableFlag=param;
                                    

                               }
                            

                        /**
                        * field for Qty
                        */

                        
                                    protected int localQty ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localQtyTracker = false ;

                           public boolean isQtySpecified(){
                               return localQtyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getQty(){
                               return localQty;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Qty
                               */
                               public void setQty(int param){
                            localQtyTracker = true;
                                   
                                            this.localQty=param;
                                    

                               }
                            

                        /**
                        * field for QtyHold
                        */

                        
                                    protected int localQtyHold ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localQtyHoldTracker = false ;

                           public boolean isQtyHoldSpecified(){
                               return localQtyHoldTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getQtyHold(){
                               return localQtyHold;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param QtyHold
                               */
                               public void setQtyHold(int param){
                            localQtyHoldTracker = true;
                                   
                                            this.localQtyHold=param;
                                    

                               }
                            

                        /**
                        * field for Sid
                        */

                        
                                    protected int localSid ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSidTracker = false ;

                           public boolean isSidSpecified(){
                               return localSidTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getSid(){
                               return localSid;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Sid
                               */
                               public void setSid(int param){
                            localSidTracker = true;
                                   
                                            this.localSid=param;
                                    

                               }
                            

                        /**
                        * field for TrackStock
                        */

                        
                                    protected boolean localTrackStock ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTrackStockTracker = false ;

                           public boolean isTrackStockSpecified(){
                               return localTrackStockTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getTrackStock(){
                               return localTrackStock;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TrackStock
                               */
                               public void setTrackStock(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localTrackStockTracker =
                                       true;
                                   
                                            this.localTrackStock=param;
                                    

                               }
                            

                        /**
                        * field for VideoId
                        */

                        
                                    protected int localVideoId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVideoIdTracker = false ;

                           public boolean isVideoIdSpecified(){
                               return localVideoIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getVideoId(){
                               return localVideoId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VideoId
                               */
                               public void setVideoId(int param){
                            localVideoIdTracker = true;
                                   
                                            this.localVideoId=param;
                                    

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
                           namespacePrefix+":ServiceInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ServiceInfo",
                           xmlWriter);
                   }

               
                   }
                if (localDefaultPriceTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "defaultPrice", xmlWriter);
                             

                                          if (localDefaultPrice==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDefaultPrice));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
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
                             } if (localDescriptionChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "descriptionChi", xmlWriter);
                             

                                          if (localDescriptionChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDescriptionChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDisplayOrderTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "displayOrder", xmlWriter);
                             
                                               if (localDisplayOrder==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDisplayOrder));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEffDttmMsTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "effDttmMs", xmlWriter);
                             
                                               if (localEffDttmMs==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("effDttmMs cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEffDttmMs));
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
                             } if (localExpDttmMsTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "expDttmMs", xmlWriter);
                             
                                               if (localExpDttmMs==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localExpDttmMs));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1EnableFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1EnableFlag", xmlWriter);
                             

                                          if (localField1EnableFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1EnableFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1EventTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1Event", xmlWriter);
                             

                                          if (localField1Event==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1Event);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1LabelTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1Label", xmlWriter);
                             

                                          if (localField1Label==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1Label);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1LabelChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1LabelChi", xmlWriter);
                             

                                          if (localField1LabelChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1LabelChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1MandatoryFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1MandatoryFlag", xmlWriter);
                             

                                          if (localField1MandatoryFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1MandatoryFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1RemarkTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1Remark", xmlWriter);
                             

                                          if (localField1Remark==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1Remark);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1RemarkChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1RemarkChi", xmlWriter);
                             

                                          if (localField1RemarkChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1RemarkChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1TypeTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1Type", xmlWriter);
                             

                                          if (localField1Type==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1Type);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1ValidateMsgTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1ValidateMsg", xmlWriter);
                             

                                          if (localField1ValidateMsg==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1ValidateMsg);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1ValidateMsgChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1ValidateMsgChi", xmlWriter);
                             

                                          if (localField1ValidateMsgChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1ValidateMsgChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField1ValidateRuleTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field1ValidateRule", xmlWriter);
                             

                                          if (localField1ValidateRule==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField1ValidateRule);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2EnableFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2EnableFlag", xmlWriter);
                             

                                          if (localField2EnableFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2EnableFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2EventTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2Event", xmlWriter);
                             

                                          if (localField2Event==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2Event);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2LabelTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2Label", xmlWriter);
                             

                                          if (localField2Label==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2Label);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2LabelChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2LabelChi", xmlWriter);
                             

                                          if (localField2LabelChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2LabelChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2MandatoryFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2MandatoryFlag", xmlWriter);
                             

                                          if (localField2MandatoryFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2MandatoryFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2RemarkTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2Remark", xmlWriter);
                             

                                          if (localField2Remark==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2Remark);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2RemarkChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2RemarkChi", xmlWriter);
                             

                                          if (localField2RemarkChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2RemarkChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2TypeTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2Type", xmlWriter);
                             

                                          if (localField2Type==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2Type);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2ValidateMsgTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2ValidateMsg", xmlWriter);
                             

                                          if (localField2ValidateMsg==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2ValidateMsg);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2ValidateMsgChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2ValidateMsgChi", xmlWriter);
                             

                                          if (localField2ValidateMsgChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2ValidateMsgChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField2ValidateRuleTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field2ValidateRule", xmlWriter);
                             

                                          if (localField2ValidateRule==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField2ValidateRule);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3EnableFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3EnableFlag", xmlWriter);
                             

                                          if (localField3EnableFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3EnableFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3EventTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3Event", xmlWriter);
                             

                                          if (localField3Event==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3Event);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3LabelTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3Label", xmlWriter);
                             

                                          if (localField3Label==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3Label);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3LabelChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3LabelChi", xmlWriter);
                             

                                          if (localField3LabelChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3LabelChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3MandatoryFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3MandatoryFlag", xmlWriter);
                             

                                          if (localField3MandatoryFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3MandatoryFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3RemarkTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3Remark", xmlWriter);
                             

                                          if (localField3Remark==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3Remark);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3RemarkChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3RemarkChi", xmlWriter);
                             

                                          if (localField3RemarkChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3RemarkChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3TypeTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3Type", xmlWriter);
                             

                                          if (localField3Type==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3Type);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3ValidateMsgTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3ValidateMsg", xmlWriter);
                             

                                          if (localField3ValidateMsg==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3ValidateMsg);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3ValidateMsgChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3ValidateMsgChi", xmlWriter);
                             

                                          if (localField3ValidateMsgChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3ValidateMsgChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField3ValidateRuleTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field3ValidateRule", xmlWriter);
                             

                                          if (localField3ValidateRule==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField3ValidateRule);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4EnableFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4EnableFlag", xmlWriter);
                             

                                          if (localField4EnableFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4EnableFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4EventTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4Event", xmlWriter);
                             

                                          if (localField4Event==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4Event);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4LabelTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4Label", xmlWriter);
                             

                                          if (localField4Label==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4Label);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4LabelChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4LabelChi", xmlWriter);
                             

                                          if (localField4LabelChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4LabelChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4MandatoryFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4MandatoryFlag", xmlWriter);
                             

                                          if (localField4MandatoryFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4MandatoryFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4RemarkTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4Remark", xmlWriter);
                             

                                          if (localField4Remark==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4Remark);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4RemarkChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4RemarkChi", xmlWriter);
                             

                                          if (localField4RemarkChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4RemarkChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4TypeTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4Type", xmlWriter);
                             

                                          if (localField4Type==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4Type);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4ValidateMsgTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4ValidateMsg", xmlWriter);
                             

                                          if (localField4ValidateMsg==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4ValidateMsg);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4ValidateMsgChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4ValidateMsgChi", xmlWriter);
                             

                                          if (localField4ValidateMsgChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4ValidateMsgChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField4ValidateRuleTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field4ValidateRule", xmlWriter);
                             

                                          if (localField4ValidateRule==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField4ValidateRule);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5EnableFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5EnableFlag", xmlWriter);
                             

                                          if (localField5EnableFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5EnableFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5EventTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5Event", xmlWriter);
                             

                                          if (localField5Event==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5Event);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5LabelTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5Label", xmlWriter);
                             

                                          if (localField5Label==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5Label);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5LabelChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5LabelChi", xmlWriter);
                             

                                          if (localField5LabelChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5LabelChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5MandatoryFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5MandatoryFlag", xmlWriter);
                             

                                          if (localField5MandatoryFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5MandatoryFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5RemarkTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5Remark", xmlWriter);
                             

                                          if (localField5Remark==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5Remark);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5RemarkChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5RemarkChi", xmlWriter);
                             

                                          if (localField5RemarkChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5RemarkChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5TypeTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5Type", xmlWriter);
                             

                                          if (localField5Type==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5Type);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5ValidateMsgTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5ValidateMsg", xmlWriter);
                             

                                          if (localField5ValidateMsg==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5ValidateMsg);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5ValidateMsgChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5ValidateMsgChi", xmlWriter);
                             

                                          if (localField5ValidateMsgChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5ValidateMsgChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localField5ValidateRuleTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "field5ValidateRule", xmlWriter);
                             

                                          if (localField5ValidateRule==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localField5ValidateRule);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImageIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "imageId", xmlWriter);
                             
                                               if (localImageId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImageSmallIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "imageSmallId", xmlWriter);
                             
                                               if (localImageSmallId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageSmallId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLupdDttmMsTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "lupdDttmMs", xmlWriter);
                             
                                               if (localLupdDttmMs==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("lupdDttmMs cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLupdDttmMs));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNameTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "name", xmlWriter);
                             

                                          if (localName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNameChiTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "nameChi", xmlWriter);
                             

                                          if (localNameChi==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNameChi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPriceEditableFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "priceEditableFlag", xmlWriter);
                             

                                          if (localPriceEditableFlag==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPriceEditableFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localQtyTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "qty", xmlWriter);
                             
                                               if (localQty==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQty));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localQtyHoldTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "qtyHold", xmlWriter);
                             
                                               if (localQtyHold==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQtyHold));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSidTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "sid", xmlWriter);
                             
                                               if (localSid==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSid));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTrackStockTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "trackStock", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("trackStock cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTrackStock));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVideoIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "videoId", xmlWriter);
                             
                                               if (localVideoId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoId));
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

                 if (localDefaultPriceTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "defaultPrice"));
                                 
                                         elementList.add(localDefaultPrice==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDefaultPrice));
                                    } if (localDescriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "description"));
                                 
                                         elementList.add(localDescription==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
                                    } if (localDescriptionChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "descriptionChi"));
                                 
                                         elementList.add(localDescriptionChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescriptionChi));
                                    } if (localDisplayOrderTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "displayOrder"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDisplayOrder));
                            } if (localEffDttmMsTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "effDttmMs"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEffDttmMs));
                            } if (localEnabledTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "enabled"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnabled));
                            } if (localExpDttmMsTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "expDttmMs"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localExpDttmMs));
                            } if (localField1EnableFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1EnableFlag"));
                                 
                                         elementList.add(localField1EnableFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1EnableFlag));
                                    } if (localField1EventTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1Event"));
                                 
                                         elementList.add(localField1Event==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1Event));
                                    } if (localField1LabelTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1Label"));
                                 
                                         elementList.add(localField1Label==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1Label));
                                    } if (localField1LabelChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1LabelChi"));
                                 
                                         elementList.add(localField1LabelChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1LabelChi));
                                    } if (localField1MandatoryFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1MandatoryFlag"));
                                 
                                         elementList.add(localField1MandatoryFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1MandatoryFlag));
                                    } if (localField1RemarkTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1Remark"));
                                 
                                         elementList.add(localField1Remark==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1Remark));
                                    } if (localField1RemarkChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1RemarkChi"));
                                 
                                         elementList.add(localField1RemarkChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1RemarkChi));
                                    } if (localField1TypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1Type"));
                                 
                                         elementList.add(localField1Type==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1Type));
                                    } if (localField1ValidateMsgTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1ValidateMsg"));
                                 
                                         elementList.add(localField1ValidateMsg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1ValidateMsg));
                                    } if (localField1ValidateMsgChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1ValidateMsgChi"));
                                 
                                         elementList.add(localField1ValidateMsgChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1ValidateMsgChi));
                                    } if (localField1ValidateRuleTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field1ValidateRule"));
                                 
                                         elementList.add(localField1ValidateRule==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField1ValidateRule));
                                    } if (localField2EnableFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2EnableFlag"));
                                 
                                         elementList.add(localField2EnableFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2EnableFlag));
                                    } if (localField2EventTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2Event"));
                                 
                                         elementList.add(localField2Event==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2Event));
                                    } if (localField2LabelTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2Label"));
                                 
                                         elementList.add(localField2Label==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2Label));
                                    } if (localField2LabelChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2LabelChi"));
                                 
                                         elementList.add(localField2LabelChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2LabelChi));
                                    } if (localField2MandatoryFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2MandatoryFlag"));
                                 
                                         elementList.add(localField2MandatoryFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2MandatoryFlag));
                                    } if (localField2RemarkTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2Remark"));
                                 
                                         elementList.add(localField2Remark==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2Remark));
                                    } if (localField2RemarkChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2RemarkChi"));
                                 
                                         elementList.add(localField2RemarkChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2RemarkChi));
                                    } if (localField2TypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2Type"));
                                 
                                         elementList.add(localField2Type==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2Type));
                                    } if (localField2ValidateMsgTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2ValidateMsg"));
                                 
                                         elementList.add(localField2ValidateMsg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2ValidateMsg));
                                    } if (localField2ValidateMsgChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2ValidateMsgChi"));
                                 
                                         elementList.add(localField2ValidateMsgChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2ValidateMsgChi));
                                    } if (localField2ValidateRuleTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field2ValidateRule"));
                                 
                                         elementList.add(localField2ValidateRule==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField2ValidateRule));
                                    } if (localField3EnableFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3EnableFlag"));
                                 
                                         elementList.add(localField3EnableFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3EnableFlag));
                                    } if (localField3EventTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3Event"));
                                 
                                         elementList.add(localField3Event==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3Event));
                                    } if (localField3LabelTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3Label"));
                                 
                                         elementList.add(localField3Label==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3Label));
                                    } if (localField3LabelChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3LabelChi"));
                                 
                                         elementList.add(localField3LabelChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3LabelChi));
                                    } if (localField3MandatoryFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3MandatoryFlag"));
                                 
                                         elementList.add(localField3MandatoryFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3MandatoryFlag));
                                    } if (localField3RemarkTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3Remark"));
                                 
                                         elementList.add(localField3Remark==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3Remark));
                                    } if (localField3RemarkChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3RemarkChi"));
                                 
                                         elementList.add(localField3RemarkChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3RemarkChi));
                                    } if (localField3TypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3Type"));
                                 
                                         elementList.add(localField3Type==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3Type));
                                    } if (localField3ValidateMsgTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3ValidateMsg"));
                                 
                                         elementList.add(localField3ValidateMsg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3ValidateMsg));
                                    } if (localField3ValidateMsgChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3ValidateMsgChi"));
                                 
                                         elementList.add(localField3ValidateMsgChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3ValidateMsgChi));
                                    } if (localField3ValidateRuleTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field3ValidateRule"));
                                 
                                         elementList.add(localField3ValidateRule==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField3ValidateRule));
                                    } if (localField4EnableFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4EnableFlag"));
                                 
                                         elementList.add(localField4EnableFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4EnableFlag));
                                    } if (localField4EventTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4Event"));
                                 
                                         elementList.add(localField4Event==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4Event));
                                    } if (localField4LabelTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4Label"));
                                 
                                         elementList.add(localField4Label==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4Label));
                                    } if (localField4LabelChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4LabelChi"));
                                 
                                         elementList.add(localField4LabelChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4LabelChi));
                                    } if (localField4MandatoryFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4MandatoryFlag"));
                                 
                                         elementList.add(localField4MandatoryFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4MandatoryFlag));
                                    } if (localField4RemarkTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4Remark"));
                                 
                                         elementList.add(localField4Remark==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4Remark));
                                    } if (localField4RemarkChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4RemarkChi"));
                                 
                                         elementList.add(localField4RemarkChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4RemarkChi));
                                    } if (localField4TypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4Type"));
                                 
                                         elementList.add(localField4Type==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4Type));
                                    } if (localField4ValidateMsgTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4ValidateMsg"));
                                 
                                         elementList.add(localField4ValidateMsg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4ValidateMsg));
                                    } if (localField4ValidateMsgChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4ValidateMsgChi"));
                                 
                                         elementList.add(localField4ValidateMsgChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4ValidateMsgChi));
                                    } if (localField4ValidateRuleTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field4ValidateRule"));
                                 
                                         elementList.add(localField4ValidateRule==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField4ValidateRule));
                                    } if (localField5EnableFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5EnableFlag"));
                                 
                                         elementList.add(localField5EnableFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5EnableFlag));
                                    } if (localField5EventTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5Event"));
                                 
                                         elementList.add(localField5Event==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5Event));
                                    } if (localField5LabelTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5Label"));
                                 
                                         elementList.add(localField5Label==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5Label));
                                    } if (localField5LabelChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5LabelChi"));
                                 
                                         elementList.add(localField5LabelChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5LabelChi));
                                    } if (localField5MandatoryFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5MandatoryFlag"));
                                 
                                         elementList.add(localField5MandatoryFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5MandatoryFlag));
                                    } if (localField5RemarkTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5Remark"));
                                 
                                         elementList.add(localField5Remark==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5Remark));
                                    } if (localField5RemarkChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5RemarkChi"));
                                 
                                         elementList.add(localField5RemarkChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5RemarkChi));
                                    } if (localField5TypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5Type"));
                                 
                                         elementList.add(localField5Type==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5Type));
                                    } if (localField5ValidateMsgTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5ValidateMsg"));
                                 
                                         elementList.add(localField5ValidateMsg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5ValidateMsg));
                                    } if (localField5ValidateMsgChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5ValidateMsgChi"));
                                 
                                         elementList.add(localField5ValidateMsgChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5ValidateMsgChi));
                                    } if (localField5ValidateRuleTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "field5ValidateRule"));
                                 
                                         elementList.add(localField5ValidateRule==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localField5ValidateRule));
                                    } if (localImageIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "imageId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageId));
                            } if (localImageSmallIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "imageSmallId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImageSmallId));
                            } if (localLupdDttmMsTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "lupdDttmMs"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLupdDttmMs));
                            } if (localNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "name"));
                                 
                                         elementList.add(localName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
                                    } if (localNameChiTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "nameChi"));
                                 
                                         elementList.add(localNameChi==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNameChi));
                                    } if (localPriceEditableFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "priceEditableFlag"));
                                 
                                         elementList.add(localPriceEditableFlag==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPriceEditableFlag));
                                    } if (localQtyTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "qty"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQty));
                            } if (localQtyHoldTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "qtyHold"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQtyHold));
                            } if (localSidTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "sid"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSid));
                            } if (localTrackStockTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "trackStock"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTrackStock));
                            } if (localVideoIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "videoId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoId));
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
        public static ServiceInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ServiceInfo object =
                new ServiceInfo();

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
                    
                            if (!"ServiceInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ServiceInfo)com.cmt.vending.ws.obj.xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","defaultPrice").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDefaultPrice(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","descriptionChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDescriptionChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","displayOrder").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDisplayOrder(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setDisplayOrder(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setDisplayOrder(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","effDttmMs").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"effDttmMs" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEffDttmMs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setEffDttmMs(java.lang.Long.MIN_VALUE);
                                           
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","expDttmMs").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setExpDttmMs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setExpDttmMs(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setExpDttmMs(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1EnableFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1EnableFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1Event").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1Event(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1Label").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1Label(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1LabelChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1LabelChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1MandatoryFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1MandatoryFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1Remark").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1Remark(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1RemarkChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1RemarkChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1Type").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1Type(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1ValidateMsg").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1ValidateMsg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1ValidateMsgChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1ValidateMsgChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field1ValidateRule").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField1ValidateRule(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2EnableFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2EnableFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2Event").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2Event(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2Label").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2Label(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2LabelChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2LabelChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2MandatoryFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2MandatoryFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2Remark").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2Remark(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2RemarkChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2RemarkChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2Type").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2Type(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2ValidateMsg").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2ValidateMsg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2ValidateMsgChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2ValidateMsgChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field2ValidateRule").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField2ValidateRule(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3EnableFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3EnableFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3Event").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3Event(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3Label").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3Label(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3LabelChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3LabelChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3MandatoryFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3MandatoryFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3Remark").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3Remark(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3RemarkChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3RemarkChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3Type").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3Type(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3ValidateMsg").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3ValidateMsg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3ValidateMsgChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3ValidateMsgChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field3ValidateRule").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField3ValidateRule(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4EnableFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4EnableFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4Event").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4Event(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4Label").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4Label(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4LabelChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4LabelChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4MandatoryFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4MandatoryFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4Remark").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4Remark(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4RemarkChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4RemarkChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4Type").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4Type(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4ValidateMsg").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4ValidateMsg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4ValidateMsgChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4ValidateMsgChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field4ValidateRule").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField4ValidateRule(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5EnableFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5EnableFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5Event").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5Event(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5Label").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5Label(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5LabelChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5LabelChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5MandatoryFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5MandatoryFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5Remark").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5Remark(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5RemarkChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5RemarkChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5Type").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5Type(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5ValidateMsg").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5ValidateMsg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5ValidateMsgChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5ValidateMsgChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","field5ValidateRule").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setField5ValidateRule(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","imageId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImageId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setImageId(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setImageId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","imageSmallId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImageSmallId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setImageSmallId(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setImageSmallId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","lupdDttmMs").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"lupdDttmMs" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLupdDttmMs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setLupdDttmMs(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","name").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","nameChi").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNameChi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","priceEditableFlag").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPriceEditableFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","qty").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQty(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setQty(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setQty(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","qtyHold").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQtyHold(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setQtyHold(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setQtyHold(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","sid").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSid(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setSid(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setSid(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","trackStock").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"trackStock" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTrackStock(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","videoId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVideoId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setVideoId(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setVideoId(java.lang.Integer.MIN_VALUE);
                                           
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
           
    