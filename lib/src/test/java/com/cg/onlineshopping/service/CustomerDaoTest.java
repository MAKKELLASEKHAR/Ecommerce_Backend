package com.cg.onlineshopping.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.repository.CustomerRepository;

@SpringBootTest
class CustomerDaoTest {

	@Autowired
	CustomerRepository customerrepo;
	
	@Autowired
	CustomerService customerService = new CustomerServiceImpl(); 

	@Test
	void testCustomerRegistration() {
		Customer customer = new Customer();
		customer.setCustomer_id(5);
		customer.setEmail("surya1@gmail.com");
		customer.setFirst_name("surya1");
		customer.setLast_name("makkella1");
		customer.setMobile_number(7623751);
		customer.setPassword("surya1231");
		customer.setUser_name("surya1_makkella");
		customerService.customerRegistration(customer);
		customer= customerrepo.getCustomerById(5);
		assertEquals("surya1@gmail.com",customer.getEmail());
		
		
	}
	@Test
	void testViewAllCustomer() {
		List<Customer> list = customerrepo.findAll();
		assertNotNull(list);
		
		
	}
	
	@Test
	void testGetCustomerById() {
		Customer cust=customerrepo.getById(1);
				assertEquals(1, cust.getCustomer_id());;
		
	}
	@Test
	void testUpdateCustomer() {
	Customer customer=new Customer();
	customer.setCustomer_id(2);
	customer.setEmail("surya1@gmail.com");
	customer.setFirst_name("surya1");
	customer.setLast_name("makkella1");
	customer.setMobile_number(7623751);
	customer.setPassword("surya1231");
	customer.setUser_name("surya1_makkella");
	customerService.updateCustomer(customer);
	customer=customerrepo.getCustomerById(2);
	assertEquals("surya1", customer.getFirst_name());
	}
	

}

