package com.cts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.modal.Admin;

import com.cts.modal.Home;
import com.cts.modal.Item;
import com.cts.modal.UserCart;
import com.cts.repository.AdminRepository;
import com.cts.repository.HomeRepository;
import com.cts.repository.ItemRepository;
import com.cts.repository.UserCartRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repo;
	
	@Autowired
	private UserCartRepository cart;
	
	
	public List<Item> getProducts(){
		return repo.findAll();
	}
	
	public int update(Item item) {
		List<UserCart> temp=cart.findByUser((item.getUser()));
		temp=temp.stream().filter(x->x.getName().equals(item.getName())).collect(Collectors.toList());
		System.out.println(temp);
		if(temp!=null && temp.size()>0) {
		if(item.getQuantity()<(item.getUserQuantity()+temp.get(0).getUserQuantity())) {
			
			return item.getQuantity();
		}
		}
		else if(temp!=null && temp.size()==0) {
			if(item.getQuantity()<(item.getUserQuantity())) {
				
				return item.getQuantity();
			}
		}
		else {
			
		}
		
		/*
		 *
		 */
		
		return 0;
	}
	
	public long id(Item item ) {
		Item temp=repo.findByName(item.getName());
		System.out.println(temp.getId());
		return temp.getId();
	}
	
	public List<Item> check(){
		return repo.findAll();
	}
	
	public boolean stock(UserCart item) {
		Item temp=repo.findByName(item.getName());
		int value=temp.getQuantity()+item.getQuantity();
		repo.stockQuantity(item.getName(), value);
		return true;
	}
	
	public boolean userStock(UserCart item) {
		Item temp=repo.findByName(item.getName());
		int value=temp.getQuantity()+item.getUserQuantity();
		repo.stockQuantity(item.getName(), value);
		return true;
	}
}
