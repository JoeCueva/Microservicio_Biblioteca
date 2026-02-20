package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.biblioteca_Entity.Categoria;
import com.example.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria no encontrada con ID: " + id));
    }

    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria editar(Integer id, Categoria categoria) {
        Categoria existente = categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria no encontrada con ID: " + id));

        existente.setNombreCategoria(categoria.getNombreCategoria());

        return categoriaRepository.save(existente);
    }

    public void eliminar(Integer id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria no encontrada con ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }
}