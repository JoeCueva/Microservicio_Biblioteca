package com.example.mapper;

import com.cibertec.biblioteca_Entity.EstadoLibro;
import com.example.dto.EstadoLibroDTO;

public class EstadoLibroMapper {

	public static EstadoLibroDTO toResponse(EstadoLibro estado) {
		EstadoLibroDTO response = new EstadoLibroDTO();
		
		response.setId_estado(estado.getId_estado());
		response.setDescripcion(estado.getDescripcion());
		
		return response;
	}
}
