/*******************************************************************
 *
 * FILE NAME   : ResponseBean.java
 *
 * DESCRIPTION : It's a bean. Response data for javalink is stored here.
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

package com.ericsson.ema.downstream.bean;

import com.ericsson.ema.downstream.constant.ProvisioningConstant;

public class ResponseBean {
	private String result = ProvisioningConstant.FAILED;
	private String response = "RESP:ErrorCode=9001,ErrorDescription=Unknown Error;";
	private String errorCode = "9001";
	private String errorDesc = "Unknown Error";

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		System.out.println(result);
		this.result = result;
	}

	public void setResponse(String response) {
		System.out.println(response);
		this.response = response;
	}

	public String getResponse() {

		// return dummyResponse();

		if (result.equals(ProvisioningConstant.SUCCESS)) {
			response = "RESP:ErrorCode=0,ErrorDescription=Success;";
		} else {
			response = "RESP:ErrorCode=" + errorCode + ",ErrorDescription="
					+ errorDesc + ";";
		}

		return response;

	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		if (errorCode != null)
			this.errorCode = errorCode;
		else
			this.errorCode = "9099";
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	protected String dummyResponse() {
		return "RESP:ErrorCode=0,ErrorDescription=success;";
	}
}
