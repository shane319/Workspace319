/*******************************************************************
 *
 * FILE NAME   : RequestBean.java
 *
 * DESCRIPTION : It's a bean. All request data for NE is stored here.
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

import com.ericsson.ema.downstream.config.NEConfig;

public class RequestBean {
	private String operation = null;
	private NEConfig neConfig = null;
	
	// add new user data
	private java.lang.String requestID;
	private java.lang.String msisdn;
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public NEConfig getNeConfig() {
		return neConfig;
	}
	public void setNeConfig(NEConfig neConfig) {
		this.neConfig = neConfig;
	}
	public java.lang.String getRequestID() {
		return requestID;
	}
	public void setRequestID(java.lang.String requestID) {
		this.requestID = requestID;
	}
	public java.lang.String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(java.lang.String msisdn) {
		this.msisdn = msisdn;
	}
	
		
}
