package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.modal.Item;
import com.cts.modal.Login;
import com.cts.modal.UserCart;

import com.cts.repository.ItemRepository;
import com.cts.repository.LoginRepository;
import com.cts.repository.UserCartRepository;

@Service
public class CartService {

	/*
	 * @Autowired private CartInterface repo;
	 */
	@Autowired
	private UserCartRepository repo;
	
	@Autowired
	private ItemRepository item;
	
	@Autowired
	private LoginRepository login;
	
	
	
	public boolean add(UserCart item) {
		
		String name=item.getUser();
		Login temp1=login.findByName(name);
		List<UserCart> cart=temp1.getUsercart();
		
		Boolean alreadyExists=false;
		if(item.getUserQuantity()==0) {
			return false;
		}
		else {
		if(cart==null) {
		 System.out.println("inside third time");
			item.setQuantity(item.getQuantity()-item.getUserQuantity());
			item.setLogin(temp1);
		repo.save(item);
		
		}
		else {
			System.out.println(cart+" hear");
			for(UserCart t:cart) {
				 if(t.getName().equals(item.getName())){ 
					 System.out.println("inside update but added extra");
					 alreadyExists=true;
					t=repo.findById(t.getUserId()).get();
					 t.setUserQuantity(item.getUserQuantity()+t.getUserQuantity());
					  t.setQuantity(t.getQuantity()-item.getUserQuantity()); repo.save(t);
				 }
				  
			}
			
			/*
			 * cart.forEach((t)->{ if(t.getName()==item.getName()) { alreadyExists=true;
			 * t.setUserQuantity(item.getUserQuantity()+t.getUserQuantity());
			 * t.setQuantity(t.getQuantity()-item.getUserQuantity()); repo.save(t); } });
			 */
		    if(!alreadyExists) {
		    	item.setQuantity(item.getQuantity()-item.getUserQuantity());
				item.setLogin(temp1);
			repo.save(item);
		    }
			
		}
		}
		return true;
	}
	
	public List<UserCart> getCart(String name){
		System.out.println("inside cart initialization");
		System.out.println(name);
		Login temp1=login.findByName(name);
		System.out.println(temp1.getName());
		List<UserCart> cart=temp1.getUsercart();
	
		return cart;
	}
	
	public boolean deleteItem(UserCart item) {

		repo.delete(item);
		 return true;
	}
	
	/*
	 * public boolean deleteAll() { List<Cart> temp=repo.findAll(); List<Item>
	 * items=item.findAll(); int n=items.size(); for(Cart i:temp) { for(int
	 * j=0;j<n;j++) { if(i.getName().equals(items.get(j).getName())) {
	 * if(items.get(j).getQuantity()>0) {
	 * items.get(j).setQuantity(items.get(j).getQuantity()-i.getUserQuantity());
	 * items.get(j).setUserQuantity(0); item.save(items.get(j)); } } }
	 * 
	 * } return true; }
	 */
	
	
	public boolean deleteAll(String name) {
		Login temp=login.findByName(name);
		List<UserCart> t=temp.getUsercart();
		boolean flag=true;
		for(UserCart a:t) {
			Item i=item.findByName(a.getName());
	    	if(i.getQuantity()-a.getUserQuantity()>=0) {
	    		flag=true;
	    	}
	    	else {
	    		flag=false;
	    		break;
	    	}
	    	
		}
		
		if(flag) {
	    for(UserCart cart:t) {
	    	Item i=item.findByName(cart.getName());
	    	if(i.getQuantity()-cart.getUserQuantity()>=0) {
	    	i.setQuantity(i.getQuantity()-cart.getUserQuantity());
	    	System.out.println(item.save(i));
	    	repo.deleteById(cart.getUserId());
	    	}
	    	else {
	    		return false;
	    	}
	    }
		
	    
	    return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
}
