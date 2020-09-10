package com.cts.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Home {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 private String name;
	 private int price;
	 private int quantity;
	 private int userQuantity;
	 private boolean cart;
	 public Home(Long id, String name, int price, int quantity, int userQuantity, boolean cart) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.userQuantity = userQuantity;
		this.cart = cart;
	}
	public int getUserQuantity() {
		return userQuantity;
	}
	public void setUserQuantity(int userQuantity) {
		this.userQuantity = userQuantity;
	}
	
	public Home() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isCart() {
		return cart;
	}
	public void setCart(boolean cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", userQuantity="
				+ userQuantity + ", cart=" + cart + "]";
	}
	
	
}
