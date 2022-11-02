package com.devs4j.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entities.Address;

@Repository
public interface AdressRepository extends CrudRepository<Address, Integer>{

}
