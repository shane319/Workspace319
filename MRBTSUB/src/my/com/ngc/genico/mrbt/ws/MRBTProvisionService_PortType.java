/**
 * MRBTProvisionService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package my.com.ngc.genico.mrbt.ws;

public interface MRBTProvisionService_PortType extends java.rmi.Remote {
    public void deactivateSubscriber(int in0, java.lang.String in1) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void activateSubscriber(int in0, java.lang.String in1) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
}
