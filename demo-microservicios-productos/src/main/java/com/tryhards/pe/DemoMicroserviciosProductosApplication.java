package com.tryhards.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoMicroserviciosProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMicroserviciosProductosApplication.class, args);
	}

}
