/**
 * MRBTProvisionService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package my.com.ngc.genico.mrbt.ws;

public interface MRBTProvisionService_PortType extends java.rmi.Remote {
    public void updateDedication(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, int in6, boolean in7) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void suspendSubscriber(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void removeSpecialOccasion(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, int in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void addDedication(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, boolean in6) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public int getMusicBoxItemCount() throws java.rmi.RemoteException;
    public void removeDedication(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, int in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void updateSubscriberLanguage(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public int getTimeBasedItemCount() throws java.rmi.RemoteException;
    public void updateMusicBox(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, int in5, boolean in6) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void updateTimeBased(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, int in5, int in6, int in7, boolean in8) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void addSpecialOccasion(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, java.lang.String in6, boolean in7) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void activateSubscriber(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void addTimeBased(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, int in5, int in6, boolean in7) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void deactivateSubscriber(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void addMusicLibrary(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void updateSpecialOccasion(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, java.lang.String in6, int in7, boolean in8) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void removeMusicBox(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, int in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public int getSpecialOccasionItemCount() throws java.rmi.RemoteException;
    public int getDedicationItemCount() throws java.rmi.RemoteException;
    public void reactivateSubscriber(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void removeTimeBased(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, int in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
    public void addMusicBox(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, boolean in5) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;
}
