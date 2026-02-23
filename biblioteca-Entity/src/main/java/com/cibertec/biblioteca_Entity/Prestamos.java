package com.cibertec.biblioteca_Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Prestamos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_prestamos;

	@Column(name = "id_usuario")
	private Integer usuarioId;

	@Column(name = "id_libros")
	private Integer libroId;

	private String fecha_prestamo;
	private String fecha_devolucion;
	private String fecha_real;
	private double multa;
	private String comentarios;

	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
	private EstadoLibro estadoLibro;

	public Prestamos() {
		super();
	}

	public Integer getId_prestamos() {
		return id_prestamos;
	}

	public void setId_prestamos(Integer id_prestamos) {
		this.id_prestamos = id_prestamos;
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

	public String getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(String fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public String getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(String fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public String getFecha_real() {
		return fecha_real;
	}

	public void setFecha_real(String fecha_real) {
		this.fecha_real = fecha_real;
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

	public EstadoLibro getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(EstadoLibro estadoLibro) {
		this.estadoLibro = estadoLibro;
	}
}