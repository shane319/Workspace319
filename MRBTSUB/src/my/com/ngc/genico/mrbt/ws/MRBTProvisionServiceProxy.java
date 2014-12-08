package my.com.ngc.genico.mrbt.ws;

public class MRBTProvisionServiceProxy implements my.com.ngc.genico.mrbt.ws.MRBTProvisionService_PortType {
  private String _endpoint = null;
  private my.com.ngc.genico.mrbt.ws.MRBTProvisionService_PortType mRBTProvisionService_PortType = null;
  
  public MRBTProvisionServiceProxy() {
    _initMRBTProvisionServiceProxy();
  }
  
  public MRBTProvisionServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initMRBTProvisionServiceProxy();
  }
  
  private void _initMRBTProvisionServiceProxy() {
    try {
      mRBTProvisionService_PortType = (new my.com.ngc.genico.mrbt.ws.MRBTProvisionService_ServiceLocator()).getMRBTProvisionServiceHttpPort();
      if (mRBTProvisionService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mRBTProvisionService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mRBTProvisionService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mRBTProvisionService_PortType != null)
      ((javax.xml.rpc.Stub)mRBTProvisionService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public my.com.ngc.genico.mrbt.ws.MRBTProvisionService_PortType getMRBTProvisionService_PortType() {
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    return mRBTProvisionService_PortType;
  }
  
  public void updateDedication(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, int in6, boolean in7) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.updateDedication(in0, in1, in2, in3, in4, in5, in6, in7);
  }
  
  public void suspendSubscriber(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.suspendSubscriber(in0, in1, in2, in3);
  }
  
  public void removeSpecialOccasion(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, int in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.removeSpecialOccasion(in0, in1, in2, in3, in4);
  }
  
  public void addDedication(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, boolean in6) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.addDedication(in0, in1, in2, in3, in4, in5, in6);
  }
  
  public int getMusicBoxItemCount() throws java.rmi.RemoteException{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    return mRBTProvisionService_PortType.getMusicBoxItemCount();
  }
  
  public void removeDedication(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, int in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.removeDedication(in0, in1, in2, in3, in4);
  }
  
  public void updateSubscriberLanguage(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.updateSubscriberLanguage(in0, in1, in2, in3, in4);
  }
  
  public int getTimeBasedItemCount() throws java.rmi.RemoteException{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    return mRBTProvisionService_PortType.getTimeBasedItemCount();
  }
  
  public void updateMusicBox(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, int in5, boolean in6) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.updateMusicBox(in0, in1, in2, in3, in4, in5, in6);
  }
  
  public void updateTimeBased(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, int in5, int in6, int in7, boolean in8) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.updateTimeBased(in0, in1, in2, in3, in4, in5, in6, in7, in8);
  }
  
  public void addSpecialOccasion(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, java.lang.String in6, boolean in7) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.addSpecialOccasion(in0, in1, in2, in3, in4, in5, in6, in7);
  }
  
  public void activateSubscriber(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.activateSubscriber(in0, in1, in2, in3);
  }
  
  public void addTimeBased(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, int in5, int in6, boolean in7) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.addTimeBased(in0, in1, in2, in3, in4, in5, in6, in7);
  }
  
  public void deactivateSubscriber(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.deactivateSubscriber(in0, in1, in2, in3);
  }
  
  public void addMusicLibrary(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.addMusicLibrary(in0, in1, in2, in3, in4);
  }
  
  public void updateSpecialOccasion(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, java.lang.String in6, int in7, boolean in8) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.updateSpecialOccasion(in0, in1, in2, in3, in4, in5, in6, in7, in8);
  }
  
  public void removeMusicBox(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, int in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.removeMusicBox(in0, in1, in2, in3, in4);
  }
  
  public int getSpecialOccasionItemCount() throws java.rmi.RemoteException{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    return mRBTProvisionService_PortType.getSpecialOccasionItemCount();
  }
  
  public int getDedicationItemCount() throws java.rmi.RemoteException{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    return mRBTProvisionService_PortType.getDedicationItemCount();
  }
  
  public void reactivateSubscriber(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.reactivateSubscriber(in0, in1, in2, in3);
  }
  
  public void removeTimeBased(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, int in4) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.removeTimeBased(in0, in1, in2, in3, in4);
  }
  
  public void addMusicBox(java.lang.String in0, long in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, boolean in5) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.addMusicBox(in0, in1, in2, in3, in4, in5);
  }
  
  
}