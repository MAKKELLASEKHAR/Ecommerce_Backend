package com.cg.onlineshopping.dto;

public class UPIPaymentDto {
	
	private String upi_id;
	private String upi_password;
	private double total_ammount;
	
	
	public String getUpi_id() {
		return upi_id;
	}
	public void setUpi_id(String upi_id) {
		this.upi_id = upi_id;
	}
	public String getUpi_password() {
		return upi_password;
	}
	public void setUpi_password(String upi_password) {
		this.upi_password = upi_password;
	}
	public double getTotal_ammount() {
		return total_ammount;
	}
	public void setTotal_ammount(double total_ammount) {
		this.total_ammount = total_ammount;
	}
	
	

}
