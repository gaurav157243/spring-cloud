package com.microservices.eurekaclientapp1;

import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.eureka.registry.rule.AlwaysMatchInstanceStatusRule;

import antlr.collections.List;
import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApp1Application implements CommandLineRunner {

	Logger _logger = Logger.getLogger(EurekaClientApp1Application.class.toString());

	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp1Application.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//_logger.info("Output: "  + restTemplate.getForEntity("http://localhost:10001/trains", String.class));
		
		IntStream.range(0, 10).forEach(x -> {
			_logger.info("Iteration: " + x);
			_logger.info("Output: "  + restTemplate.getForEntity("http://test-app-2/trains", String.class));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
	}

}
