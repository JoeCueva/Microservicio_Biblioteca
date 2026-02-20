package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.biblioteca_Entity.EstadoLibro;
import com.example.service.EstadoLibroService;

@RestController
@RequestMapping("/api/v1/libros-service-ws/estados")
public class EstadoLibroController {
	   @Autowired
	    private EstadoLibroService estadoLibroService;

	    @GetMapping
	    public List<EstadoLibro> listar() {
	        return estadoLibroService.listarTodos();
	    }
}
