package com.ericsson.mrbt.generator;

import com.ericsson.ema.downstream.bean.RequestBean;

public class RequestGenerator {
	public String generate(RequestBean requestBean){
		StringBuffer request = new StringBuffer();
		
		request.append("<soapenv:Envelope targetNamespace=\"http://ws.mrbt.genico.ngc.com.my\"");
	    request.append("xmlns:tns=\"http://ws.mrbt.genico.ngc.com.my\"");
	    request.append("xmlns:wsdlsoap=\"http://schemas.xmlsoap.org/wsdl/soap/\"");
	    request.append("xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"");
	    request.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
	    request.append("xmlns:soapenc11=\"http://schemas.xmlsoap.org/soap/encoding/\"");
	    request.append("xmlns:soapenc12=\"http://www.w3.org/2003/05/soap-encoding\"");
	    request.append("xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"");
	    request.append("xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"");
	    request.append("soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">");
	    request.append("<soapenv:Body>");
	    request.append("<"+requestBean.getOperation()+" xmlns=\"http://ws.mrbt.genico.ngc.com.my\">");
	    request.append("<hlrResponse>"+requestBean.getHlrResponse()+"</hlrResponse>");
	    request.append("<msisdn>"+requestBean.getMsisdn()+"</msisdn>");
	    request.append("</"+requestBean.getOperation()+">");
	    request.append("</soapenv:Body>");
	    request.append("</soapenv:Envelope>");
	    	    
	    return request.toString().replaceAll("\n", "");
	}
	
}
