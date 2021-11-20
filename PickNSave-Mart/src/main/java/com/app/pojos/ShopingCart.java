package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class ShopingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@ManyToOne
	@JoinColumn(name = "customer_id",nullable = false)
	private Users customer;
	@ManyToOne
	@JoinColumn(name = "product_id",nullable = false)
	private Product product;
	private int quantity;
	
	public ShopingCart() {
		// TODO Auto-generated constructor stub
	}

	public ShopingCart(int cartId, Users customer, Product product, int quantity) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Users getCustomer() {
		return customer;
	}

	public void setCustomer(Users customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("ShopingCart [cartId=%s, quantity=%s]", cartId, quantity);
	}
	
	
}
