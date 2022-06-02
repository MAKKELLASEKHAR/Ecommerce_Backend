package com.cg.onlineshopping.service;

import java.util.List;

import com.cg.onlineshopping.dto.OrdersDto;
import com.cg.onlineshopping.exceptions.OrderNotFoundException;

public interface OrdersService {
	
	int addOrders(OrdersDto ordersdto) throws OrderNotFoundException;
	List<OrdersDto> viewAllOrders();
	OrdersDto getOrdersById(int order_id) throws OrderNotFoundException;
	void deleteOrders(int order_id);

}
