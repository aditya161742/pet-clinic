package com.springboot.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.petclinic.model.PetType;
import com.springboot.petclinic.repositories.PetTypeRepository;
import com.springboot.petclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDjpaService implements PetTypeService{
		
	private final PetTypeRepository petTypeRepository;
	
	public PetTypeSDjpaService(PetTypeRepository petTyperepository) {
		super();
		this.petTypeRepository = petTyperepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		// TODO Auto-generated method stub
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		// TODO Auto-generated method stub
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		petTypeRepository.deleteById(id);
	}

	
}
