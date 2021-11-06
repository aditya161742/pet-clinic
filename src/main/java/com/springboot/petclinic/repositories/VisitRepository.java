package com.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long>{

}
