package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.biblioteca_Entity.Autores;
import com.example.repository.AutoresRepository;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autores> listarTodos() {
        return autoresRepository.findAll();
    }

    public Autores buscarPorId(Integer id) {
        return autoresRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + id));
    }

    public Autores guardar(Autores autores) {
        return autoresRepository.save(autores);
    }

    public Autores editar(Integer id, Autores autores) {
        Autores existente = autoresRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + id));

        existente.setNombreAutores(autores.getNombreAutores());
        existente.setNacionalidad(autores.getNacionalidad());

        return autoresRepository.save(existente);
    }

    public void eliminar(Integer id) {
        if (!autoresRepository.existsById(id)) {
            throw new RuntimeException("Autor no encontrado con ID: " + id);
        }
        autoresRepository.deleteById(id);
    }
}
