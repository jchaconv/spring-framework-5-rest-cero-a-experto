package com.devs4j.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class Devs4jController {
	
	@GetMapping
	public String helloWorld() {
		return "hello world";
	}

}
