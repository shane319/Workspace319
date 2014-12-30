/*******************************************************************
 *
 * FILE NAME   : NEConfig.java
 *
 * DESCRIPTION : Required data for NE configuration is defined here.
 * 
 * DOCUMENTS   : 
 *
 * AUTHOR      : Subhasish Mondal(esumond)
 *
 * DATE        : Aug-2012
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

package com.ericsson.ema.downstream.config;

import java.net.URL;

import javax.xml.rpc.Service;

public class NEConfig {
	private URL endpointURL = null;
	private URL changeMsisdnURL = null;
	private Service service = null;
	private int timeOut;
	private String username = null ;
	private String password = null ;

	public NEConfig() {
		super();
	}

	public NEConfig(URL endpointURL) {
		super();
		this.endpointURL = endpointURL;
	}

	public NEConfig(URL endpointURL, Service service) {
		super();
		this.endpointURL = endpointURL;
		this.service = service;
	}

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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public void setChangeMsisdnURL(URL changeMsisdnURL) {
		this.changeMsisdnURL = changeMsisdnURL;
	}

	public URL getChangeMsisdnURL() {
		return changeMsisdnURL;
	}


	

}
