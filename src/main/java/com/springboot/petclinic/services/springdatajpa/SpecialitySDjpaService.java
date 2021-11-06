package com.springboot.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.petclinic.model.Speciality;
import com.springboot.petclinic.repositories.SpecialityRepository;
import com.springboot.petclinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialitySDjpaService implements SpecialityService{
	
private final SpecialityRepository specialityRepository;
	
	public SpecialitySDjpaService(SpecialityRepository specialityRepository) {
		
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> speciality = new HashSet<>();
		specialityRepository.findAll().forEach(speciality::add);
		return speciality;
	}

	@Override
	public Speciality findById(Long id) {
		
		return specialityRepository.findById(id).orElse(null);
		
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return specialityRepository.save(object);
	
	}

	@Override
	public void delete(Speciality object) {
		// TODO Auto-generated method stub
		specialityRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		
		specialityRepository.deleteById(id);
		
	}

}
