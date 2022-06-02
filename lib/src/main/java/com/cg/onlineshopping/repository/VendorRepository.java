package com.cg.onlineshopping.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor,Integer>{

	@Query(value="select vendor from Vendor vendor  where vendor.vendor_id=?1")
	Vendor getVendorById(int vendor_id);
	
	@Query(value="select vendor from Vendor vendor  where vendor.user_name=?1")
	Vendor getVendorByUser_name(String user_name);

}