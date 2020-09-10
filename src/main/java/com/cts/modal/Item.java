package com.cts.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 private String name;
	 @Transient
	 private String user;
	 private int price;
	 private int quantity;
	 private int userQuantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
	public int getUserQuantity() {
		return userQuantity;
	}
	public void setUserQuantity(int userQuantity) {
		this.userQuantity = userQuantity;
	}
	
	public Item() {
		super();
	}
	
	public Item(Long id, String name, String user, int price, int quantity, int userQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.price = price;
		this.quantity = quantity;
		this.userQuantity = userQuantity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", user=" + user + ", price=" + price + ", quantity=" + quantity
				+ ", userQuantity=" + userQuantity + "]";
	}
	
	
	
}
