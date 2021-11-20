package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.dto.LoginRequest;
import com.app.pojos.Role;
import com.app.pojos.Users;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDao userRepo;
	
	public UserServiceImpl() {
		System.out.println("---------- CTOR: "+ getClass().getName() +" -----------");
	}
	
	@Override
	public Users registerOrEditUser(Users user) {
		
		return userRepo.save(user);
	}
	
	@Override
	public Users edit(Users user, int userId) {
		user.setPassword(userRepo.findById(userId).get().getPassword());
		user.setId(userId);
		return userRepo.save(user);
	}
	
	

	@Override
	public Users authenticateUser(LoginRequest request) {
				
		return userRepo.findByEmailAndPassword(request.getEmail(), request.getPassword()).get();
	}

	@Override
	public List<Users> getUsersByRole(Role role) {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public Users findById(Integer id) {
		return userRepo.findById(id).get();
	}

	@Override
	public String deleteUserById(Integer uid) {
		userRepo.deleteById(uid);
		return "Deleted User with ID: " + uid + " successfully!";
	}
	
	@Override
	public Users getUserByEmail(String Email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(Email);
	}
	
	@Override
	public List<Users> getUserByName(String fname) {
		// TODO Auto-generated method stub
		return userRepo.findByFirstName(fname);
	}
    
	
	@Override
	public int countUsers() {
		// TODO Auto-generated method stub
		return (int) userRepo.count();
	}
		
}
