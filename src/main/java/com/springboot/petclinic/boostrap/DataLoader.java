package com.springboot.petclinic.boostrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.petclinic.model.Owner;
import com.springboot.petclinic.model.Pet;
import com.springboot.petclinic.model.PetType;
import com.springboot.petclinic.model.Speciality;
import com.springboot.petclinic.model.Vet;
import com.springboot.petclinic.model.Visit;
import com.springboot.petclinic.services.OwnerService;
import com.springboot.petclinic.services.PetTypeService;
import com.springboot.petclinic.services.SpecialityService;
import com.springboot.petclinic.services.VetService;
import com.springboot.petclinic.services.VisitService;

//This is spring boot specific way to load data, there are other ways to load data for spring core
//By declaring this a component spring will load this on boot
@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	private final PetTypeService petTypeService;
	
	private final SpecialityService specialityService;
	private final VisitService visitService; // Here we are using interface example VisitService
											//Therefore spring will inject a active profile which has implementation ,which is currently active, i.e jpa repository or map service 
	
	/*public DataLoader() {
		ownerService = new OwnerServiceMap(); // Object created manually when class object is not created by spring i.e @Service, @Compneent etc
		vetService = new VetServiceMap(); // Object created manually when class object is not created by spring i.e @Service, @Compneent etc
		
		
	}*/
	
	//Use this constructor when object is created by spring, then spring will autowire
	//In spring 4 we have use @Autowire on this constructor but not in spring 5
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService,VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int count  = petTypeService.findAll().size();
		
		if(count == 0)
		{
		LoadData();
		}
		
	}

	private void LoadData() {
	PetType dog = new PetType();
		
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
		Owner owner = new Owner();
		//owner.setId(1L);
		owner.setFirstname("Sam");
		owner.setLastname("Jhonsan");
		owner.setAddress("Address 1");
		owner.setCity("Milford");
		owner.setTelephone("99855185");
		
		//Owner.builder().address("Some Address").build(); // We can add data like this 
		//after addding project lombak and added annotation @Builder on Owner model. @Builder
		//creates builder pattern without writting the boilerplate code.
		
		Pet samsPet=  new Pet();
		samsPet.setPetType(savedDogPetType);
		samsPet.setOwner(owner);
		samsPet.setBirthDate(LocalDate.now());
		samsPet.setName("Rasco");
		
		
		owner.getPets().add(samsPet);
		
		ownerService.save(owner);
		
		Owner owner2 = new Owner();
		//owner2.setId(2L);
		owner2.setFirstname("Anglina");
		owner2.setLastname("Jolie");
		owner2.setAddress("Address 2");
		owner2.setCity("Hartford");
		owner2.setTelephone("333-333-33");
		
		Pet angPet=  new Pet();
		angPet.setPetType(savedCatPetType);
		angPet.setOwner(owner2);
		angPet.setBirthDate(LocalDate.now());
		angPet.setName("Hankcock");
		owner2.getPets().add(angPet);
		
		ownerService.save(owner2);
		
		Visit visit = new Visit();
		visit.setPet(angPet);
		visit.setDate(LocalDate.now());
		visit.setDescription("Sneeky Kitty");
		visitService.save(visit);
		
		System.out.println("Owner Loaded");
		
		Vet vet = new Vet();
		
		//vet.setId(1L);
		vet.setFirstname("Vet1");
		vet.setLastname("vet Lastname");
		vet.getSpecialities().add(savedRadiology);
		
		vetService.save(vet);
		
		Vet vet2  = new Vet();
		//vet2.setId(2L);
		vet2.setFirstname("Vet2");
		vet2.setLastname("Lastname 2 ");
		vet2.getSpecialities().add(savedSurgery);
		
		vetService.save(vet2);
		
		System.out.println("Vet Loaded");
	}

	
}
