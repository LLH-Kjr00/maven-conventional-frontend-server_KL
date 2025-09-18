
/**
 * PromotionDetailInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.cmt.vending.ws.obj.xsd;
            

            /**
            *  PromotionDetailInfo bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class PromotionDetailInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = PromotionDetailInfo
                Namespace URI = http://obj.ws.vending.cmt.com/xsd
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for DailyFlag
                        */

                        
                                    protected boolean localDailyFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDailyFlagTracker = false ;

                           public boolean isDailyFlagSpecified(){
                               return localDailyFlagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getDailyFlag(){
                               return localDailyFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DailyFlag
                               */
                               public void setDailyFlag(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localDailyFlagTracker =
                                       true;
                                   
                                            this.localDailyFlag=param;
                                    

                               }
                            

                        /**
                        * field for DiscountAmount
                        */

                        
                                    protected java.math.BigDecimal localDiscountAmount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDiscountAmountTracker = false ;

                           public boolean isDiscountAmountSpecified(){
                               return localDiscountAmountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getDiscountAmount(){
                               return localDiscountAmount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DiscountAmount
                               */
                               public void setDiscountAmount(java.math.BigDecimal param){
                            localDiscountAmountTracker = true;
                                   
                                            this.localDiscountAmount=param;
                                    

                               }
                            

                        /**
                        * field for DiscountPercentage
                        */

                        
                                    protected java.math.BigDecimal localDiscountPercentage ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDiscountPercentageTracker = false ;

                           public boolean isDiscountPercentageSpecified(){
                               return localDiscountPercentageTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getDiscountPercentage(){
                               return localDiscountPercentage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DiscountPercentage
                               */
                               public void setDiscountPercentage(java.math.BigDecimal param){
                            localDiscountPercentageTracker = true;
                                   
                                            this.localDiscountPercentage=param;
                                    

                               }
                            

                        /**
                        * field for EffDateMs
                        */

                        
                                    protected long localEffDateMs ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEffDateMsTracker = false ;

                           public boolean isEffDateMsSpecified(){
                               return localEffDateMsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getEffDateMs(){
                               return localEffDateMs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EffDateMs
                               */
                               public void setEffDateMs(long param){
                            
                                       // setting primitive attribute tracker to true
                                       localEffDateMsTracker =
                                       param != java.lang.Long.MIN_VALUE;
                                   
                                            this.localEffDateMs=param;
                                    

                               }
                            

                        /**
                        * field for ExpDateMs
                        */

                        
                                    protected long localExpDateMs ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExpDateMsTracker = false ;

                           public boolean isExpDateMsSpecified(){
                               return localExpDateMsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getExpDateMs(){
                               return localExpDateMs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ExpDateMs
                               */
                               public void setExpDateMs(long param){
                            
                                       // setting primitive attribute tracker to true
                                       localExpDateMsTracker =
                                       param != java.lang.Long.MIN_VALUE;
                                   
                                            this.localExpDateMs=param;
                                    

                               }
                            

                        /**
                        * field for MaxQty
                        */

                        
                                    protected int localMaxQty ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMaxQtyTracker = false ;

                           public boolean isMaxQtySpecified(){
                               return localMaxQtyTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMaxQty(){
                               return localMaxQty;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaxQty
                               */
                               public void setMaxQty(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localMaxQtyTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localMaxQty=param;
                                    

                               }
                            

                        /**
                        * field for PromotionDtlId
                        */

                        
                                    protected int localPromotionDtlId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPromotionDtlIdTracker = false ;

                           public boolean isPromotionDtlIdSpecified(){
                               return localPromotionDtlIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getPromotionDtlId(){
                               return localPromotionDtlId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PromotionDtlId
                               */
                               public void setPromotionDtlId(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localPromotionDtlIdTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localPromotionDtlId=param;
                                    

                               }
                            

                        /**
                        * field for PromotionTypeId
                        */

                        
                                    protected int localPromotionTypeId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPromotionTypeIdTracker = false ;

                           public boolean isPromotionTypeIdSpecified(){
                               return localPromotionTypeIdTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getPromotionTypeId(){
                               return localPromotionTypeId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PromotionTypeId
                               */
                               public void setPromotionTypeId(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localPromotionTypeIdTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localPromotionTypeId=param;
                                    

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
                           namespacePrefix+":PromotionDetailInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "PromotionDetailInfo",
                           xmlWriter);
                   }

               
                   }
                if (localDailyFlagTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "dailyFlag", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("dailyFlag cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDailyFlag));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDiscountAmountTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "discountAmount", xmlWriter);
                             

                                          if (localDiscountAmount==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDiscountAmount));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDiscountPercentageTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "discountPercentage", xmlWriter);
                             

                                          if (localDiscountPercentage==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDiscountPercentage));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEffDateMsTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "effDateMs", xmlWriter);
                             
                                               if (localEffDateMs==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("effDateMs cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEffDateMs));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localExpDateMsTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "expDateMs", xmlWriter);
                             
                                               if (localExpDateMs==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("expDateMs cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localExpDateMs));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMaxQtyTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "maxQty", xmlWriter);
                             
                                               if (localMaxQty==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("maxQty cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxQty));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPromotionDtlIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "promotionDtlId", xmlWriter);
                             
                                               if (localPromotionDtlId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("promotionDtlId cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPromotionDtlId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPromotionTypeIdTracker){
                                    namespace = "http://obj.ws.vending.cmt.com/xsd";
                                    writeStartElement(null, namespace, "promotionTypeId", xmlWriter);
                             
                                               if (localPromotionTypeId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("promotionTypeId cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPromotionTypeId));
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

                 if (localDailyFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "dailyFlag"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDailyFlag));
                            } if (localDiscountAmountTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "discountAmount"));
                                 
                                         elementList.add(localDiscountAmount==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDiscountAmount));
                                    } if (localDiscountPercentageTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "discountPercentage"));
                                 
                                         elementList.add(localDiscountPercentage==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDiscountPercentage));
                                    } if (localEffDateMsTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "effDateMs"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEffDateMs));
                            } if (localExpDateMsTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "expDateMs"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localExpDateMs));
                            } if (localMaxQtyTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "maxQty"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxQty));
                            } if (localPromotionDtlIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "promotionDtlId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPromotionDtlId));
                            } if (localPromotionTypeIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd",
                                                                      "promotionTypeId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPromotionTypeId));
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
        public static PromotionDetailInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            PromotionDetailInfo object =
                new PromotionDetailInfo();

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
                    
                            if (!"PromotionDetailInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (PromotionDetailInfo)com.cmt.vending.ws.obj.xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","dailyFlag").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"dailyFlag" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDailyFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","discountAmount").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDiscountAmount(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","discountPercentage").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDiscountPercentage(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","effDateMs").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"effDateMs" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEffDateMs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setEffDateMs(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","expDateMs").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"expDateMs" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setExpDateMs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setExpDateMs(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","maxQty").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"maxQty" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMaxQty(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMaxQty(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","promotionDtlId").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"promotionDtlId" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPromotionDtlId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setPromotionDtlId(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://obj.ws.vending.cmt.com/xsd","promotionTypeId").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"promotionTypeId" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPromotionTypeId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setPromotionTypeId(java.lang.Integer.MIN_VALUE);
                                           
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
           
    