package com.cibertec.dto;

public class LibroDto {

	private Integer id_libros;
	private String titulo;
	private int anio;
	private String isbn;
	private String editorial;

	private Integer idAutor;
	private String nombreAutor;
	private String nacionalidadAutor;

	private Integer idCategoria;
	private String nombreCategoria;

	private Integer idEstado;
	private String descripcionEstado;

	public LibroDto() {
		super();
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

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getNacionalidadAutor() {
		return nacionalidadAutor;
	}

	public void setNacionalidadAutor(String nacionalidadAutor) {
		this.nacionalidadAutor = nacionalidadAutor;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
}