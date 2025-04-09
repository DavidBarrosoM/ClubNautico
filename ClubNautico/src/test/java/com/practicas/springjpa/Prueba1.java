package com.practicas.springjpa;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practicas.springjpa.model.Barco;
import com.practicas.springjpa.model.Socio;
import com.practicas.springjpa.repositories.RepositorioSocio;
import com.practicas.springjpa.service.ServicioBarco;
import com.practicas.springjpa.service.ServicioSocio;
@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class Prueba1 {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private RepositorioSocio socioRepositorio;
	@Autowired
	private ServicioSocio socioServicio;
	@Autowired
	private ServicioBarco barcoServicio;
	@Test
	void contextLoads() {
	}
	
	
	 @Test
	    public void borraTodosBarcos() {
	        // given
	        //Nada no le insertamos ningun dato a barco
		 	
	        // when
	        List<Barco> allBarcos = barcoServicio.readAll();
	        // then
	        //assertThat(allSocios).hasSize(3).extracting(Socio::getNombre).containsOnly(juan.getNombre(), maria.getNombre(), carlos.getNombre());
	        assertThat(allBarcos).hasSize(5);
	    }
	 @Test
	    public void compruebaUpdateBarco() {
	        // given
		 	Socio juan = new Socio("Juan", "Perez", "juan.perez@example.com");
	        Barco b1 = new Barco("BO101","El intrepido",2,250.95,juan);
	        //Socio carlos = new Socio("Carlos", "Gomez", "carlos.gomez@example.com");

	        entityManager.persist(juan);
	        entityManager.persist(b1);
	        //entityManager.persist(carlos);
	        entityManager.flush();
	        //entityManager.detach(b1);
	        // when
	        //List<Barco> allBarcos = barcoServicio.readAll();
	        b1.setAmarre(4);
	        entityManager.merge(b1);
	        barcoServicio.update(b1, barcoServicio.buscaPorNombre("El intrepido").get(0).getIdBarco());
	        Barco b2 = barcoServicio.buscaPorNombre("El intrepido").get(1);
	        // then
	        //assertThat(allSocios).hasSize(3).extracting(Socio::getNombre).containsOnly(juan.getNombre(), maria.getNombre(), carlos.getNombre());
	        assertEquals(4, b2.getAmarre());
	    }
}
