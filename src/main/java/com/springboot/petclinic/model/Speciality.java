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
@Table(name="specialities")
public class Speciality extends BaseEntity{
	
	private String Description;

	/*public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}*/
	
	
}
