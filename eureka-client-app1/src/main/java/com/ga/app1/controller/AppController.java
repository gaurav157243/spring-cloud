package com.ga.app1.controller;

import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/app1")
public class AppController {
	
	@Autowired
	Environment env;
	
	@GetMapping("/details")
	@ResponseBody
	public Map<String,String> getTasks() throws Exception {
		
		System.out.println("invoking endpoint...");
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();	
		map.put("status", "success");
		map.put("host", InetAddress.getLocalHost().getHostName());
		map.put("port", env.getProperty("server.port"));
		map.put("appName", env.getProperty("spring.application.name"));
		return map;
	
	}
}

