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
  
  public void deactivateSubscriber(int in0, java.lang.String in1) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.deactivateSubscriber(in0, in1);
  }
  
  public void activateSubscriber(int in0, java.lang.String in1) throws java.rmi.RemoteException, my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail{
    if (mRBTProvisionService_PortType == null)
      _initMRBTProvisionServiceProxy();
    mRBTProvisionService_PortType.activateSubscriber(in0, in1);
  }
  
  
}