package com.devs4j.users.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.users.entities.User;
import com.devs4j.users.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{userId}")
	public ResponseEntity<User> getUsersById(@PathVariable("userId") Integer userId) {
		return new ResponseEntity<User>(service.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping(value="/username/{username}")
	public ResponseEntity<User> getUsersByUsername(@PathVariable("username") String username) {
		return new ResponseEntity<User>(service.getUserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> authenticate(@RequestBody User user) {
		return new ResponseEntity<>(service.getUserByUsernameAndPassword(user.getUsername(), user.getPassword()), 
				HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable("username") String username) {
		service.deleteUserByUsername(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
