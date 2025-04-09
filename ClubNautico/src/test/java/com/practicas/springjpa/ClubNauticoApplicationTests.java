package com.practicas.springjpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.practicas.springjpa.model.Socio;
import com.practicas.springjpa.repositories.RepositorioSocio;
import com.practicas.springjpa.service.ServicioSocio;
@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@TestPropertySource(locations = "classpath:application.properties")
class ClubNauticoApplicationTests {
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private ServicioSocio socioServicio;
	@Test
	void contextLoads() {
	}
	@Test
    public void whenFindById_thenReturnSocio() {
        // given
        Socio socio = new Socio();
        socio.setNombre("Juan");
        socio.setApellidos("Perez");
        socio.setEmail("juan.perez@example.com");
        entityManager.persistAndFlush(socio);

        // when
        Socio found = socioServicio.findById(socio.getIdSocio()).orElse(null);

        // then
        assertThat(found.getNombre()).isEqualTo(socio.getNombre());
    }
	@Test
    public void whenInvalidId_thenReturnNull() {
        // when
        Socio s = socioServicio.findById(-99L).orElse(null);

        // then
        assertThat(s).isNull();
    }
	
	 @Test
	    public void givenSetOfSocios_whenFindAll_thenReturnAllSocios() {
	        // given
	        Socio juan = new Socio("Juan", "Perez", "juan.perez@example.com");
	        Socio maria = new Socio("Maria", "Lopez", "maria.lopez@example.com");
	        Socio carlos = new Socio("Carlos", "Gomez", "carlos.gomez@example.com");

	        entityManager.persist(juan);
	        entityManager.persist(maria);
	        entityManager.persist(carlos);
	        entityManager.flush();

	        // when
	        List<Socio> allSocios = socioServicio.readAll();

	        // then
	        assertThat(allSocios).hasSize(3).extracting(Socio::getNombre).containsOnly(juan.getNombre(), maria.getNombre(), carlos.getNombre());
	    }
	 /*
	 @Test
	 public void borradoSocio() {
		 socioRepositorio.find
	 }
	 */
}
