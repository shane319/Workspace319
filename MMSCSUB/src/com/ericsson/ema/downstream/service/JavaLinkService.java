/*******************************************************************
 *
 * FILE NAME   : JavaLinkService.java
 *
 * DESCRIPTION : Interface for Javalink service
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

package com.ericsson.ema.downstream.service;

import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.exception.JavaLinkException;

public interface JavaLinkService {
	public Object processRequest(RequestBean requestBean) throws JavaLinkException ;
}
