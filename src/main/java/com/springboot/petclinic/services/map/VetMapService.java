package com.springboot.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.petclinic.model.Speciality;
import com.springboot.petclinic.model.Vet;
import com.springboot.petclinic.services.SpecialityService;
import com.springboot.petclinic.services.VetService;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService{
	
	private SpecialityService specialityService;
	
	public VetMapService(SpecialityService specialityService) {
		
		this.specialityService = specialityService;
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		if(object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(speciality->{
				if(speciality.getId() == null) {
					Speciality saveSpeciality = specialityService.save(speciality);
					speciality.setId(saveSpeciality.getId());
				}
			});	
			
		}
		
		return super.save(object);
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
