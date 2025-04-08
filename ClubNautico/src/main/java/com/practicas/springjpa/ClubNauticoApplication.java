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
	
	/*
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
	*/
	
	@Bean
    CommandLineRunner init(ServicioBarco servicio,ServicioSocio servicio2, DataSource dataSource) {
        return args -> {
            // Ejecutar el archivo import.sql después de que la aplicación se haya iniciado
            /*try (Connection connection = dataSource.getConnection()) {
                ScriptUtils.executeSqlScript(connection, new ClassPathResource("import.sql"));
            } catch (SQLException e) {
                e.printStackTrace();
            }*/

            // Lógica adicional después de cargar los datos
            servicio.readAll().forEach(t -> System.out.println(t.toString()));
            servicio2.readAll().forEach(s->System.out.println(s.toString()));
        };
    }
}
