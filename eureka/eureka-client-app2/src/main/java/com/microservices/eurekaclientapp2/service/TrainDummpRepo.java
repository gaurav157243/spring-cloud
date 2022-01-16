package com.microservices.eurekaclientapp2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TrainDummpRepo {

	Map<Integer, Train> trainMap = new HashMap<>();
	
	public TrainDummpRepo() {
		
		Train train = new Train();
		train.setTrainId(12345);
		train.setStartStation("Mumbai");
		train.setDestStation("Delhi");
		List<String> stopList = Arrays.asList("Bhusawal", "Nagpur" , "Bilaspur"); 
		train.setListOfStops(stopList);
		
		trainMap.put(12345, train);
	}
	
	public List<Train> getTrains() {
		List<Train> trainList = new ArrayList<>(trainMap.values());
		return trainList;
	}

	public Train getTrain(int trainId) {
		return trainMap.get(trainId);
	}

}
