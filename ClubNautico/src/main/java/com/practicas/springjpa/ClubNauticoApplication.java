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
	CommandLineRunner init(ServicioBarco servicio) {
		return args ->{
			//ServicioPatron servicioPatron;
			
			//ServicioBarco sevicioBarco;
			//servicio.readAll().forEach(t -> System.out.println(t.getNombre()) );
			servicio.readAll().forEach(t -> t.toString() );
			//System.out.println(servicio.readAll());
			//servicioBarco.getAll();
		};
	}
	
}
