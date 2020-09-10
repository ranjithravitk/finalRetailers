package com.cts.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Login")
public class Login {
	
	@Id
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
      
    @OneToMany(mappedBy="login",fetch = FetchType.EAGER)
    private List<UserCart> usercart;
      
	@JsonIgnore
	public List<UserCart> getUsercart() {
		return usercart;
	}
	public void setUsercart(List<UserCart> usercart) {
		this.usercart = usercart;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public Login(long id, String name, String password, List<UserCart> usercart) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.usercart = usercart;
	}
	public Login() {
		super();
	}
	
}
