package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.biblioteca_Entity.Autores;
import com.cibertec.biblioteca_Entity.Categoria;
import com.cibertec.biblioteca_Entity.EstadoLibro;
import com.cibertec.biblioteca_Entity.Libros;
import com.example.dto.LibrosRequest;
import com.example.dto.LibrosResponse;
import com.example.exception.IsbnDuplicadoException;
import com.example.exception.LibroNotFoundException;
import com.example.mapper.LibrosMapper;
import com.example.repository.AutoresRepository;
import com.example.repository.CategoriaRepository;
import com.example.repository.EstadoLibroRepository;
import com.example.repository.LibrosRepository;

@Service
public class LibrosService {

	@Autowired
	private LibrosRepository librosRepository;

	@Autowired
	private AutoresRepository autoresRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private EstadoLibroRepository estadoLibroRepository;

	private LibrosMapper mapper = new LibrosMapper();

	public List<LibrosResponse> listarTodos() {
		return librosRepository.findAll().stream().map(mapper::toResponse).toList();
	}

	public LibrosResponse buscarPorId(Integer id) {
		Libros libro = librosRepository.findById(id)
				.orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
		return mapper.toResponse(libro);
	}

	public LibrosResponse guardar(LibrosRequest request) {
		if (librosRepository.existsByIsbn(request.getIsbn())) {
			throw new IsbnDuplicadoException("El ISBN " + request.getIsbn() + " ya está registrado");
		}

		Autores autor = autoresRepository.findById(request.getIdAutores())
				.orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + request.getIdAutores()));

		Categoria categoria = categoriaRepository.findById(request.getIdCategoria())
				.orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + request.getIdCategoria()));

		EstadoLibro estado = estadoLibroRepository.findById(request.getIdEstado())
				.orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + request.getIdEstado()));

		Libros libro = new Libros();
		libro.setTitulo(request.getTitulo());
		libro.setAnio(request.getAnio());
		libro.setIsbn(request.getIsbn());
		libro.setEditorial(request.getEditorial());
		libro.setAutores(autor);
		libro.setCategoria(categoria);
		libro.setEstadoLibro(estado);

		return mapper.toResponse(librosRepository.save(libro));
	}

	public LibrosResponse editar(Integer id, LibrosRequest request) {
		Libros existente = librosRepository.findById(id)
				.orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));

		if (!existente.getIsbn().equals(request.getIsbn()) && librosRepository.existsByIsbn(request.getIsbn())) {
			throw new IsbnDuplicadoException("El ISBN " + request.getIsbn() + " ya está registrado");
		}

		Autores autor = autoresRepository.findById(request.getIdAutores())
				.orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + request.getIdAutores()));

		Categoria categoria = categoriaRepository.findById(request.getIdCategoria())
				.orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + request.getIdCategoria()));

		EstadoLibro estado = estadoLibroRepository.findById(request.getIdEstado())
				.orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + request.getIdEstado()));

		existente.setTitulo(request.getTitulo());
		existente.setAnio(request.getAnio());
		existente.setIsbn(request.getIsbn());
		existente.setEditorial(request.getEditorial());
		existente.setAutores(autor);
		existente.setCategoria(categoria);
		existente.setEstadoLibro(estado);

		return mapper.toResponse(librosRepository.save(existente));
	}

	public void eliminar(Integer id) {
		if (!librosRepository.existsById(id)) {
			throw new LibroNotFoundException("Libro no encontrado con ID: " + id);
		}
		librosRepository.deleteById(id);
	}
}