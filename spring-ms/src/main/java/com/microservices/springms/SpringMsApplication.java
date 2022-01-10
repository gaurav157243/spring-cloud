package com.microservices.springms;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.microservices.springms.config.DataSourceProperties;


@SpringBootApplication

//@EnableAutoConfiguration
//@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
//		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
//@Configuration
/** 
 * Spring boot will automatically add a component scan with this packages and sub packages 
 *  All the beans within those packages will be automatically created 
 *  
 *  Auto Configuration - This it the most important functionality of spring boot
 *  
 *  **/
public class SpringMsApplication {

	Logger _logger = Logger.getLogger(SpringMsApplication.class.toString());
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMsApplication.class, args);
	}
	
	  @Bean
	  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	    return args -> {
	      _logger.info("***** Let's inspect the beans provided by Spring Boot: ******");
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
