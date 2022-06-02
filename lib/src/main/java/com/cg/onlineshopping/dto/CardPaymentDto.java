package com.cg.onlineshopping.dto;

public class CardPaymentDto {
	
	
	private String name_on_card;
	private long card_number;
	private int cvv;
	private double total_ammount;
	
	
	
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
	
	

}
