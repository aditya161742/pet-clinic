package com.springboot.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.petclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private final OwnerService ownerservice;

	public OwnerController(OwnerService ownerservice) {
		
		this.ownerservice = ownerservice;
	}
	
	@RequestMapping({"","/","index.html","index"})
	public String listOwners(Model model) {
		model.addAttribute("owners", ownerservice.findAll());
		
		System.out.println(model.getAttribute("owners").toString());
		
		return "owners/index";
	}
	
	@RequestMapping("/find")
	public String findOwners() {
		
		return "owners/index";
	}
}
