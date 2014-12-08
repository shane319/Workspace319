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

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;


import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import my.com.u.www.UmobilePortalServiceSoapBindingStub;
import org.apache.axis.AxisFault;

import org.apache.axis.message.SOAPHeaderElement;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.constant.ProvisioningConstant;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.handler.ErrorHandler;

import javax.xml.namespace.QName;

import data.ws.wsserver.umobileportal.ericsson.com.Request;
import data.ws.wsserver.umobileportal.ericsson.com.Response;

public class ProvisioningService implements JavaLinkService {
	static final Logger logger = Logger.getLogger(ProvisioningService.class);

	// General method for all operation.
	// The connection between javalink and NE has done here.
	// Raw NE response has been captured and return to the Provisioning
	// Controller.

	public Object processRequest(RequestBean requestBean)
			throws JavaLinkException {
		String operation = requestBean.getOperation();
		Response response = null;
		ErrorHandler errorHandler = new ErrorHandler();

		if (operation
				.equals(ProvisioningConstant.INVOKES_API_ADD_NEW_PORTAL_USER)) {
			try {
				response = processAddNewPortalUser(requestBean);
				return response;
			} catch (AxisFault e) {
				// TODO Auto-generated catch block
				errorHandler.handleError(e);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				errorHandler.handleError(e);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				errorHandler.handleError(e);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				errorHandler.handleError(e);
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				errorHandler.handleError(e);
			}
		} else if (operation
				.equals(ProvisioningConstant.INVOKES_API_DELETE_PORTAL_USER)) {
			try {
				response = processDeletePortalUser(requestBean);
				return response;
			} catch (RemoteException e) {
				errorHandler.handleError(e);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				errorHandler.handleError(e);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				errorHandler.handleError(e);
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				errorHandler.handleError(e);
			}
		} else {
			logger.error("Invoked API not found...");
			throw new JavaLinkException("API not found");
		}
		return response;
	}

	private Response processAddNewPortalUser(RequestBean requestBean)
			throws RemoteException, IllegalAccessException,
			InvocationTargetException, SOAPException {
		
		 
		UmobilePortalServiceSoapBindingStub umobilePortalServiceSoapBindingStub = new UmobilePortalServiceSoapBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		
		umobilePortalServiceSoapBindingStub.setTimeout(requestBean.getNeConfig().getTimeOut());
		
			 
			  // Finally, attach the header to the binding.
			  umobilePortalServiceSoapBindingStub.setHeader(getHeader(requestBean));
		
		Request request = new Request();
		BeanUtils.copyProperties(request, requestBean);
		
		
		
		
		Response response = umobilePortalServiceSoapBindingStub
				.addNewPortalUser(request);
		return response;
	}

	private SOAPHeaderElement getHeader(RequestBean requestBean) throws SOAPException {
		// TODO Auto-generated method stub
		String wsUser= requestBean.getNeConfig().getUsername();
		 String wsPass =  requestBean.getNeConfig().getPassword();

		QName headerName = new QName(
			    "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
			  SOAPHeaderElement header = new SOAPHeaderElement(headerName);
			  //  no intermediate actors are involved.
			  header.setActor(null);
			  // not important, "wsse" is standard
			  header.setPrefix("wsse");
			  header.setMustUnderstand(true);
			 
			  // Add the UsernameToken element to the WS-Security header
			  SOAPElement utElem = header.addChildElement("UsernameToken");
			  SOAPElement userNameElem = utElem.addChildElement("Username");
			  userNameElem.setValue(wsUser);
			  SOAPElement passwordElem = utElem.addChildElement("Password");
			  passwordElem.setValue(wsPass);
		return header;
	}

	private Response processDeletePortalUser(RequestBean requestBean)
			throws IllegalAccessException, InvocationTargetException,
			RemoteException, SOAPException {
		UmobilePortalServiceSoapBindingStub umobilePortalServiceSoapBindingStub = new UmobilePortalServiceSoapBindingStub(
				requestBean.getNeConfig().getEndpointURL(), requestBean
						.getNeConfig().getService());
		
		umobilePortalServiceSoapBindingStub.setTimeout(requestBean.getNeConfig().getTimeOut());
		
		umobilePortalServiceSoapBindingStub.setHeader(getHeader(requestBean));
		Request request = new Request();
		BeanUtils.copyProperties(request, requestBean);
		
		
		Response response = umobilePortalServiceSoapBindingStub
				.deletePortalUser(request);
		return response;
	}
}