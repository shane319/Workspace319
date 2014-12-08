package com.ericsson.ema.downstream.service;

import java.lang.reflect.InvocationTargetException;
import java.net.SocketTimeoutException;
import java.rmi.RemoteException;
import org.apache.axis.AxisFault;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import vms.CreateUserReqt;
import vms.CreateUserResponse;
import vms.DeleteUserReqt;
import vms.DeleteUserResponse;
import vms.IvmsbossHttpBindingStub;
import vms.ModifyUserReqt;
import vms.ModifyUserResponse;
import vms.QueryOperidReqt;
import vms.QueryOperidResponse;
import vms.QueryUserReqt;
import vms.QueryUserResponse;

import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.constant.ProvisioningConstant;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.handler.ErrorHandler;

public class ProvisioningService implements JavaLinkService {
	static final Logger logger = Logger.getLogger(ProvisioningService.class);

	public Object processRequest(RequestBean requestBean)
			throws JavaLinkException {
		String operation = requestBean.getOperation();
		ErrorHandler errorHandler = new ErrorHandler();
		
		// Response Object from NE
		CreateUserResponse createUserResponse = null;
		DeleteUserResponse deleteUserResponse = null;
		ModifyUserResponse modifyUserResponse = null;
		QueryUserResponse queryUserResponse = null;
		QueryOperidResponse queryOperidResponse = null;

		
		//System.out.println("Inside ProcessRequest.....");
		
		
		if (operation.equals(ProvisioningConstant.INVOKES_API_CREATE_USER)) {
			try {
				createUserResponse = processCreateUser(requestBean);
				return createUserResponse;
			} catch (AxisFault e) {
				errorHandler.handleError(e);
			}  catch (RemoteException e) {
				errorHandler.handleError(e);
			} catch (IllegalAccessException e) {
				errorHandler.handleError(e);
			} catch (InvocationTargetException e) {
				errorHandler.handleError(e);
			}catch(Exception e){
				errorHandler.handleError(e);
			}
		} else if (operation
				.equals(ProvisioningConstant.INVOKES_API_MODIFY_USER)) {
			try {
				modifyUserResponse = processModifyUser(requestBean);
				return modifyUserResponse;
			} catch (AxisFault e) {
				errorHandler.handleError(e);
			}  catch (RemoteException e) {
				errorHandler.handleError(e);
			} catch (IllegalAccessException e) {
				errorHandler.handleError(e);
			} catch (InvocationTargetException e) {
				errorHandler.handleError(e);
			}
		} else if (operation
				.equals(ProvisioningConstant.INVOKES_API_DELETE_USER)) {
			try {
				deleteUserResponse = processDeleteUser(requestBean);
				return deleteUserResponse;
			} catch (AxisFault e) {
				errorHandler.handleError(e);
			} catch (RemoteException e) {
				errorHandler.handleError(e);
			} catch (IllegalAccessException e) {
				errorHandler.handleError(e);
			} catch (InvocationTargetException e) {
				errorHandler.handleError(e);
			}
		} else if (operation
				.equals(ProvisioningConstant.INVOKES_API_QUERY_USER)) {
			try {
				queryUserResponse = processQueryUser(requestBean);
				
				/*queryUserResponse = new QueryUserResponse();
				queryUserResponse.setResultcode(0);
				queryUserResponse.setServiceClass("2");
				queryUserResponse.setDescription("Success");*/
				return queryUserResponse;
			} catch (AxisFault e) {
				errorHandler.handleError(e);
			} catch (RemoteException e) {
				errorHandler.handleError(e);
			} catch (IllegalAccessException e) {
				errorHandler.handleError(e);
			} catch (InvocationTargetException e) {
				errorHandler.handleError(e);
			}
		}else if (operation
				.equals(ProvisioningConstant.INVOKES_API_QUERY_USER_OPER_ID)) {
			try {
				queryOperidResponse = processQueryUserOperId(requestBean);
				return queryOperidResponse;
			} catch (AxisFault e) {
				errorHandler.handleError(e);
			} catch (RemoteException e) {
				errorHandler.handleError(e);
			} catch (IllegalAccessException e) {
				errorHandler.handleError(e);
			} catch (InvocationTargetException e) {
				errorHandler.handleError(e);
			}
		}
		/*
		 * else
		 * if(operation.equals(ProvisioningConstant.INVOKES_API_QUERY_USER)){
		 * processQueryUser(requestBean); }else
		 * if(operation.equals(ProvisioningConstant
		 * .INVOKES_API_QUERY_USER_OPER_ID)){
		 * processQueryUserOperId(requestBean); }
		 */

		else {
			logger.error("Invoked API not found...");
			throw new JavaLinkException("API not found");
		}
		
		return null;
	}

	private CreateUserResponse processCreateUser(RequestBean requestBean)
			throws IllegalAccessException, InvocationTargetException,
			RemoteException {
		IvmsbossHttpBindingStub ivmsbossHttpBindingStub = new IvmsbossHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		
		// Subhasish Added 10-Apr-14
		ivmsbossHttpBindingStub.setTimeout(requestBean.getNeConfig().getTimeOut());
		
		
		CreateUserReqt createUserReqt = new CreateUserReqt();
		BeanUtils.copyProperties(createUserReqt, requestBean);
		CreateUserResponse createUserResponse = ivmsbossHttpBindingStub
				.createUser(createUserReqt);
		return createUserResponse;
	}

	private DeleteUserResponse processDeleteUser(RequestBean requestBean)
			throws IllegalAccessException, InvocationTargetException,
			RemoteException {
		IvmsbossHttpBindingStub ivmsbossHttpBindingStub = new IvmsbossHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		
		// Subhasish Added 10-Apr-14
		ivmsbossHttpBindingStub.setTimeout(requestBean.getNeConfig().getTimeOut());
		
		DeleteUserReqt deleteUserReqt = new DeleteUserReqt();
		BeanUtils.copyProperties(deleteUserReqt, requestBean);
		DeleteUserResponse deleteUserResponse = ivmsbossHttpBindingStub
				.deleteUser(deleteUserReqt);
		return deleteUserResponse;
	}

	private ModifyUserResponse processModifyUser(RequestBean requestBean)
			throws IllegalAccessException, InvocationTargetException,
			RemoteException {
		IvmsbossHttpBindingStub ivmsbossHttpBindingStub = new IvmsbossHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		
		// Subhasish Added 10-Apr-14
		ivmsbossHttpBindingStub.setTimeout(requestBean.getNeConfig().getTimeOut());
		
		ModifyUserReqt modifyUserReqt = new ModifyUserReqt();
		BeanUtils.copyProperties(modifyUserReqt, requestBean);
		ModifyUserResponse modifyUserResponse = ivmsbossHttpBindingStub
				.modifyUser(modifyUserReqt);
		return modifyUserResponse;
	}

	private QueryUserResponse processQueryUser(RequestBean requestBean)
			throws RemoteException, IllegalAccessException,
			InvocationTargetException {
		IvmsbossHttpBindingStub ivmsbossHttpBindingStub = new IvmsbossHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());

		// Subhasish Added 10-Apr-14
		ivmsbossHttpBindingStub.setTimeout(requestBean.getNeConfig().getTimeOut());
		
		QueryUserReqt queryUserReqt = new QueryUserReqt();
		BeanUtils.copyProperties(queryUserReqt, requestBean);
		QueryUserResponse queryUserResponse = ivmsbossHttpBindingStub
				.queryUser(queryUserReqt);

		return queryUserResponse;

	}

	private QueryOperidResponse processQueryUserOperId(RequestBean requestBean)
			throws IllegalAccessException, InvocationTargetException,
			RemoteException {
		IvmsbossHttpBindingStub ivmsbossHttpBindingStub = new IvmsbossHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());

		
		// Subhasish Added 10-Apr-14
		ivmsbossHttpBindingStub.setTimeout(requestBean.getNeConfig().getTimeOut());
		
		QueryOperidReqt queryOperidReqt = new QueryOperidReqt();
		BeanUtils.copyProperties(queryOperidReqt, requestBean);

		QueryOperidResponse queryOperidResponse = ivmsbossHttpBindingStub
				.queryUseroperid(queryOperidReqt);
		return queryOperidResponse;

	}

}
