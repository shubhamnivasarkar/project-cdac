package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Address;
import com.app.service.IAddressService;

@CrossOrigin /*Cross origin is called as CORS which means Cross origins resource sharing. 
						It allows you to make request from one website to another website in the browser, 
						which is prohibited by Same origin policy.
						*/
@RestController/*- It is used to create RestFull web service using spring mvc.
							- Spring rest controller takes care of mapping request data to define request handler method. 
								Once response body in generated from the handler method, it converts it to JSON response
								*/
@RequestMapping("/address")//- It is used to map web request onto specific class or method.
public class AddressController {
	
	@Autowired
	private IAddressService addrService;
	
	
	
	
	
	@GetMapping("/userAddress")
		public ResponseEntity<?> getAddressofUser(){
		Integer userId =Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
			return ResponseEntity.ok(addrService.getDeliveryAddress(userId));
	}
	
	@PutMapping("/updateUserAddress")
	public ResponseEntity<?> updateAddress(@RequestBody Address adrr){
		Integer userId =Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println("in update address");
		return ResponseEntity.ok(addrService.updateAddress(userId, adrr));
		
	}
}
