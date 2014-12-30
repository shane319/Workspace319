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
import java.net.SocketTimeoutException;
import java.rmi.RemoteException;

import my.com.ngc.genico.mrbt.ws.MRBTProvisionServiceHttpBindingStub;
import my.com.ngc.genico.mrbt.ws.ProvisionFaultDetail;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.bean.ResponseBean;
import com.ericsson.ema.downstream.constant.ProvisioningConstant;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.handler.ErrorHandler;
import com.ericsson.ema.downstream.mrbtsub.DemoJavalink;
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
		ErrorHandler errorHandler = new ErrorHandler();
		if (DemoJavalink.logger.isInfoEnabled()){
			DemoJavalink.logger.info(String.format("Receiving request, operation is %s, msisdn is %s", operation, requestBean.getMsisdn()));
		}
		if (operation.equalsIgnoreCase(ProvisioningConstant.INVOKES_API_ACTIVE)) {
			/*object = processSubscriberRequest(requestBean);
			return object;*/
			try {
				object = processActivateSubscriber(requestBean);
				return object;
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				errorHandler.handleError(e);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				errorHandler.handleError(e);
			}
		} else if (operation
				.equalsIgnoreCase(ProvisioningConstant.INVOKES_API_DEACTIVE)) {
			
			/*object = processSubscriberRequest(requestBean);
			return object;*/
			
			try {
				object = processDeactivateSubscriber(requestBean);
				return object;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				errorHandler.handleError(e);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				errorHandler.handleError(e);
			}
		} /*else if (operation
				.equalsIgnoreCase(ProvisioningConstant.INVOKES_API_SUSPEND)) {
			object = processSubscriberRequest(requestBean);
			return object;
			
			try {
				object = processSuspendSubscriber(requestBean);
				return object;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				throw new JavaLinkException(e.getMessage());
			}
		} */ else if (operation
				.equalsIgnoreCase(ProvisioningConstant.INVOKES_API_CHANGE_MSISDN)){
			object = processChangeMsisdnRequest(requestBean);
			return object;
			
//			try {
//				object = processReactivateSubscriber(requestBean);
//				return object;
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				logger.error(e.getMessage());
//				throw new JavaLinkException(e.getMessage());
//			}
		}
		else {
			logger.error("Operation not found");
			throw new JavaLinkException("Operation not found");
		}
		
		return object;
	}
	
	private Object processSubscriberRequest(RequestBean requestBean){
		ResponseBean responseBean = new ResponseBean();
		ProvisioningStub provisioningStub = new ProvisioningStub(requestBean.getNeConfig().getEndpointURL());
		try {
			provisioningStub.submitRequest(requestBean);
			//responseBean.setResponse("RESP:ErrorCode=0,ErrorDescription=Success;");
			responseBean.setResult(ProvisioningConstant.SUCCESS);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			logger.error("Exception: "+e.getMessage());
			//responseBean.setResponse("RESP:ErrorCode=1,ErrorDescription=Faild;");
			//e.printStackTrace();
			responseBean.setResult(ProvisioningConstant.FAILED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Exception: "+e.getMessage());
			//responseBean.setResponse("RESP:ErrorCode=1,ErrorDescription=Faild;");
			//e.printStackTrace();
			responseBean.setResult(ProvisioningConstant.FAILED);
		}
		return responseBean;
	}

	
	private Object processChangeMsisdnRequest(RequestBean requestBean){
		ResponseBean responseBean = new ResponseBean();

		ProvisioningStub provisioningStub = new ProvisioningStub(requestBean.getNeConfig().getChangeMsisdnURL() ,
																 requestBean.getNeConfig().getUsername(),
																 requestBean.getNeConfig().getPassword(),
																 requestBean.getNeConfig().getTimeOut());
	
		//TODO: Handle Error Code
		try {
			String results[] = provisioningStub.changeMsisdn(requestBean);
			if ( "200".equals(results[0])){
				responseBean.setResult(ProvisioningConstant.SUCCESS);
				//responseBean.setResponse("RESP:ErrorCode=0,ErrorDescription=Success;");
			} else {
				responseBean.setResult(ProvisioningConstant.FAILED);
				responseBean.setErrorCode(String.valueOf(results[0]));
				responseBean.setErrorDesc(results[1]);
			}
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			logger.error("Exception: "+e.getMessage(), e);
			responseBean.setResult(ProvisioningConstant.FAILED);
			responseBean.setErrorCode(String.valueOf(9002));
			responseBean.setErrorDesc("Response Time out");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Exception: "+e.getMessage(), e);
			responseBean.setResult(ProvisioningConstant.FAILED);
			responseBean.setErrorCode(String.valueOf(9002));
			responseBean.setErrorDesc("Response Time out");
		} catch (Throwable e){
			logger.error("Throwable Exception: "+e.getMessage(), e);
			responseBean.setResult(ProvisioningConstant.FAILED);
			//responseBean.setResponse("RESP:ErrorCode=1,ErrorDescription="+e.getMessage()+";");
		}
 
		return responseBean;
	}
	private Object processActivateSubscriber(RequestBean requestBean)
			throws Exception {
		MRBTProvisionServiceHttpBindingStub mRBTProvisionServiceHttpBindingStub = new MRBTProvisionServiceHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		
		mRBTProvisionServiceHttpBindingStub.setTimeout(requestBean
						.getNeConfig().getTimeOut());
		
		ResponseBean responseBean = new ResponseBean();
		try {
			//System.out.println("Executing Activate Request...");
			
			////System.out.println("hlr response: "+Integer.parseInt(requestBean.getHlrResponse()));
			////System.out.println("msisdn: "+requestBean.getMsisdn());
			
			mRBTProvisionServiceHttpBindingStub.activateSubscriber(
					Integer.parseInt(requestBean.getHlrResponse()),	requestBean.getMsisdn());
			//System.out.println("Sent Activate Request successfully.");
			logger.debug("Sent Activate Request successfully.");
			responseBean.setResult(ProvisioningConstant.SUCCESS);
		} catch(ProvisionFaultDetail pf){
			
			//System.out.println(pf.getErrorCode());
			//System.out.println(pf.getErrorKey());
			//System.out.println(pf.getErrorParams());
			
			responseBean.setResult(ProvisioningConstant.FAILED);
			responseBean.setErrorCode(pf.getErrorCode());
			responseBean.setErrorDesc(pf.getErrorKey());
			
		}catch(RemoteException e){
			throw e;
		}catch (Exception e) {
			throw e;
		}
		return responseBean;
	}

	private Object processDeactivateSubscriber(RequestBean requestBean)
			throws Exception {
		MRBTProvisionServiceHttpBindingStub mRBTProvisionServiceHttpBindingStub = new MRBTProvisionServiceHttpBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
	
		
		mRBTProvisionServiceHttpBindingStub.setTimeout(requestBean
				.getNeConfig().getTimeOut());
				
		ResponseBean responseBean = new ResponseBean();
		long start = System.currentTimeMillis();
		try {
			mRBTProvisionServiceHttpBindingStub.deactivateSubscriber(
					Integer.parseInt(requestBean.getHlrResponse()),	requestBean.getMsisdn());
			responseBean.setResult(ProvisioningConstant.SUCCESS);
		
		} catch(ProvisionFaultDetail pf){
			
			//System.out.println(pf.getErrorCode());
			//System.out.println(pf.getErrorKey());
			//System.out.println(pf.getErrorParams());
			
			responseBean.setResult(ProvisioningConstant.FAILED);
			responseBean.setErrorCode(pf.getErrorCode());
			responseBean.setErrorDesc(pf.getErrorKey());
		
		} catch(RemoteException e){
			throw e;
		}catch (Exception e) {
			throw e;
		}finally{
			DemoJavalink.logger.debug(String.format("Deactivate subscriber %s done, status is %s, duration %s", 
					requestBean.getMsisdn(), responseBean.getResult(), System.currentTimeMillis()-start));
		}
		return responseBean;
	}

	/*private Object processSuspendSubscriber(RequestBean requestBean)
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
	}*/

}
