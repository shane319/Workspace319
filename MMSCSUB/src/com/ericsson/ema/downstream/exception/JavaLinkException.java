/*******************************************************************
 *
 * FILE NAME   : .java
 *
 * DESCRIPTION : It's a JavaLink specific exception. 
 * 				It writes to general log file.
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

package com.ericsson.ema.downstream.exception;

import org.apache.log4j.Logger;

public class JavaLinkException extends Exception{

	/**
	 * 
	 */
	static final Logger logger = Logger.getLogger(JavaLinkException.class);
	private static final long serialVersionUID = -8013973233818836298L;
	
	private String errorDescription = "JavaLink Error";
	private int errorCode = 9001;
	
	public JavaLinkException(String description) {
		super("[MMSC]JavaLink exception: " + description);
		this.errorDescription = description;
	}

	public JavaLinkException(String errorDescription, int errorCode) {
		super("[MMSC]JavaLink exception: " + errorDescription);
		this.errorDescription = errorDescription;
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public int getErrorCode() {
		return errorCode;
	}
}
