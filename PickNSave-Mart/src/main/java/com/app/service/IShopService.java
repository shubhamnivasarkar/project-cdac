package com.app.service;

import java.util.List;

import com.app.pojos.Product;
import com.app.pojos.Shop;

public interface IShopService {
	Shop addNewShope(int U_id, Shop shop);//R

	List<Shop> getAllShop();//R

	Product addNewProductInShop(int U_id, Product newProduct);//R

	Shop getShopByUserId(int U_id);//R

	String deleteShop(int sId);//R

	Shop updateShop(Shop s);//R

	Shop getShopBYSid(int sid);

}
