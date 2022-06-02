package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.PaymentDetails;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetails,Integer>{
	
	@Query(value="select payment from PaymentDetails payment where payment.payment_id=?1")
	PaymentDetails getPaymentById(int payment_id);

}
