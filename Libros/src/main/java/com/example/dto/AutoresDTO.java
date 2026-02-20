package com.example.dto;


public class AutoresDTO {

	private Integer id_autores;
	private String nombreAutores;
	private String nacionalidad;
	
	public AutoresDTO() {
		super();
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

	
}
