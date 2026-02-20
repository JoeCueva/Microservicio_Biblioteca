package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.biblioteca_Entity.Libros;
import com.example.dto.LibrosRequest;
import com.example.dto.LibrosResponse;
import com.example.service.LibrosService;

@RestController
@RequestMapping("/api/v1/libros-service-ws/libros")
public class LibrosController {

    @Autowired
    private LibrosService librosService;

    @GetMapping
    public List<LibrosResponse> listar() {
        return librosService.listarTodos();
    }

    @GetMapping("/{id}")
    public LibrosResponse buscarPorId(@PathVariable Integer id) {
        return librosService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<LibrosResponse> guardar(@RequestBody LibrosRequest request) {
        LibrosResponse response = librosService.guardar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibrosResponse> editar(
            @PathVariable Integer id,
            @RequestBody LibrosRequest request) {
        LibrosResponse response = librosService.editar(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        librosService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}