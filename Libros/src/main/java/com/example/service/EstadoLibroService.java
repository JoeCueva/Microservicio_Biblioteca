package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.biblioteca_Entity.EstadoLibro;
import com.example.repository.EstadoLibroRepository;

@Service
public class EstadoLibroService {
	@Autowired
    private EstadoLibroRepository estadoLibroRepository;

    public List<EstadoLibro> listarTodos() {
        return estadoLibroRepository.findAll();
    }

}
