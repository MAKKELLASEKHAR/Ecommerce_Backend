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

import com.cg.onlineshopping.dto.VendorDto;
import com.cg.onlineshopping.dto.VendorLoginDto;
import com.cg.onlineshopping.dto.VendorRegisterDto;
import com.cg.onlineshopping.service.VendorServiceImpl;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	VendorServiceImpl vendorservice;
	
	@PostMapping("/vendorRegistration")
	public ResponseEntity<String> vendorRegistration(@RequestBody VendorRegisterDto vendordto){
	
		@SuppressWarnings("unused")
		int vendor_id = vendorservice.vendorRegistration(vendordto);
		
		return new ResponseEntity<String>("Registration done Successfully",HttpStatus.OK);
		
	}
	@GetMapping("/viewVendors")
	public ResponseEntity<List<VendorDto>> viewAllVendor(){
		
		List<VendorDto> vendorlist = vendorservice.viewAllVendor();
		return new ResponseEntity<List<VendorDto>>(vendorlist,HttpStatus.OK);
		
	}
	@GetMapping("/id/{vendor_id}")
	public ResponseEntity<VendorDto> getVendorById(@PathVariable int vendor_id){
		VendorDto vendors = vendorservice.getVendorById(vendor_id);
		return new ResponseEntity <VendorDto>(vendors,HttpStatus.OK);
		
	}
	@DeleteMapping("/id/{vendor_id}")
	public ResponseEntity<String> deleteVendor(@PathVariable int vendor_id){
		vendorservice.deleteVendor(vendor_id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
		
	}
	@PostMapping("/login")
	public ResponseEntity<String> customerLogin(@RequestBody VendorLoginDto logindto){
		vendorservice.vendorLogin(logindto);
		return new ResponseEntity<String>("Login Successful ...",HttpStatus.OK);
		
	}

}
