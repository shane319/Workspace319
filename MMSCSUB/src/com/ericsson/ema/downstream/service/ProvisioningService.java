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
import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.bean.ResponseBean;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.handler.ErrorHandler;
import com.ericsson.mmsc.provisioning.ProvisioningStub;

public class ProvisioningService implements JavaLinkService {
	static final Logger logger = Logger.getLogger(ProvisioningService.class);

	// General method for all operation.
	// The connection between javalink and NE has done here.
	// Raw NE response has been captured and return to the Provisioning
	// Controller.

	public ResponseBean processRequest(RequestBean requestBean)
			throws JavaLinkException {
		ResponseBean resp = null;
		ErrorHandler errorHandler = new ErrorHandler();
		String operation = requestBean.getOperation();
		
		logger.debug("Operation: " + operation);
		logger.info("Request contain: " + requestBean);

		if (operation.equalsIgnoreCase("delete")) {
			try {
				resp = processDelete(requestBean);
			} catch (HttpException e) {
				errorHandler.handleError(e);
			} catch (IOException e) {
				errorHandler.handleError(e);
			} catch (Exception e) {
				errorHandler.handleError(e);
			}
		} else {
			throw new JavaLinkException("Operation not matched");
		}
		return resp;
	}

	private ResponseBean processDelete(RequestBean requestBean) throws HttpException,
			IOException, Exception {
		ResponseBean resp = null;
		ProvisioningStub provisioningStub = new ProvisioningStub(requestBean
				.getNeConfig().getEndpointURL(), requestBean.getNeConfig()
				.getUserId(), requestBean.getNeConfig().getPassword());
		
		provisioningStub.setTimeOut(requestBean.getNeConfig().getTimeOut());
		
		resp = provisioningStub.submitRequest(requestBean);
		
		return resp;
	}
}
