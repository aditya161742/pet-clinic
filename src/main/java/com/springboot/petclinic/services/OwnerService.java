package com.springboot.petclinic.services;

import com.springboot.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{
	
	Owner findByLastName(String name);
	
}
