package com.ga.app1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.ga.app1.service.DataToolClientProxy;

//@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableAsync
public class EurekaClientApp1Application implements CommandLineRunner {

	@Autowired
	DataToolClientProxy dtClient;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//{"payload":{"visitId":"e18dde25-ced0-4ca8-ad31-bc0ff9fd4d19"},"dtParams":{"processId":"SR-FRA-PRO-CAV-2020"}}
		
//		Map<String, String> dtParams = new HashMap<>();
//		dtParams.put("processId", "SR-FRA-PRO-CAV-2020");
//		
//		Map<String, String> payload = new HashMap<>();
//		payload.put("visitId", "e18dde25-ced0-4ca8-ad31-bc0ff9fd4d19");
//		
//		
//		HashMap<String, Object> requestMap = new HashMap<>();
//		requestMap.put("payload", payload);
//		requestMap.put("dtParams", dtParams);
//		
//		dtClient.downloadFile(requestMap);
		
		System.out.println("testing feign rest client");
//		invokeGetProcessHeaders();
		
	}
	
	public void invokeGetProcessHeaders() {
		Map<String, String> requestMap = new HashMap<>();
		requestMap.put("processId", "SR-CMRT");
		System.out.println(dtClient.getProcessHeaders(requestMap));
	}
	
    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() 
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("AsynchThread-");
        executor.initialize();
        return executor;
    }
	

}
