package com.practicas.springjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface Servicio<T> {
	T create(T entity);
	List<T> readAll();
	Optional<T> findById(Long id);
	T update(T entity, Long id);
	public boolean delete(Long id);
}
