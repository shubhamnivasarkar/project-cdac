package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Shops")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int S_Id;
	@NotBlank
	@Column(length = 30)
private String shopName;
	@NotBlank
	@Column(length = 30)
private String shopDescription;
	@NotBlank
	@Column(length = 30)
private String shopCategory;
	@Column(length = 40, name="image_name")
private String imageName;


@OneToMany(mappedBy = "shop",cascade = {CascadeType.MERGE,CascadeType.REMOVE})
@JsonIgnore
private List<Product> s_products;
@OneToOne
@JoinColumn(name = "user_id",nullable = false,unique = true)
private Users user;

public Shop() {
	// TODO Auto-generated constructor stub
}

public Shop(int s_Id, String shopName, String shopDescription, List<Product> s_products) {
	super();
	S_Id = s_Id;
	this.shopName = shopName;
	this.shopDescription = shopDescription;
	this.s_products = s_products;
}

public int getS_Id() {
	return S_Id;
}

public void setS_Id(int s_Id) {
	S_Id = s_Id;
}

public String getShopName() {
	return shopName;
}

public void setShopName(String shopName) {
	this.shopName = shopName;
}

public String getShopDescription() {
	return shopDescription;
}

public void setShopDescription(String shopDescription) {
	this.shopDescription = shopDescription;
}

public List<Product> getS_products() {
	return s_products;
}

public void setS_products(List<Product> s_products) {
	this.s_products = s_products;
}

public Users getUser() {
	return user;
}

public void setUser(Users user) {
	this.user = user;
}



public String getShopCategory() {
	return shopCategory;
}

public void setShopCategory(String shopCategory) {
	this.shopCategory = shopCategory;
}



public String getImageName() {
	return imageName;
}

public void setImageName(String imageName) {
	this.imageName = imageName;
}

@Override
public String toString() {
	return String.format("Shop [S_Id=%s, shopName=%s, shopDescription=%s, s_products=%s]", S_Id, shopName,
			shopDescription, s_products);
}
}
