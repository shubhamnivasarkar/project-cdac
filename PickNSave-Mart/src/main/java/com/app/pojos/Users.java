package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity	// table creation 				
@Table(name="users")	
public class Users extends BaseEntity {
		
							
	

	@NotBlank(message = "password not be blank")
	@Column(length = 30, nullable = false)
	private String password;
	@NotBlank
	@Column(name = "first_name", length = 30,nullable = false)
	private String firstName;
	@NotBlank
	@Column(name = "last_name", length = 30)
	private String lastName;
	@NotBlank
	@Column(length = 30,unique = true,nullable = false )
	private String email;
	
	@Column(length = 15)
	private String phone;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Role role;
	
	@JsonIgnore
	@OneToOne(mappedBy = "selectedUser",cascade = CascadeType.ALL)
	private Address addresses ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Order> custOrder;
	
	@OneToOne(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.LAZY)
	@JsonIgnore
	private Shop userShop;
	
	@OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ShopingCart> userCart;
	
	
	
	 public String getPassword() { return password; }
	 
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	
	public Address getAddresses() {
		return addresses;
	}

	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User ID: " + getId() + " [password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phone=" + phone + ", role=" + role + "]";
	}
	
	
}
