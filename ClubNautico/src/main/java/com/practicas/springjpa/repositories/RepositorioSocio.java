package com.practicas.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicas.springjpa.model.Socio;

@Repository
public interface RepositorioSocio extends JpaRepository<Socio, Long>{

}
