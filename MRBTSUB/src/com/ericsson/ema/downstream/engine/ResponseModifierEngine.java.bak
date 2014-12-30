/*******************************************************************
 *
 * FILE NAME   : ResponseModifierEngine.java
 *
 * DESCRIPTION : Raw response for NE has been modified here.
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

package com.ericsson.ema.downstream.engine;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;

import com.ericsson.ema.downstream.bean.ResponseBean;
import com.ericsson.ema.downstream.constant.ProvisioningConstant;
import com.ericsson.ema.downstream.exception.JavaLinkException;

public class ResponseModifierEngine implements JavaLinkEngine {

	private Object rawResponse;
	private String operation;

	public ResponseModifierEngine(Object rawPesponse, String operation) {
		super();
		this.rawResponse = rawPesponse;
		this.operation = operation;
	}
	
	//Raw data from NE is been captured and 
	//set necessary data NE data to responseBean
	
	@Override
	public Object invoke() throws IllegalAccessException,
			InvocationTargetException, JavaLinkException {
		// TODO Auto-generated method stub
		ResponseBean responseBean = null;
		
		responseBean = new ResponseBean();
		responseBean.setResponse("RESP:ErrorCode=0,ErrorDescription=Success;");
		//BeanUtils.copyProperties(responseBean, (Response)rawResponse);
		
		return responseBean;
	}

}
