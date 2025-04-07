package com.practicas.springjpa.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Salida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_salida")
	private Long idSalida;
	@Column(name = "fecha_hora_salida")
	private Date fecha_hora_salida;
	@Column(name = "destino")
	private String destino;
	@Column(name = "patron")
	private Patron patron;
	
}
