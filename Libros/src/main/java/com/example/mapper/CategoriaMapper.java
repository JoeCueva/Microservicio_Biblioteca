package com.example.mapper;

import com.cibertec.biblioteca_Entity.Categoria;
import com.example.dto.CategoriaDTO;

public class CategoriaMapper {

	public static CategoriaDTO toResponse(Categoria categoria) {
		CategoriaDTO response = new CategoriaDTO();
		
		response.setId_categoria(categoria.getId_categoria());
		response.setNombreCategoria(categoria.getNombreCategoria());
		
		return response;
	}
}
