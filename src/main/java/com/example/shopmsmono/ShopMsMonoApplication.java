package com.example.shopmsmono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@ComponentScan("com")

@EntityScan("com")
@EnableEurekaClient

public class ShopMsMonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopMsMonoApplication.class, args);
	}
	
	@Bean("webclient")
	@LoadBalanced
	public WebClient.Builder beanCreate(){
		return WebClient.builder();
	}

}
