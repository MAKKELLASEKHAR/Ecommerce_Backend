package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Item;

@Repository
public interface ItemRepository  extends JpaRepository<Item,Integer>{
	
	@Query(value="select item from Item item where item.item_id=?1")
	Item getItemById(int item_id);

}



