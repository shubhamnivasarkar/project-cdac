package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ShopingCart;
import com.app.service.IProductService;
import com.app.service.IShopingCartService;
import com.app.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class ShopingCartController {
	
	@Autowired
	private IShopingCartService shopcartService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IUserService userService;
	
	
	public ShopingCartController() {
	
		System.out.println("in const "+getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/{p_id}")
	public ResponseEntity<?> addProductIntoCart(@PathVariable int p_id){
		Integer userId =Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
	ShopingCart cart=new ShopingCart();
	cart.setCustomer(userService.findById(userId));
	cart.setProduct(productService.findById(p_id));
	cart.setQuantity(1);
		return ResponseEntity.ok(shopcartService.addProductToCart(cart));
	}
	
	@GetMapping("/fetch/{cartId}")
	public ResponseEntity<?> getCartById(@PathVariable int cartId){
		return ResponseEntity.ok(shopcartService.getCartById(cartId));
	}
	
	@GetMapping("/product")
	public ResponseEntity<?> getProductToCart(){
		Integer userId =Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		return ResponseEntity.ok(shopcartService.getCartByUserId(userId));
	}
	
	@DeleteMapping("/{c_id}")
	public ResponseEntity<?> deleteproductFromCart(@PathVariable int c_id){
		return ResponseEntity.ok(shopcartService.deleteItemFromCart(c_id));
	}
	
	
	@PutMapping("/{c_id}")
	public ResponseEntity<?> editQuantityInCart(@PathVariable int c_id, @RequestBody ShopingCart cartItem){
		
		return ResponseEntity.ok(shopcartService.editQuantity(c_id, cartItem));
	}
	
	
	@GetMapping("/checkout")
	public ResponseEntity<?> checkoutAllOrder(){
		
		Integer userId=Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		return ResponseEntity.ok(shopcartService.checkOutProduct(userId));
	}
	

	

}
