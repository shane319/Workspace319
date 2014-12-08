/*******************************************************************
 *
 * FILE NAME   : ConfigException.java
 *
 * DESCRIPTION : If any type of error will occur regarding 
 * 				configuration then ConfigException class 
 * 				throws the exception. It writes to general log file.
 * 
 * DOCUMENTS   : A reference to the applicable design documents
 *               and coding guidelines document used.
 *
 * AUTHOR      : Subhasish Mondal
 *
 * DATE        : 
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

package com.ericsson.ema.downstream.exception;

import org.apache.log4j.Logger;


public class ConfigException extends Exception {
	static final Logger logger = Logger.getLogger(ConfigException.class);
	private static final long serialVersionUID = 6418934629333811579L;

	public ConfigException(String description) {
		super("Inside JavaLink Configuration: " + description);
	}
}

/************************ End of file **************************/
