package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{
	
	@Query("select o from Order o where o.customer.Id=:uId")
	List<Order> getallOrdersOfCustomer(@Param("uId") int uId);
	@Query("SELECT SUM(o.subtotal) FROM Order o")
    float sumOrders();
}
