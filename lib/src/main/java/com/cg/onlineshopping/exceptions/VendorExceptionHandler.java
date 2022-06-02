package com.cg.onlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class VendorExceptionHandler {
	
	@ExceptionHandler(value = VendorNotFoundException.class)
	public ResponseEntity<Object> exception(VendorNotFoundException exception){
		return new ResponseEntity<Object>("Vendor Not Found...",HttpStatus.OK);
	}


}
