package com.cg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.dto.ItemDto;
import com.cg.onlineshopping.entities.Item;
import com.cg.onlineshopping.entities.Vendor;
import com.cg.onlineshopping.exceptions.ItemNotFoundException;
import com.cg.onlineshopping.repository.ItemRepository;
import com.cg.onlineshopping.repository.VendorRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemrepo;
	@Autowired
	VendorRepository vendorrepo;

	@Override
	public int addItem(ItemDto itemdto) {
		
		Vendor vendor = vendorrepo.getVendorById(itemdto.getVendor_id());
		if(vendor == null)
			throw new ItemNotFoundException();
		Item item = new Item();
	    item.setItem_name(itemdto.getItem_name());
	    item.setItem_description(itemdto.getItem_description());
	    item.setItem_price(itemdto.getItem_price());
	    item.setVendor(vendor);
	    itemrepo.save(item);
		return item.getItem_id();
	}

	
	
	@Override
	public List<ItemDto> viewAllItems() {
		
		List<Item> itemlist= itemrepo.findAll();
		ArrayList<ItemDto> itemdtolist =new ArrayList<ItemDto>();
		for(Item item : itemlist) {
			ItemDto itemdto = new ItemDto();
			itemdto.setItem_description(item.getItem_description());
			itemdto.setItem_name(item.getItem_name());
			itemdto.setItem_price(item.getItem_price());
			itemdto.setVendor_id(item.getVendor().getVendor_id());
		
			itemdtolist.add(itemdto);

		}
		
		return itemdtolist;
		 
	}

	@Override
	public ItemDto getItemById(int item_id) {
		Item item = itemrepo.getItemById(item_id);
		if(item == null)
			throw new ItemNotFoundException();
		ItemDto itemdto = new ItemDto();
		itemdto.setItem_name(item.getItem_name());
		itemdto.setItem_description(item.getItem_description());
		itemdto.setItem_price(item.getItem_price());
		itemdto.setVendor_id(item.getVendor().getVendor_id());
		
		
		return itemdto;
	}

	@Override
	public void deleteItem(int item_id) {
		itemrepo.deleteById(item_id);
		
	}



	

}
