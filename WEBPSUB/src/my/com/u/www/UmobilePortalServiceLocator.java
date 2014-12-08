/**
 * UmobilePortalServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package my.com.u.www;

public class UmobilePortalServiceLocator extends org.apache.axis.client.Service implements my.com.u.www.UmobilePortalService {

    public UmobilePortalServiceLocator() {
    }


    public UmobilePortalServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UmobilePortalServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UmobilePortalServicePort
    private java.lang.String UmobilePortalServicePort_address = "http://10.30.25.62:8090/umobilePortal/UmobilePortalService";

    public java.lang.String getUmobilePortalServicePortAddress() {
        return UmobilePortalServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UmobilePortalServicePortWSDDServiceName = "UmobilePortalServicePort";

    public java.lang.String getUmobilePortalServicePortWSDDServiceName() {
        return UmobilePortalServicePortWSDDServiceName;
    }

    public void setUmobilePortalServicePortWSDDServiceName(java.lang.String name) {
        UmobilePortalServicePortWSDDServiceName = name;
    }

    public my.com.u.www.UmobilePortalPortType getUmobilePortalServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UmobilePortalServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUmobilePortalServicePort(endpoint);
    }

    public my.com.u.www.UmobilePortalPortType getUmobilePortalServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            my.com.u.www.UmobilePortalServiceSoapBindingStub _stub = new my.com.u.www.UmobilePortalServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getUmobilePortalServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUmobilePortalServicePortEndpointAddress(java.lang.String address) {
        UmobilePortalServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (my.com.u.www.UmobilePortalPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                my.com.u.www.UmobilePortalServiceSoapBindingStub _stub = new my.com.u.www.UmobilePortalServiceSoapBindingStub(new java.net.URL(UmobilePortalServicePort_address), this);
                _stub.setPortName(getUmobilePortalServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UmobilePortalServicePort".equals(inputPortName)) {
            return getUmobilePortalServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.u.com.my/", "UmobilePortalService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.u.com.my/", "UmobilePortalServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UmobilePortalServicePort".equals(portName)) {
            setUmobilePortalServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
