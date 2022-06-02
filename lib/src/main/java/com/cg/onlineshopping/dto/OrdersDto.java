package com.cg.onlineshopping.dto;

import java.util.Date;

public class OrdersDto {
	
	private String order_status;
	private Date order_date;
	private double amount;
	private long delivery_time;
	private int customer_id;
	
	
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(long delivery_time) {
		this.delivery_time = delivery_time;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	

}
