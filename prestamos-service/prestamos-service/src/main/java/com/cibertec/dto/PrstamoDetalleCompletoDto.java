package com.cibertec.dto;

public class PrstamoDetalleCompletoDto {

	private Integer prestamoId;
	private String fechaPrestamo;
	private String fechaDevolucion;
	private String fechaReal;
	private double multa;
	private String comentarios;
	private String estadoPrestamo;

	private Integer usuarioId;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String dniUsuario;
	private String correoUsuario;
	private String telefonoUsuario;
	private String direccionUsuario;
	private String generoUsuario;
	private String fechaNacimientoUsuario;


	private Integer libroId;
	private String tituloLibro;
	private Integer anioLibro;
	private String isbnLibro;
	private String editorialLibro;
	private String autorLibro;
	private String nacionalidadAutor;
	private String categoriaLibro;
	private String estadoLibro;

	public PrstamoDetalleCompletoDto() {
		super();
	}

	public Integer getPrestamoId() {
		return prestamoId;
	}

	public void setPrestamoId(Integer prestamoId) {
		this.prestamoId = prestamoId;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getFechaReal() {
		return fechaReal;
	}

	public void setFechaReal(String fechaReal) {
		this.fechaReal = fechaReal;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}

	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getGeneroUsuario() {
		return generoUsuario;
	}

	public void setGeneroUsuario(String generoUsuario) {
		this.generoUsuario = generoUsuario;
	}

	public String getFechaNacimientoUsuario() {
		return fechaNacimientoUsuario;
	}

	public void setFechaNacimientoUsuario(String fechaNacimientoUsuario) {
		this.fechaNacimientoUsuario = fechaNacimientoUsuario;
	}

	public Integer getLibroId() {
		return libroId;
	}

	public void setLibroId(Integer libroId) {
		this.libroId = libroId;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public Integer getAnioLibro() {
		return anioLibro;
	}

	public void setAnioLibro(Integer anioLibro) {
		this.anioLibro = anioLibro;
	}

	public String getIsbnLibro() {
		return isbnLibro;
	}

	public void setIsbnLibro(String isbnLibro) {
		this.isbnLibro = isbnLibro;
	}

	public String getEditorialLibro() {
		return editorialLibro;
	}

	public void setEditorialLibro(String editorialLibro) {
		this.editorialLibro = editorialLibro;
	}

	public String getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}

	public String getNacionalidadAutor() {
		return nacionalidadAutor;
	}

	public void setNacionalidadAutor(String nacionalidadAutor) {
		this.nacionalidadAutor = nacionalidadAutor;
	}

	public String getCategoriaLibro() {
		return categoriaLibro;
	}

	public void setCategoriaLibro(String categoriaLibro) {
		this.categoriaLibro = categoriaLibro;
	}

	public String getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(String estadoLibro) {
		this.estadoLibro = estadoLibro;
	}
}