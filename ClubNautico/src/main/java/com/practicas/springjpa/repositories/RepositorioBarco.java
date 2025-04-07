package com.practicas.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicas.springjpa.model.Barco;

@Repository
public interface RepositorioBarco extends JpaRepository<Barco, Long>{

}
