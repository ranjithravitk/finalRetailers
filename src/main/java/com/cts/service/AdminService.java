package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.modal.Item;
import com.cts.repository.ItemRepository;

@Service
public class AdminService {
	@Autowired
     private ItemRepository repo;
 
	public boolean add(Item item) {
	Item name=repo.findByName(item.getName());
	
	if(name==null) {
		repo.save(item);
		return true;
	}
	
	
	return false;
	}
}
