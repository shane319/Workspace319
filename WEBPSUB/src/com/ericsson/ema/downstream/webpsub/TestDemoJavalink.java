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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;

import com.ericsson.ema.downstream.config.Config;
import com.ericsson.ema.downstream.mml.MmlConstant;

import se.ericsson.ema.downstream.DownStreamException;

public class TestDemoJavalink
{

    /**
     * @param args
     * @throws DownStreamException
     */
    public static void main(String[] args) throws DownStreamException
    {
    	DOMConfigurator.configure(Config.SYS_CONFIG_PATH + "log4j.xml");
    	
    	// used to detect if DemoJavalink is generated correctly
        DemoJavalink testLink = new DemoJavalink();
        String[] configurations = new String[4];
       
        configurations[0] = "http://127.0.0.1:8085/WebSimulator/simulator.do";
        configurations[1]="IatPrtal_user";
        configurations[2]="IatPrtal_password";
        configurations[3]="3000";
        
        testLink.setConfiguration(configurations);

        testLink.connect();
        try {
			String result = testLink.sendMessage(deserializeString(new File(MmlConstant.xmlFile)));
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        testLink.disconnect();
    }
    
    public static String deserializeString(File file)
    throws IOException {
        int len;
        char[] chr = new char[4096];
        final StringBuffer buffer = new StringBuffer();
        final FileReader reader = new FileReader(file);
        try {
            while ((len = reader.read(chr)) > 0) {
                buffer.append(chr, 0, len);
            }
        } finally {
            reader.close();
        }
        return buffer.toString();
    }
}
