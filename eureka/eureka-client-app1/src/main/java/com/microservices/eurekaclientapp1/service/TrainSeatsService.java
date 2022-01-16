package com.microservices.eurekaclientapp1.service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainSeatsService {

	Logger _logger = Logger.getLogger(TrainSeatStatus.class.toString());
	
	@Autowired
	RestTemplate restTemplate; 
	
	public Map<String, Object> getTrainSeatStatusForTrain(String trainId) {
		

		/** The below code directly connects with the second service via the host name and port **/
//		Train trainResponse = restTemplate.getForEntity("http://localhost:10001/trains/" + trainId, 
//				Train.class).getBody();

		Train trainResponse = restTemplate.getForEntity("http://test-app-2/trains/" + trainId, Train.class).getBody();
		TrainSeatStatus tss = new TrainSeatStatus(100, 200, 50);
		Map<String, Object> finalResponse = new HashMap<>();
		finalResponse.put("trainInfo", trainResponse);
		finalResponse.put("seatStatus", tss);
		_logger.info("Response: " + finalResponse);
		return finalResponse;
	}
	
}
