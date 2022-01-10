package com.microservices.test;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class OutsideComponentScan {

	@PostConstruct
	public void init() {
		
		System.out.println("*** OutsideComponentScan *** - the bean didnt got created and this statement is the proof");
	}
}
