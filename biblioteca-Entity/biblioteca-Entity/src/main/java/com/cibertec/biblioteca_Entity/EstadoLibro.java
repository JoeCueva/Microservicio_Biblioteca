package com.cibertec.biblioteca_Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EstadoLibro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estado;
	private String descripcion;
	
	public EstadoLibro() {
		super();
	}

	public EstadoLibro(Integer id_estado, String descripcion) {
		super();
		this.id_estado = id_estado;
		this.descripcion = descripcion;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
