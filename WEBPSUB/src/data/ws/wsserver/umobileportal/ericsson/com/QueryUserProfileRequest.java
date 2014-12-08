/**
 * QueryUserProfileRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package data.ws.wsserver.umobileportal.ericsson.com;

public class QueryUserProfileRequest  extends data.ws.wsserver.umobileportal.ericsson.com.Request  implements java.io.Serializable {
    private java.lang.Integer pinNumber;

    public QueryUserProfileRequest() {
    }

    public QueryUserProfileRequest(
           java.lang.String requestID,
           java.lang.String msisdn,
           java.lang.Integer pinNumber) {
        super(
            requestID,
            msisdn);
        this.pinNumber = pinNumber;
    }


    /**
     * Gets the pinNumber value for this QueryUserProfileRequest.
     * 
     * @return pinNumber
     */
    public java.lang.Integer getPinNumber() {
        return pinNumber;
    }


    /**
     * Sets the pinNumber value for this QueryUserProfileRequest.
     * 
     * @param pinNumber
     */
    public void setPinNumber(java.lang.Integer pinNumber) {
        this.pinNumber = pinNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryUserProfileRequest)) return false;
        QueryUserProfileRequest other = (QueryUserProfileRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.pinNumber==null && other.getPinNumber()==null) || 
             (this.pinNumber!=null &&
              this.pinNumber.equals(other.getPinNumber())));
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
        if (getPinNumber() != null) {
            _hashCode += getPinNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryUserProfileRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:com.ericsson.umobileportal.wsserver.ws.data", "QueryUserProfileRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pinNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ericsson.umobileportal.wsserver.ws.data", "PinNumber"));
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
