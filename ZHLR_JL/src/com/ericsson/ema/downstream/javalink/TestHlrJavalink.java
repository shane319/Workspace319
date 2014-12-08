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
 */

package com.ericsson.ema.downstream.javalink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import se.ericsson.ema.downstream.DownStreamException;

public class TestHlrJavalink
{
    static final Logger logger = Logger.getLogger(TestHlrJavalink.class);
    
    public static void main(String[] args)
		    throws DownStreamException
    {
         //String[] configurations =  { "localhost", "3140", "", "DSA", "Password" };
        String[] configurations =  { "10.48.50.8", "3140", "", "DSA", "Password" };
        
        HlrJavalink hlink = new HlrJavalink();
        hlink.setConfiguration(configurations);
        hlink.connect();
	logger.info("Connected");
	System.out.println("Connected");

	for (int i = 0; i < 2; i++) {
	    String command, response;

	    command = String.format("ADD USER:IMSI=5101388888%05d,MSISDN=6912209%05d,PROFILE=7;", i, i);
	    logger.info("Command: \"" + command + "\"");
	    System.out.println("Command : \"" + command + "\"");
	    response = hlink.sendMessage(command);
	    logger.info("Response: \"" + response + "\"");
	    System.out.println("Response: \"" + response + "\"" + "\n");

	    command = String.format("MOD IMSI: IMSI=5101388888%05d,NewIMSID=5101377777%05d;", i, i);
	    logger.info("Command: \"" + command + "\"");
	    System.out.println("Command : \"" + command + "\"");
	    response = hlink.sendMessage(command);
	    logger.info("Response: \"" + response + "\"");
	    System.out.println("Response: \"" + response + "\"" + "\n");

	    command = String.format("QRY USER: IMSI=5101388888%05d, Item=ISDN;", i);
	    logger.info("Command: \"" + command + "\"");
	    System.out.println("Command : \"" + command + "\"");
	    response = hlink.sendMessage(command);
	    logger.info("Response: \"" + response + "\"");
	    System.out.println("Response: \"" + response + "\"" + "\n");

	    command = String.format("DEL USER:MSISDN=6912209%05d;", i);
	    logger.info("Command: \"" + command + "\"");
	    System.out.println("Command : \"" + command + "\"");
	    response = hlink.sendMessage(command);
	    logger.info("Response: \"" + response + "\"");
	    System.out.println("Response: \"" + response + "\"" + "\n");
	}
        hlink.disconnect();
	logger.info("Disconnected");
	System.out.println("Disconnected");
    }
}
