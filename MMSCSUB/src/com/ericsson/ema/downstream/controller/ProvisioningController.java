/*******************************************************************
 *
 * FILE NAME   : ProvisioningController.java
 *
 * DESCRIPTION : All the javalink engines and major services is been invoked from here.
 * 				This class is known how to execute the major component for javalink
 * 				sequentially. It control the flow of the execution. It is the backbone 
 * 				of javalink.
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

package com.ericsson.ema.downstream.controller;

import org.apache.log4j.Logger;
import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.bean.ResponseBean;
import com.ericsson.ema.downstream.config.NEConfig;
import com.ericsson.ema.downstream.engine.ConfigEngine;
import com.ericsson.ema.downstream.engine.JavaLinkEngine;
import com.ericsson.ema.downstream.engine.ParseEngine;
import com.ericsson.ema.downstream.engine.ResponseModifierEngine;
import com.ericsson.ema.downstream.engine.ValidatorEngine;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.service.JavaLinkService;
import com.ericsson.ema.downstream.service.ProvisioningService;

public class ProvisioningController {
	static final Logger logger = Logger.getLogger(ProvisioningController.class);

	private String[] configurations;
	private String mmlString;

	private JavaLinkEngine javaLinkEngine = null;
	private JavaLinkService javaLinkService = null;

	public ProvisioningController(String[] configurations, String mmlString) {
		super();
		this.configurations = configurations;
		this.mmlString = mmlString;
	}
	
	//This method is invoked all the major component of javalink.
	
	public ResponseBean performJob() {
		ResponseBean responseBean = null;

		try {
			//invoke the config component
			javaLinkEngine = new ConfigEngine(configurations);
			NEConfig neConfig = (NEConfig) javaLinkEngine.invoke();
			
			//invoke the parse component
			javaLinkEngine = new ParseEngine(mmlString);
			RequestBean requestBean = (RequestBean) javaLinkEngine.invoke();
			requestBean.setNeConfig(neConfig);
			
			//invoke the validation component
			javaLinkEngine = new ValidatorEngine(requestBean);
			javaLinkEngine.invoke();
			
			//performing the actual provisioning communication
			javaLinkService = new ProvisioningService();
			responseBean = (ResponseBean) javaLinkService.processRequest(requestBean);
			
			
			//invoke response modifier for modifying the raw response
			/*javaLinkEngine = new ResponseModifierEngine(obj,
					requestBean.getOperation());
			responseBean = (ResponseBean) javaLinkEngine.invoke();*/
		} catch (JavaLinkException e) {
			logger.error(e.getMessage());
			responseBean = new ResponseBean();
			responseBean.setStatusCode(e.getErrorCode());
			responseBean.setErrorMessage(e.getErrorDescription());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("[MMSC] "+e.getMessage());
			responseBean = new ResponseBean();
			responseBean.setStatusCode(9099);
			responseBean.setErrorMessage("JavaLink Error");
			
		} finally{
			if(responseBean == null){
				responseBean = new ResponseBean();
			}
		}
		return responseBean;
	}

}
