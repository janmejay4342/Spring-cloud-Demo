package com.mkyong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	// inject via application.properties
	@Value("${instance.server.name}")
	private String message;

	@RequestMapping("/")
	public String welcome() {
		return message;
	}

}