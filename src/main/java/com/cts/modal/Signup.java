package com.cts.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Signup {

@Id
	
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
      private String name;
      private String password;
      private String retype_password;
	public long getId() {
		return id;
	}
	public Signup() {
		super();
	}
	public Signup(long id, String name, String password, String retype_password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.retype_password = retype_password;
	}
	@Override
	public String toString() {
		return "Signup [id=" + id + ", name=" + name + ", password=" + password + ", retype_password=" + retype_password
				+ "]";
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
	public String getRetype_password() {
		return retype_password;
	}
	public void setRetype_password(String retype_password) {
		this.retype_password = retype_password;
	}
	
}
