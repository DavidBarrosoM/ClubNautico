package com.practicas.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.practicas.springjpa.model.Socio;
import com.practicas.springjpa.repositories.RepositorioSocio;

@Service
public class ServicioSocio implements Servicio<Socio>{
	@Autowired
	RepositorioSocio repo;

	@Override
	public Socio create(Socio entity) {
		repo.save(entity);
		return entity;
	}

	@Override
	public List<Socio> readAll() {
		return (List<Socio>)repo.findAll();
	}

	@Override
	public Socio findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Socio update(Socio entity, Long id) {
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
