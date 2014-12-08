/**
 * UmobilePortalPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package my.com.u.www;

public interface UmobilePortalPortType extends java.rmi.Remote {
    public data.ws.wsserver.umobileportal.ericsson.com.Response changePortalUserPassword(data.ws.wsserver.umobileportal.ericsson.com.Request request) throws java.rmi.RemoteException;
    public data.ws.wsserver.umobileportal.ericsson.com.Response deletePortalUser(data.ws.wsserver.umobileportal.ericsson.com.Request request) throws java.rmi.RemoteException;
    public data.ws.wsserver.umobileportal.ericsson.com.Response echo(data.ws.wsserver.umobileportal.ericsson.com.Request request) throws java.rmi.RemoteException;
    public data.ws.wsserver.umobileportal.ericsson.com.Response addNewPortalUser(data.ws.wsserver.umobileportal.ericsson.com.Request request) throws java.rmi.RemoteException;
    public data.ws.wsserver.umobileportal.ericsson.com.QueryUserProfileResponse queryUserProfile(data.ws.wsserver.umobileportal.ericsson.com.QueryUserProfileRequest request) throws java.rmi.RemoteException;
}
