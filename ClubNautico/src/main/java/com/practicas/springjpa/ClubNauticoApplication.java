package com.practicas.springjpa;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.practicas.springjpa.service.*;
import com.practicas.springjpa.model.*;

@SpringBootApplication
public class ClubNauticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubNauticoApplication.class, args);
	}
	
	
	
	@Bean
    CommandLineRunner init(ServicioBarco servicio,ServicioSocio servicio2, ServicioSalida servicio3,DataSource dataSource) {
        return args -> {
        	Socio socio = new Socio();//"David","Barroso","david@example.com"
        	socio.setNombre("David");
        	socio.setApellidos("Barroso");
        	socio.setEmail("david@example.com");
            servicio2.create(socio);
        	System.out.println("Todos los barcos: ");
            servicio.readAll().forEach(t -> System.out.println(t.toString()));
            System.out.println("Todos los socios: ");
            servicio2.readAll().forEach(s->System.out.println(s.toString()));
            System.out.println("Todos las salidas: ");
            servicio3.readAll().forEach(s->System.out.println(s.toString()));
            System.out.println("Barco con id = 1 : \n"+servicio.findById(1L).toString());
            
        };
    }
}
