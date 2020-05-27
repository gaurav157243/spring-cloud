package com.example.datatoolclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DatatoolClientApplicationTests {

	private static final Log logger = LogFactory.getLog(DatatoolClientApplicationTests.class);
	
	@Autowired
	DataToolClientProxy dtClient;
	
	@Test
	void contextLoads() {
	}

//	@Test
//	void testGetProcessHeaders() {
//		
//		Map<String, String> requestMap = new HashMap<>();
//		requestMap.put("processId", "SR-CMRT");
//		List<Map<String, Object>> response = dtClient.getProcessHeaders(requestMap);
//		logger.info("response: " + response);
//		
//	}


}
