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

import com.cg.onlineshopping.dto.OrdersDto;
import com.cg.onlineshopping.service.OrdersServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	OrdersServiceImpl ordersservice;
	
	@PostMapping("/addOrders")
	public ResponseEntity<String> addOrders(@RequestBody OrdersDto ordersdto){
	
		@SuppressWarnings("unused")
		int order_id = ordersservice.addOrders(ordersdto);
		
		return new ResponseEntity<String>("inserted orderscode = "+ order_id,HttpStatus.OK);
		
	}
	@GetMapping("/viewOrders")
	public ResponseEntity<List<OrdersDto>> viewAllOrders(){
		
		List<OrdersDto> orderslist = ordersservice.viewAllOrders();
		return new ResponseEntity<List<OrdersDto>>(orderslist,HttpStatus.OK);
		
	}
	@GetMapping("/id/{order_id}")
	public ResponseEntity<OrdersDto> getOrdersById(@PathVariable int order_id){
		OrdersDto orders = ordersservice.getOrdersById(order_id);
		return new ResponseEntity <OrdersDto>(orders,HttpStatus.OK);
		
	}
	@DeleteMapping("/id/{order_id}")
	public ResponseEntity<String> deleteOrders(@PathVariable int order_id){
		ordersservice.deleteOrders(order_id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
		
	}
	
	

}
