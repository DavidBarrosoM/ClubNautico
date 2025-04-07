package com.practicas.springjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Barco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_barco")
	private Long idBarco;
	@Column(name = "matricula")
	private Long matricula;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "amarre")
	private Integer amarre;
	@Column(name = "cuota")
	private Double cuota;
	
	
	public Long getIdBarco() {
		return idBarco;
	}
	public void setIdBarco(Long idBarco) {
		this.idBarco = idBarco;
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getAmarre() {
		return amarre;
	}
	public void setAmarre(Integer amarre) {
		this.amarre = amarre;
	}
	public Double getCuota() {
		return cuota;
	}
	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}
	
}
