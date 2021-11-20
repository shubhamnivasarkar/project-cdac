package com.app.service;

import java.util.List;

import com.app.pojos.Product;
import com.app.pojos.Shop;

public interface IProductService {
	
	List<Product> getProductBySId(int S_id);//R
	
	
	List<Product> displayProduct();//R
	
    Product findById(int id);//R
	
    Shop delete(int id);//R
    
    Product editProduct(int id, Product editProduct);//R
    
 String addNewStokesByPid(int pId,int quantity);

}
