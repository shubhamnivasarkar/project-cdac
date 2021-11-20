package com.app.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Product;
import com.app.pojos.Shop;
import com.app.service.IShopService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private IShopService shopSer;
	
	
	
	@Value("${file.upload.location}")
	private String path;
	
	public ShopController() {
	
		System.out.println("in const "+getClass().getName());
		// TODO Auto-generated constructor stub
	}

	
	@PostMapping("/add")
	public ResponseEntity<?> addNewshops(@RequestParam String newShop,@RequestParam(required = false) MultipartFile image ){
		Integer userId =Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		String msg=null;
		try {
			
			Shop shop= new ObjectMapper().readValue(newShop, Shop.class);
			
			if(image != null) {
				image.transferTo(new File(path, image.getOriginalFilename()));
				shop.setImageName(image.getOriginalFilename());
				msg= shop.getShopName() +"  add successfully";
			}
			
			shopSer.addNewShope(userId, shop);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(msg);
	}
	

	
	  @GetMapping("/details") public ResponseEntity<?> getDetails(){ 
		  return new
	  ResponseEntity<>(shopSer.getAllShop(), HttpStatus.OK); }
	 
	
	
	 
	
	@GetMapping("/owner")
	public ResponseEntity<?> getShopByOwnerId(){
		Integer userId =Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		return new ResponseEntity<>(shopSer.getShopByUserId(userId),HttpStatus.OK);
	}
	

	@PostMapping("/add-product")
	public ResponseEntity<?> addNewProduct(@RequestParam String newProduct,@RequestParam(required = false) MultipartFile image ){
		Integer userId =Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		String msg=null;
		
		try {
			
			Product product= new ObjectMapper().readValue(newProduct, Product.class);
			
			if(image != null) {
				image.transferTo(new File(path, image.getOriginalFilename()));
				product.setImageName(image.getOriginalFilename());
				msg= product.getProductName()+" add successfully";
			}
			
			shopSer.addNewProductInShop(userId, product);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(msg);
	}
	
	
	
	
	@DeleteMapping("/deleteShop/{sId}")
	public ResponseEntity<?> deleteShop(@PathVariable int sId){
		System.out.println("inside delete shopmethod....");
		return ResponseEntity.ok(shopSer.deleteShop(sId));
	}
	
	
	
	@PutMapping("/updateShop")
	public ResponseEntity<?> updateshops(@RequestParam String shop,@RequestParam(required = false) MultipartFile image ){
		Integer userId =Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		String msg=null;
		try {
			
			Shop newshop= new ObjectMapper().readValue(shop, Shop.class);
			
			if(image != null) {
				image.transferTo(new File(path, image.getOriginalFilename()));
				newshop.setImageName(image.getOriginalFilename());
				msg= newshop.getShopName() +"  add successfully";
			}
			
			shopSer.updateShop(newshop);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(msg);
	}
	
	
	

	
}
