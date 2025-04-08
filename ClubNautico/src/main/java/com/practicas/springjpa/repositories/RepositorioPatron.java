package com.practicas.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicas.springjpa.model.Patron;

@Repository
public interface RepositorioPatron extends JpaRepository<Patron, Long>{

}
