package com.devs4j.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.model.User;
import com.github.javafaker.Faker;

@Service
public class UserServiceUsingLists {

	@Autowired
	private Faker faker;

	private List<User> users = new ArrayList<>();
	
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceUsingLists.class);


	@PostConstruct
	public void init() {
		
		for(int i = 0; i < 100; i++) {
			users.add(new User(faker.funnyName().name(), faker.name().username(), 
					faker.dragonBall().character()));			
		}
		
	}

	public List<User> getUsers(String startsWith) {
		if(startsWith != null) {
			return users.stream().filter(u -> u.getUserName().
					startsWith(startsWith)).collect(Collectors.toList());
		} else {
			return users;
		}
	}
	
	@Cacheable("users")
	public User getUserByUsername(String username) {
		log.info("Getting user by username {}", username);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users.stream().filter(u -> u.getUserName().equals(username)).findAny()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("User %s not found", username)));
	}
	
	public User createUser(User user) {
		if(users.stream().anyMatch(u -> u.getUserName().equals(user.getUserName()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					String.format("User %s already exists", user.getUserName()));
		}
		users.add(user);
		return user;
	}
	
	public User updateUser(User user, String username) {
		User userToBeUpdated = getUserByUsername(username);
		userToBeUpdated.setNickName(user.getNickName());
		userToBeUpdated.setUserName(user.getUserName());
		userToBeUpdated.setPassword(user.getPassword());
		return userToBeUpdated;
	}
	
	public void deleteUser(String username) {
		User userByUsername = getUserByUsername(username);
		users.remove(userByUsername);
	}

}
