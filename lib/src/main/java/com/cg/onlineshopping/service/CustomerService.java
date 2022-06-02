package com.cg.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import com.cg.onlineshopping.dto.CustomerLoginDto;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.exceptions.CustomerAlreadyExistException;
import com.cg.onlineshopping.exceptions.CustomerNotFoundException;

public interface CustomerService {
	
	void customerRegistration(Customer customer) throws CustomerAlreadyExistException;
	List<Customer> viewAllCustomer();
	Optional<Customer> getCustomerById(int customer_id) throws CustomerNotFoundException;
	void updateCustomer(Customer customer);
	void deleteCustomer(int customer_id);
	String customerLogin(CustomerLoginDto logindto);

}
