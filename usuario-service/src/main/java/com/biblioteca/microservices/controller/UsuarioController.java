package com.biblioteca.microservices.controller;

import java.util.List;

import com.biblioteca.microservices.dto.UsuarioRequest;
import com.biblioteca.microservices.dto.UsuarioResponse;
import com.biblioteca.microservices.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario-service-ws")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public List<UsuarioResponse> getUsuarios() {
        return usuarioService.getUsuarios();
    }
    
    @GetMapping("/page")
    public Page<UsuarioResponse> getUsuarios(Pageable pageable) {
        return usuarioService.getUsuarios(pageable);
    }
    
    @GetMapping("/{id}")
    public UsuarioResponse getUsuario(@PathVariable Integer id) {
        return usuarioService.getUsuario(id);
    }
    
    @GetMapping("/correo/{correo}")
    public UsuarioResponse getUsuarioPorCorreo(@PathVariable String correo) {
        return usuarioService.getUsuarioPorCorreo(correo);
    }
    
    @PostMapping
    public ResponseEntity<UsuarioResponse> crearUsuario(@RequestBody UsuarioRequest request) {
        UsuarioResponse response = usuarioService.crearUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> actualizarUsuario(
            @PathVariable Integer id, 
            @RequestBody UsuarioRequest request) {
        UsuarioResponse response = usuarioService.actualizarUsuario(id, request);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
