package com.ga.app2;

import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApp2Application implements CommandLineRunner{

	@LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	
	@Autowired
    RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// this service will make a call to another service
		
		IntStream.range(1, 10).forEach(i -> {
			System.out.println("iteration " + i);
			Map<String, String> map = restTemplate.getForEntity("http://MicroService1/app1/details", Map.class).getBody();
			System.out.println(map);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
	}
}
