package com.practicas.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicas.springjpa.model.Salida;

@Repository
public interface RepositorioSalida extends JpaRepository<Salida, Long>{

}
