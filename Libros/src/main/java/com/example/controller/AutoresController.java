package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.biblioteca_Entity.Autores;
import com.example.service.AutoresService;

@RestController
@RequestMapping("/api/v1/libros-service-ws/autores")
public class AutoresController {

    @Autowired
    private AutoresService autoresService;

    @GetMapping
    public List<Autores> listar() {
        return autoresService.listarTodos();
    }

    @GetMapping("/{id}")
    public Autores buscarPorId(@PathVariable Integer id) {
        return autoresService.buscarPorId(id);
    }

    @PostMapping
    public Autores guardar(@RequestBody Autores autores) {
        return autoresService.guardar(autores);
    }

    @PutMapping("/{id}")
    public Autores editar(@PathVariable Integer id, @RequestBody Autores autores) {
        return autoresService.editar(id, autores);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        autoresService.eliminar(id);
    }
}
