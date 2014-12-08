package com.ericsson.ema.downstream.bean;

import com.ericsson.ema.downstream.util.ValidatorUtil;

/**
 * 
 * @author ESUMOND
 */
public class ResponseBean {
	private int resultcode = 9001;
	private java.lang.String description = "Unknown Error";
	private String queryResponse;

	public int getResultcode() {
		return resultcode;
	}

	public void setResultcode(int resultcode) {
		this.resultcode = resultcode;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public String getQueryResponse() {
		return queryResponse;
	}

	public void setQueryResponse(String queryResponse) {
		this.queryResponse = queryResponse;
	}

	public String getResponse() {
		if (queryResponse != null) {
			return this.queryResponse;
		} else {

			// this dummyResponse is used for testing purpose. Actual response
			// is blocked. Block the dummyResponse and un-block block line
			// return dummyResponse();

			if (ValidatorUtil.isNull(this.queryResponse)) {
				return "RESP:ErrorCode=" + this.resultcode
						+ ",ErrorDescription=" + this.description + ";";
			} else {
				return this.queryResponse;
			}
		}
	}

	private String dummyResponse() {
		return "RESP:ErrorCode=0,ErrorDescription=success;";
	}
}
