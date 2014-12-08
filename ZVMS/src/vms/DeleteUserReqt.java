/**
 * DeleteUserReqt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package vms;

public class DeleteUserReqt  implements java.io.Serializable {
    private java.lang.String boxNumber;

    private java.lang.String operID;

    private java.lang.String operPwd;

    public DeleteUserReqt() {
    }

    public DeleteUserReqt(
           java.lang.String boxNumber,
           java.lang.String operID,
           java.lang.String operPwd) {
           this.boxNumber = boxNumber;
           this.operID = operID;
           this.operPwd = operPwd;
    }


    /**
     * Gets the boxNumber value for this DeleteUserReqt.
     * 
     * @return boxNumber
     */
    public java.lang.String getBoxNumber() {
        return boxNumber;
    }


    /**
     * Sets the boxNumber value for this DeleteUserReqt.
     * 
     * @param boxNumber
     */
    public void setBoxNumber(java.lang.String boxNumber) {
        this.boxNumber = boxNumber;
    }


    /**
     * Gets the operID value for this DeleteUserReqt.
     * 
     * @return operID
     */
    public java.lang.String getOperID() {
        return operID;
    }


    /**
     * Sets the operID value for this DeleteUserReqt.
     * 
     * @param operID
     */
    public void setOperID(java.lang.String operID) {
        this.operID = operID;
    }


    /**
     * Gets the operPwd value for this DeleteUserReqt.
     * 
     * @return operPwd
     */
    public java.lang.String getOperPwd() {
        return operPwd;
    }


    /**
     * Sets the operPwd value for this DeleteUserReqt.
     * 
     * @param operPwd
     */
    public void setOperPwd(java.lang.String operPwd) {
        this.operPwd = operPwd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteUserReqt)) return false;
        DeleteUserReqt other = (DeleteUserReqt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.boxNumber==null && other.getBoxNumber()==null) || 
             (this.boxNumber!=null &&
              this.boxNumber.equals(other.getBoxNumber()))) &&
            ((this.operID==null && other.getOperID()==null) || 
             (this.operID!=null &&
              this.operID.equals(other.getOperID()))) &&
            ((this.operPwd==null && other.getOperPwd()==null) || 
             (this.operPwd!=null &&
              this.operPwd.equals(other.getOperPwd())));
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
        if (getBoxNumber() != null) {
            _hashCode += getBoxNumber().hashCode();
        }
        if (getOperID() != null) {
            _hashCode += getOperID().hashCode();
        }
        if (getOperPwd() != null) {
            _hashCode += getOperPwd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeleteUserReqt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("vms", ">DeleteUserReqt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boxNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "BoxNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operID");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "OperID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operPwd");
        elemField.setXmlName(new javax.xml.namespace.QName("vms", "OperPwd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        //added to remove empty tag (21-10-2013 : EJLNOPC)
        elemField.setMinOccurs(0);
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
