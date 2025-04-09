package com.practicas.springjpa.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.springjpa.model.Barco;
import com.practicas.springjpa.model.Salida;
import com.practicas.springjpa.repositories.RepositorioBarco;
import com.practicas.springjpa.repositories.RepositorioSocio;

@Service
public class ServicioBarco implements Servicio<Barco>{
	@Autowired
	RepositorioBarco repo;
	@Autowired
	RepositorioSocio repo2;
	@Autowired
	ServicioSocio servicioSocio;
	@Autowired
	ServicioSalida servicioSalida;
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
		
		//return repo.findById(id).get();
		return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el barco con id: " + id));
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
		//Barco b = repo.findById(id).get();
		//repo.deletePorId(id);
		
		servicioSalida.deleteSalidasPorBarco(id);
		int result = repo.deletePorId(id);
        return result > 0;
		//return repo.findById(id).isEmpty();
	}
	public void agregarSalida(Salida s) {
		
	}
}
