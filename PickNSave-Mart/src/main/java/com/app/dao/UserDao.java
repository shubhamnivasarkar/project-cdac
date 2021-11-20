package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Address;
import com.app.pojos.Users;

public interface UserDao extends JpaRepository<Users, Integer> {
	
	Users findByEmail(String email);
	Optional<Users> findByEmailAndPassword(String email, String password);
	
	  @Query("select u from Users u join fetch u.addresses where u.Id=:uId") Users
	  getUserbyAddressId(@Param("uId") int uId);
	  
	  List<Users> findByFirstName(String firstName);
	 

}
