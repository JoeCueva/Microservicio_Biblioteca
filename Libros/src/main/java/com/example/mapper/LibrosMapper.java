package com.example.mapper;

import com.cibertec.biblioteca_Entity.Libros;
import com.example.dto.LibrosResponse;

public class LibrosMapper {

	public LibrosResponse toResponse(Libros libros) {
		LibrosResponse response = new LibrosResponse();

		response.setId_libros(libros.getId_libros());
		response.setTitulo(libros.getTitulo());
		response.setAnio(libros.getAnio());
		response.setIsbn(libros.getIsbn());
		response.setEditorial(libros.getEditorial());

		if (libros.getAutores() != null) {
			response.setIdAutor(libros.getAutores().getId_autores());
			response.setNombreAutor(libros.getAutores().getNombreAutores());
			response.setNacionalidadAutor(libros.getAutores().getNacionalidad());
		}

		if (libros.getCategoria() != null) {
			response.setIdCategoria(libros.getCategoria().getId_categoria());
			response.setNombreCategoria(libros.getCategoria().getNombreCategoria());
		}

		if (libros.getEstadoLibro() != null) {
			response.setIdEstado(libros.getEstadoLibro().getId_estado());
			response.setDescripcionEstado(libros.getEstadoLibro().getDescripcion());
		}

		return response;
	}
}