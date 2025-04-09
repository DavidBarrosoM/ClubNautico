package com.practicas.springjpa.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="barco")
public class Barco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barco")
    private Long idBarco;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "amarre")
    private Integer amarre;

    @Column(name = "cuota")
    private Double cuota;

    @ManyToOne
    @JoinColumn(name = "id_socio")  
    private Socio socio;

    @OneToMany(mappedBy = "barco", cascade = CascadeType.ALL, orphanRemoval = true)//, orphanRemoval = true,fetch = FetchType.EAGER
    private List<Salida> salidas;


    public boolean agregarSalida(Salida s) {
        return this.salidas.add(s);
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) { 
        this.socio = socio;
    }

    public List<Salida> getSalidas() {
        return salidas;
    }

    public void setSalidas(List<Salida> salidas) {
        this.salidas = salidas;
    }

    public Long getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(Long idBarco) {
        this.idBarco = idBarco;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
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

    @Override
    public String toString() {
        return "Barco [idBarco=" + idBarco + ", matricula=" + matricula + ", nombre=" + nombre + ", amarre=" + amarre
                + ", cuota=" + cuota + "]"; // , propietario=" + socio.getNombre() + ", salidas=(" + arraySalidasToString()+ ")
    }
    public String arraySalidasToString() {
    	StringBuilder concatenatedDestinos = new StringBuilder();
        for (Salida salida : salidas) {
            concatenatedDestinos.append(salida.getDestino()).append(", ");
        }
    	return concatenatedDestinos.toString();
    }
}
