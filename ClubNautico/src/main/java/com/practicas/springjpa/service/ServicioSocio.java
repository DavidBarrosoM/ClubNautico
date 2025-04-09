package com.practicas.springjpa.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<Socio> findById(Long id) {

		//Optional<Socio> socio = repo.findById(id);
		if (repo.findById(id).isPresent()) {
			return repo.findById(id);
		} else {
		
			return Optional.empty();
		}

		//return  Optional.ofNullable(repo.findById(id).get());
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
	
	public Socio findByNombre(String nombre) {
		return repo.findByNombre(nombre).get();
	}
}
