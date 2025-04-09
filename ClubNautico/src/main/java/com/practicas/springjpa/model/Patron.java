package com.practicas.springjpa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="patron")
public class Patron {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_patron")
	private Long idPatron;
	@Column(name = "nombre")
	@NotNull
    @Size(min = 2, max = 14)
    @NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	@Column(name = "apellidos")
	@NotNull
    @Size(min = 2, max = 14)
    @NotBlank(message = "Los apellidos son obligatorios")
	private String apellidos;
	@Column(name = "email")
	@Size(min = 10, max = 100)
    @Email(message = "El email debe ser válido")
    @NotBlank(message = "El email es obligatorio")
	private String email;
	
	@OneToOne
	@JoinColumn(name = "id_salida")
	private Salida salida;
	
	public Long getIdPatron() {
		return idPatron;
	}
	public void setIdPatron(Long idPatron) {
		this.idPatron = idPatron;
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
	@Override
	public String toString() {
		return "Patron [idPatron=" + idPatron + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ "]";
	}
	
	
}
