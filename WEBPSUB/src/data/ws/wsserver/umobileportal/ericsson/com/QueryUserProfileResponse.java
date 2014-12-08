/**
 * QueryUserProfileResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package data.ws.wsserver.umobileportal.ericsson.com;

public class QueryUserProfileResponse  extends data.ws.wsserver.umobileportal.ericsson.com.Response  implements java.io.Serializable {
    private java.lang.Integer pinFlag;

    private java.lang.Integer userStatus;

    public QueryUserProfileResponse() {
    }

    public QueryUserProfileResponse(
           java.lang.String requestID,
           java.lang.Integer statusCode,
           java.lang.String errorMessage,
           java.lang.String transactionId,
           java.lang.Integer pinFlag,
           java.lang.Integer userStatus) {
        super(
            requestID,
            statusCode,
            errorMessage,
            transactionId);
        this.pinFlag = pinFlag;
        this.userStatus = userStatus;
    }


    /**
     * Gets the pinFlag value for this QueryUserProfileResponse.
     * 
     * @return pinFlag
     */
    public java.lang.Integer getPinFlag() {
        return pinFlag;
    }


    /**
     * Sets the pinFlag value for this QueryUserProfileResponse.
     * 
     * @param pinFlag
     */
    public void setPinFlag(java.lang.Integer pinFlag) {
        this.pinFlag = pinFlag;
    }


    /**
     * Gets the userStatus value for this QueryUserProfileResponse.
     * 
     * @return userStatus
     */
    public java.lang.Integer getUserStatus() {
        return userStatus;
    }


    /**
     * Sets the userStatus value for this QueryUserProfileResponse.
     * 
     * @param userStatus
     */
    public void setUserStatus(java.lang.Integer userStatus) {
        this.userStatus = userStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryUserProfileResponse)) return false;
        QueryUserProfileResponse other = (QueryUserProfileResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.pinFlag==null && other.getPinFlag()==null) || 
             (this.pinFlag!=null &&
              this.pinFlag.equals(other.getPinFlag()))) &&
            ((this.userStatus==null && other.getUserStatus()==null) || 
             (this.userStatus!=null &&
              this.userStatus.equals(other.getUserStatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getPinFlag() != null) {
            _hashCode += getPinFlag().hashCode();
        }
        if (getUserStatus() != null) {
            _hashCode += getUserStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryUserProfileResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:com.ericsson.umobileportal.wsserver.ws.data", "QueryUserProfileResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pinFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ericsson.umobileportal.wsserver.ws.data", "PinFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ericsson.umobileportal.wsserver.ws.data", "UserStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
