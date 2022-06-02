package com.cg.onlineshopping.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int order_id;
	
	@Column(name="order_status",length=20)
	private String order_status;
	
	@Column(name="order_date",length=20)
	private Date order_date;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name="delivery_time",length=20)
	private long delivery_time;
	
	@OneToOne
	@JoinColumn(name="customer_id",unique=true)
	private Customer customer;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}
