/**
 * MRBTProvisionService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package my.com.ngc.genico.mrbt.ws;

public class MRBTProvisionService_ServiceLocator extends org.apache.axis.client.Service implements my.com.ngc.genico.mrbt.ws.MRBTProvisionService_Service {

    public MRBTProvisionService_ServiceLocator() {
    }


    public MRBTProvisionService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MRBTProvisionService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MRBTProvisionServiceHttpPort
    private java.lang.String MRBTProvisionServiceHttpPort_address = "http://192.168.99.69:8080/genico-mrbt-ws/MRBTProvisionService";

    public java.lang.String getMRBTProvisionServiceHttpPortAddress() {
        return MRBTProvisionServiceHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MRBTProvisionServiceHttpPortWSDDServiceName = "MRBTProvisionServiceHttpPort";

    public java.lang.String getMRBTProvisionServiceHttpPortWSDDServiceName() {
        return MRBTProvisionServiceHttpPortWSDDServiceName;
    }

    public void setMRBTProvisionServiceHttpPortWSDDServiceName(java.lang.String name) {
        MRBTProvisionServiceHttpPortWSDDServiceName = name;
    }

    public my.com.ngc.genico.mrbt.ws.MRBTProvisionService_PortType getMRBTProvisionServiceHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MRBTProvisionServiceHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMRBTProvisionServiceHttpPort(endpoint);
    }

    public my.com.ngc.genico.mrbt.ws.MRBTProvisionService_PortType getMRBTProvisionServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            my.com.ngc.genico.mrbt.ws.MRBTProvisionServiceHttpBindingStub _stub = new my.com.ngc.genico.mrbt.ws.MRBTProvisionServiceHttpBindingStub(portAddress, this);
            _stub.setPortName(getMRBTProvisionServiceHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMRBTProvisionServiceHttpPortEndpointAddress(java.lang.String address) {
        MRBTProvisionServiceHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (my.com.ngc.genico.mrbt.ws.MRBTProvisionService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                my.com.ngc.genico.mrbt.ws.MRBTProvisionServiceHttpBindingStub _stub = new my.com.ngc.genico.mrbt.ws.MRBTProvisionServiceHttpBindingStub(new java.net.URL(MRBTProvisionServiceHttpPort_address), this);
                _stub.setPortName(getMRBTProvisionServiceHttpPortWSDDServiceName());
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
        if ("MRBTProvisionServiceHttpPort".equals(inputPortName)) {
            return getMRBTProvisionServiceHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.mrbt.genico.ngc.com.my", "MRBTProvisionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.mrbt.genico.ngc.com.my", "MRBTProvisionServiceHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MRBTProvisionServiceHttpPort".equals(portName)) {
            setMRBTProvisionServiceHttpPortEndpointAddress(address);
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
