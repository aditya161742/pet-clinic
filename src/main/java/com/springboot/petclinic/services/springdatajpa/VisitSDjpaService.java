package com.springboot.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.petclinic.model.Visit;
import com.springboot.petclinic.repositories.VisitRepository;
import com.springboot.petclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDjpaService implements VisitService{
	
	private final VisitRepository visitRepository;
	
	public VisitSDjpaService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visit = new HashSet<>();
		visitRepository.findAll().forEach(visit::add);
		return visit;
	}

	@Override
	public Visit findById(Long id) {
		
		return visitRepository.findById(id).orElse(null);
		
	}

	@Override
	public Visit save(Visit object) {
		// TODO Auto-generated method stub
		return visitRepository.save(object);
	
	}

	@Override
	public void delete(Visit object) {
		// TODO Auto-generated method stub
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		
		visitRepository.deleteById(id);
		
	}

}
