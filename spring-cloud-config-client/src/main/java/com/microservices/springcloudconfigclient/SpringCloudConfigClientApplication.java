package com.microservices.springcloudconfigclient;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RefreshScope
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	@Bean
	  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	    return args -> {
	      //_logger.info("***** Let's inspect the beans provided by Spring Boot: ******");
	      String[] beanNames = ctx.getBeanDefinitionNames();
	      Arrays.sort(beanNames);
	      int i = 0;
	      for (String beanName : beanNames) {
	        //System.out.println("Bean " + i++  + ": " + beanName);
	    	  ;
	      }
	    };
	  }
}
