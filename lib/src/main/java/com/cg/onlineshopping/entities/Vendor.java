package com.cg.onlineshopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendor_id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "email")
	private String email;

	@Column(name = "user_name")
	private String user_name;

	@Column(name = "password")
	private String password;

	@Column(name = "catagory_Specialization")
	private String catagorySpecialization;
	
	@OneToOne
	@JoinColumn(name="item_id")
	private Item item ;

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCatagorySpecialization() {
		return catagorySpecialization;
	}

	public void setCatagorySpecialization(String catagorySpecialization) {
		this.catagorySpecialization = catagorySpecialization;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	
	

	

	
	
	

}
