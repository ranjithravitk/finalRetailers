package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.modal.Admin;
import com.cts.modal.Login;
import com.cts.repository.AdminRepository;
import com.cts.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
	@Autowired
	private AdminRepository admin;

	public boolean UserExist(Login user) {
		// TODO Auto-generated method stub
		List<Login> temp=repo.findAll();
		System.out.println(user);
		for(Login i:temp) {
			System.out.println(i.getName());
	    	if(i.getName().equals(user.getName())) {
	    		return true;
	    	}
	    }
	  
		return false;
	}
	
	public boolean adminExist(Login user) {
		// TODO Auto-generated method stub
		List<Admin> temp=admin.findAll();
		System.out.println(user.getName());
		for(Admin i:temp) {
			//System.out.println(i.getName());
	    	if(i.getName().equals(user.getName())) {
	    		return true;
	    	}
	    }
	  
		return false;
	}
	
	
	public long getId(String name) {
		Login temp= repo.findByName(name);
		long id=temp.getId();
		System.out.println(id);
		return id;
	}
	
}
