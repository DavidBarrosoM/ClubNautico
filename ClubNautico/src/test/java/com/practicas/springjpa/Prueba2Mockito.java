package com.practicas.springjpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.practicas.springjpa.service.ServicioBarco;
import com.practicas.springjpa.service.ServicioPatron;
import com.practicas.springjpa.service.ServicioSalida;
import com.practicas.springjpa.service.ServicioSocio;

@RunWith(MockitoJUnitRunner.class)
class Prueba2Mockito {
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
	@Mock
	private ServicioSocio socioServicio;
	@Autowired
	@Mock
	private ServicioBarco barcoServicio;
	@Autowired
	@Mock
	private ServicioPatron patronServicio;
	@Autowired
	@Mock
	private ServicioSalida salidaServicio;
	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Before(value = "")
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	 public void verificaBorradoPatron() {
		 salidaServicio.deletePorPatron(1L);
		 verify(patronServicio).delete(1L);
	 }

}
