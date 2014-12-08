package com.ericsson.ema.downstream.controller;
/**
 * 
 * @author ESUMOND
 */
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

	public ResponseBean performJob() {
		ResponseBean responseBean = null;

		try {

			javaLinkEngine = new ConfigEngine(configurations);
			NEConfig neConfig = (NEConfig) javaLinkEngine.invoke();
			javaLinkEngine = new ParseEngine(mmlString);
			RequestBean requestBean = (RequestBean) javaLinkEngine.invoke();
			requestBean.setNeConfig(neConfig);

			javaLinkEngine = new ValidatorEngine(requestBean);
			javaLinkEngine.invoke();

			javaLinkService = new ProvisioningService();
			Object obj = javaLinkService.processRequest(requestBean);

			javaLinkEngine = new ResponseModifierEngine(obj,
					requestBean.getOperation());
			responseBean = (ResponseBean) javaLinkEngine.invoke();
		} catch (JavaLinkException e) {
			logger.error(e.getMessage());
			responseBean = new ResponseBean();
			responseBean.setResultcode(e.getErrorCode());
			responseBean.setDescription(e.getErrorDescription());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error(e.getMessage());
			responseBean = new ResponseBean();
			responseBean.setResultcode(9099);
			responseBean.setDescription("JavaLink Error");
		} finally {
			if(responseBean == null){
				responseBean = new ResponseBean();
			}
		}
		return responseBean;
	}

}
