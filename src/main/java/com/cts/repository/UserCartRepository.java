package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.modal.Login;
import com.cts.modal.UserCart;

@Repository
public interface UserCartRepository extends JpaRepository<UserCart, Long> {
	public UserCart findByName(String name);
	
	 public List<UserCart> findByUser(String user);
		
}
