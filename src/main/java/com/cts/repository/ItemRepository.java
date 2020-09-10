package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.modal.Item;
import com.cts.modal.UserCart;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE Item c SET c.quantity = :quantity WHERE c.name = :name")
	 * public int updateQuantity(@Param("name") String name, @Param("quantity") int
	 * quantity);
	 */
	@Modifying
	@Transactional
    @Query("UPDATE Item c SET c.quantity = :quantity WHERE c.name = :name")
   public int stockQuantity(@Param("name") String name, @Param("quantity") int quantity);

	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("select * from item c where c.quantity=0") public List<Item>
	 * checkQuantity();
	 */
   public Item findByName(String name);
   
  
}
