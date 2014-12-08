package my.com.u.www;

public class UmobilePortalPortTypeProxy implements my.com.u.www.UmobilePortalPortType {
  private String _endpoint = null;
  private my.com.u.www.UmobilePortalPortType umobilePortalPortType = null;
  
  public UmobilePortalPortTypeProxy() {
    _initUmobilePortalPortTypeProxy();
  }
  
  public UmobilePortalPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initUmobilePortalPortTypeProxy();
  }
  
  private void _initUmobilePortalPortTypeProxy() {
    try {
      umobilePortalPortType = (new my.com.u.www.UmobilePortalServiceLocator()).getUmobilePortalServicePort();
      if (umobilePortalPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)umobilePortalPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)umobilePortalPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (umobilePortalPortType != null)
      ((javax.xml.rpc.Stub)umobilePortalPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public my.com.u.www.UmobilePortalPortType getUmobilePortalPortType() {
    if (umobilePortalPortType == null)
      _initUmobilePortalPortTypeProxy();
    return umobilePortalPortType;
  }
  
  public data.ws.wsserver.umobileportal.ericsson.com.Response changePortalUserPassword(data.ws.wsserver.umobileportal.ericsson.com.Request request) throws java.rmi.RemoteException{
    if (umobilePortalPortType == null)
      _initUmobilePortalPortTypeProxy();
    return umobilePortalPortType.changePortalUserPassword(request);
  }
  
  public data.ws.wsserver.umobileportal.ericsson.com.Response deletePortalUser(data.ws.wsserver.umobileportal.ericsson.com.Request request) throws java.rmi.RemoteException{
    if (umobilePortalPortType == null)
      _initUmobilePortalPortTypeProxy();
    return umobilePortalPortType.deletePortalUser(request);
  }
  
  public data.ws.wsserver.umobileportal.ericsson.com.Response echo(data.ws.wsserver.umobileportal.ericsson.com.Request request) throws java.rmi.RemoteException{
    if (umobilePortalPortType == null)
      _initUmobilePortalPortTypeProxy();
    return umobilePortalPortType.echo(request);
  }
  
  public data.ws.wsserver.umobileportal.ericsson.com.Response addNewPortalUser(data.ws.wsserver.umobileportal.ericsson.com.Request request) throws java.rmi.RemoteException{
    if (umobilePortalPortType == null)
      _initUmobilePortalPortTypeProxy();
    return umobilePortalPortType.addNewPortalUser(request);
  }
  
  public data.ws.wsserver.umobileportal.ericsson.com.QueryUserProfileResponse queryUserProfile(data.ws.wsserver.umobileportal.ericsson.com.QueryUserProfileRequest request) throws java.rmi.RemoteException{
    if (umobilePortalPortType == null)
      _initUmobilePortalPortTypeProxy();
    return umobilePortalPortType.queryUserProfile(request);
  }
  
  
}