package com.backend.app.animal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.app.animal.model.dao.AnimalDao;
import com.backend.app.animal.model.entity.Animal;

@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	private AnimalDao animalDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Animal> findAll() {
		return (List<Animal>) animalDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Animal findById(Long id) {
		return animalDao.findById(id).orElse(null);
	}

}
