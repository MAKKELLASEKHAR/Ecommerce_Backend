package com.cg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.dto.VendorDto;
import com.cg.onlineshopping.dto.VendorLoginDto;
import com.cg.onlineshopping.dto.VendorRegisterDto;
import com.cg.onlineshopping.entities.Vendor;
import com.cg.onlineshopping.exceptions.InvalidPasswordException;
import com.cg.onlineshopping.exceptions.InvalidUserNameException;
import com.cg.onlineshopping.exceptions.VendorNotFoundException;
import com.cg.onlineshopping.repository.ItemRepository;
import com.cg.onlineshopping.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	VendorRepository vendorrepo;
	@Autowired
	ItemRepository itemrepo;
	
	
	@Override
	public int vendorRegistration(VendorRegisterDto vendordto) {
	
		Vendor vendor = new Vendor();
		vendor.setFirst_name(vendordto.getFirst_name());
		vendor.setLast_name(vendordto.getLast_name());
		vendor.setEmail(vendordto.getEmail());
		vendor.setCatagorySpecialization(vendordto.getCatagorySpecialization());
		vendor.setUser_name(vendordto.getUser_name());
		vendor.setPassword(vendordto.getPassword());
		vendorrepo.save(vendor);
		
		return vendor.getVendor_id();
	}

	@Override
	public List<VendorDto> viewAllVendor() {
		
		Iterable<Vendor> vendorlist= vendorrepo.findAll();
		ArrayList<VendorDto> vendordtolist =new ArrayList<VendorDto>();
		for(Vendor vendor : vendorlist) {
			VendorDto vendordto = new VendorDto();
			vendordto.setFirst_name(vendor.getFirst_name());
			vendordto.setLast_name(vendor.getLast_name());
			vendordto.setEmail(vendor.getEmail());
			vendordto.setCatagorySpecialization(vendor.getCatagorySpecialization());
			vendordto.setUser_name(vendor.getUser_name());
			vendordto.setPassword(vendor.getPassword());
			vendordto.setItem_id(vendor.getItem().getItem_id());
			vendordtolist.add(vendordto);
		}
		
		return vendordtolist;
		 
	}

	@Override
	public VendorDto getVendorById(int vendor_id) {
		Vendor vendor = vendorrepo.getVendorById(vendor_id);
		if(vendor == null)
			throw new VendorNotFoundException();
		VendorDto vendordto = new VendorDto();
		vendordto.setFirst_name(vendor.getFirst_name());
		vendordto.setLast_name(vendor.getLast_name());
		vendordto.setEmail(vendor.getEmail());
		vendordto.setCatagorySpecialization(vendor.getCatagorySpecialization());
		vendordto.setUser_name(vendor.getUser_name());
		vendordto.setPassword(vendor.getPassword());
		vendordto.setItem_id(vendor.getItem().getItem_id());

		return vendordto;
	}

	@Override
	public void deleteVendor(int vendor_id) {
		vendorrepo.deleteById(vendor_id);
		
	}

	@Override
	public String vendorLogin(VendorLoginDto logindto) {
		Vendor vendor = vendorrepo.getVendorByUser_name(logindto.getUser_name());
		if(vendor==null)
			throw new InvalidUserNameException();
		else if(vendor.getPassword().equals(logindto.getPassword()))
			return vendor.getFirst_name()+vendor.getLast_name();
		
		else 
			throw new InvalidPasswordException();
	}

}
