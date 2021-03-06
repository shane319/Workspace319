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
	
	private String requestID;
	private String txnType;
	private String channel;
	private int personalPK;
	private String transactionId;
	
	private String msisdn;
	private String newMsisdn;
	private String hlrResponse;
	
	
	public java.lang.String in0;
	public long in1;
	public java.lang.String in2; 
	public java.lang.String in3;
	
	
	public java.lang.String getIn0() {
		return in0;
	}
	public void setIn0(java.lang.String in0) {
		this.in0 = in0;
	}
	public long getIn1() {
		return in1;
	}
	public void setIn1(long in1) {
		this.in1 = in1;
	}
	public java.lang.String getIn2() {
		return in2;
	}
	public void setIn2(java.lang.String in2) {
		this.in2 = in2;
	}
	public java.lang.String getIn3() {
		return in3;
	}
	public void setIn3(java.lang.String in3) {
		this.in3 = in3;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
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
	public java.lang.String getChannel() {
		return channel;
	}
	public void setChannel(java.lang.String channel) {
		this.channel = channel;
	}
	public int getPersonalPK() {
		return personalPK;
	}
	public void setPersonalPK(int personalPK) {
		this.personalPK = personalPK;
	}
	public java.lang.String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(java.lang.String transactionId) {
		this.transactionId = transactionId;
	}
	public java.lang.String getHlrResponse() {
		return hlrResponse;
	}
	public void setHlrResponse(java.lang.String hlrResponse) {
		this.hlrResponse = hlrResponse;
	}
	public String getNewMsisdn() {
		return newMsisdn;
	}
	public void setNewMsisdn(String nmsisdn) {
		this.newMsisdn = nmsisdn;
	}
}
