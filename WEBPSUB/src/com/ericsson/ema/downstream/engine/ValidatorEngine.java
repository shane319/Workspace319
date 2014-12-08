/*******************************************************************
 *
 * FILE NAME   : ValidatorEngine.java
 *
 * DESCRIPTION : This class only concern about all the input validation. 
 * 				The validation logic has been embedded into it.
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

import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.constant.ProvisioningConstant;
import com.ericsson.ema.downstream.exception.ConfigException;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.util.ValidatorUtil;

public class ValidatorEngine implements JavaLinkEngine {

	RequestBean requestBean = null;

	public ValidatorEngine(RequestBean requestBean) {
		super();
		this.requestBean = requestBean;
	}
	
	//Perform the input data validation which has come from MVNE.
	//If any mandatory data is missing or unwanted value found
	//then it will throw an exception
	
	@Override
	public Object invoke() throws ConfigException, JavaLinkException {
		// TODO Auto-generated method stub
		// validation for configuration
		if (ValidatorUtil.isNull(requestBean.getNeConfig().getEndpointURL()
				.toString())) {
			throw new ConfigException("End point URL is not configured");
		}

		// validation for input value
		if (requestBean.getOperation().equals(
				ProvisioningConstant.INVOKES_API_ADD_NEW_PORTAL_USER)) {

			if (!ValidatorUtil.isNull(requestBean.getMsisdn())) {
				if (!ValidatorUtil.isNull(requestBean.getMsisdn())) {
					return ProvisioningConstant.SUCCESS;
				} else {
					throw new JavaLinkException("Invalid MSISDN");
				}
			} else {
				throw new JavaLinkException("MSISDN is null");
			}
		} else if (requestBean.getOperation().equals(
				ProvisioningConstant.INVOKES_API_DELETE_PORTAL_USER)) {
			if (!ValidatorUtil.isNull(requestBean.getMsisdn())) {
				if (!ValidatorUtil.isNull(requestBean.getMsisdn())) {
					return ProvisioningConstant.SUCCESS;
				} else {
					throw new JavaLinkException("Invalid MSISDN");
				}
			} else {
				throw new JavaLinkException("MSISDN is null");
			}
		} else {
			throw new JavaLinkException("Operation not found");
		}
	}
}
