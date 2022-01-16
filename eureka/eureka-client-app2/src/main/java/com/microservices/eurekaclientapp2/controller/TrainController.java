package com.microservices.eurekaclientapp2.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.eurekaclientapp2.service.Train;
import com.microservices.eurekaclientapp2.service.TrainService;

@RestController
public class TrainController {

	Logger _logger = Logger.getLogger(TrainController.class.toString());
	
	@Autowired
	TrainService trainService;
	
	@GetMapping("/trains") 
	public List<Train> getTrains() {
		return trainService.getTrains();
	}
	
	@GetMapping("/trains/{trainId}") 
	public Train getTrains(@PathVariable(required=true,name="trainId") int trainId){
		_logger.info("retrieving details of train: " + trainId);
		return trainService.getTrain(trainId);
	}
}
