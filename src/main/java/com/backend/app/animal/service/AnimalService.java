package com.backend.app.animal.service;

import java.util.List;

import com.backend.app.animal.model.entity.Animal;

public interface AnimalService {
	
	public List<Animal> findAll();
	
	public Animal findById(Long id);
}
