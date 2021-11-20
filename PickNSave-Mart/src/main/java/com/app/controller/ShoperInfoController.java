package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.IShopService;
import com.app.service.IShoperInfoService;

@RestController
@CrossOrigin
@RequestMapping("/shopper")
public class ShoperInfoController {
	
	@Autowired
	private IShoperInfoService ShoperService;
	@Autowired 
	private IShopService shop;
	
	public ShoperInfoController() {
	
		System.out.println("in const "+ getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
  @GetMapping("/shopDetails")
  public ResponseEntity<?> getShoperInfo(){
	  
	  int userId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
	  return ResponseEntity.ok(ShoperService.getShoperInfoUId(shop.getShopByUserId(userId).getS_Id()));
	  
  }

}
