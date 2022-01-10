package com.microservices.springms.config;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataSourceProperties {
	
	Logger _logger = Logger.getLogger(DataSourceProperties.class.toString());
	
	@Value("${database.name}")
	String dbHostName;
	
	String dbUsername;
	
	String dbPassword;
	

	@PostConstruct
	public void postConstruct() {
		_logger.info("Data Host Name: " + dbHostName);
	}
}
