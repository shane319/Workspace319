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

package com.ericsson.ema.downstream.webpsub;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.ericsson.ema.downstream.bean.ResponseBean;
import com.ericsson.ema.downstream.config.Config;
import com.ericsson.ema.downstream.controller.ProvisioningController;

import se.ericsson.ema.downstream.DownStreamConnection;
import se.ericsson.ema.downstream.DownStreamException;

public class DemoJavalink implements DownStreamConnection {
	static final Logger logger = Logger.getLogger(DemoJavalink.class);

	String[] configurations;

	/***************************************************************************
	 * Link Constructor *
	 **************************************************************************/
	public DemoJavalink() {
		DOMConfigurator.configure("/var/sog/sdk/downstream/java/WEBP/log4j.xml");
		//System.out.println("DemoJavalink()");
		logger.info("DemoJavalink()");
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
		//System.out.println("setConfiguration:");
		logger.info("setConfiguration:");
		for (int i = 0; i < configurations.length; ++i) {
			//System.out.println("Param:" + i + ":" + configurations[i]);
			logger.info("Param:" + i + ":" + configurations[i]);
		}

		this.configurations = configurations;
	}

	/***************************************************************************
	 * Link Connection *
	 **************************************************************************/
	public void connect() throws DownStreamException {
		// Set up the connection to the NE
		//System.out.println("connect()");
		logger.info("connect()");
	}

	/***************************************************************************
	 * Send Message *
	 **************************************************************************/
	public String sendMessage(String mmlString) throws DownStreamException {
		// send MML command
		// to the NE and return the NE response
		
		Long start_time = System.currentTimeMillis();
		
		

		ProvisioningController provisioningController = new ProvisioningController(
				configurations, mmlString);
		ResponseBean responseBean = provisioningController.performJob();

		// TODO Auto-generated method stub
		logger.info("Response: \n" + responseBean.getResponse());
		
		/*Long end_time = System.currentTimeMillis();
		Long execution_time = end_time - start_time;
		logger.info("Execution time: "+execution_time+" Start time: "+start_time+" End time: "+end_time);
	
		*/
		
		
		
		Long end_time = System.currentTimeMillis();
		Long execution_time = end_time - start_time;
		//logger.info("Execution time: "+execution_time+" Start time: "+start_time+" End time: "+end_time);
		
		//System.out.println("\n\nExecution Time => "+execution_time+" millisecond\n----- Request -----\n"+mmlString+"\n----- Response -----\n"+responseBean.getResponse());
		logger.info("\n\nExecution Time => "+execution_time+" millisecond\n----- Request -----\n"+mmlString+"\n----- Response -----\n"+responseBean.getResponse());
		
		
		
		return responseBean.getResponse();
	}

	/***************************************************************************
	 * Link Disconnection *
	 **************************************************************************/
	public void disconnect() throws DownStreamException {
		// To close the connection to the NE
		//System.out.println("disconnect()");
		logger.info("disconnect()");
	}
}
