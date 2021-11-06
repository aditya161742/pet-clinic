package com.springboot.petclinic.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.services.OwnerService;

/*Unit test example with mockito. There are two ways to write test 1) using mockito and 2) using underlying persitence layer i.e database*/
//In Junit 4 we have RunWith and in Junit 5 we have ExtendWith

//Add mockito dependency in pom.xml to get MockitoExtension.class
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	
	@Mock
	OwnerService ownerservice;
	
	@InjectMocks
	OwnerController controller;
	
	Set<Owner> owners;
	
	MockMvc mockMvc;
	
	//Before annotation was replaced by BeforeEach in Junit 5.
	@BeforeEach
	void setUp() throws Exception {
		Owner owner1 = new Owner();
		owner1.setId(1L);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		
		owners = new HashSet<>();
		owners.add(owner1);
		owners.add(owner2);
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		/*mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();*/
	}
	
	@Test
	void testFindOwners() throws Exception{
		
		//mockMvc.perform(get("/owners")).andExpect(status().is(200));
		mockMvc.perform(get("/owners/find"))
					.andExpect(status().isOk())				// .is(200) is also correct
					.andExpect(view().name("owners/index"));
		
		//verifyZeroInteractions(ownerservice);  // To check that no interactions would have happened with ownerservice
		
	}
	
	@Test
	void testListOwners() throws Exception{
		when(ownerservice.findAll()).thenReturn(owners);
		
		//mockMvc.perform(get("/owners")).andExpect(status().is(200));
		mockMvc.perform(get("/owners"))
					.andExpect(status().isOk())				// .is(200) is also correct
					.andExpect(view().name("owners/index"))
					.andExpect(model().attribute("owners", hasSize(2))); // Here size is 2 because we are adding only 2 owner objects in setUp method
		
		
	}

}
