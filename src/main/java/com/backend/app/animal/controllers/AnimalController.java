package com.backend.app.animal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/animal")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal nuevoAnimal = service.createAnimal(animal);
        return new ResponseEntity<>(nuevoAnimal, HttpStatus.CREATED);
    }
	
	@PutMapping("/animal/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animal) {
        Animal animalActualizado = service.updateAnimal(id, animal);
        return new ResponseEntity<>(animalActualizado, HttpStatus.OK);
    }
	
	@DeleteMapping("/animal/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        service.deleteAnimal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
