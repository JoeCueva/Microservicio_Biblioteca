package com.biblioteca.microservices.service;

import java.util.List;

import com.biblioteca.microservices.dto.UsuarioRequest;
import com.biblioteca.microservices.dto.UsuarioResponse;
import com.biblioteca.microservices.exception.DuplicateDniException;
import com.biblioteca.microservices.exception.DuplicateEmailException;
import com.biblioteca.microservices.exception.UsuarioNotFoundException;
import com.biblioteca.microservices.mapper.UsuarioMapper;
import com.biblioteca.microservices.repository.UsuarioRepository;
import com.cibertec.biblioteca_Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    
    private UsuarioMapper mapper = new UsuarioMapper();
    
    public List<UsuarioResponse> getUsuarios() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
    
    public Page<UsuarioResponse> getUsuarios(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }
    
    public UsuarioResponse getUsuario(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new UsuarioNotFoundException("El usuario con ID " + id + " no existe"));
    }
    
    public UsuarioResponse getUsuarioPorCorreo(String correo) {
        return repository.findByCorreo(correo)
                .map(mapper::toResponse)
                .orElseThrow(() -> new UsuarioNotFoundException("El usuario con correo " + correo + " no existe"));
    }
    
    public UsuarioResponse crearUsuario(UsuarioRequest request) {
       
        if (repository.existsByCorreo(request.getCorreo())) {
            throw new DuplicateEmailException("El correo " + request.getCorreo() + " ya está registrado");
        }
       
        if (repository.existsByDni(request.getDni())) {
            throw new DuplicateDniException("El DNI " + request.getDni() + " ya está registrado");
        }
        
        Usuario nuevoUsuario = repository.save(mapper.toEntity(request));
        return mapper.toResponse(nuevoUsuario);
    }
    
    public UsuarioResponse actualizarUsuario(Integer id, UsuarioRequest request) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no existe"));
        
        if (!usuario.getCorreo().equals(request.getCorreo()) && 
            repository.existsByCorreo(request.getCorreo())) {
            throw new DuplicateEmailException("El correo " + request.getCorreo() + " ya está registrado");
        }
        
        if (!usuario.getDni().equals(request.getDni()) && 
            repository.existsByDni(request.getDni())) {
            throw new DuplicateDniException("El DNI " + request.getDni() + " ya está registrado");
        }
        
        usuario.setNombre_usuario(request.getNombreUsuario());
        usuario.setApellido_usuario(request.getApellidoUsuario());
        usuario.setDni(request.getDni());
        usuario.setCorreo(request.getCorreo());
        usuario.setTelefono(request.getTelefono());
        usuario.setDireccion(request.getDireccion());
        usuario.setGenero(request.getGenero());
        usuario.setFecha_nacimiento(request.getFechaNacimiento());
        
        Usuario actualizado = repository.save(usuario);
        return mapper.toResponse(actualizado);
    }
    
    public void eliminarUsuario(Integer id) {
        if (!repository.existsById(id)) {
            throw new UsuarioNotFoundException("El usuario con ID " + id + " no existe");
        }
        repository.deleteById(id);
    }
}
