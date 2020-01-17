package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class L1aMicroservicesEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(L1aMicroservicesEurekaServerApplication.class, args);
	}

}
