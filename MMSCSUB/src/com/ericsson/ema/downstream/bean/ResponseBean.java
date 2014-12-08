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

public class ResponseBean {

	private java.lang.Integer statusCode = 9001;
	private java.lang.String errorMessage = "Unknown Error";

	public java.lang.Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(java.lang.Integer statusCode) {
		this.statusCode = statusCode;
	}

	public java.lang.String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(java.lang.String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getResponse() {
		return "RESP:ErrorCode="+this.statusCode+",ErrorDescription="+this.errorMessage+";";
		//return dummyResponse();
	}

	private String dummyResponse() {
		return "RESP:ErrorCode=0,ErrorDescription=success;";
	}
	
	@Override
	public String toString() {
		return "ResponseBean [statusCode=" + statusCode + ", errorMessage="
				+ errorMessage + "]";
	}
}
