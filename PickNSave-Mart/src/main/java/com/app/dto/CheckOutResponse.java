package com.app.dto;

import java.time.LocalDate;

public class CheckOutResponse {

	private String userName;
	private LocalDate date = LocalDate.now();
	private double totalAmmount;
	private int productId;
	private String productName;
	private String msg;
	private int status = 0;

	public CheckOutResponse(String userName, int productId, String productName, String msg) {
		super();
		this.userName = userName;
		this.productId = productId;
		this.productName = productName;
		this.msg = msg;
	}

	public CheckOutResponse(String userName, double totalAmmount, String msg, int status) {
		super();
		this.userName = userName;
		this.totalAmmount = totalAmmount;
		this.msg = msg;
		this.status = status;
	}

	public CheckOutResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getTotalAmmount() {
		return totalAmmount;
	}

	public void setTotalAmmount(double totalAmmount) {
		this.totalAmmount = totalAmmount;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("CheckOutResponse [userName=%s, date=%s, totalAmmount=%s]", userName, date, totalAmmount);
	}

}
