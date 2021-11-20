package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.ShopingCart;

public interface CartDao extends JpaRepository<ShopingCart, Integer> {
	
	@Query("select s from ShopingCart s where s.customer.Id=:id")
	List<ShopingCart> placedOrder(@Param("id") int u_id);

}
