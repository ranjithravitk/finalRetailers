package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cts.modal.Home;
import com.cts.modal.Item;
import com.cts.modal.Login;
import com.cts.modal.Signup;
import com.cts.modal.UserCart;
import com.cts.service.AdminService;
import com.cts.service.CartService;
import com.cts.service.ItemService;
import com.cts.service.LoginService;
import com.cts.service.SignupService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

	@Autowired
	private LoginService service;

	@Autowired
	private SignupService signup;

	@Autowired
	private ItemService home;
	
	@Autowired
	private CartService cart;
	
	@Autowired
	private AdminService admin;

	@PostMapping("/login")
	public boolean userPresent(@RequestBody Login user) {
		System.out.println(user);
		boolean temp = service.UserExist(user);
	
		return temp;
	}

	@PostMapping("/admin")
	public boolean adminPresent(@RequestBody Login user) {
		// System.out.println(user);
		boolean temp = service.adminExist(user);
	
		return temp;
	}
	
	@PostMapping("/signup")
	public boolean resgisterUser(@RequestBody Signup user) {
		return signup.register(user);
	}

	@GetMapping("/home")
	public List<Item> getProducts() {
		return home.getProducts();
	}
	@PostMapping("/cart")
	public boolean addCart(@RequestBody UserCart item) {
		boolean temp=cart.add(item);
		System.out.println( temp); 
		return temp;
	}
	
	@PostMapping("/getcart")
	public List<UserCart> getCart(@RequestBody String name){
		System.out.println(name);
		return cart.getCart(name);
	}
	@PostMapping("/id")
	public Long getId(@RequestBody String name) {
		return service.getId(name);
	}
	
	@PostMapping("/delete")
	public boolean deleteCart(@RequestBody UserCart item) {
		System.out.println(item);
		return cart.deleteItem(item); 
	}
	
	@PostMapping("/listitem")
	public boolean listitem(@RequestBody Item item) {
		return admin.add(item);
	}
	
	@PostMapping("/update")
	public int update(@RequestBody Item item) {
		System.out.println("inside update");
		return home.update(item);
	}
	
	@PostMapping("/idProduct")
	public long idProduct(@RequestBody Item item) {
	
		return home.id(item);
	}
	@GetMapping("/checkitem")
	public List<Item> check(){
		
		return home.check();
	}
	@PostMapping("/stockitem")
	public boolean stockadd(@RequestBody UserCart item) {

		return home.stock(item);
	}
	@PostMapping("/userStock")
	public boolean userStock(@RequestBody UserCart item) {
	return home.userStock(item);	
	}
	
	
	 @PostMapping("/deleteAll") 
	 public boolean deleteCart(@RequestBody String name) {
		 System.out.println("inside deleteAll");
		 boolean temp=cart.deleteAll(name);
		 System.out.println(temp);
		 return temp; }
	
}
