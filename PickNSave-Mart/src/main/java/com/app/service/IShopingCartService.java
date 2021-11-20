package com.app.service;

import java.util.List;

import com.app.dto.CheckOutResponse;
import com.app.pojos.ShopingCart;

public interface IShopingCartService {
	ShopingCart addProductToCart(ShopingCart cart);// R

	String deleteItemFromCart(int id);// R

	List<ShopingCart> getCartByUserId(int u_id);// R

	ShopingCart editQuantity(int id, ShopingCart cart);// R

	CheckOutResponse checkOutProduct(int u_id);// R

	CheckOutResponse availablity(ShopingCart cart, int uId);

	ShopingCart getCartById(int cartId);// R

}
