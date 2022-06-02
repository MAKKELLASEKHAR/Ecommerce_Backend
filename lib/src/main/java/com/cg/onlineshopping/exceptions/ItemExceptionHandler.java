package com.cg.onlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemExceptionHandler {
	
	@ExceptionHandler(value = ItemNotFoundException.class)
	public ResponseEntity<Object> exception(ItemNotFoundException exception){
		return new ResponseEntity<Object>("Item Not Found...",HttpStatus.OK);
	}
	@ExceptionHandler(value = ItemAlreadyExistException.class)
	public ResponseEntity<Object> exception(ItemAlreadyExistException exception){
		return new ResponseEntity<Object>("Item Already Exist...",HttpStatus.OK);
		
	}

}
