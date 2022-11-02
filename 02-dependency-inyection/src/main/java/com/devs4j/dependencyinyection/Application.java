package com.devs4j.dependencyinyection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.dependencyinyection.aop.TargetObject;
import com.devs4j.dependencyinyection.atributo.Coche;
import com.devs4j.dependencyinyection.atributo.Motor;
import com.devs4j.dependencyinyection.profiles.EnvironmentService;
import com.devs4j.dependencyinyection.qualifiers.Animal;
import com.devs4j.dependencyinyection.qualifiers.Perro;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		TargetObject targetObject = context.getBean(TargetObject.class);
		targetObject.hello("Hello World!");
		targetObject.foo();
		
		/*EnvironmentService environmentService = context.getBean(EnvironmentService.class);
		log.info("Active environment {}", environmentService.getEnvironment());*/
	}

}
