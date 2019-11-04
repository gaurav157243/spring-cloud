package com.ga.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp1Application.class, args);
	}

}
