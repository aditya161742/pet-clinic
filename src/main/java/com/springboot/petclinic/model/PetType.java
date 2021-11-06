package com.springboot.petclinic.model;

import java.util.Set;

import javax.persistence.Entity;
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
@Table(name="types")
public class PetType extends BaseEntity{
	
	private String name;

	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/
	
	
}
