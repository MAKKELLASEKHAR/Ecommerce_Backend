package com.cg.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.dto.CardPaymentDto;
import com.cg.onlineshopping.service.CardPaymentServiceImpl;

@RestController
@RequestMapping("/payment")
public class CardPaymentController {
	
	@Autowired
	CardPaymentServiceImpl paymentservice;
	
	@PostMapping("/cardPayment")
	public ResponseEntity<String> cardPayment(@RequestBody  CardPaymentDto paymentdto){
		@SuppressWarnings("unused")
		int payment_id = paymentservice.cardPayment(paymentdto);
		
		return new ResponseEntity<String>("Payment done Successfully  ",HttpStatus.OK);
	}
	
	
	
}
