package com.cibertec.biblioteca_Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Libros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_libros;
	private String titulo;
	private int anio;
	@Column(unique = true)
	private String isbn;
	private String editorial;
	
	@ManyToOne
	@JoinColumn(name = "id_autores", referencedColumnName = "id_autores")
	private Autores autores;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
	private EstadoLibro estadoLibro;
	
	
	public Libros() {
		super();
	}

	public Libros(Integer id_libros, String titulo, int anio, String isbn, String editorial, Autores autores,
			Categoria categoria, EstadoLibro estadoLibro) {
		super();
		this.id_libros = id_libros;
		this.titulo = titulo;
		this.anio = anio;
		this.isbn = isbn;
		this.editorial = editorial;
		this.autores = autores;
		this.categoria = categoria;
		this.estadoLibro = estadoLibro;
	}

	public Integer getId_libros() {
		return id_libros;
	}

	public void setId_libros(Integer id_libros) {
		this.id_libros = id_libros;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Autores getAutores() {
		return autores;
	}

	public void setAutores(Autores autores) {
		this.autores = autores;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public EstadoLibro getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(EstadoLibro estadoLibro) {
		this.estadoLibro = estadoLibro;
	}
}
