package com.backend.app.animal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
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
	
	@Override
    @Transactional
    public Animal createAnimal(Animal animal) {
		animal.setCreatedAt(new Date());
        return animalDao.save(animal);
    }
	
	@Override
    @Transactional
    public Animal updateAnimal(Long id, Animal animal) {
        Animal animalExist = animalDao.findById(id).orElse(null);
        if (animalExist != null) {
            animalExist.setNombre(animal.getNombre());
            animalExist.setTipo(animal.getTipo());
            animalExist.setNacimiento(animal.getNacimiento());
            animalExist.setGenero(animal.getGenero());

            return animalDao.save(animalExist);
        } else {
            return null;
        }
    }
	
	@Override
	@Transactional
	public void deleteAnimal(Long id) {
	    Animal animalExistente = animalDao.findById(id).orElse(null);
	    if (animalExistente != null) {
	    	animalDao.delete(animalExistente);
	    	}
	    }

}
