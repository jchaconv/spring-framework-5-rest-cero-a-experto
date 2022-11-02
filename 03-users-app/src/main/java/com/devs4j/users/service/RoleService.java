package com.devs4j.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entities.Role;
import com.devs4j.users.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;
	
	public List<Role> getRoles() {
		
		return repository.findAll();
	}
	
	public Role createRole(Role role) {
		return repository.save(role);
	}
	
	public Role updateRole(Integer roleId, Role role) {
		
		Optional<Role> result = repository.findById(roleId);
		if(result.isPresent()) {
			return repository.save(role); 
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					String.format("Role id %s doesn't exist", roleId));
		}
		
	}

	public void deleteRole(Integer roleId) {
		Optional<Role> result = repository.findById(roleId);
		if(result.isPresent()) {
			repository.delete(result.get());; 
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					String.format("Role id %d doesn't exist", roleId));
		}
	}
	
}
