package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class BaseServiceApplication {
	
	// inject via application.properties
	@Value("${instance.server.name}")
	private String message;	

	public static void main(String[] args) {
		SpringApplication.run(BaseServiceApplication.class, args);
	}
	
	@RequestMapping("/")
	public String welcome() {
		return message;
	}

}
