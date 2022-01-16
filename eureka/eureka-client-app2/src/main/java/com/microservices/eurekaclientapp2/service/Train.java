package com.microservices.eurekaclientapp2.service;

import java.util.List;

public class Train {

	private int trainId; 
	private String startStation;
	private String destStation;
	private List<String> listOfStops;
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getDestStation() {
		return destStation;
	}
	public void setDestStation(String destStation) {
		this.destStation = destStation;
	}
	public List<String> getListOfStops() {
		return listOfStops;
	}
	public void setListOfStops(List<String> listOfStops) {
		this.listOfStops = listOfStops;
	}
	

}
