package com.cg.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.dto.UPIPaymentDto;
import com.cg.onlineshopping.entities.PaymentDetails;
import com.cg.onlineshopping.repository.PaymentRepository;

@Service
public class UpiPaymentServiceImpl implements UpiPaymentService{
	
	@Autowired
	PaymentRepository paymentrepo;

	@Override
	public int upiPayment(UPIPaymentDto paymentdto) {
		PaymentDetails payment = new PaymentDetails();
		payment.setTotal_ammount(paymentdto.getTotal_ammount());
		payment.setUpi_id(paymentdto.getUpi_id());
		payment.setUpi_password(paymentdto.getUpi_password());
		return payment.getPayment_id();
	}
	
	

}
