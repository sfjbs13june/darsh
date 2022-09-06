package com.mongo.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CreateController {
  @Autowired
  CustomerRepository customerRepo;

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public Customer saveCustomer(@RequestBody Customer customer) {
    customer = customerRepo.save(customer);
    return customer;
  }

  @RequestMapping(value = "/read", method = RequestMethod.GET)
  public List<Customer> readCustomer() {
    return customerRepo.findAll();
  }

  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public void modifyByID(@RequestParam String custId, @RequestParam String name) {
    Customer customer = customerRepo.findByName(name);
    customer.setCustId(custId);
    customerRepo.save(customer);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public String deleteByName(@RequestParam String name) {
    customerRepo.deleteByName(name);
    return "Deleted";
  }

  @RequestMapping(value = "/findByid", method = RequestMethod.GET)
  public Customer findByID(@RequestParam String custId) {
    return customerRepo.findBycustId(custId);
  }

}
