package com.microservices.eurekaclientapp1;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

	@LoadBalanced
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
      return builder.build();
    }
}
