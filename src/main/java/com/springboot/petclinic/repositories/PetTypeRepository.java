package com.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long>{

}
