package com.cibertec.biblioteca_Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categoria;
	
	@Column(name = "nombre_categoria")
	private String nombreCategoria;

	public Categoria(Integer id_categoria, String nombreCategoria) {
		super();
		this.id_categoria = id_categoria;
		this.nombreCategoria = nombreCategoria;
	}
	
	public Categoria() {
		super();
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
}
