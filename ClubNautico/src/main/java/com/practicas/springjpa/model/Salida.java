package com.practicas.springjpa.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="salida")
public class Salida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_salida")
	private Long idSalida;
	@Column(name = "fecha_hora_salida")
	private Date fecha_hora_salida;
	@Column(name = "destino")
	private String destino;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)//, orphanRemoval = true
	@JoinColumn(name = "patron_id", referencedColumnName = "id_patron")
	private Patron patron;
	
	@ManyToOne
	@JoinColumn(name="id_barco")
	private Barco barco;

	public Long getIdSalida() {
		return idSalida;
	}

	public void setIdSalida(Long idSalida) {
		this.idSalida = idSalida;
	}

	public Date getFecha_hora_salida() {
		return fecha_hora_salida;
	}

	public void setFecha_hora_salida(Date fecha_hora_salida) {
		this.fecha_hora_salida = fecha_hora_salida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	@Transactional
	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	@Override
	public String toString() {
		return "Salida [idSalida=" + idSalida + ", fecha_hora_salida=" + fecha_hora_salida + ", destino=" + destino
				+ "]";//, patron=" + patron.toString() + ", barco=" + barco.getNombre() + "
	}
	
	
}
