/*******************************************************************
 *
 * FILE NAME   : ParseEngine.java
 *
 * DESCRIPTION : This class only concern about parsing input data. 
 * 				Parsing logic is been embedded here.
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

package com.ericsson.ema.downstream.engine;

import org.apache.log4j.Logger;
import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.mml.MmlParser;
import com.ericsson.ema.downstream.util.RandomUtil;

public class ParseEngine implements JavaLinkEngine {
	static final Logger logger = Logger.getLogger(ParseEngine.class);
	private String mmlString;

	public ParseEngine(String mmlString) {
		super();
		this.mmlString = mmlString;
	}

	// It parse the input xml data and store it in a requestBean object
	@Override
	public RequestBean invoke() throws JavaLinkException {

		logger.info("Inside parse engine");
		logger.info("Mml Request \n");
		logger.info(mmlString);
		MmlParser mmlParser = new MmlParser();
		RequestBean requestBean = mmlParser.processParsing(mmlString);
		// assigning random value to sessionid
		requestBean.setSessionId(RandomUtil.getRandom());
		logger.info("Session ID: " + requestBean.getSessionId());
		return requestBean;
	}
}
