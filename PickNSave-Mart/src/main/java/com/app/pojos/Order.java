package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OrderId;
	private LocalDate Odate=LocalDate.now();
	@ManyToOne
	@JoinColumn(name = "customer_id",nullable = false)
	private Users customer;
	@ManyToOne
	@JoinColumn(name = "product_id",nullable = false)
	private Product product;
	private float unitPrice;
	private int Quntity;
	private float subtotal;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, LocalDate odate, Users customer, Product product, float unitPrice, int quntity,
			float subtotal, Status status) {
		super();
		OrderId = orderId;
		Odate = odate;
		this.customer = customer;
		this.product = product;
		this.unitPrice = unitPrice;
		Quntity = quntity;
		this.subtotal = subtotal;
		this.status = status;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public LocalDate getOdate() {
		return Odate;
	}

	public void setOdate(LocalDate odate) {
		Odate = odate;
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

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuntity() {
		return Quntity;
	}

	public void setQuntity(int quntity) {
		Quntity = quntity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format(
				"Order [OrderId=%s, Odate=%s, customer=%s, product=%s, unitPrice=%s, Quntity=%s, subtotal=%s, status=%s]",
				OrderId, Odate, customer, product, unitPrice, Quntity, subtotal, status);
	}
	
	
	

}
