package com.practicas.springjpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practicas.springjpa.model.Patron;
import com.practicas.springjpa.model.Salida;

@Repository
public interface RepositorioSalida extends JpaRepository<Salida, Long>{
	@Modifying //(clearAutomatically = true, flushAutomatically = true)
    @Transactional
	 @Query("DELETE FROM Salida s WHERE s.barco.id = ?1")
	void deleteByBarco(Long idBarco);
	@Modifying //(clearAutomatically = true, flushAutomatically = true)
    @Transactional
	 @Query("SELECT s.id FROM Salida s WHERE s.barco.id = ?1")
	List<Long> findByBarco(Long idBarco);
	@Modifying //(clearAutomatically = true, flushAutomatically = true)
    @Transactional
	 @Query("SELECT s.patron FROM Salida s WHERE s.barco.id = ?1")
	List<Patron> findPatronByBarco(Long idBarco);
}
