package com.stacksimplify.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	@GetMapping("/helloworldbean")
	public UserDetails helloWorldBean() {
		return new UserDetails("kalyan", "Reddy", "Hyderabad");
	}
}
