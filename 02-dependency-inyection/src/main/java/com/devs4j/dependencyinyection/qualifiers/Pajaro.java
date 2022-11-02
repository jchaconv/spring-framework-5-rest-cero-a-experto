package com.devs4j.dependencyinyection.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Pajaro extends Animal implements Volador {

	private static final Logger log = LoggerFactory.getLogger(Pajaro.class);
	
	public Pajaro(@Value("Piolin") String nombre, @Value("2") Integer edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void volar() {
		
		log.info("Soy un pajaro y estoy volando");
		
	}

	
	
}
