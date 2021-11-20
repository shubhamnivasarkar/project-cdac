package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductDao;
import com.app.pojos.Product;
import com.app.pojos.Shop;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProductBySId(int S_id) {
		// TODO Auto-generated method stub
		return productDao.getProductBySId(S_id);
	}

	@Override
	public List<Product> displayProduct() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id).get();
	}

	@Override
	public Shop delete(int id) { // TODO Auto-generated method stub
		Shop s = productDao.findById(id).get().getShop();
		productDao.deleteById(id);
		return s;
	}

	@Override
	public Product editProduct(int id, Product editProduct) {
		// TODO Auto-generated method stub
		Product p = productDao.findById(id).get();
		p.setProductName(editProduct.getProductName());
		p.setCategories(editProduct.getCategories());
		p.setPrice(editProduct.getPrice());
		p.setStocks(editProduct.getStocks());
		return productDao.save(p);
	}

	
	  @Override public String addNewStokesByPid(int pId, int quantity) { Product
	  p=productDao.findById(pId).get(); p.setStocks(p.getStocks() + quantity);
	  return "new Stokes are added "; }
	 

}
