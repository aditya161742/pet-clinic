package com.springboot.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.petclinic.model.Owner;

class OwnerMapServiceTest {

	OwnerMapService ownerMapService;
	final Long ownerId = 1L;
	final String lastname = "Smith";
	
	@BeforeEach
	void setUp() throws Exception {
		
		ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
		Owner owner = new Owner();
		owner.setId(ownerId);
		owner.setLastname(lastname);
		ownerMapService.save(owner);
		
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		assertEquals(1,ownerSet.size());
		
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerMapService.findById(ownerId);
		assertEquals(ownerId,owner.getId());
	}

	@Test
	void saveExistingId() {
		Long Id = 2L;
		Owner owner2 = new Owner();
		owner2.setId(Id);
		
		Owner savedOwner = ownerMapService.save(owner2);
		
		assertEquals(Id,savedOwner.getId());
	}	
	
	@Test
	void saveNoId() {
		Owner savedOwner = ownerMapService.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}
	
	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(ownerId));
		assertEquals(0,ownerMapService.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(ownerId);
		assertEquals(0,ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner smith = ownerMapService.findByLastName(lastname);
		assertNotNull(smith);
		assertEquals(ownerId,smith.getId());
	}

}
