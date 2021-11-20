package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Shop;

public interface ShopDao extends JpaRepository<Shop, Integer> {
	@Query("select s from Shop s left outer join fetch s.s_products where s.user.Id=:uid")
	Shop getByUserId(@Param("uid") int U_id);

}
