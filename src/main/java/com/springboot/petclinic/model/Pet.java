package com.springboot.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //Project Lombok's @Builder is a useful mechanism for using the Builder 
		//pattern without writing boilerplate code. We can apply this annotation to a Class or a method.

@Entity
@Table(name="pets")
public class Pet extends BaseEntity{
	
	private String name;
	@ManyToOne
	@JoinColumn(name="type_id")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="pet")
	private Set<Visit> visits = new HashSet<>();
	
	/*
	public Pet() {
		super();
	}
	
	public Pet(PetType petType, Owner owner, LocalDate birthDate) {
		super();
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
	}
	
	
	
	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetType getPetType() {
		return petType;
	}
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}*/
	
	
}
