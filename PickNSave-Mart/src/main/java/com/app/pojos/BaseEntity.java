package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass //super class for base entity
public class BaseEntity {
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	public Integer getId() {
		return Id;
	}
     
	public void setId(Integer id) {
		Id = id;
	}

	
}
