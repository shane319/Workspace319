/*******************************************************************
 *
 * FILE NAME   : RequestGenerator.java
 *
 * DESCRIPTION : It generate the input request xml for NE
 * 
 * DOCUMENTS   : 
 *
 * AUTHOR      : Subhasish Mondal(esumond)
 *
 * DATE        : Nov-2012
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
package com.ericsson.mmsc.generator;

import com.ericsson.ema.downstream.bean.RequestBean;

public class RequestGenerator {
	public String generate(RequestBean requestBean, String sessionId) {
		StringBuffer request = new StringBuffer();

		request.append("<soap-env:Envelope xmlns:soap-env=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		request.append("<soap-env:Header>");
		request.append("<sessionId>" + sessionId + "</sessionId>");
		request.append("<transactionId>" + requestBean.getTransactionId()
				+ "</transactionId>");
		request.append("</soap-env:Header>");
		request.append("<soap-env:Body>");
		request.append("<Delete>");
		request.append("<MOType>subscriber</MOType>");
		request.append("<MOId>");
		request.append("<MSISDN>" + requestBean.getMsisdn() + "</MSISDN>");
		request.append("</MOId>");
		request.append("</Delete>");
		request.append("</soap-env:Body>");
		request.append("</soap-env:Envelope>");

		return request.toString();
	}

	public String generateLoginRequest(String userid, String pass) {
		StringBuffer request = new StringBuffer();

		request.append("<soap-env:Envelope xmlns:soap-env=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		request.append("<soap-env:Header>");
		request.append("</soap-env:Header>");
		request.append("<soap-env:Body>");
		request.append("<Login>");
		request.append("<userId>" + userid + "</userId>");
		request.append("<pwd>" + pass + "</pwd>");
		request.append("</Login>");
		request.append("</soap-env:Body>");
		request.append("</soap-env:Envelope>");

		return request.toString();
	}

	public String generateLogoutRequest(String sessionId) {
		StringBuffer request = new StringBuffer();

		request.append("<soap-env:Envelope xmlns:soap-env=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		request.append("<soap-env:Header>");
		request.append("<sessionId>" + sessionId + "</sessionId>");
		request.append("</soap-env:Header>");
		request.append("<soap-env:Body>");
		request.append("<Logout></Logout>");
		request.append("</soap-env:Body>");
		request.append("</soap-env:Envelope>");

		return request.toString();
	}
}
