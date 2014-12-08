package com.ericsson.ema.downstream.service;

import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.exception.JavaLinkException;

public interface JavaLinkService {
	public Object processRequest(RequestBean requestBean) throws JavaLinkException ;
}
