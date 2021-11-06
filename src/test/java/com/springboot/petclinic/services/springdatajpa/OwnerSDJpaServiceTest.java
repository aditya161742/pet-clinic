package com.springboot.petclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.repositories.OwnerRepository;
import com.springboot.petclinic.repositories.PetRepository;
import com.springboot.petclinic.repositories.PetTypeRepository;

/*Unit test example with mockito. There are two ways to write test 1) using mockito and 2) using underlying persitence layer i.e database*/
//In Junit 4 we have RunWith and in Junit 5 we have ExtendWith

//Add mockito dependency in pom.xml to get MockitoExtension.class
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	
	final String lastname = "smith";
	
	//refernce https://www.baeldung.com/mockito-annotations
	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJpaService service;
	
	Owner returnOwner;
	
	@BeforeEach
	void setUp() throws Exception {
		returnOwner = new Owner();
		returnOwner.setId(1L);
		returnOwner.setLastname(lastname);
	}

	@Test
	void testFindAll() {
		Set<Owner> returnOwnersSet = new HashSet<>();
		Owner owner1 = new Owner();
		Owner owner2 = new Owner();
		
		owner1.setId(1L);
		owner2.setId(2L);
		
		returnOwnersSet.add(owner1);
		returnOwnersSet.add(owner2);
		
		when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
		
		Set<Owner> owners = service.findAll();
		
		assertNotNull(owners);
		assertEquals(2,owners.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner owner = service.findById(1L);
		assertNotNull(owner);
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		
		Owner owner = service.findById(1L);
		assertNull(owner);
	}
	
	@Test
	void testSave() {
		Owner ownerToSave = new Owner();
		ownerToSave.setId(1L);
		
		when(ownerRepository.save(any())).thenReturn(ownerToSave);
		
		Owner savedOwner = service.save(ownerToSave);
		
		assertNotNull(savedOwner);
		
		verify(ownerRepository).save(any());
		
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		verify(ownerRepository).delete(any()); // This is good use case of verify method, becase we are not returning anything for delete method in OwnerSDJpaService
		
		/*verify(mock, times(5)).someMethod("was called five times");
		verify(mock, never()).someMethod("was never called");
		verify(mock, atLeastOnce()).someMethod("was called at least once");
		verify(mock, atLeast(2)).someMethod("was called at least twice");
		verify(mock, atMost(3)).someMethod("was called at most 3 times");
		verify(mock, atLeast(0)).someMethod("was called any number of times"); // useful with captors
		verify(mock, only()).someMethod("no other method has been called on the mock");*/
	}

	@Test
	void testDeleteById() {
		
		service.deleteById(1L);
		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {
		
		when(ownerRepository.findByLastname(any())).thenReturn(returnOwner); // We have return Owner object here because in OwnerSDJpaService findByLastName(String lastname) expects returned object to be of Owner type
	
		Owner smith = service.findByLastName(lastname);
		assertEquals(lastname,smith.getLastname()); // Test 1 
		verify(ownerRepository).findByLastname(lastname); //Test 2, Mockito verify() method can be used to test number of method invocations too. We can test exact number of times, at least once, at least, at most number of invocation times for a mocked method.
	}

}
