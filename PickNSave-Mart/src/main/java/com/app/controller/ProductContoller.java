package com.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Product;
import com.app.service.IProductService;
import com.app.service.IShopService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductContoller {
	
	@Autowired
	private IProductService productService;
	@Autowired
	private IShopService shopService;
	
	@Value("${file.upload.location}")
	private String imgpath;
	
	public ProductContoller() {
	
		System.out.println(" in const "+getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getDetails(){
		System.out.println("in method");
		Integer userId =Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		return new ResponseEntity<>(productService.getProductBySId(shopService.getShopByUserId(userId).getS_Id()), HttpStatus.OK);
	}
	
	@GetMapping("/getShopProduct/{sid}")
	public ResponseEntity<?> getProductByShop(@PathVariable int sid){
		return ResponseEntity.ok(productService.getProductBySId(sid));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getProduct() {
		return new ResponseEntity<>(productService.displayProduct(), HttpStatus.OK);

	}
	
	
	
	@GetMapping("/info/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		System.out.println("inside get...");
		Product prd = productService.findById(id);
		return ResponseEntity.ok().body(prd);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
		System.out.println("Inside delete");
		Product prd = productService.findById(id);
		productService.delete(prd.getP_Id());
		return ResponseEntity.ok().body("Product with ID : " + id + " deleted with success!");
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editProduct(@PathVariable("id") int id,@RequestParam String product,@RequestParam(required = false) MultipartFile image){
		
		String msg=null;
		
		try {
			
			Product editProduct = new ObjectMapper().readValue(product, Product.class);
			
			if(image != null) {
				image.transferTo(new File(imgpath,image.getOriginalFilename()));
				editProduct.setImageName(image.getOriginalFilename());
			}
			
			productService.editProduct(id, editProduct);
			msg=editProduct.getProductName()+ "  edited succesfully ";
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(msg);
	}
	
	
	
	@GetMapping("/image/{imgName}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable String imgName) throws IOException {

		
		Path path = Paths.get(imgpath, imgName);
		InputStreamResource inputStreamResource =
				new InputStreamResource(new FileInputStream(path.toFile()));

		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", Files.probeContentType(path));
		return ResponseEntity.ok().headers(headers).body(inputStreamResource);
	}

}
