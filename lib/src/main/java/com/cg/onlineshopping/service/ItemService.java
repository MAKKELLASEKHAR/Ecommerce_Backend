package com.cg.onlineshopping.service;

import java.util.List;
import com.cg.onlineshopping.dto.ItemDto;
import com.cg.onlineshopping.exceptions.ItemNotFoundException;

public interface ItemService {
  
	
	int addItem(ItemDto itemdto) throws ItemNotFoundException;
	List<ItemDto> viewAllItems();
	ItemDto getItemById(int item_id) throws ItemNotFoundException;
	void deleteItem(int item_id);
}
