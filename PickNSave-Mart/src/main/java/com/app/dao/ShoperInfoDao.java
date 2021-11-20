package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.ShoperInfo;

public interface ShoperInfoDao extends JpaRepository<ShoperInfo, Integer>{
	
	@Query("select s from ShoperInfo s where s.shopId=:sId")
	List<ShoperInfo> getShoperInfo(@Param("sId") int sId);
	
	@Query("select s from ShoperInfo s where s.orderId=:oId")
	List<ShoperInfo> getShInfos(@Param("oId") int oId);

}
