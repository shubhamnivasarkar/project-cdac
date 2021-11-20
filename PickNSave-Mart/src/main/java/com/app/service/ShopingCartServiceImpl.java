package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CartDao;
import com.app.dao.ProductDao;
import com.app.dao.UserDao;
import com.app.dto.CheckOutResponse;
import com.app.pojos.Product;
import com.app.pojos.ShopingCart;
import com.app.pojos.Users;

@Service
@Transactional
public class ShopingCartServiceImpl implements IShopingCartService {

	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao userDao;

	@Override
	public ShopingCart addProductToCart(ShopingCart cart) {

		List<ShopingCart> ls = cartDao.placedOrder(cart.getCustomer().getId());
		for (ShopingCart i : ls) {
			Product p = productDao.findById(i.getProduct().getP_Id()).get();
			if (p.getP_Id() == cart.getProduct().getP_Id()) {
				i.setQuantity(i.getQuantity() + 1);
				return cart;
			}
		}

		return cartDao.save(cart);
	}

	@Override
	public String deleteItemFromCart(int id) {
		cartDao.deleteById(id);
		return "item deleted successfully";

	}

	@Override
	public List<ShopingCart> getCartByUserId(int u_id) {
		// TODO Auto-generated method stub
		return cartDao.placedOrder(u_id);

	}

	@Override
	public ShopingCart editQuantity(int id, ShopingCart cart) {
		ShopingCart shopCart = cartDao.findById(id).get();
		shopCart.setQuantity(cart.getQuantity());
		return cartDao.save(shopCart);
	}

	@Override
	public CheckOutResponse checkOutProduct(int u_id) {
		// TODO Auto-generated method stub
		float totalAmount = 0;
		Users u = userDao.findById(u_id).get();
		List<ShopingCart> ls = new ArrayList<>();
		ls = cartDao.placedOrder(u_id);
		System.out.println(ls.size());
		for (ShopingCart i : ls) {
			Product p = productDao.findById(i.getProduct().getP_Id()).get();
			if (p.getStocks() < i.getQuantity()) {
				System.out.println(p.getStocks() + "   " + i.getQuantity());
				return new CheckOutResponse(u.getFirstName() + " " + u.getLastName(), i.getProduct().getP_Id(),
						i.getProduct().getProductName(), "Out of Stock");
			}

			totalAmount = totalAmount + p.getPrice() * i.getQuantity();
			System.out.println(totalAmount + "total amount ");
			p.setStocks(p.getStocks() - i.getQuantity());
		}

		return new CheckOutResponse(u.getFirstName() + " " + u.getLastName(), totalAmount, "Product Available", 1);
	}

	@Override
	public CheckOutResponse availablity(ShopingCart cart, int uId) { //
		Users u = userDao.findById(uId).get();
		return new CheckOutResponse(u.getFirstName() + " " + u.getLastName(), cart.getProduct().getP_Id(),
				cart.getProduct().getProductName(), "Out of Stock");
	}

	@Override
	public ShopingCart getCartById(int cartId) {
		// TODO Auto-generated method stub
		return cartDao.findById(cartId).get();
	}



}
