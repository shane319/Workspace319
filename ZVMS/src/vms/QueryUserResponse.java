/**
 * QueryUserResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package vms;

public class QueryUserResponse  implements java.io.Serializable {
    private int resultcode;

    private java.lang.String IDNumber;

    private java.lang.String LDOperatorCode;

    private java.lang.String MWNDest;

    private java.lang.String MWNType;

    private java.lang.String email;

    private java.lang.String entryAuthen;

    private java.lang.String language;

    private java.lang.String messageNotify;

    private java.lang.String serviceClass;

    private java.lang.String userName;

    private java.lang.String userStatus;

    private java.lang.String zipCode;

    private java.lang.String terminalType;

    private java.lang.String billingNumber;

    private java.lang.String MMSDest;

    private java.lang.String description;

    private java.lang.String password;

    private java.lang.String SMSNotifyPhone;

    private java.lang.String secondary1;

    private java.lang.String secondary2;

    private java.lang.String secondary3;

    private java.lang.String secondary4;

    private java.lang.String secondary5;

    private java.lang.String MCAservice;

    private java.lang.String CMNservice;

    private java.lang.String usertype;

    public QueryUserResponse() {
    }

    public QueryUserResponse(
           int resultcode,
           java.lang.String IDNumber,
           java.lang.String LDOperatorCode,
           java.lang.String MWNDest,
           java.lang.String MWNType,
           java.lang.String email,
           java.lang.String entryAuthen,
           java.lang.String language,
           java.lang.String messageNotify,
           java.lang.String serviceClass,
           java.lang.String userName,
           java.lang.String userStatus,
           java.lang.String zipCode,
           java.lang.String terminalType,
           java.lang.String billingNumber,
           java.lang.String MMSDest,
           java.lang.String description,
           java.lang.String password,
           java.lang.String SMSNotifyPhone,
           java.lang.String secondary1,
           java.lang.String secondary2,
           java.lang.String secondary3,
           java.lang.String secondary4,
           java.lang.String secondary5,
           java.lang.String MCAservice,
           java.lang.String CMNservice,
           java.lang.String usertype) {
           this.resultcode = resultcode;
           this.IDNumber = IDNumber;
           this.LDOperatorCode = LDOperatorCode;
           this.MWNDest = MWNDest;
           this.MWNType = MWNType;
           this.email = email;
           this.entryAuthen = entryAuthen;
           this.language = language;
           this.messageNotify = messageNotify;
           this.serviceClass = serviceClass;
           this.userName = userName;
           this.userStatus = userStatus;
           this.zipCode = zipCode;
           this.terminalType = terminalType;
           this.billingNumber = billingNumber;
           this.MMSDest = MMSDest;
           this.description = description;
           this.password = password;
           this.SMSNotifyPhone = SMSNotifyPhone;
           this.secondary1 = secondary1;
           this.secondary2 = secondary2;
           this.secondary3 = secondary3;
           this.secondary4 = secondary4;
           this.secondary5 = secondary5;
           this.MCAservice = MCAservice;
           this.CMNservice = CMNservice;
           this.usertype = usertype;
    }


    /**
     * Gets the resultcode value for this QueryUserResponse.
     * 
     * @return resultcode
     */
    public int getResultcode() {
        return resultcode;
    }


    /**
     * Sets the resultcode value for this QueryUserResponse.
     * 
     * @param resultcode
     */
    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }


    /**
     * Gets the IDNumber value for this QueryUserResponse.
     * 
     * @return IDNumber
     */
    public java.lang.String getIDNumber() {
        return IDNumber;
    }


    /**
     * Sets the IDNumber value for this QueryUserResponse.
     * 
     * @param IDNumber
     */
    public void setIDNumber(java.lang.String IDNumber) {
        this.IDNumber = IDNumber;
    }


    /**
     * Gets the LDOperatorCode value for this QueryUserResponse.
     * 
     * @return LDOperatorCode
     */
    public java.lang.String getLDOperatorCode() {
        return LDOperatorCode;
    }


    /**
     * Sets the LDOperatorCode value for this QueryUserResponse.
     * 
     * @param LDOperatorCode
     */
    public void setLDOperatorCode(java.lang.String LDOperatorCode) {
        this.LDOperatorCode = LDOperatorCode;
    }


    /**
     * Gets the MWNDest value for this QueryUserResponse.
     * 
     * @return MWNDest
     */
    public java.lang.String getMWNDest() {
        return MWNDest;
    }


    /**
     * Sets the MWNDest value for this QueryUserResponse.
     * 
     * @param MWNDest
     */
    public void setMWNDest(java.lang.String MWNDest) {
        this.MWNDest = MWNDest;
    }


    /**
     * Gets the MWNType value for this QueryUserResponse.
     * 
     * @return MWNType
     */
    public java.lang.String getMWNType() {
        return MWNType;
    }


    /**
     * Sets the MWNType value for this QueryUserResponse.
     * 
     * @param MWNType
     */
    public void setMWNType(java.lang.String MWNType) {
        this.MWNType = MWNType;
    }


    /**
     * Gets the email value for this QueryUserResponse.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this QueryUserResponse.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the entryAuthen value for this QueryUserResponse.
     * 
     * @return entryAuthen
     */
    public java.lang.String getEntryAuthen() {
        return entryAuthen;
    }


    /**
     * Sets the entryAuthen value for this QueryUserResponse.
     * 
     * @param entryAuthen
     */
    public void setEntryAuthen(java.lang.String entryAuthen) {
        this.entryAuthen = entryAuthen;
    }


    /**
     * Gets the language value for this QueryUserResponse.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this QueryUserResponse.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }


    /**
     * Gets the messageNotify value for this QueryUserResponse.
     * 
     * @return messageNotify
     */
    public java.lang.String getMessageNotify() {
        return messageNotify;
    }


    /**
     * Sets the messageNotify value for this QueryUserResponse.
     * 
     * @param messageNotify
     */
    public void setMessageNotify(java.lang.String messageNotify) {
        this.messageNotify = messageNotify;
    }


    /**
     * Gets the serviceClass value for this QueryUserResponse.
     * 
     * @return serviceClass
     */
    public java.lang.String getServiceClass() {
        return serviceClass;
    }


    /**
     * Sets the serviceClass value for this QueryUserResponse.
     * 
     * @param serviceClass
     */
    public void setServiceClass(java.lang.String serviceClass) {
        this.serviceClass = serviceClass;
    }


    /**
     * Gets the userName value for this QueryUserResponse.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this QueryUserResponse.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the userStatus value for this QueryUserResponse.
     * 
     * @return userStatus
     */
    public java.lang.String getUserStatus() {
        return userStatus;
    }


    /**
     * Sets the userStatus value for this QueryUserResponse.
     * 
     * @param userStatus
     */
    public void setUserStatus(java.lang.String userStatus) {
        this.userStatus = userStatus;
    }


    /**
     * Gets the zipCode value for this QueryUserResponse.
     * 
     * @return zipCode
     */
    public java.lang.String getZipCode() {
        return zipCode;
    }


    /**
     * Sets the zipCode value for this QueryUserResponse.
     * 
     * @param zipCode
     */
    public void setZipCode(java.lang.String zipCode) {
        this.zipCode = zipCode;
    }


    /**
     * Gets the terminalType value for this QueryUserResponse.
     * 
     * @return terminalType
     */
    public java.lang.String getTerminalType() {
        return terminalType;
    }


    /**
     * Sets the terminalType value for this QueryUserResponse.
     * 
     * @param terminalType
     */
    public void setTerminalType(java.lang.String terminalType) {
        this.terminalType = terminalType;
    }


    /**
     * Gets the billingNumber value for this QueryUserResponse.
     * 
     * @return billingNumber
     */
    public java.lang.String getBillingNumber() {
        return billingNumber;
    }


    /**
     * Sets the billingNumber value for this QueryUserResponse.
     * 
     * @param billingNumber
     */
    public void setBillingNumber(java.lang.String billingNumber) {
        this.billingNumber = billingNumber;
    }


    /**
     * Gets the MMSDest value for this QueryUserResponse.
     * 
     * @return MMSDest
     */
    public java.lang.String getMMSDest() {
        return MMSDest;
    }


    /**
     * Sets the MMSDest value for this QueryUserResponse.
     * 
     * @param MMSDest
     */
    public void setMMSDest(java.lang.String MMSDest) {
        this.MMSDest = MMSDest;
    }


    /**
     * Gets the description value for this QueryUserResponse.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this QueryUserResponse.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the password value for this QueryUserResponse.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this QueryUserResponse.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the SMSNotifyPhone value for this QueryUserResponse.
     * 
     * @return SMSNotifyPhone
     */
    public java.lang.String getSMSNotifyPhone() {
        return SMSNotifyPhone;
    }


    /**
     * Sets the SMSNotifyPhone value for this QueryUserResponse.
     * 
     * @param SMSNotifyPhone
     */
    public void setSMSNotifyPhone(java.lang.String SMSNotifyPhone) {
        this.SMSNotifyPhone = SMSNotifyPhone;
    }


    /**
     * Gets the secondary1 value for this QueryUserResponse.
     * 
     * @return secondary1
     */
    public java.lang.String getSecondary1() {
        return secondary1;
    }


    /**
     * Sets the secondary1 value for this QueryUserResponse.
     * 
     * @param secondary1
     */
    public void setSecondary1(java.lang.String secondary1) {
        this.secondary1 = secondary1;
    }


    /**
     * Gets the secondary2 value for this QueryUserResponse.
     * 
     * @return secondary2
     */
    public java.lang.String getSecondary2() {
        return secondary2;
    }


    /**
     * Sets the secondary2 value for this QueryUserResponse.
     * 
     * @param secondary2
     */
    public void setSecondary2(java.lang.String secondary2) {
        this.secondary2 = secondary2;
    }


    /**
     * Gets the secondary3 value for this QueryUserResponse.
     * 
     * @return secondary3
     */
    public java.lang.String getSecondary3() {
        return secondary3;
    }


    /**
     * Sets the secondary3 value for this QueryUserResponse.
     * 
     * @param secondary3
     */
    public void setSecondary3(java.lang.String secondary3) {
        this.secondary3 = secondary3;
    }


    /**
     * Gets the secondary4 value for this QueryUserResponse.
     * 
     * @return secondary4
     */
    public java.lang.String getSecondary4() {
        return secondary4;
    }


    /**
     * Sets the secondary4 value for this QueryUserResponse.
     * 
     * @param secondary4
     */
    public void setSecondary4(java.lang.String secondary4) {
        this.secondary4 = secondary4;
    }


    /**
     * Gets the secondary5 value for this QueryUserResponse.
     * 
     * @return secondary5
     */
    public java.lang.String getSecondary5() {
        return secondary5;
    }


    /**
     * Sets the secondary5 value for this QueryUserResponse.
     * 
     * @param secondary5
     */
    public void setSecondary5(java.lang.String secondary5) {
        this.secondary5 = secondary5;
    }


    /**
     * Gets the MCAservice value for this QueryUserResponse.
     * 
     * @return MCAservice
     */
    public java.lang.String getMCAservice() {
        return MCAservice;
    }


    /**
     * Sets the MCAservice value for this QueryUserResponse.
     * 
     * @param MCAservice
     */
    public void setMCAservice(java.lang.String MCAservice) {
        this.MCAservice = MCAservice;
    }


    /**
     * Gets the CMNservice value for this QueryUserResponse.
     * 
     * @return CMNservice
     */
    public java.lang.String getCMNservice() {
        return CMNservice;
    }


    /**
     * Sets the CMNservice value for this QueryUserResponse.
     * 
     * @param CMNservice
     */
    public void setCMNservice(java.lang.String CMNservice) {
        this.CMNservice = CMNservice;
    }


    /**
     * Gets the usertype value for this QueryUserResponse.
     * 
     * @return usertype
     */
    public java.lang.String getUsertype() {
        return usertype;
    }


    /**
     * Sets the usertype value for this QueryUserResponse.
     * 
     * @param usertype
     */
    public void setUsertype(java.lang.String usertype) {
        this.usertype = usertype;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryUserResponse)) return false;
        QueryUserResponse other = (QueryUserResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.resultcode == other.getResultcode() &&
            ((this.IDNumber==null && other.getIDNumber()==null) || 
             (this.IDNumber!=null &&
              this.IDNumber.equals(other.getIDNumber()))) &&
            ((this.LDOperatorCode==null && other.getLDOperatorCode()==null) || 
             (this.LDOperatorCode!=null &&
              this.LDOperatorCode.equals(other.getLDOperatorCode()))) &&
            ((this.MWNDest==null && other.getMWNDest()==null) || 
             (this.MWNDest!=null &&
              this.MWNDest.equals(other.getMWNDest()))) &&
            ((this.MWNType==null && other.getMWNType()==null) || 
             (this.MWNType!=null &&
              this.MWNType.equals(other.getMWNType()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.entryAuthen==null && other.getEntryAuthen()==null) || 
             (this.entryAuthen!=null &&
              this.entryAuthen.equals(other.getEntryAuthen()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.messageNotify==null && other.getMessageNotify()==null) || 
             (this.messageNotify!=null &&
              this.messageNotify.equals(other.getMessageNotify()))) &&
            ((this.serviceClass==null && other.getServiceClass()==null) || 
             (this.serviceClass!=null &&
              this.serviceClass.equals(other.getServiceClass()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.userStatus==null && other.getUserStatus()==null) || 
             (this.userStatus!=null &&
              this.userStatus.equals(other.getUserStatus()))) &&
            ((this.zipCode==null && other.getZipCode()==null) || 
             (this.zipCode!=null &&
              this.zipCode.equals(other.getZipCode()))) &&
            ((this.terminalType==null && other.getTerminalType()==null) || 
             (this.terminalType!=null &&
              this.terminalType.equals(other.getTerminalType()))) &&
            ((this.billingNumber==null && other.getBillingNumber()==null) || 
             (this.billingNumber!=null &&
              this.billingNumber.equals(other.getBillingNumber()))) &&
            ((this.MMSDest==null && other.getMMSDest()==null) || 
             (this.MMSDest!=null &&
              this.MMSDest.equals(other.getMMSDest()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.SMSNotifyPhone==null && other.getSMSNotifyPhone()==null) || 
             (this.SMSNotifyPhone!=null &&
              this.SMSNotifyPhone.equals(other.getSMSNotifyPhone()))) &&
            ((this.secondary1==null && other.getSecondary1()==null) || 
             (this.secondary1!=null &&
              this.secondary1.equals(other.getSecondary1()))) &&
            ((this.secondary2==null && other.getSecondary2()==null) || 
             (this.secondary2!=null &&
              this.secondary2.equals(other.getSecondary2()))) &&
            ((this.secondary3==null && other.getSecondary3()==null) || 
             (this.secondary3!=null &&
              this.secondary3.equals(other.getSecondary3()))) &&
            ((this.secondary4==null && other.getSecondary4()==null) || 
             (this.secondary4!=null &&
              this.secondary4.equals(other.getSecondary4()))) &&
            ((this.secondary5==null && other.getSecondary5()==null) || 
             (this.secondary5!=null &&
              this.secondary5.equals(other.getSecondary5()))) &&
            ((this.MCAservice==null && other.getMCAservice()==null) || 
             (this.MCAservice!=null &&
              this.MCAservice.equals(other.getMCAservice()))) &&
            ((this.CMNservice==null && other.getCMNservice()==null) || 
             (this.CMNservice!=null &&
              this.CMNservice.equals(other.getCMNservice()))) &&
            ((this.usertype==null && other.getUsertype()==null) || 
             (this.usertype!=null &&
              this.usertype.equals(other.getUsertype())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getResultcode();
        if (getIDNumber() != null) {
            _hashCode += getIDNumber().hashCode();
        }
        if (getLDOperatorCode() != null) {
            _hashCode += getLDOperatorCode().hashCode();
        }
        if (getMWNDest() != null) {
            _hashCode += getMWNDest().hashCode();
        }
        if (getMWNType() != null) {
            _hashCode += getMWNType().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getEntryAuthen() != null) {
            _hashCode += getEntryAuthen().hashCode();
        }
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        if (getMessageNotify() != null) {
            _hashCode += getMessageNotify().hashCode();
        }
        if (getServiceClass() != null) {
            _hashCode += getServiceClass().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getUserStatus() != null) {
            _hashCode += getUserStatus().hashCode();
        }
        if (getZipCode() != null) {
            _hashCode += getZipCode().hashCode();
        }
        if (getTerminalType() != null) {
            _hashCode += getTerminalType().hashCode();
        }
        if (getBillingNumber() != null) {
            _hashCode += getBillingNumber().hashCode();
        }
        if (getMMSDest() != null) {
            _hashCode += getMMSDest().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getSMSNotifyPhone() != null) {
            _hashCode += getSMSNotifyPhone().hashCode();
        }
        if (getSecondary1() != null) {
            _hashCode += getSecondary1().hashCode();
        }
        if (getSecondary2() != null) {
            _hashCode += getSecondary2().hashCode();
        }
        if (getSecondary3() != null) {
            _hashCode += getSecondary3().hashCode();
        }
        if (getSecondary4() != null) {
            _hashCode += getSecondary4().hashCode();
        }
        if (getSecondary5() != null) {
            _hashCode += getSecondary5().hashCode();
        }
        if (getMCAservice() != null) {
            _hashCode += getMCAservice().hashCode();
        }
        if (getCMNservice() != null) {
            _hashCode += getCMNservice().hashCode();
        }
        if (getUsertype() != null) {
            _hashCode += getUsertype().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryUserResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("vms", ">QueryUserResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultcode");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "resultcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "IDNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LDOperatorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "LDOperatorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MWNDest");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "MWNDest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MWNType");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "MWNType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entryAuthen");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "entryAuthen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("language");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "language"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageNotify");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "messageNotify"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceClass");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "serviceClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "userStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zipCode");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "zipCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminalType");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "TerminalType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("billingNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "BillingNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MMSDest");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "MMSDest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "Password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMSNotifyPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "SMSNotifyPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secondary1");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "Secondary1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secondary2");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "Secondary2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secondary3");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "Secondary3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secondary4");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "Secondary4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secondary5");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "Secondary5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MCAservice");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "MCAservice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMNservice");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "CMNservice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usertype");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "Usertype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
