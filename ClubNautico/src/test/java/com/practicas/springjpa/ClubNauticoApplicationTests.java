package com.practicas.springjpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.practicas.springjpa.model.Barco;
import com.practicas.springjpa.model.Patron;
import com.practicas.springjpa.model.Salida;
import com.practicas.springjpa.model.Socio;
import com.practicas.springjpa.repositories.RepositorioSocio;
import com.practicas.springjpa.service.ServicioBarco;
import com.practicas.springjpa.service.ServicioPatron;
import com.practicas.springjpa.service.ServicioSalida;
import com.practicas.springjpa.service.ServicioSocio;

@SpringBootTest(classes = ClubNauticoApplication.class)
class ClubNauticoApplicationTests {

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
	 	Long idSocio = 2L;
        // when
        List<Barco> allBarcos = barcoServicio.buscaBarcosSocio(idSocio);
        // then
        
        assertThat(allBarcos).isNotEmpty();
    }
	
	 @Test
    public void borraTodosBarcosPorSocio() {
        // given
	 	Long idSocio = 1L;
	 	barcoServicio.borraTodosBarcosSocio(idSocio);
        // when
        List<Barco> allBarcos = barcoServicio.buscaBarcosSocio(idSocio);
        // then
        
        assertThat(allBarcos).hasSize(0);
    }
	 @Test
    public void compruebaUpdateBarco() {
        // given
	 	Socio juan = new Socio("Juan", "Perez", "juan.perez@example.com");
        Barco b1 = new Barco("BO101","El intrepido",2,250.95,juan);
        socioServicio.create(juan);
        barcoServicio.create(b1);
       
        // when
        b1.setAmarre(4);
        barcoServicio.update(b1, b1.getIdBarco());
        Barco b2 = barcoServicio.buscaPorNombre("El intrepido").get(0);
        // then
        assertEquals(4, b2.getAmarre());
    }
	 
	 @Test
	 public void creaSalidaYPatron() {
		// given
		 Patron pepe=new Patron();
		 pepe.setNombre("Pepe");
		 pepe.setApellidos("Gonzalez");
		 pepe.setEmail("pepe@example.com");
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
		 socioServicio.delete(3L);
		 List<Socio> socios = socioServicio.readAll();
		 assertThat(socios).isNotEmpty();
	 }
}
