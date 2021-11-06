package com.springboot.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.petclinic.model.Pet;
import com.springboot.petclinic.repositories.PetRepository;
import com.springboot.petclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDjpaService implements PetService{
	
	private final PetRepository petRepository;
	
	public PetSDjpaService(PetRepository petRepository) {
		
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		
		return petRepository.findById(id).orElse(null);
		
	}

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return petRepository.save(object);
	
	}

	@Override
	public void delete(Pet object) {
		// TODO Auto-generated method stub
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		
		petRepository.deleteById(id);
		
	}
	
	
}
