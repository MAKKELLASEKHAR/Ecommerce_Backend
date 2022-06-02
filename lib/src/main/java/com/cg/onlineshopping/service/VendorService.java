package com.cg.onlineshopping.service;

import java.util.List;

import com.cg.onlineshopping.dto.VendorDto;
import com.cg.onlineshopping.dto.VendorLoginDto;
import com.cg.onlineshopping.dto.VendorRegisterDto;

public interface VendorService {
	
	int vendorRegistration(VendorRegisterDto vendordto);
	List<VendorDto> viewAllVendor();
	VendorDto getVendorById(int vendor_id);
	void deleteVendor(int vendor_id);
	String vendorLogin(VendorLoginDto logindto);

}
