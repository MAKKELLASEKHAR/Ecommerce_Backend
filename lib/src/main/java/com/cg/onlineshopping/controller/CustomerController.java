package com.cg.onlineshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.dto.CustomerLoginDto;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl service;
	
	@PostMapping("/customerRegistration")
	public ResponseEntity<String> customerRegistration(@RequestBody Customer customer){
		service.customerRegistration(customer);
		return new ResponseEntity<String>("inserted",HttpStatus.OK);
		
	}
	@GetMapping("/viewAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> customerlist = service.viewAllCustomer();
		return new ResponseEntity<List<Customer>>(customerlist,HttpStatus.OK);
		
	}
	@GetMapping("/id/{customer_id}")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable int customer_id){
		Optional<Customer> customerdetails = service.getCustomerById(customer_id);
		return new ResponseEntity<Optional<Customer>>(customerdetails,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> editCustomer(@RequestBody Customer customer){
		service.updateCustomer(customer);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{customer_id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customer_id){
		service.deleteCustomer(customer_id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> customerLogin(@RequestBody CustomerLoginDto logindto){
		service.customerLogin(logindto);
		return new ResponseEntity<String>("Login Successful ...",HttpStatus.OK);
		
	}

}
