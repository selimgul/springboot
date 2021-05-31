package com.gul.selim.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.gul.selim.config.EndpointConfig;
import com.gul.selim.config.SecurityConfig;
import com.gul.selim.http.RequestHelper;
import com.gul.selim.http.UriHelper;

public class ServiceBaseImpl {
	
	protected final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	protected RequestHelper reqHelper;
	
	@Autowired
	protected UriHelper uriHelper;
	
	@Autowired
	protected EndpointConfig endpointConfig;
	
	@Autowired
	protected SecurityConfig securityConfig;

}
