package com.cg.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.dto.UPIPaymentDto;
import com.cg.onlineshopping.service.UpiPaymentServiceImpl;

@RestController
@RequestMapping("/payment")
public class UpiPaymentController {
	
	@Autowired
	UpiPaymentServiceImpl paymentservice;
	
	@PostMapping("/upiPayment")
	public ResponseEntity<String> upiPayment(@RequestBody  UPIPaymentDto paymentdto){
		@SuppressWarnings("unused")
		int payment_id = paymentservice.upiPayment(paymentdto);
		
		return new ResponseEntity<String>("Payment done Successfully ",HttpStatus.OK);
	}

}
