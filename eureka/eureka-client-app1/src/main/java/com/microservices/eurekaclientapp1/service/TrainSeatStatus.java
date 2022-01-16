package com.microservices.eurekaclientapp1.service;

public class TrainSeatStatus {
	
	int sleepSeats;
	int thirdACseats;
	int secondACseats;
	public TrainSeatStatus(int sleepSeats, int thirdACseats, int secondACseats) {
		super();
		this.sleepSeats = sleepSeats;
		this.thirdACseats = thirdACseats;
		this.secondACseats = secondACseats;
	}
	public int getSleepSeats() {
		return sleepSeats;
	}
	public void setSleepSeats(int sleepSeats) {
		this.sleepSeats = sleepSeats;
	}
	public int getThirdACseats() {
		return thirdACseats;
	}
	public void setThirdACseats(int thirdACseats) {
		this.thirdACseats = thirdACseats;
	}
	public int getSecondACseats() {
		return secondACseats;
	}
	public void setSecondACseats(int secondACseats) {
		this.secondACseats = secondACseats;
	}

}
