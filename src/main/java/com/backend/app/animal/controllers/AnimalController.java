package com.backend.app.animal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.animal.model.entity.Animal;
import com.backend.app.animal.service.AnimalService;


@RestController
public class AnimalController {
	
	@Autowired
	private AnimalService service;
	
	@GetMapping("/list")
	public List<Animal> list(){
		
		return service.findAll();
	} 
	
	@GetMapping("/animal/{id}")
	public Animal detail(@PathVariable Long id) {
		return service.findById(id);
	}

}
