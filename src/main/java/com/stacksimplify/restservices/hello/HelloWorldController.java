package com.stacksimplify.restservices.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@Autowired
	private ResourceBundleMessageSource messageSource;
	@GetMapping(path = "/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	@GetMapping("/helloworldbean")
	public UserDetails helloWorldBean() {
		return new UserDetails("kalyan", "Reddy", "Hyderabad");
	}
	@GetMapping("/hello-int")
	public String getMessagesInI18NFormat(@RequestHeader(name="Accept-Langauge", required=false) String locale ) {
		return messageSource.getMessage("label.hello", null,new Locale(locale));
	}
	
	@GetMapping("/hello-int2")
	public String getMessagesInI18NFormat() {
		System.out.println("Locale -"+LocaleContextHolder.getLocale());
		return messageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
	}
}