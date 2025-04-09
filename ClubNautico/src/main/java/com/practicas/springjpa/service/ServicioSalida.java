package com.practicas.springjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.springjpa.model.Patron;
import com.practicas.springjpa.model.Salida;
import com.practicas.springjpa.repositories.RepositorioSalida;

@Service
public class ServicioSalida implements Servicio<Salida>{
	@Autowired
	RepositorioSalida repo;
	@Autowired
	ServicioPatron servicioPatron;
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
	public Optional<Salida> findById(Long id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id);
		} else {
		
			return Optional.empty();
		}
		//return  Optional.ofNullable(repo.findById(id).get());
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
	public boolean deleteSalidasPorBarco(Long idBarco) {
		/*List<Patron> patrones = repo.findPatronByBarco(idBarco);
		patrones.forEach(patron->servicioPatron.delete(patron.getIdPatron()));
		*/
		repo.deleteByBarco(idBarco);
		//int result = repo.deletePorId(id);
		return repo.findByBarco(idBarco).isEmpty();
	}
}
