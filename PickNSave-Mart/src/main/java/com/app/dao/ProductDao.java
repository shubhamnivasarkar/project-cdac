package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query("select p from Product p left outer join fetch p.shop where p.shop.S_Id=:sid")
	List<Product> getProductBySId(@Param("sid") int S_id );
	
}
