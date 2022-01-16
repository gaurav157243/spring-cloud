package com.microservices.eurekaclientapp1.controller;

import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.eurekaclientapp1.service.TrainSeatsService;

@RestController
public class TrainAvailiableController {
	
	Logger _logger = Logger.getLogger(TrainAvailiableController.class.toString());
	
	@Autowired
	TrainSeatsService trainSeatsService; 
	
	@GetMapping("/train/{trainId}/seat-status")
	public Map<String, Object> getTrainSeatStatus(@PathVariable(required=true,name="trainId") String trainId){
		
		_logger.info("requesting seats for train: " + trainId);
		Map<String, Object> response = trainSeatsService.getTrainSeatStatusForTrain(trainId);
		_logger.info("Response: " + response);
		return response;
	}

}
