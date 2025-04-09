package com.practicas.springjpa.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<Patron> findById(Long id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id);
		} else {
		
			return Optional.empty();
		}
		//return  Optional.ofNullable(repo.findById(id).get());
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
		//repo.deleteById(id);
		int result =repo.deletePorId(id);
		return result>0;
	}
	public boolean eliminaPorSalida(Long id) {
		
		int result = repo.deletePorSalida(id);
		return result>0;
	}
}
