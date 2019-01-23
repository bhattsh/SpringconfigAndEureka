package com.capgemini.bankWebApp.transactionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class TransactionServiceApplication /* implements CommandLineRunner */{

	/*
	 * @Autowired private TransactionRepository repository;
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}

//	@Override
//	public void run(String... args) throws Exception {
//	repository.save(new Transaction(101,2000.0, "deposit","savingsAccount"));
//	repository.save(new Transaction(102,2000.0, "deposit","savingsAccount"));
//	repository.save(new Transaction(101,4000.0, "deposit","savingsAccount"));
//
//		
//	}
//	

}

