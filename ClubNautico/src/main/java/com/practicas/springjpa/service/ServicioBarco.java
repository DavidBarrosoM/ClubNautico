package com.practicas.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.springjpa.model.Barco;
import com.practicas.springjpa.repositories.RepositorioBarco;

@Service
public class ServicioBarco implements Servicio<Barco>{
	@Autowired
	RepositorioBarco repo;

	@Override
	public Barco create(Barco entity) {
		repo.save(entity);
		return entity;
	}

	@Override
	public List<Barco> readAll() {
		return (List<Barco>)repo.findAll();
	}

	@Override
	public Barco findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Barco update(Barco entity, Long id) {
		if (repo.existsById(id)) {
            return repo.save(entity);
        } else {
            throw new RuntimeException("Patron not found");
        }
	}

	@Override
	public boolean delete(Long id) {
		repo.deleteById(id);
		return repo.findById(id).isEmpty();
	}
	
}
