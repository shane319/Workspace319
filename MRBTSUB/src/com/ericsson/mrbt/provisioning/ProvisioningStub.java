package com.ericsson.mrbt.provisioning;

import java.io.IOException;
import java.net.URL;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
import com.ericsson.mrbt.generator.RequestGenerator;
import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.mrbtsub.DemoJavalink;


public class ProvisioningStub {
	public static int CONNECTION_TIME_OUT = 2;
	public static int SO_TIME_OUT = 2;
	
	private String username ;
	private String password ; 
	private int timeout;
	
	static final Logger logger = Logger.getLogger(ProvisioningStub.class);
	private java.net.URL endpointURL;
	public ProvisioningStub(URL endpointURL) {
		super();
		this.endpointURL = endpointURL;
	}
	
	public ProvisioningStub(URL endpointURL, String username, String password, int timeout) {
		super();
		this.endpointURL = endpointURL;
		this.username = username ;
		this.password = password ;
		this.timeout = timeout;
	}
	
	public void submitRequest(RequestBean request) throws HttpException, IOException{
		
		RequestGenerator requestGenerator = new RequestGenerator();
		createCall(requestGenerator.generate(request));
	}
	
	public String[] changeMsisdn(RequestBean request) throws HttpException, IOException{
		 
		HttpClient httpClient = new HttpClient();
		 
		
		HttpConnectionManager httpConnectionManager = httpClient.getHttpConnectionManager();
		httpConnectionManager.getParams().setConnectionTimeout(timeout);
		httpConnectionManager.getParams().setSoTimeout(timeout);
		
		//TODO: Can not hard code URL/IP/PORT/UserName/Password
//		String openURL = String.format("http://10.30.32.21:8080/subscription/ChangeMsisdn?user=mmp&pass=mmp&msisdn=%s" +
//				"&newmsisdn=%s&siteid=1&newsiteid=1&refid=1", request.getMsisdn(),request.getNewMsisdn());
		
		String openURL = String.format("%s?user=%s&pass=%s&msisdn=%s" +
				"&newmsisdn=%s&siteid=1&newsiteid=1&refid=1", this.endpointURL, this.username, this.password, 
					request.getMsisdn(),request.getNewMsisdn());
	
		
		if (DemoJavalink.logger.isInfoEnabled()){
			DemoJavalink.logger.info(String.format("Sending HTTP request: %s", openURL ));
		}
		
		String responseBody = null;
		int statusCode = -1;
		GetMethod httpGet = new GetMethod(openURL);
		try {
			statusCode = httpClient.executeMethod(httpGet);
			responseBody = httpGet.getResponseBodyAsString();
			if (DemoJavalink.logger.isDebugEnabled()){
				DemoJavalink.logger.debug(String.format("Change msisdn, %s, %s, status code is %s, response body is %s", 
						request.getMsisdn(), request.getNewMsisdn(), statusCode, responseBody));
			}
		} finally {
			 httpGet.releaseConnection();
		}
		
		String errorDescription = "";
		if (responseBody !=null && responseBody.indexOf("|")>=0){
			errorDescription = responseBody.split("\\|", -1)[1];
		}
		return new String[]{String.valueOf(statusCode), errorDescription.replaceAll("\n", "")};
		
		//i, Open URL (http://<ip:<port>/subscription/ChangeMsisdn?user=mmp&pass=mmp&msisdn=9845115965&newmsisdn=9845000000&siteid=1&newsiteid=1&refid=1)
		//ii, get the status code
		
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
