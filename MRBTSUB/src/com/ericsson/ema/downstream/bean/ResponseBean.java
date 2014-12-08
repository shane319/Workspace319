/*******************************************************************
 *
 * FILE NAME   : ResponseBean.java
 *
 * DESCRIPTION : It's a bean. Response data for javalink is stored here.
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

package com.ericsson.ema.downstream.bean;

public class ResponseBean {
    private String result = "";
    private String response;
    
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}    
	
    public void setResponse(String response) {
		this.response = response;
	}

	public String getResponse(){
    	return response;
		
		//return dummyResponse();
    	
    	/*
    	if(result.equals(ProvisioningConstant.SUCCESS)){
    		return "RESP:ErrorCode=0,ErrorDescription=Success;";
    	}else{
    		return "RESP:ErrorCode=-1,ErrorDescription=Faild;";
    	}*/
    }
    protected String dummyResponse(){
    	return "RESP:ErrorCode=0,ErrorDescription=success;";
    }
}
