package com.cg.onlineshopping.service;

import java.util.List;

import com.cg.onlineshopping.dto.CartDto;

public interface CartService {
	
	int addToCart(CartDto cartdto);
	List<CartDto> viewAllCart();
	void deleteCart(int cart_id);

}
