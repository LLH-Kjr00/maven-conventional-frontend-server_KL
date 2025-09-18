
/**
 * RedemptionInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.cmt.vending.ws.obj.xsd;
            

            /**
            *  RedemptionInfo bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class RedemptionInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = RedemptionInfo
                Namespace URI = http://obj.ws.vending.cmt.com/xsd
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for CreDttm
                        */

                        
                                    protected java.util.Date localCreDttm ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCreDttmTracker = false ;

                           public boolean isCreDttmSpecified(){
                               return localCreDttmTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getCreDttm(){
                               return localCreDttm;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CreDttm
                               */
                               public void setCreDttm(java.util.Date param){
                            localCreDttmTracker = true;
                                   
                                            this.localCreDttm=param;
                                    

                               }
                            

                        /**
                        * field for CreUser
                        */

                        
                                    protected java.lang.String localCreUser ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCreUserTracker = false ;

                           public boolean isCreUserSpecified(){
                               return localCreUserTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCreUser(){
                               return localCreUser;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CreUser
                               */
                               public void setCreUser(java.lang.String param){
                            localCreUserTracker = true;
                                   
                                            this.localCreUser=param;
                                    

                               }
                            

                        /**
                        * field for EffDttm
                        */

                        
                                    protected java.util.Date localEffDttm ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEffDttmTracker = false ;

                           public boolean isEffDttmSpecified(){
                               return localEffDttmTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getEffDttm(){
                               return localEffDttm;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EffDttm
                               */
                               public void setEffDttm(java.util.Date param){
                            localEffDttmTracker = true;
                                   
                                            this.localEffDttm=param;
                                    

                               }
                            

                        /**
                        * field for ExpDttm
                        */

                        
                                    protected java.util.Date localExpDttm ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExpDttmTracker = false ;

                           public boolean isExpDttmSpecified(){
                               return localExpDttmTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getExpDttm(){
                               return localExpDttm;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ExpDttm
                               */
                               public void setExpDttm(java.util.Date param){
                            localExpDttmTracker = true;
                                   
                                            this.localExpDttm=param;
                                    

                               }
                            

                        /**
                        * field for LupdDttm
                        */

                        
                                    protected java.util.Date localLupdDttm ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLupdDttmTracker = false ;

                           public boolean isLupdDttmSpecified(){
                               return localLupdDttmTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getLupdDttm(){
                               return localLupdDttm;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LupdDttm
                               */
                               public void setLupdDttm(java.util.Date param){
                            localLupdDttmTracker = true;
                                   
                                            this.localLupdDttm=param;
                                    

                               }
                            

                        /**
                        * field for LupdUser
                        */

                        
                                    protected java.lang.String localLupdUser ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLupdUserTracker = false ;

                           public boolean isLupdUserSpecified(){
                               return localLupdUserTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLupdUser(){
                               return localLupdUser;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LupdUser
                               */
                               public void setLupdUser(java.lang.String param){
                            localLupdUserTracker = true;
                                   
                                            this.localLupdUser=param;
                                    

                               }
                            

                        /**
                        * field for ProductId
                        */

                        
                                    protected int localProductId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProductIdTracker = false ;

                           public boolean isProductIdSpecified(){
                               return localProductIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getProductId(){
                               return localProductId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ProductId
                               */
                               public void setProductId(int param){
                            localProductIdTracker = true;
                                   
                                            this.localProductId=param;
                                    

                               }
                            

                        /**
                        * field for RedCode
                        */

                        
                                    protected java.lang.String localRedCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRedCodeTracker = false ;

                           public boolean isRedCodeSpecified(){
                               return localRedCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRedCode(){
                               return localRedCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RedCode
                               */
                               public void setRedCode(java.lang.String param){
                            localRedCodeTracker = true;
                                   
                                            this.localRedCode=param;
                                    

                               }
                            

                        /**
                        * field for RedDttm
                        */

                        
                                    protected java.util.Date localRedDttm ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRedDttmTracker = false ;

                           public boolean isRedDttmSpecified(){
                               return localRedDttmTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getRedDttm(){
                               return localRedDttm;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RedDttm
                               */
                               public void setRedDttm(java.util.Date param){
                            localRedDttmTracker = true;
                                   
                                            this.localRedDttm=param;
                                    

                               }
                            

                        /**
                        * field for Remark
                        */

                        
                                    protected java.lang.String localRemark ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRemarkTracker = false ;

                           public boolean isRemarkSpecified(){
                               return localRemarkTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRemark(){
                               return localRemark;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Remark
                               */
                               public void setRemark(java.lang.String param){
                            localRemarkTracker = true;
                                   
                                            this.localRemark=param;
                                    

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
                           namespacePrefix+":RedemptionInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "RedemptionInfo",
                           xmlWriter);
                   }

               
                   }
                if (localCreDttmTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "creDttm", xmlWriter);
                             

                                          if (localCreDttm==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCreDttm));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCreUserTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "creUser", xmlWriter);
                             

                                          if (localCreUser==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCreUser);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEffDttmTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "effDttm", xmlWriter);
                             

                                          if (localEffDttm==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEffDttm));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localExpDttmTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "expDttm", xmlWriter);
                             

                                          if (localExpDttm==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localExpDttm));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLupdDttmTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "lupdDttm", xmlWriter);
                             

                                          if (localLupdDttm==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLupdDttm));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLupdUserTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "lupdUser", xmlWriter);
                             

                                          if (localLupdUser==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLupdUser);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localProductIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "productId", xmlWriter);
                             
                                               if (localProductId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProductId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRedCodeTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "redCode", xmlWriter);
                             

                                          if (localRedCode==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRedCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRedDttmTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "redDttm", xmlWriter);
                             

                                          if (localRedDttm==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRedDttm));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRemarkTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "remark", xmlWriter);
                             

                                          if (localRemark==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRemark);
                                            
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

                 if (localCreDttmTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "creDttm"));
                                 
                                         elementList.add(localCreDttm==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCreDttm));
                                    } if (localCreUserTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "creUser"));
                                 
                                         elementList.add(localCreUser==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCreUser));
                                    } if (localEffDttmTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "effDttm"));
                                 
                                         elementList.add(localEffDttm==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEffDttm));
                                    } if (localExpDttmTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "expDttm"));
                                 
                                         elementList.add(localExpDttm==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localExpDttm));
                                    } if (localLupdDttmTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "lupdDttm"));
                                 
                                         elementList.add(localLupdDttm==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLupdDttm));
                                    } if (localLupdUserTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "lupdUser"));
                                 
                                         elementList.add(localLupdUser==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLupdUser));
                                    } if (localProductIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "productId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProductId));
                            } if (localRedCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "redCode"));
                                 
                                         elementList.add(localRedCode==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRedCode));
                                    } if (localRedDttmTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "redDttm"));
                                 
                                         elementList.add(localRedDttm==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRedDttm));
                                    } if (localRemarkTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "remark"));
                                 
                                         elementList.add(localRemark==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRemark));
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
        public static RedemptionInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            RedemptionInfo object =
                new RedemptionInfo();

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
                    
                            if (!"RedemptionInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RedemptionInfo)com.cmt.vending.ws.obj.xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","creDttm").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCreDttm(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","creUser").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCreUser(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","effDttm").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEffDttm(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","expDttm").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setExpDttm(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","lupdDttm").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLupdDttm(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","lupdUser").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLupdUser(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","productId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProductId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setProductId(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setProductId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","redCode").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRedCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","redDttm").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRedDttm(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","remark").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRemark(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
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
           
    