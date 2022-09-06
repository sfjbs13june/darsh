package com.mongo.app.controller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{

	public Customer findByName(String name);
	public Customer findBycustId(String custId);
	public void deleteByName(String name);
	public Customer save(Customer customer);
	
}
