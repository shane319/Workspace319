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
import org.apache.log4j.Logger;

import vms.CreateUserResponse;
import vms.DeleteUserResponse;
import vms.ModifyUserResponse;
import vms.QueryOperidResponse;
import vms.QueryUserResponse;

import com.ericsson.ema.downstream.bean.ResponseBean;
import com.ericsson.ema.downstream.constant.ProvisioningConstant;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.util.ResponseXmlUtil;

public class ResponseModifierEngine implements JavaLinkEngine {
	static final Logger logger = Logger.getLogger(ResponseModifierEngine.class);
	private Object rawResponse;
	private String operation;

	public ResponseModifierEngine(Object rawPesponse, String operation) {
		super();
		this.rawResponse = rawPesponse;
		this.operation = operation;
	}

	@Override
	public Object invoke() throws IllegalAccessException,
			InvocationTargetException, JavaLinkException {
		// TODO Auto-generated method stub
		ResponseBean responseBean = null;
		if (operation.equals(ProvisioningConstant.INVOKES_API_CREATE_USER)) {
			logger.info("Response modification for " + operation);
			responseBean = new ResponseBean();
			BeanUtils.copyProperties(responseBean,
					(CreateUserResponse) rawResponse);
		} else if (operation
				.equals(ProvisioningConstant.INVOKES_API_MODIFY_USER)) {
			logger.info("Response modification for " + operation);
			responseBean = new ResponseBean();
			BeanUtils.copyProperties(responseBean,
					(ModifyUserResponse) rawResponse);
		} else if (operation
				.equals(ProvisioningConstant.INVOKES_API_DELETE_USER)) {
			logger.info("Response modification for " + operation);
			responseBean = new ResponseBean();
			BeanUtils.copyProperties(responseBean,
					(DeleteUserResponse) rawResponse);
		} else if (operation
				.equals(ProvisioningConstant.INVOKES_API_QUERY_USER)) {
			logger.info("Response modification for " + operation);
			System.out.println("Response modification for " + operation);
			responseBean = new ResponseBean();
			ResponseXmlUtil responseXmlUtil = new ResponseXmlUtil();
			responseBean.setQueryResponse(responseXmlUtil
					.generateQueryResponseXml((QueryUserResponse) rawResponse));
			BeanUtils.copyProperties(responseBean,
					(QueryUserResponse) rawResponse);
		} else if (operation
				.equals(ProvisioningConstant.INVOKES_API_QUERY_USER_OPER_ID)) {
			logger.info("Response modification for " + operation);
			responseBean = new ResponseBean();
			BeanUtils.copyProperties(responseBean,
					(QueryOperidResponse) rawResponse);
		} else {
			throw new JavaLinkException("Operation not matched");
		}
		return responseBean;
	}

}
