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
	private java.lang.String transactionId;

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

	public java.lang.String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(java.lang.String transactionId) {
		this.transactionId = transactionId;
	}

	// dummy data is used for testing purpose.
	// for getting actual response un-block the block line and block the
	// dummyResponse()
	public String getResponse() {

		if (this.statusCode == 0 && this.errorMessage == null)
			this.errorMessage = "Success";

		String mmlResponse = "RESP:ErrorCode=" + this.statusCode
				+ ",ErrorDescription=" + this.errorMessage+";";

		return mmlResponse;
		// return dummyResponse();
	}

	private String dummyResponse() {
		return "RESP:ErrorCode=0,ErrorDescription=success;";
	}
}
