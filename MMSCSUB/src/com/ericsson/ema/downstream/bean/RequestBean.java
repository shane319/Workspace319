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
	
	private String transactionId = null;
	private String msisdn = null;
	private String sessionId = null;
		
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
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String toString(){
		return "Trans ID: "+this.transactionId+" MSISDN: "+this.msisdn;
	}
}
