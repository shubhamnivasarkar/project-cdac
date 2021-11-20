package com.app.dto;


import com.app.pojos.Users;

public class LoginResponse {
	private String status;
	private Users data;
	private String token;
	
	public LoginResponse() {
		System.out.println("\n----------- CTOR: LoginResponse default CTOR --------------\n");
	}
	
	public LoginResponse(String status, Users user, String token) {
		System.out.println("\n----------- CTOR: LoginResponse - generating response with user details and JWT --------------\n");
		this.status = status;
		this.data = user;
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Users getData() {
		return data;
	}

	public void setData(Users user) {
		this.data = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "LoginResponse [status=" + status + ", data=" + data + ", token=" + token + "]";
	}


}
