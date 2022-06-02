package com.cg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.dto.OrdersDto;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.entities.Orders;
import com.cg.onlineshopping.exceptions.OrderNotFoundException;
import com.cg.onlineshopping.repository.CustomerRepository;
import com.cg.onlineshopping.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	OrdersRepository ordersrepo;
	@Autowired
	CustomerRepository customerrepo;

	@Override
	public int addOrders(OrdersDto ordersdto) {
				Customer customer = customerrepo.getById(ordersdto.getCustomer_id());
				if(customer == null)
					throw new OrderNotFoundException();
				Orders orders = new Orders();
				orders.setOrder_status(ordersdto.getOrder_status());
				orders.setOrder_date(ordersdto.getOrder_date());
				orders.setAmount(ordersdto.getAmount());
				orders.setDelivery_time(ordersdto.getDelivery_time());
				orders.setCustomer(customer);
				ordersrepo.save(orders);
				
				return orders.getOrder_id();
	}

	@Override
	public List<OrdersDto> viewAllOrders() {
		List<Orders> orderslist= ordersrepo.findAll();
		ArrayList<OrdersDto> ordersdtolist =new ArrayList<OrdersDto>();
		for(Orders orders : orderslist) {
			OrdersDto ordersdto = new OrdersDto();
			ordersdto.setOrder_status(orders.getOrder_status());
			ordersdto.setOrder_date(orders.getOrder_date());
			orders.setAmount(orders.getAmount());
			orders.setDelivery_time(orders.getDelivery_time());
			ordersdto.setCustomer_id(orders.getCustomer().getCustomer_id());
			ordersdtolist.add(ordersdto);
		}
		
		return ordersdtolist;
	}

	@Override
	public OrdersDto getOrdersById(int orders_id) {
		Orders orders = ordersrepo.getOrdersById(orders_id);
		if(orders == null)
			throw new OrderNotFoundException();
		OrdersDto ordersdto = new OrdersDto();
		ordersdto.setOrder_status(orders.getOrder_status());
		ordersdto.setOrder_date(orders.getOrder_date());
		orders.setAmount(orders.getAmount());
		orders.setDelivery_time(orders.getDelivery_time());
		ordersdto.setCustomer_id(orders.getCustomer().getCustomer_id());
		
		return ordersdto;
	}

	@Override
	public void deleteOrders(int orders_id) {
		ordersrepo.deleteById(orders_id);
		
	}
	
	

}
