package com.cts.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class UserCart {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Long UserId;
 
	 @ManyToOne
	 @JoinColumn(name="login_id")
     private Login login;
    
    private String name;
    private String user;
    private int price;
	 private int quantity;
	 private int userQuantity;
	 private boolean cart;
	
	
	
	public UserCart(Long userId, Login login, String name, String user, int price, int quantity, int userQuantity,
			boolean cart) {
		super();
		UserId = userId;
		this.login = login;
		this.name = name;
		this.user = user;
		this.price = price;
		this.quantity = quantity;
		this.userQuantity = userQuantity;
		this.cart = cart;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
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
	public int getUserQuantity() {
		return userQuantity;
	}
	public void setUserQuantity(int userQuantity) {
		this.userQuantity = userQuantity;
	}
	public boolean isCart() {
		return cart;
	}
	public void setCart(boolean cart) {
		this.cart = cart;
	}
	public UserCart() {
		super();
	}

	@Override
	public String toString() {
		return "UserCart [UserId=" + UserId + ", login=" + login + ", name=" + name + ", user=" + user + ", price="
				+ price + ", quantity=" + quantity + ", userQuantity=" + userQuantity + ", cart=" + cart + "]";
	}
	
	
}
