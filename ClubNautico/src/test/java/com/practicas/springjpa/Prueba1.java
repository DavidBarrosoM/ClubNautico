package com.practicas.springjpa;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.List;

import org.mockito.junit.MockitoJUnitRunner;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practicas.springjpa.model.Barco;
import com.practicas.springjpa.model.Patron;
import com.practicas.springjpa.model.Salida;
import com.practicas.springjpa.model.Socio;
import com.practicas.springjpa.service.ServicioBarco;
import com.practicas.springjpa.service.ServicioPatron;
import com.practicas.springjpa.service.ServicioSalida;
import com.practicas.springjpa.service.ServicioSocio;
//@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = ClubNauticoApplication.class)
public class Prueba1 {

	//@Autowired
   // private TestEntityManager entityManager;
	
	@Autowired
	private ServicioSocio socioServicio;
	@Autowired
	private ServicioBarco barcoServicio;
	@Autowired
	private ServicioPatron patronServicio;
	@Autowired
	private ServicioSalida salidaServicio;
	
	@Test
	void contextLoads() {
	}
	 @Test
    public void buscaTodosBarcosPorSocio() {
        // given
        //Nada no le insertamos ningun dato a barco
	 	Long idSocio = 2L;
        // when
        List<Barco> allBarcos = barcoServicio.buscaBarcosSocio(idSocio);
        // then
        //assertThat(allSocios).hasSize(3).extracting(Socio::getNombre).containsOnly(juan.getNombre(), maria.getNombre(), carlos.getNombre());
        assertThat(allBarcos).isNotEmpty();
    }
	
	 @Test
    public void borraTodosBarcosPorSocio() {
        // given
        //Nada no le insertamos ningun dato a barco
	 	Long idSocio = 1L;
	 	barcoServicio.borraTodosBarcosSocio(idSocio);
        // when
        List<Barco> allBarcos = barcoServicio.buscaBarcosSocio(idSocio);
        // then
        //assertThat(allSocios).hasSize(3).extracting(Socio::getNombre).containsOnly(juan.getNombre(), maria.getNombre(), carlos.getNombre());
        assertThat(allBarcos).hasSize(0);
    }
	 @Test
    public void compruebaUpdateBarco() {
        // given
	 	Socio juan = new Socio("Juan", "Perez", "juan.perez@example.com");
        Barco b1 = new Barco("BO101","El intrepido",2,250.95,juan);
        //Socio carlos = new Socio("Carlos", "Gomez", "carlos.gomez@example.com");
        socioServicio.create(juan);
        barcoServicio.create(b1);
        //entityManager.persist(juan);
        //entityManager.persist(b1);
        //entityManager.persist(carlos);
        //entityManager.flush();
        //entityManager.detach(b1);
        // when
        //List<Barco> allBarcos = barcoServicio.readAll();
        b1.setAmarre(4);
        //entityManager.merge(b1);
        barcoServicio.update(b1, b1.getIdBarco());
        Barco b2 = barcoServicio.buscaPorNombre("El intrepido").get(0);
        // then
        //assertThat(allSocios).hasSize(3).extracting(Socio::getNombre).containsOnly(juan.getNombre(), maria.getNombre(), carlos.getNombre());
        assertEquals(4, b2.getAmarre());
    }
	 
	 @Test
	 public void creaSalidaYPatron() {
		// given
		 Patron pepe=new Patron();
		 pepe.setNombre("Pepe");
		 pepe.setApellidos("Gonzalez");
		 pepe.setEmail("pepe@example.com");
		 //patronServicio.create(pepe);
		 Barco b2 = barcoServicio.buscaPorNombre("El intrepido").get(0);
		 Salida excursion = new Salida();
		 excursion.setBarco(b2);
		 excursion.setDestino("Miami");
		 excursion.setPatron(pepe);
		 excursion.setFecha_hora_salida(new Date());
		 Long idSalida = salidaServicio.create(excursion).getIdSalida();
		 
		 Salida s = salidaServicio.findById(idSalida).get();
		 //then
		 assertThat(s).isNotNull();
	 }
	 @Test
	 public void buscaTodosPatrones() {
		 List<Patron> patrones = patronServicio.readAll();
		 assertThat(patrones).isNotEmpty();
	 }
	 @Test
	 public void creaUnPatron() {
		 Patron pepe=new Patron();
		 pepe.setNombre("Pepe");
		 pepe.setApellidos("Gonzalez");
		 pepe.setEmail("pepe@example.com");
		 patronServicio.create(pepe);
		 patronServicio.findById(2L);
		 //patronServicio.delete(2L);
		 //assertThat(patrones).isNotEmpty();
	 }
	 @Test
	 public void crudSocio() {
		 Socio pepe=new Socio();
		 pepe.setNombre("Pepe");
		 pepe.setApellidos("Gonzalez");
		 pepe.setEmail("pepe@example.com");
		 socioServicio.create(pepe);
		 Socio pepe2 = socioServicio.findByNombre("Pepe");
		 pepe2.setEmail("pepepepito@gmail.com");
		 socioServicio.update(pepe2, pepe2.getIdSocio());
		 //assertThat(patrones).isNotEmpty();
		 socioServicio.delete(3L);
		 List<Socio> socios = socioServicio.readAll();
		 assertThat(socios).isNotEmpty();
	 }
}
