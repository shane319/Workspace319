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
	private Service service = null;
	private String Username = null;
	private int timeOut;
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	private String Password = null;

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

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	
}
