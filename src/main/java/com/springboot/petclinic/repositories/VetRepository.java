package com.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long>{

}
