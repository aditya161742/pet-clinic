package com.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality,Long>{

}
