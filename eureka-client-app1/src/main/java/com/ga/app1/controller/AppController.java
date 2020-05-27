package com.ga.app1.controller;

import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/app1")
public class AppController {

	private static final Log logger = LogFactory.getLog(AppController.class);

	
	@Autowired
	Environment env;
	
	@Async(value = "asyncExecutor")
	@GetMapping("/details")
	@ResponseBody
	public Future<Map<String,String>> getTasks() throws Exception {
		
		logger.info("invoking endpoint...");
		Thread.sleep(10000);
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();	
		map.put("status", "success");
		map.put("host", InetAddress.getLocalHost().getHostName());
		map.put("port", env.getProperty("server.port"));
		map.put("appName", env.getProperty("spring.application.name"));
		logger.info("finished processing...");
		
		return new AsyncResult<Map<String, String>>(map);
	
	}
}

