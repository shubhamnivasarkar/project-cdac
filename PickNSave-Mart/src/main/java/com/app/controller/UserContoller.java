package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_excs.CustomerHandlingException;
import com.app.dto.LoginRequest;
import com.app.dto.LoginResponse;
import com.app.pojos.Users;
import com.app.service.IUserService;
import com.app.util.JwtUtil;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserContoller {
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private IUserService userService;
	
	@Autowired 
	private AuthenticationManager authenticationManager;

	public UserContoller() {
		System.out.println("int const " + getClass().getName() );
	}

	
	
	
	@GetMapping("/details")
	public ResponseEntity<?> getUserDetails() 
	{
		Integer id = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println("User ID from API: " + id);
		System.out.println(userService.findById(id));
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
		
	}
	
	@PutMapping("/edit/{uid}")
	public ResponseEntity<?> editUser(@RequestBody Users user, @PathVariable int uid){
		return new ResponseEntity<>(userService.edit(user, uid), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register") 
	public ResponseEntity<?> registerUser(@RequestBody Users user) throws CustomerHandlingException {
		System.out.println("In register new user");
		try{return new ResponseEntity<>(userService.registerOrEditUser(user), HttpStatus.CREATED);
	}catch(Exception e) {
		throw new CustomerHandlingException("Duplicated Email Detected...!!");
	}
	}
	
	@PostMapping("/login") 
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request) throws CustomerHandlingException {
		System.out.println("login REST API");
		try {

			Authentication authenticate = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			System.out.println("Authenticated userDetails:" + authenticate );
			

		} catch (Exception e) {
			throw new CustomerHandlingException("Authentication Failure");
		}

		Users user = userService.findByEmail(request.getEmail());

		return new ResponseEntity<>(new LoginResponse("success", user, jwtUtil.generateToken(user.getId())),
				HttpStatus.OK);
	}
	
	
	  @DeleteMapping("/delete/{uid}") 
	  public ResponseEntity<?> deleteUserById(@PathVariable Integer uid){
		  
		  return new ResponseEntity<>(userService.deleteUserById(uid), HttpStatus.OK);
	  }
	 
	
}
