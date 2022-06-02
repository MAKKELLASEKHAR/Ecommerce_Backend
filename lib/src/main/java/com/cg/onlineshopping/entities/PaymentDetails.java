package com.cg.onlineshopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_details")
public class PaymentDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int payment_id;
	@Column(name="upi_id",length=20)
	private String upi_id;
	@Column(name="upi_password",length=30)
	private String upi_password;
	@Column(name="name_on_card",length=30)
	private String name_on_card;
	@Column(name="card_number",length=25)
	private long card_number;
	@Column(name="cvv",length=4)
	private int cvv;
	@Column(name="total_ammount")
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
	public String getName_on_card() {
		return name_on_card;
	}
	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}
	public long getCard_number() {
		return card_number;
	}
	public void setCard_number(long card_number) {
		this.card_number = card_number;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public double getTotal_ammount() {
		return total_ammount;
	}
	public void setTotal_ammount(double total_ammount) {
		this.total_ammount = total_ammount;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	

}
