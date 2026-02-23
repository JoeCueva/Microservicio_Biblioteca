package com.cibertec.mapper;

import com.cibertec.biblioteca_Entity.*;
import com.cibertec.dto.PrestamoDto;
import com.cibertec.dto.PrestamoRequest;

public class PrestamoMapper {

	public Prestamos toEntity(PrestamoRequest request) {
		Prestamos prestamo = new Prestamos();

		prestamo.setUsuarioId(request.getUsuarioId());
		prestamo.setLibroId(request.getLibroId());
		prestamo.setFecha_prestamo(request.getFechaPrestamo());
		prestamo.setFecha_devolucion(request.getFechaDevolucion());
		prestamo.setFecha_real(request.getFechaReal());
		prestamo.setComentarios(request.getComentarios());
		prestamo.setMulta(0.0);

		if (request.getEstadoId() != null) {
			EstadoLibro estado = new EstadoLibro();
			estado.setId_estado(request.getEstadoId());
			prestamo.setEstadoLibro(estado);
		}

		return prestamo;
	}

	public PrestamoDto toDto(Prestamos prestamo) {
		PrestamoDto dto = new PrestamoDto();

		dto.setPrestamoId(prestamo.getId_prestamos());
		dto.setFechaPrestamo(prestamo.getFecha_prestamo());
		dto.setFechaDevolucion(prestamo.getFecha_devolucion());
		dto.setFechaReal(prestamo.getFecha_real());
		dto.setMulta(prestamo.getMulta());
		dto.setUsuarioId(prestamo.getUsuarioId());
		dto.setLibroId(prestamo.getLibroId());

		if (prestamo.getEstadoLibro() != null) {
			dto.setEstadoPrestamo(prestamo.getEstadoLibro().getDescripcion());
		}

		return dto;
	}
}