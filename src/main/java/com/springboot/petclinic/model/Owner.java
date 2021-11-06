package com.springboot.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name="owners")
public class Owner extends Person{
	
	private String address;
	private String city;
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="owner")
	private Set<Pet> pets = new HashSet<>(); // Important to initialise, otherwise could give error "not initialised"

	/*public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}*/
	
	
	
}
