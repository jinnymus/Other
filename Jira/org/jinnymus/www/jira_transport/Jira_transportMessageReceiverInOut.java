
/**
 * Jira_transportMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
        package org.jinnymus.www.jira_transport;

        /**
        *  Jira_transportMessageReceiverInOut message receiver
        */

        public class Jira_transportMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        Jira_transportSkeletonInterface skel = (Jira_transportSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)){

        

            if("uploadToJira".equals(methodName)){
                
                org.jinnymus.www.jira_transport.UploadResponseToJira uploadResponseToJira5 = null;
	                        org.jinnymus.www.jira_transport.UploadRequestToJira wrappedParam =
                                                             (org.jinnymus.www.jira_transport.UploadRequestToJira)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.jinnymus.www.jira_transport.UploadRequestToJira.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               uploadResponseToJira5 =
                                                   
                                                   
                                                         skel.uploadToJira(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), uploadResponseToJira5, false);
                                    } else 

            if("uploadToALM".equals(methodName)){
                
                org.jinnymus.www.jira_transport.UploadResponseToALM uploadResponseToALM7 = null;
	                        org.jinnymus.www.jira_transport.UploadRequestToALM wrappedParam =
                                                             (org.jinnymus.www.jira_transport.UploadRequestToALM)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.jinnymus.www.jira_transport.UploadRequestToALM.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               uploadResponseToALM7 =
                                                   
                                                   
                                                         skel.uploadToALM(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), uploadResponseToALM7, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(org.jinnymus.www.jira_transport.UploadRequestToJira param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.jinnymus.www.jira_transport.UploadRequestToJira.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.jinnymus.www.jira_transport.UploadResponseToJira param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.jinnymus.www.jira_transport.UploadResponseToJira.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.jinnymus.www.jira_transport.UploadRequestToALM param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.jinnymus.www.jira_transport.UploadRequestToALM.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.jinnymus.www.jira_transport.UploadResponseToALM param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.jinnymus.www.jira_transport.UploadResponseToALM.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.jinnymus.www.jira_transport.UploadResponseToJira param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.jinnymus.www.jira_transport.UploadResponseToJira.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.jinnymus.www.jira_transport.UploadResponseToJira wrapuploadToJira(){
                                org.jinnymus.www.jira_transport.UploadResponseToJira wrappedElement = new org.jinnymus.www.jira_transport.UploadResponseToJira();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.jinnymus.www.jira_transport.UploadResponseToALM param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.jinnymus.www.jira_transport.UploadResponseToALM.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.jinnymus.www.jira_transport.UploadResponseToALM wrapuploadToALM(){
                                org.jinnymus.www.jira_transport.UploadResponseToALM wrappedElement = new org.jinnymus.www.jira_transport.UploadResponseToALM();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (org.jinnymus.www.jira_transport.UploadRequestToJira.class.equals(type)){
                
                           return org.jinnymus.www.jira_transport.UploadRequestToJira.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.jinnymus.www.jira_transport.UploadResponseToJira.class.equals(type)){
                
                           return org.jinnymus.www.jira_transport.UploadResponseToJira.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.jinnymus.www.jira_transport.UploadRequestToALM.class.equals(type)){
                
                           return org.jinnymus.www.jira_transport.UploadRequestToALM.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.jinnymus.www.jira_transport.UploadResponseToALM.class.equals(type)){
                
                           return org.jinnymus.www.jira_transport.UploadResponseToALM.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    