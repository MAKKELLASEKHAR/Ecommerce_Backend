package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Customer;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	@Query(value="select cart from Cart cart where cart.cart_id=?1")
	Customer getCartById(int customer_id);

}
