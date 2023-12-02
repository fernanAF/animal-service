package com.backend.app.animal.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.app.animal.model.entity.Animal;

public interface AnimalDao extends CrudRepository<Animal, Long> {

}
