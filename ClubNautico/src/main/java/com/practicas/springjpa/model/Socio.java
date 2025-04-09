package com.practicas.springjpa.model;

import java.io.Serializable;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="socio")
public class Socio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Long idSocio;

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

    @OneToMany(mappedBy = "socio",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)//, orphanRemoval = true
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

    public boolean agregarBarco(Barco b) {
        return this.barcosPropiedad.add(b);
    }

    @Override
    public String toString() {
        return "Socio [idSocio=" + idSocio + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
                + "]";//, barcosPropiedad= ( " + getNombresBarcosLista() + " )
    }
    public String getNombresBarcosLista() {
    	StringBuilder concatenatedNombres = new StringBuilder();
        for (Barco barco : barcosPropiedad) {
        	concatenatedNombres.append(barco.getNombre()).append(", ");
        }
    	return concatenatedNombres.toString();
    }
}
