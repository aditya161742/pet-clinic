package com.springboot.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.petclinic.model.Vet;
import com.springboot.petclinic.repositories.VetRepository;
import com.springboot.petclinic.services.VetService;

//This will only run when springjpa profile is active
@Service
@Profile("springdatajpa")
public class VetSDjpaService implements VetService{
	
	private final VetRepository vetRepository;
	
	public VetSDjpaService(VetRepository vetRepository) {
		
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		
		return vetRepository.findById(id).orElse(null);
		
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return vetRepository.save(object);
	
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		
		vetRepository.deleteById(id);
		
	}

}
