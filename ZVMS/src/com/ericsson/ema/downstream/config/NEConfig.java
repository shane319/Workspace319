package com.ericsson.ema.downstream.config;

import java.net.URL;

import javax.xml.rpc.Service;

public class NEConfig {
	private URL endpointURL = null;
	private Service service = null;
	
	private int timeOut = -1;
	
	public URL getEndpointURL() {
		return endpointURL;
	}
	public void setEndpointURL(URL endpointURL) {
		this.endpointURL = endpointURL;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public int getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
	
}
