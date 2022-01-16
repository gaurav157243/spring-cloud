package com.microservices.gatewayserver.filter;

import java.util.logging.Logger;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class LogRequestFilter extends AbstractGatewayFilterFactory<LogRequestFilter.Config> {

	Logger _logger = Logger.getLogger(LogRequestFilter.class.toString());
	
	public LogRequestFilter() {
		super(Config.class);
	}
	
	@Override
	public GatewayFilter apply(Config config) {
		
		return (exchange, chain) -> {
			_logger.info("Request: " + exchange.getRequest().getURI());
			_logger.info("Request Headers: " + exchange.getRequest().getHeaders());
			
			long starTime = System.currentTimeMillis();
			return chain.filter(exchange).then(Mono.fromRunnable(() -> { 
				_logger.info("Response Status: " + exchange.getResponse().getStatusCode());
				_logger.info("Response Headers: " + exchange.getResponse().getHeaders());
				_logger.info("Time taken to execute request: " + (System.currentTimeMillis() - starTime));
			}));
		};
	}
	
	public static class Config {
		private String name;
		
		public String getName() {
			return this.name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}