package com.example.mapper;

import com.cibertec.biblioteca_Entity.Autores;
import com.example.dto.AutoresDTO;

public class AutoresMapper {

	public static AutoresDTO toResponse(Autores autores) {
		AutoresDTO response = new AutoresDTO();
		
		response.setId_autores(autores.getId_autores());
		response.setNombreAutores(autores.getNombreAutores());
		response.setNacionalidad(autores.getNacionalidad());
		
		return response;
	}
}
