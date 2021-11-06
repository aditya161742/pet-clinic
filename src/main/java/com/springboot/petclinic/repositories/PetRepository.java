package com.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long>{

}
