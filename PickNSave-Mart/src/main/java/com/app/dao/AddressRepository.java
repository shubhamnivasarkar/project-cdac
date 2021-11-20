package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	/*
JPA Repository - JpaRepository is JPA specific extension of Repository.
 It contains the full API of CrudRepository and PagingAndSortingRepository.
 So it contains API for basic CRUD operations
 */
	/*
	 * @Query("select a from Address a join fetch a.selectedUser where a.selectedUser.id=:id"
	 * ) Address getAddressesByUserId(@Param("id") Integer userId);
	 */
	
	@Query("select a from Address a join fetch a.selectedUser where a.selectedUser.id=:id")
	Address getDelivryAddress(@Param("id") Integer userId);
	
	
	
}
