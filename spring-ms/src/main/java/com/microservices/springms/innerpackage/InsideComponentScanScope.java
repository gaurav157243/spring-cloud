package com.microservices.springms.innerpackage;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.microservices.springms.SpringMsApplication;

@Component
public class InsideComponentScanScope {

	Logger _logger = Logger.getLogger(InsideComponentScanScope.class.toString());
	
	@PostConstruct
	public void init() {
		_logger.info("InsideComponentScanScope - the bean got create and this statement is the proof");
	}
}
