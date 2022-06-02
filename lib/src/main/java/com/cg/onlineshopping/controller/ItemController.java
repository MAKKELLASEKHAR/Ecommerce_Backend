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

import com.cg.onlineshopping.dto.ItemDto;
import com.cg.onlineshopping.service.ItemServiceImpl;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemServiceImpl service;
	
	@SuppressWarnings("unused")
	@PostMapping("/additem")
	public ResponseEntity<String> addItem(@RequestBody ItemDto itemdto){
     int item_id = service.addItem(itemdto);
		
		return new ResponseEntity<String>("inserted orderscode = ",HttpStatus.OK);
		
	}
	@GetMapping("/viewAllItem")
	public ResponseEntity<List<ItemDto>> getAllItem(){
		List<ItemDto> itemlist = service.viewAllItems();
		return new ResponseEntity<List<ItemDto>>(itemlist,HttpStatus.OK);
		
	}
	@GetMapping("/item/{item_id}")
	public ResponseEntity<ItemDto> getItemById(@PathVariable int item_id){
		ItemDto itemdetails = service.getItemById(item_id);
		return new ResponseEntity<ItemDto>(itemdetails,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{item_id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable int item_id){
		service.deleteItem(item_id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
}
