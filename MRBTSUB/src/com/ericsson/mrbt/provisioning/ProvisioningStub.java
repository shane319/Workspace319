package com.ericsson.mrbt.provisioning;

import java.io.IOException;
import java.net.URL;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
import com.ericsson.mrbt.generator.RequestGenerator;
import com.ericsson.ema.downstream.bean.RequestBean;


public class ProvisioningStub {
	public static int CONNECTION_TIME_OUT = 2;
	public static int SO_TIME_OUT = 2;
	
	static final Logger logger = Logger.getLogger(ProvisioningStub.class);
	private java.net.URL endpointURL;
	public ProvisioningStub(URL endpointURL) {
		super();
		this.endpointURL = endpointURL;
	}
	
	
	public void submitRequest(RequestBean request) throws HttpException, IOException{
		
		RequestGenerator requestGenerator = new RequestGenerator();
		createCall(requestGenerator.generate(request));
		
	}
	
	private String createCall(String postMessage) throws HttpException, IOException{
		logger.info("URL: "+endpointURL.toString());
		logger.info("Message: \n"+postMessage);
		
		System.out.println("URL: "+endpointURL.toString());
		System.out.println("Message: \n"+postMessage);
		
		HttpClient httpClient = new HttpClient();
		
		
		HttpConnectionManager httpConnectionManager = httpClient.getHttpConnectionManager();
		httpConnectionManager.getParams().setConnectionTimeout(CONNECTION_TIME_OUT * 1000);
		httpConnectionManager.getParams().setSoTimeout(SO_TIME_OUT * 1000);
		
		
		PostMethod postMethod = new PostMethod(endpointURL.toString());
		
		postMethod.setRequestEntity(new StringRequestEntity(postMessage,"text/plain", "UTF-8"));
		//postMethod.addParameter(postMessage,"text/xml; charset=UTF-8");
		postMethod.setRequestHeader("Content-Type", "text/xml; charset=UTF-8");
		
		int statusCode = httpClient.executeMethod(postMethod);
		
		logger.info("Status code: "+statusCode);
		System.out.println("Status code: "+statusCode);
		
		String response = postMethod.getResponseBodyAsString();
		return response;
	}
}
