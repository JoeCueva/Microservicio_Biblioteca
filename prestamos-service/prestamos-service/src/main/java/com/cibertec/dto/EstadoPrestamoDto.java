package com.cibertec.dto;

public class EstadoPrestamoDto {

	private Integer idEstado;
	private String descripcion;

	public EstadoPrestamoDto() {
		super();
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}