package com.practicas.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.springjpa.model.Salida;
import com.practicas.springjpa.repositories.RepositorioSalida;

@Service
public class ServicioSalida implements Servicio<Salida>{
	@Autowired
	RepositorioSalida repo;

	@Override
	public Salida create(Salida entity) {
		repo.save(entity);
		return entity;
	}

	@Override
	public List<Salida> readAll() {
		return (List<Salida>)repo.findAll();
	}

	@Override
	public Salida findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Salida update(Salida entity, Long id) {
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
