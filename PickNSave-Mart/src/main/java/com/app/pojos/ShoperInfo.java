package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopInfo")
public class ShoperInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id ;
	private int shopId;
	private int orderId;
	private LocalDate orderDate;
	private int productId;
	@Column(length = 30)
	private String productName;
	private int qunatity;
	private float unitPrice;
	private float subTotal;
	
	public ShoperInfo() {
		// TODO Auto-generated constructor stub
	}
	
	

	



	public ShoperInfo(int shopId, int orderId, LocalDate orderDate, int productId, String productName, int qunatity,
			float unitPrice, float subTotal) {
		super();
		this.shopId = shopId;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.productId = productId;
		this.productName = productName;
		this.qunatity = qunatity;
		this.unitPrice = unitPrice;
		this.subTotal = subTotal;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return String.format(
				"ShoperInfo [id=%s, shopId=%s, orderId=%s, orderDate=%s, productId=%s, productName=%s, qunatity=%s, unitPrice=%s, subTotal=%s]",
				id, shopId, orderId, orderDate, productId, productName, qunatity, unitPrice, subTotal);
	}
	
	

}
