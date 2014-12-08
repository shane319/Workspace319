/*******************************************************************
 *
 * FILE NAME   : ProvisioningService.java
 *
 * DESCRIPTION : Provisioning functionality with NE has been embedded here.
 * 
 * DOCUMENTS   : 
 *
 * AUTHOR      : Subhasish Mondal(esumond)
 *
 * DATE        : Aug-2012
 *      
 *******************************************************************/
/*******************************************************************
 *
 * MODIFICATION HISTORY:
 *
 * 1. Name  :
 *    Date  :
 *    Change:
 *
 *************************************************************/

package com.ericsson.ema.downstream.service;

import java.io.IOException;
import java.rmi.RemoteException;

import my.com.ngc.genico.mrbt.ws.MRBTProvisionServiceHttpBindingStub;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.bean.ResponseBean;
import com.ericsson.ema.downstream.constant.ProvisioningConstant;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.mrbt.provisioning.ProvisioningStub;

public class ProvisioningService implements JavaLinkService {
	static final Logger logger = Logger.getLogger(ProvisioningService.class);

	// General method for all operation.
	// The connection between javalink and NE has done here.
	// Raw NE response has been captured and return to the Provisioning
	// Controller.

	public Object processRequest(RequestBean requestBean)
			throws JavaLinkException {
		String operation = requestBean.getOperation();
		Object object = null;
		if (operation.equalsIgnoreCase(ProvisioningConstant.INVOKES_API_ACTIVE)) {
			object = processSubscriberRequest(requestBean);
			return object;
			/*try {
				object = processActivateSubscriber(requestBean);
				
				return object;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				throw new JavaLinkException(e.getMessage());
			}*/
		} else if (operation
				.equalsIgnoreCase(ProvisioningConstant.INVOKES_API_DEACTIVE)) {
			
			object = processSubscriberRequest(requestBean);
			return object;
			
			/*try {
				object = processDeactivateSubscriber(requestBean);
				return object;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				throw new JavaLinkException(e.getMessage());
			}*/
		} else if (operation
				.equalsIgnoreCase(ProvisioningConstant.INVOKES_API_SUSPEND)) {
			object = processSubscriberRequest(requestBean);
			return object;
			
			/*try {
				object = processSuspendSubscriber(requestBean);
				return object;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				throw new JavaLinkException(e.getMessage());
			}*/
		} else if (operation
				.equalsIgnoreCase(ProvisioningConstant.INVOKES_API_REACTIVE)) {
			object = processSubscriberRequest(requestBean);
			return object;
			
			/*try {
				object = processReactivateSubscriber(requestBean);
				return object;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				throw new JavaLinkException(e.getMessage());
			}*/
		} else {
			logger.error("Operation not found");
			throw new JavaLinkException("Operation not found");
		}
	}
	
	private Object processSubscriberRequest(RequestBean requestBean){
		ResponseBean responseBean = new ResponseBean();
		ProvisioningStub provisioningStub = new ProvisioningStub(requestBean.getNeConfig().getEndpointURL());
	
		
		try {
			provisioningStub.submitRequest(requestBean);
			responseBean.setResponse("RESP:ErrorCode=0,ErrorDescription=Success;");
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			logger.error("Exception: "+e.getMessage());
			System.out.println("Exception: "+e.getMessage());
			responseBean.setResponse("RESP:ErrorCode=1,ErrorDescription=Faild;");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Exception: "+e.getMessage());
			System.out.println("Exception: "+e.getMessage());
			responseBean.setResponse("RESP:ErrorCode=1,ErrorDescription=Faild;");
			//e.printStackTrace();
		}
		return responseBean;
	}

	private Object processActivateSubscriber(RequestBean requestBean)
			throws RemoteException {
		MRBTProvisionServiceHttpBindingStub mRBTProvisionServiceHttpBindingStub = new MRBTProvisionServiceHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		ResponseBean responseBean = new ResponseBean();
		try {
			mRBTProvisionServiceHttpBindingStub.activateSubscriber(
					requestBean.getChannel(), requestBean.getPersonalPK(),
					requestBean.getTransactionId(), requestBean.getMsisdn());
			responseBean.setResult(ProvisioningConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setResult(ProvisioningConstant.FAILED);
		}
		return responseBean;
	}

	private Object processDeactivateSubscriber(RequestBean requestBean)
			throws RemoteException {
		MRBTProvisionServiceHttpBindingStub mRBTProvisionServiceHttpBindingStub = new MRBTProvisionServiceHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		ResponseBean responseBean = new ResponseBean();
		try {
			mRBTProvisionServiceHttpBindingStub.deactivateSubscriber(
					requestBean.getChannel(), requestBean.getPersonalPK(),
					requestBean.getTransactionId(), requestBean.getMsisdn());
			responseBean.setResult(ProvisioningConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setResult(ProvisioningConstant.FAILED);
		}
		return responseBean;
	}

	private Object processSuspendSubscriber(RequestBean requestBean)
			throws RemoteException {
		MRBTProvisionServiceHttpBindingStub mRBTProvisionServiceHttpBindingStub = new MRBTProvisionServiceHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		ResponseBean responseBean = new ResponseBean();
		try {
			mRBTProvisionServiceHttpBindingStub.suspendSubscriber(
					requestBean.getChannel(), requestBean.getPersonalPK(),
					requestBean.getTransactionId(), requestBean.getMsisdn());
			responseBean.setResult(ProvisioningConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setResult(ProvisioningConstant.FAILED);
		}
		return responseBean;
	}

	private Object processReactivateSubscriber(RequestBean requestBean)
			throws RemoteException {
		MRBTProvisionServiceHttpBindingStub mRBTProvisionServiceHttpBindingStub = new MRBTProvisionServiceHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		ResponseBean responseBean = new ResponseBean();
		try {
			mRBTProvisionServiceHttpBindingStub.reactivateSubscriber(
					requestBean.getChannel(), requestBean.getPersonalPK(),
					requestBean.getTransactionId(), requestBean.getMsisdn());
			responseBean.setResult(ProvisioningConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setResult(ProvisioningConstant.FAILED);
		}
		return responseBean;
	}

}
