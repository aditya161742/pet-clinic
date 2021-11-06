package com.springboot.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.repositories.OwnerRepository;
import com.springboot.petclinic.repositories.PetRepository;
import com.springboot.petclinic.repositories.PetTypeRepository;
import com.springboot.petclinic.services.OwnerService;

// Note: spring will ignore this JPA profile when it is not active. Therefore any errors in 
//inactive profiles are just ignored by spring

//This will only run when springjpa profile is active

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService{
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;
	
	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		//Optional<Owner> optionalOwner = ownerRepository.findById(id);
		
		return ownerRepository.findById(id).orElse(null);
		
		/*if(optionalOwner.isPresent()) {
			return optionalOwner.get();
		}
		else {
			return null;
		}*/
		
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		// TODO Auto-generated method stub
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastname) {
		// TODO Auto-generated method stub
		return ownerRepository.findByLastname(lastname);
	}

	
}
