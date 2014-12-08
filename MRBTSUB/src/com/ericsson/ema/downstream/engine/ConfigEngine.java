/*******************************************************************
 *
 * FILE NAME   : ConfigEngine.java
 *
 * DESCRIPTION : This class only concern about configuration activity.
 * 				All the configuration functionality has been embedded into this class.
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

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;
import com.ericsson.ema.downstream.config.NEConfig;
import com.ericsson.ema.downstream.exception.ConfigException;
import com.ericsson.ema.downstream.util.ValidatorUtil;

public class ConfigEngine implements JavaLinkEngine {
	static final Logger logger = Logger.getLogger(ConfigEngine.class);
	private String[] configurations;

	public ConfigEngine(String[] configurations) {
		super();
		this.configurations = configurations;
	}

	@Override
	public NEConfig invoke() throws MalformedURLException, ConfigException {
		// TODO Auto-generated method stub

		NEConfig neConfig = new NEConfig();
		if (ValidatorUtil.isNull(configurations[0])) {
			throw new ConfigException("Server URL is null");
		}
		neConfig.setEndpointURL(new URL(configurations[0]));

		return neConfig;
	}
}
