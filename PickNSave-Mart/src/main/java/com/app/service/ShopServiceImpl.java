package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CartDao;
import com.app.dao.ProductDao;
import com.app.dao.ShopDao;
import com.app.dao.UserDao;
import com.app.pojos.Product;
import com.app.pojos.Shop;

@Service
@Transactional
public class ShopServiceImpl implements IShopService {

	@Autowired
	private ShopDao shopDao;
	@Autowired
	private UserDao user;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private IProductService product;

	@Autowired
	private CartDao cartDao;

	@Override
	public Shop addNewShope(int U_id, Shop shop) { // TODO
		shop.setUser(user.findById(U_id).get());
		return shopDao.save(shop);
	}

	
	  @Override public Shop getShopBYSid(int sid) { // TODO Auto-generated method
	  return shopDao.findById(sid).get(); }
	 
	@Override
	public List<Shop> getAllShop() { // TODO Auto-generated method stub
		return shopDao.findAll();
	}

	@Override
	public Product addNewProductInShop(int U_id, Product newProduct) {
		// TODO Auto-generated method stub

		Shop s = shopDao.getByUserId(U_id);
		s.getS_products().add(newProduct);
		newProduct.setShop(s);
		return productDao.save(newProduct);
	}

	@Override
	public Shop getShopByUserId(int U_id) {
		// TODO Auto-generated method stub

		return shopDao.getByUserId(U_id);
	}



	@Override
	public String deleteShop(int sId) {
		// TODO Auto-generated method stub
		Shop s = shopDao.findById(sId).get();
		shopDao.delete(s);

		return "deleted successfuly";
	}

	@Override
	public Shop updateShop(Shop s) {
		// TODO Auto-generated method stub
		Shop u = shopDao.findById(s.getS_Id()).get();
		System.out.println(u);
		u.setShopDescription(s.getShopDescription());
		u.setShopName(s.getShopName());
		u.setShopCategory(s.getShopCategory());
		u.setImageName(s.getImageName());
		return shopDao.save(u);
	}

	
}
