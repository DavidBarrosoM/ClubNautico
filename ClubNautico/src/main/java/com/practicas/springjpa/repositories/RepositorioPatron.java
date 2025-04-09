package com.practicas.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practicas.springjpa.model.Patron;

@Repository
public interface RepositorioPatron extends JpaRepository<Patron, Long>{
	@Modifying //(clearAutomatically = true, flushAutomatically = true)
    @Transactional
	 @Query("DELETE FROM Patron p WHERE p.salida.id = ?1")
	int deletePorSalida(Long idSalida);
	@Modifying //(clearAutomatically = true, flushAutomatically = true)
    @Transactional
	 @Query("DELETE FROM Patron p WHERE p.id = ?1")
	int deletePorId(Long id);
}
