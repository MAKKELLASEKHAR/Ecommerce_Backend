package com.cg.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.dto.CardPaymentDto;
import com.cg.onlineshopping.entities.PaymentDetails;
import com.cg.onlineshopping.repository.PaymentRepository;

@Service
public class CardPaymentServiceImpl implements CardPaymentService{
	
	@Autowired
	PaymentRepository paymentrepo;

	

	@Override
	public int  cardPayment(CardPaymentDto paymentdto) {
		PaymentDetails payment = new PaymentDetails();
		payment.setName_on_card(paymentdto.getName_on_card());
		payment.setCard_number(paymentdto.getCard_number());
		payment.setCvv(paymentdto.getCvv());
		payment.setTotal_ammount(paymentdto.getTotal_ammount());
		return payment.getPayment_id();
		
		
	}

}
