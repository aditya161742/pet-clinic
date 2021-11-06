package com.springboot.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.petclinic.services.VetService;

@RequestMapping("vets/")
@Controller
public class VetController {
	
	private final VetService vetservice;
	
	public VetController(VetService vetservice) {
		this.vetservice = vetservice;
	}

	@RequestMapping({"","index","index.html"})
	public String vetList(Model model) {
		model.addAttribute("vets", vetservice.findAll());
		return "vets/index";
	}
	
}
