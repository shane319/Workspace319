/**
 * ------------------------------------------------------------------------
 *
 * (C) Copyright Ericsson AB, 2007
 *
 * The copyright to the computer program (s) herein is the property of
 * Ericsson AB, Sweden. The program (s) may be used and/or
 * copied only with the written permission from Ericsson AB
 * or in accordance with the terms and conditions stipulated in the
 * agreement/contract under which the program (s) has been supplied.
 * All rights reserved.
 *
 * ------------------------------------------------------------------------
 * Ericsson MA Composer - Java Downstream
 * ------------------------------------------------------------------------
 */

package com.ericsson.ema.downstream.zvms;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import com.ericsson.ema.downstream.bean.ResponseBean;
import com.ericsson.ema.downstream.config.Config;
import com.ericsson.ema.downstream.controller.ProvisioningController;
import se.ericsson.ema.downstream.DownStreamConnection;
import se.ericsson.ema.downstream.DownStreamException;

public class VmsJavalink implements DownStreamConnection {
	static final Logger logger = Logger.getLogger(VmsJavalink.class);
	private String[] configurations;

	/***************************************************************************
	 * Link Constructor *
	 **************************************************************************/
	public VmsJavalink() {
		
		DOMConfigurator.configure("/var/sog/sdk/downstream/java/ZVMS/log4j.xml");
		//System.out.println("DemoJavalink()");
	}

	/***************************************************************************
	 * Set Configuration *
	 **************************************************************************/
	public void setConfiguration(String[] configurations)
			throws DownStreamException {
		// To set the NE link parameters
		// The number and sequence of the link parameters is the
		// same as the one configured in the EMA GUI
		//DOMConfigurator.configure(Config.SYS_CONFIG_PATH + "log4j.xml");
		logger.info("setConfiguration:");
		for (int i = 0; i < configurations.length; ++i) {
			logger.info("Param:" + i + ":" + configurations[i]);
		}

		this.configurations = configurations;

	}

	/***************************************************************************
	 * Link Connection *
	 **************************************************************************/
	public void connect() throws DownStreamException {
		// Set up the connection to the NE
		// A simple socket is used
		// user can implement any other protocols here
		logger.info("connect()");
	}

	/***************************************************************************
	 * Send Message *
	 **************************************************************************/
	public String sendMessage(String mmlString) throws DownStreamException {
		// send MML command
		// to the NE and return the NE response
		
		Long start_time = System.currentTimeMillis();
		
		//logger.info("receive:" + mmlString);

		ResponseBean responseBean = new ResponseBean();
		ProvisioningController provisioningController = new ProvisioningController(
				configurations, mmlString);

		responseBean = provisioningController.performJob();

		//System.out.println("Response Des: " + responseBean.getDescription());
		//System.out.println("Response Code: " + responseBean.getResultcode());
		
		//logger.info("Response Code: " + responseBean.getResultcode());
		//logger.info("Response Desription : " + responseBean.getDescription());
		
		//System.out.println("Response: \n" + responseBean.getResponse());
		//logger.info("Response: \n" + responseBean.getResponse());
		// TODO Auto-generated method stub
		
		
		Long end_time = System.currentTimeMillis();
		Long execution_time = end_time - start_time;
		logger.info("\nExecution time: "+execution_time+"\nRequest: \n"+mmlString+"\nResponse: \n"+responseBean.getResponse());
	
		
		return responseBean.getResponse();
	}

	/***************************************************************************
	 * Link Disconnection *
	 **************************************************************************/
	public void disconnect() throws DownStreamException {
		// To close the connection to the NE
		logger.info("disconnect()");
	}
}
