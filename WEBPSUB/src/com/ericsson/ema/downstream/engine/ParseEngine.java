/*******************************************************************
 *
 * FILE NAME   : ParseEngine.java
 *
 * DESCRIPTION : This class only concern about parsing input data. 
 * 				Parsing logic has been embedded here.
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
import com.ericsson.ema.downstream.constant.ProvisioningConstant;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.mml.MmlParser;

public class ParseEngine implements JavaLinkEngine {
	static final Logger logger = Logger.getLogger(ParseEngine.class);
	private String mmlString;

	public ParseEngine(String mmlString) {
		super();
		this.mmlString = mmlString;
	}
	
	
	//It parse the input xml data and store it in a requestBean object
	@Override
	public RequestBean invoke() throws JavaLinkException {

		RequestBean requestBean = new MmlParser().processParsing(mmlString);
		return requestBean;
	}
	
	protected RequestBean dummyData(){
		RequestBean requestBean = new RequestBean();
		requestBean.setOperation(ProvisioningConstant.INVOKES_API_ADD_NEW_PORTAL_USER);
		
		
		requestBean.setMsisdn("1234567890123456");
		
		return requestBean;
		
	}

}
