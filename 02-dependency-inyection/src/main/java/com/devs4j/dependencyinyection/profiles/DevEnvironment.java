package com.devs4j.dependencyinyection.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "default"})
public class DevEnvironment implements EnvironmentService {

	@Override
	public String getEnvironment() {
		// TODO Auto-generated method stub
		return "Dev";
	}

}