package com.practicas.springjpa.model;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="socio")
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_socio")
	private Long idSocio;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy="propietario",cascade=CascadeType.ALL,orphanRemoval = true)
	@Column(name = "barcos_propiedad")
	private List<Barco> barcosPropiedad;
	
	public Long getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(Long idSocio) {
		this.idSocio = idSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Barco> getBarcosPropiedad() {
		return barcosPropiedad;
	}
	public void setBarcosPropiedad(List<Barco> barcosPropiedad) {
		this.barcosPropiedad = barcosPropiedad;
	}
	
	
}
