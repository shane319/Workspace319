package com.ericsson.ema.downstream.bean;
/**
 * 
 * @author ESUMOND
 */
import com.ericsson.ema.downstream.config.NEConfig;

public class RequestBean {
	private String operation = null;
	private NEConfig neConfig = null;
	
	//Common data for create, delete, modify
	
	private java.lang.String boxNumber;
    private java.lang.String operID;
    private java.lang.String operPwd;
    
    //common data for create, modify
    
    private java.lang.String serviceClass;
    private java.lang.String language;
    private java.lang.String password;
    private java.lang.String entryAuthen;
    private java.lang.String messageNotify;
    private java.lang.String userName;
    private java.lang.String email;
    private java.lang.String zipCode;
    private java.lang.String IDNumber;
    private java.lang.String MWNType;
    private java.lang.String MWNDest;
    private java.lang.String LDOperatorCode;
    private java.lang.String terminalType;
    private java.lang.String billingNumber;
    private java.lang.String MMSDest;
    private java.lang.String SMSNotifyPhone;
    private java.lang.String secondary1;
    private java.lang.String secondary2;
    private java.lang.String secondary3;
    private java.lang.String secondary4;
    private java.lang.String secondary5;
    private java.lang.String usertype;
    
    //Modify data

    private java.lang.String userStatus;
    private java.lang.String MCAservice;
    private java.lang.String CMNservice;

    
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
	public java.lang.String getBoxNumber() {
		return boxNumber;
	}
	public void setBoxNumber(java.lang.String boxNumber) {
		this.boxNumber = boxNumber;
	}
	public java.lang.String getOperID() {
		return operID;
	}
	public void setOperID(java.lang.String operID) {
		this.operID = operID;
	}
	public java.lang.String getOperPwd() {
		return operPwd;
	}
	public void setOperPwd(java.lang.String operPwd) {
		this.operPwd = operPwd;
	}
	public java.lang.String getServiceClass() {
		return serviceClass;
	}
	public void setServiceClass(java.lang.String serviceClass) {
		this.serviceClass = serviceClass;
	}
	public java.lang.String getLanguage() {
		return language;
	}
	public void setLanguage(java.lang.String language) {
		this.language = language;
	}
	public java.lang.String getPassword() {
		return password;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	public java.lang.String getEntryAuthen() {
		return entryAuthen;
	}
	public void setEntryAuthen(java.lang.String entryAuthen) {
		this.entryAuthen = entryAuthen;
	}
	public java.lang.String getMessageNotify() {
		return messageNotify;
	}
	public void setMessageNotify(java.lang.String messageNotify) {
		this.messageNotify = messageNotify;
	}
	public java.lang.String getUserName() {
		return userName;
	}
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public java.lang.String getZipCode() {
		return zipCode;
	}
	public void setZipCode(java.lang.String zipCode) {
		this.zipCode = zipCode;
	}
	public java.lang.String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(java.lang.String iDNumber) {
		IDNumber = iDNumber;
	}
	public java.lang.String getMWNType() {
		return MWNType;
	}
	public void setMWNType(java.lang.String mWNType) {
		MWNType = mWNType;
	}
	public java.lang.String getMWNDest() {
		return MWNDest;
	}
	public void setMWNDest(java.lang.String mWNDest) {
		MWNDest = mWNDest;
	}
	public java.lang.String getLDOperatorCode() {
		return LDOperatorCode;
	}
	public void setLDOperatorCode(java.lang.String lDOperatorCode) {
		LDOperatorCode = lDOperatorCode;
	}
	public java.lang.String getTerminalType() {
		return terminalType;
	}
	public void setTerminalType(java.lang.String terminalType) {
		this.terminalType = terminalType;
	}
	public java.lang.String getBillingNumber() {
		return billingNumber;
	}
	public void setBillingNumber(java.lang.String billingNumber) {
		this.billingNumber = billingNumber;
	}
	public java.lang.String getMMSDest() {
		return MMSDest;
	}
	public void setMMSDest(java.lang.String mMSDest) {
		MMSDest = mMSDest;
	}
	public java.lang.String getSMSNotifyPhone() {
		return SMSNotifyPhone;
	}
	public void setSMSNotifyPhone(java.lang.String sMSNotifyPhone) {
		SMSNotifyPhone = sMSNotifyPhone;
	}
	public java.lang.String getSecondary1() {
		return secondary1;
	}
	public void setSecondary1(java.lang.String secondary1) {
		this.secondary1 = secondary1;
	}
	public java.lang.String getSecondary2() {
		return secondary2;
	}
	public void setSecondary2(java.lang.String secondary2) {
		this.secondary2 = secondary2;
	}
	public java.lang.String getSecondary3() {
		return secondary3;
	}
	public void setSecondary3(java.lang.String secondary3) {
		this.secondary3 = secondary3;
	}
	public java.lang.String getSecondary4() {
		return secondary4;
	}
	public void setSecondary4(java.lang.String secondary4) {
		this.secondary4 = secondary4;
	}
	public java.lang.String getSecondary5() {
		return secondary5;
	}
	public void setSecondary5(java.lang.String secondary5) {
		this.secondary5 = secondary5;
	}
	public java.lang.String getUsertype() {
		return usertype;
	}
	public void setUsertype(java.lang.String usertype) {
		this.usertype = usertype;
	}
	public java.lang.String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(java.lang.String userStatus) {
		this.userStatus = userStatus;
	}
	public java.lang.String getMCAservice() {
		return MCAservice;
	}
	public void setMCAservice(java.lang.String mCAservice) {
		MCAservice = mCAservice;
	}
	public java.lang.String getCMNservice() {
		return CMNservice;
	}
	public void setCMNservice(java.lang.String cMNservice) {
		CMNservice = cMNservice;
	}
	@Override
	public String toString() {
		return "RequestBean [operation=" + operation + ", neConfig=" + neConfig
				+ ", boxNumber=" + boxNumber + ", operID=" + operID
				+ ", operPwd=" + operPwd + ", serviceClass=" + serviceClass
				+ ", language=" + language + ", password=" + password
				+ ", entryAuthen=" + entryAuthen + ", messageNotify="
				+ messageNotify + ", userName=" + userName + ", email=" + email
				+ ", zipCode=" + zipCode + ", IDNumber=" + IDNumber
				+ ", MWNType=" + MWNType + ", MWNDest=" + MWNDest
				+ ", LDOperatorCode=" + LDOperatorCode + ", terminalType="
				+ terminalType + ", billingNumber=" + billingNumber
				+ ", MMSDest=" + MMSDest + ", SMSNotifyPhone=" + SMSNotifyPhone
				+ ", secondary1=" + secondary1 + ", secondary2=" + secondary2
				+ ", secondary3=" + secondary3 + ", secondary4=" + secondary4
				+ ", secondary5=" + secondary5 + ", usertype=" + usertype
				+ ", userStatus=" + userStatus + ", MCAservice=" + MCAservice
				+ ", CMNservice=" + CMNservice + "]";
	}
	
	
}
