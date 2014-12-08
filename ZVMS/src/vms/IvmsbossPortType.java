/**
 * IvmsbossPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package vms;

public interface IvmsbossPortType extends java.rmi.Remote {
    public vms.CreateUserResponse createUser(vms.CreateUserReqt parameters) throws java.rmi.RemoteException;
    public vms.DeleteUserResponse deleteUser(vms.DeleteUserReqt parameters) throws java.rmi.RemoteException;
    public vms.QueryUserResponse queryUser(vms.QueryUserReqt parameters) throws java.rmi.RemoteException;
    public vms.ModifyUserResponse modifyUser(vms.ModifyUserReqt parameters) throws java.rmi.RemoteException;
    public vms.QueryOperidResponse queryUseroperid(vms.QueryOperidReqt parameters) throws java.rmi.RemoteException;
}
