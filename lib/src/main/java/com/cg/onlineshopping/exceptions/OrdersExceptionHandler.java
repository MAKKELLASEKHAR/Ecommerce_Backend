package com.cg.onlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrdersExceptionHandler {
	
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<Object> exception(OrderNotFoundException exception){
		return new ResponseEntity<Object>("Order Not Found...",HttpStatus.OK);
	}

}
