package com.cibertec.biblioteca_Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Autores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_autores;
	
	@Column(name = "nombre_autores")
	private String nombreAutores;
	
	private String nacionalidad;

	public Autores() {
		super();
	}

	public Autores(Integer id_autores, String nombreAutores, String nacionalidad) {
		super();
		this.id_autores = id_autores;
		this.nombreAutores = nombreAutores;
		this.nacionalidad = nacionalidad;
	}
	
	public Integer getId_autores() {
		return id_autores;
	}

	public void setId_autores(Integer id_autores) {
		this.id_autores = id_autores;
	}

	public String getNombreAutores() {
		return nombreAutores;
	}

	public void setNombreAutores(String nombreAutores) {
		this.nombreAutores = nombreAutores;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Autores [id_autores=" + id_autores + ", nombreAutores=" + nombreAutores + ", nacionalidad="
				+ nacionalidad + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
