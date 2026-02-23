package com.cibertec.dto;

public class PrestamoRequest {

	private Integer usuarioId;
	private Integer libroId;
	private Integer estadoId;
	private String fechaPrestamo;
	private String fechaDevolucion;
	private String fechaReal;
	private String comentarios;

	public PrestamoRequest() {
        super();
    }
	
	public PrestamoRequest(Integer usuarioId, Integer libroId, Integer estadoId, String fechaPrestamo,
			String fechaDevolucion, String fechaReal, String comentarios) {
		super();
		this.usuarioId = usuarioId;
		this.libroId = libroId;
		this.estadoId = estadoId;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.fechaReal = fechaReal;
		this.comentarios = comentarios;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getLibroId() {
		return libroId;
	}

	public void setLibroId(Integer libroId) {
		this.libroId = libroId;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
