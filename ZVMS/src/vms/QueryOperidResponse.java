/**
 * QueryOperidResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package vms;

public class QueryOperidResponse  implements java.io.Serializable {
    private int resultcode;

    private java.lang.String operID;

    private java.lang.String description;

    public QueryOperidResponse() {
    }

    public QueryOperidResponse(
           int resultcode,
           java.lang.String operID,
           java.lang.String description) {
           this.resultcode = resultcode;
           this.operID = operID;
           this.description = description;
    }


    /**
     * Gets the resultcode value for this QueryOperidResponse.
     * 
     * @return resultcode
     */
    public int getResultcode() {
        return resultcode;
    }


    /**
     * Sets the resultcode value for this QueryOperidResponse.
     * 
     * @param resultcode
     */
    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }


    /**
     * Gets the operID value for this QueryOperidResponse.
     * 
     * @return operID
     */
    public java.lang.String getOperID() {
        return operID;
    }


    /**
     * Sets the operID value for this QueryOperidResponse.
     * 
     * @param operID
     */
    public void setOperID(java.lang.String operID) {
        this.operID = operID;
    }


    /**
     * Gets the description value for this QueryOperidResponse.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this QueryOperidResponse.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryOperidResponse)) return false;
        QueryOperidResponse other = (QueryOperidResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.resultcode == other.getResultcode() &&
            ((this.operID==null && other.getOperID()==null) || 
             (this.operID!=null &&
              this.operID.equals(other.getOperID()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription())));
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
        if (getOperID() != null) {
            _hashCode += getOperID().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryOperidResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("vms", ">QueryOperidResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultcode");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "resultcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operID");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "OperID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
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
