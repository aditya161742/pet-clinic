package com.springboot.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.model.Pet;
import com.springboot.petclinic.services.OwnerService;
import com.springboot.petclinic.services.PetService;
import com.springboot.petclinic.services.PetTypeService;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService{
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		Owner savedOwner = null;
		
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet->{
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}
					else {
						throw new RuntimeException("Pet type is required");
					}
					
					if(pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
					
				});
			}
			return super.save(object);	
		}else {
			return null;
		}
		
		
	}

	@Override
	public void delete(Owner object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastname) {
		// TODO Auto-generated method stub
		
		return this.findAll()
				.stream()
				.filter(owner -> owner.getLastname().equalsIgnoreCase(lastname))
				.findFirst()
				.orElse(null);
	}

	
	
}
