package com.example.datatoolclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DatatoolClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatatoolClientApplication.class, args);
	}

}
