package vms;

public class IvmsbossPortTypeProxy implements vms.IvmsbossPortType {
  private String _endpoint = null;
  private vms.IvmsbossPortType ivmsbossPortType = null;
  
  public IvmsbossPortTypeProxy() {
    _initIvmsbossPortTypeProxy();
  }
  
  public IvmsbossPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initIvmsbossPortTypeProxy();
  }
  
  private void _initIvmsbossPortTypeProxy() {
    try {
      ivmsbossPortType = (new vms.IvmsbossLocator()).getIvmsbossHttpPort();
      if (ivmsbossPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ivmsbossPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ivmsbossPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ivmsbossPortType != null)
      ((javax.xml.rpc.Stub)ivmsbossPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public vms.IvmsbossPortType getIvmsbossPortType() {
    if (ivmsbossPortType == null)
      _initIvmsbossPortTypeProxy();
    return ivmsbossPortType;
  }
  
  public vms.CreateUserResponse createUser(vms.CreateUserReqt parameters) throws java.rmi.RemoteException{
    if (ivmsbossPortType == null)
      _initIvmsbossPortTypeProxy();
    return ivmsbossPortType.createUser(parameters);
  }
  
  public vms.DeleteUserResponse deleteUser(vms.DeleteUserReqt parameters) throws java.rmi.RemoteException{
    if (ivmsbossPortType == null)
      _initIvmsbossPortTypeProxy();
    return ivmsbossPortType.deleteUser(parameters);
  }
  
  public vms.QueryUserResponse queryUser(vms.QueryUserReqt parameters) throws java.rmi.RemoteException{
    if (ivmsbossPortType == null)
      _initIvmsbossPortTypeProxy();
    return ivmsbossPortType.queryUser(parameters);
  }
  
  public vms.ModifyUserResponse modifyUser(vms.ModifyUserReqt parameters) throws java.rmi.RemoteException{
    if (ivmsbossPortType == null)
      _initIvmsbossPortTypeProxy();
    return ivmsbossPortType.modifyUser(parameters);
  }
  
  public vms.QueryOperidResponse queryUseroperid(vms.QueryOperidReqt parameters) throws java.rmi.RemoteException{
    if (ivmsbossPortType == null)
      _initIvmsbossPortTypeProxy();
    return ivmsbossPortType.queryUseroperid(parameters);
  }
  
  
}