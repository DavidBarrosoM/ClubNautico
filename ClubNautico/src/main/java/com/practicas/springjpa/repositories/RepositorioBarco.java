package com.practicas.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practicas.springjpa.model.Barco;

@Repository
public interface RepositorioBarco extends JpaRepository<Barco, Long>{
	@Modifying
    @Transactional
	 @Query("DELETE FROM Barco b WHERE b.id = ?1")
	 int deletePorId(Long id);
}
