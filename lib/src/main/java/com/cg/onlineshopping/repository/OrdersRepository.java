package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer>{
	
	@Query(value="select orders from Orders orders  where orders.order_id=?1")
	Orders getOrdersById(int order_id);

}
