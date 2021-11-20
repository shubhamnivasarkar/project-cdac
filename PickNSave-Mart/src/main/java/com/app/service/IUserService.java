package com.app.service;

import java.util.List;

import com.app.dto.LoginRequest;
import com.app.pojos.Role;
import com.app.pojos.Users;

public interface IUserService {
	
	Users registerOrEditUser(Users user);//R

	Users authenticateUser(LoginRequest request);//R

	List<Users> getUsersByRole(Role role); 
	
	Users findByEmail(String email);//R

	Users findById(Integer id);//R
	 
	Users edit(Users user,int userId);//R

	String deleteUserById(Integer uid);//R
	
	List<Users> getUserByName(String fname);
	
	Users getUserByEmail(String Email);
	
	int countUsers();
	

}
