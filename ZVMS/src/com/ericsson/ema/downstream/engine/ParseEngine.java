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

import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.constant.ProvisioningConstant;
import com.ericsson.ema.downstream.exception.JavaLinkException;
import com.ericsson.ema.downstream.mml.MmlParser;

public class ParseEngine implements JavaLinkEngine {

	private String mmlString;

	public ParseEngine(String mmlString) {
		super();
		this.mmlString = mmlString;
	}

	@Override
	public RequestBean invoke() throws JavaLinkException {
		System.out.println("Inside ParesEngine..");
		RequestBean requestBean = new MmlParser().processParsing(mmlString);
		System.out.println(requestBean);
		return requestBean;
	}
	
	protected RequestBean dummyData(){
		RequestBean requestBean = new RequestBean();

		requestBean.setOperation(ProvisioningConstant.INVOKES_API_CREATE_USER);
		
		requestBean.setServiceClass("1");
		
		requestBean.setOperID("admin");
		requestBean.setTerminalType("1");
		requestBean.setBoxNumber("13345678920");
		requestBean.setOperPwd("admin");
		requestBean.setLanguage("1");
		requestBean.setPassword("8888");
		requestBean.setEntryAuthen("1");
		requestBean.setMessageNotify("110");
		requestBean.setUserName("test");
		requestBean.setEmail("hh@tt.com");
		requestBean.setZipCode("112332");
		requestBean.setIDNumber("133123123123123");
		requestBean.setMWNType("1");
		requestBean.setMWNDest("33888833");

		return requestBean;
	}

}
