package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	private static final String someConst = "7th";
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot + Tanzu! - app 1" + " some const of " + someConst;
	}

}