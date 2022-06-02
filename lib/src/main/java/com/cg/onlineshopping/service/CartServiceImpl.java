package com.cg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.dto.CartDto;
import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.repository.CartRepository;
import com.cg.onlineshopping.repository.ItemRepository;

@Service
public class CartServiceImpl implements CartService{
	
	
	@Autowired
	CartRepository cartrepo;
	@Autowired
	ItemRepository itemrepo;

	@Override
	public int addToCart(CartDto cartdto) {
		Cart cart = new Cart();
		cart.setItem_name(cartdto.getItem_name());
		cart.setItem_price(cartdto.getItem_price());
		cart.setItem_quantity(cartdto.getItem_quantity());
		cart.setItem_description(cartdto.getItem_description());
		cartrepo.save(cart);
		return cart.getCart_id();
		
	}

	@Override
	public List<CartDto> viewAllCart() {
		Iterable<Cart> cartlist= cartrepo.findAll();
		ArrayList<CartDto> cartdtolist =new ArrayList<CartDto>();
		for(Cart cart : cartlist) {
			CartDto cartdto = new CartDto();
			cartdto.setItem_name(cart.getItem_name());
			cartdto.setItem_price(cart.getItem_price());
			cartdto.setItem_quantity(cart.getItem_quantity());
			cartdto.setItem_description(cart.getItem_description());
			cartdtolist.add(cartdto);

		}
		
		return cartdtolist;
	}

	
	@Override
	public void deleteCart(int cart_id) {
		cartrepo.deleteById(cart_id);

		
	}
	
	

}
