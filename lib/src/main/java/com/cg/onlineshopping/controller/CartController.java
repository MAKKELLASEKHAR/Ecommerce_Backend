package com.cg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.dto.CartDto;
import com.cg.onlineshopping.service.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartServiceImpl cartservice;
	
	@PostMapping("/addToCart")
	public ResponseEntity<String> addToCart(@RequestBody CartDto cartdto){
	
		@SuppressWarnings("unused")
		int cart_id = cartservice.addToCart(cartdto);
		
		return new ResponseEntity<String>("Item Added to Cart Successfully",HttpStatus.OK);
		
	}
	@GetMapping("/viewCart")
	public ResponseEntity<List<CartDto>> viewAllCart(){
		
		List<CartDto> cartlist = cartservice.viewAllCart();
		return new ResponseEntity<List<CartDto>>(cartlist,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/id/{cart_id}")
	public ResponseEntity<String> deleteCart(@PathVariable int cart_id){
		cartservice.deleteCart(cart_id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
		
	}

}
