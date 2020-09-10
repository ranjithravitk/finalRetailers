package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.modal.Login;
import com.cts.modal.Signup;
import com.cts.repository.LoginRepository;

@Service
public class SignupService {

	@Autowired
	private LoginRepository repo;
	
	
	public boolean register(Signup user) {
		Login temp=repo.findByName(user.getName());
		System.out.println(temp);
		if(temp!=null) {
			Login insert = new Login();
			insert.setName(user.getName());
			insert.setPassword(user.getPassword());
			repo.save(insert);
			return true;
		}
		return false;
	}
}
