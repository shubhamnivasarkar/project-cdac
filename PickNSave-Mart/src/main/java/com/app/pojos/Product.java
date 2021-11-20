package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int P_Id;
	@NotBlank
	@Column(length = 30)
	private String productName;
	@NotBlank
	@Column(length = 30)
	private String categories;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "shop_id",nullable = false)
	private Shop shop;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ShopingCart> cartProduct;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Order> orderProduct;
	
	private int stocks;
	private float price;
	
    @Column(length = 40, name="image_name")
	private String imageName;
	
    
	public int getP_Id() {
		return P_Id;
	}

	public void setP_Id(int p_Id) {
		P_Id = p_Id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<ShopingCart> getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(List<ShopingCart> cartProduct) {
		this.cartProduct = cartProduct;
	}

	public List<Order> getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(List<Order> orderProduct) {
		this.orderProduct = orderProduct;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return String.format(
				"Product [P_Id=%s, productName=%s, categories=%s, shop=%s, cartProduct=%s, orderProduct=%s, stocks=%s, price=%s, imageName=%s]",
				P_Id, productName, categories, shop, cartProduct, orderProduct, stocks, price, imageName);
	}

	
	
	
	
}
