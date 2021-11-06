package com.springboot.petclinic.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//We are telling JPA that other classes inherits this class and we donot want to create saperate table for this class
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
public class BaseEntity implements Serializable{
	//This tells JPA that his is the ID value
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	/*
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	*/
	
}
