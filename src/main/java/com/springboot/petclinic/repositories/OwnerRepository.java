package com.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long>{
	
	Owner findByLastname(String lastname);  // Note: when using JPA Data method name should match 
	//the model property after findBy else it will give error "No property found for type", 
	//i.e findByLastName will throw error because in Person model property name is lastname 
	//therefore correct method name will be findByLastname
	
	/*
	  While using CrudRepository of Spring , we have to append the propertyname correctly 
	  after findBy otherwise it will give you exception "No Property Found for Type”

		I was getting this exception as. because property name and method name were not in sync.
		
		I have used below code for DB Access.
		
		public interface OwnerRepository extends CrudRepository<Owner, Long> {
		    Owner findByLastName(String name);
		and my Domain User has property.
		
		@Entity
		public class Person{
		
		    private String lastname;
	  */
	
}
