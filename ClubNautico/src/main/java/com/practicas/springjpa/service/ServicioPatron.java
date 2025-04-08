package com.practicas.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.springjpa.model.Patron;
import com.practicas.springjpa.repositories.RepositorioPatron;

@Service
public class ServicioPatron  implements Servicio<Patron> {
	@Autowired
	RepositorioPatron repo;

	@Override
	public Patron create(Patron entity) {
		repo.save(entity);
		return entity;
	}

	@Override
	public List<Patron> readAll() {
		return (List<Patron>)repo.findAll();
	}

	@Override
	public Patron findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Patron update(Patron entity, Long id) {
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
