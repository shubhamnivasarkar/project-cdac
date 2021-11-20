package com.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.pojos.Users;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userRepo;

	public UserDetailsServiceImpl() {
		System.out.println("\n---------- CTOR: " + getClass().getName() + " -----------\n");
	}

	// R
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		System.out.println("\n------------ IN UserDetailsServiceImpl.loadUserByUsername ---------------\n");

		System.out.println("Email: " + email);

		Users user = userRepo.findByEmail(email);

		System.out.println("User from loadUserByUsername: " + user);
		return new org.springframework.security.core.userdetails.User(Integer.toString(user.getId()),
				user.getPassword(), new ArrayList<GrantedAuthority>());
	}

	
	  public UserDetails loadUserById(Integer id) throws UsernameNotFoundException
	  {
	  
	  System.out.
	  println("\n------------ IN UserDetailsServiceImpl.loadUserById ---------------\n"
	  );
	  
	  System.out.println("Id: " + id);
	  
	  Users user = userRepo.findById(id).get();
	  
	  System.out.println("User from loadUserById: " + user); return new
	  org.springframework.security.core.userdetails.User(Integer.toString(user.
	  getId()), user.getPassword(), new ArrayList<GrantedAuthority>()); }
	 

}
