package com.springboot.petclinic.services;

import java.util.Set;

//Here we are just mimicing CrudRepository, in real project we use CrudRepository, this is just 
//for understanding what happens inside it

public interface CrudService<T,ID> {

		Set<T> findAll();
		
		T findById(ID id);
		T save(T object);
		void delete(T object);
		void deleteById(ID id);
}
