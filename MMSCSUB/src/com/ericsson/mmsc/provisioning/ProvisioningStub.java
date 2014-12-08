/*******************************************************************
 *
 * FILE NAME   : ProvisioningStub.java
 *
 * DESCRIPTION : Making connection and send the request xml towards NE
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

package com.ericsson.mmsc.provisioning;

import java.io.IOException;
import java.net.URL;
import com.ericsson.mmsc.generator.RequestGenerator;
import com.ericsson.mmsc.util.LoginResponseParser;
import com.ericsson.mmsc.util.ResponseParser;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.bean.ResponseBean;

public class ProvisioningStub {
	static final Logger logger = Logger.getLogger(ProvisioningStub.class);
	private java.net.URL endpointURL;
	private String userName;
	private String password;
	private int timeOut;
	

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public ProvisioningStub(URL endpointURL, String username, String password) {
		super();
		this.endpointURL = endpointURL;
		this.userName = username;
		this.password = password;
	}

	public ResponseBean submitRequest(RequestBean request) throws HttpException,
			IOException, Exception {
		ResponseBean response = null;
		RequestGenerator requestGenerator = new RequestGenerator();
		String loginResponse = createCall(requestGenerator.generateLoginRequest(userName, password));
		String sessionId = new LoginResponseParser().parseResponse(loginResponse);
		String rawResp = createCall(requestGenerator.generate(request,sessionId));
		logger.debug("Parsing response");
		response = new ResponseParser().parseResponse(rawResp);
		createCall(requestGenerator.generateLogoutRequest(sessionId));
		return response;
	}

	

	private String createCall(String postMessage) throws HttpException,
			IOException {
		System.out.println("URL: " + endpointURL.toString());
		System.out.println("Message: \n" + postMessage);

		logger.info("URL: " + endpointURL);
		logger.info("UserId: " + userName);
		logger.info("Password: " + password);
		logger.info("Message request: \n" + postMessage);

		
		PostMethod postMethod = null;
		
		HttpClient httpClient = new HttpClient();
		
		HttpConnectionManager httpConnectionManager = httpClient.getHttpConnectionManager();
		httpConnectionManager.getParams().setConnectionTimeout(this.timeOut);
		httpConnectionManager.getParams().setSoTimeout(this.timeOut);
		
		
		String response = null;
		try {
			postMethod = new PostMethod(endpointURL.toString());
			
			postMethod.setRequestEntity(new StringRequestEntity(postMessage,
					"text/plain", "UTF-8"));
			// postMethod.addParameter(postMessage,"text/xml; charset=UTF-8");
			postMethod.setRequestHeader("Content-Type", "text/xml; charset=UTF-8");
			postMethod.setRequestHeader("Connection", "close");
			
			int statusCode = httpClient.executeMethod(postMethod);
			System.out.println("Status code: " + statusCode);

			response = postMethod.getResponseBodyAsString();
		} finally {
			if (postMethod != null){
				postMethod.releaseConnection();
			}
		}
				
		logger.info("Response: \n" + response);
		return response;
	}
}