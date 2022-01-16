package com.microservices.eurekaclientapp2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

	Logger _logger = Logger.getLogger(TrainService.class.toString());
	
	@Autowired
	TrainDummpRepo trainRepo; 
	
	public List<Train> getTrains() {
		
		_logger.info("Getting trains data");
		return trainRepo.getTrains();
	}

	public Train getTrain(int trainId) {
		return trainRepo.getTrain(trainId);
	}

}
