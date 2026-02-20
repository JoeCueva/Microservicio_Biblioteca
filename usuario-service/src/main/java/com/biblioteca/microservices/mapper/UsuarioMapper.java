package com.biblioteca.microservices.mapper;

import com.biblioteca.microservices.dto.UsuarioDto;
import com.biblioteca.microservices.dto.UsuarioRequest;
import com.biblioteca.microservices.dto.UsuarioResponse;
import com.cibertec.biblioteca_Entity.Usuario;

public class UsuarioMapper {

	public Usuario toEntity(UsuarioRequest request) {
		Usuario usuario = new Usuario();
		usuario.setNombre_usuario(request.getNombreUsuario());
		usuario.setApellido_usuario(request.getApellidoUsuario());
		usuario.setDni(request.getDni());
		usuario.setCorreo(request.getCorreo());
		usuario.setTelefono(request.getTelefono());
		usuario.setDireccion(request.getDireccion());
		usuario.setGenero(request.getGenero());
		usuario.setFecha_nacimiento(request.getFechaNacimiento());
		
		return usuario;
	}
	
	public UsuarioResponse toResponse(Usuario usuario) {
		UsuarioResponse response = new UsuarioResponse();
		response.setUsuarioId(usuario.getId_usuario());
		response.setNombreUsuario(usuario.getNombre_usuario());
		response.setApellidoUsuario(usuario.getApellido_usuario());
		response.setDni(usuario.getDni());
		response.setCorreo(usuario.getCorreo());
		response.setTelefono(usuario.getTelefono());
		response.setDireccion(usuario.getDireccion());
		response.setGenero(usuario.getGenero());
		response.setFechaNacimiento(usuario.getFecha_nacimiento());
		
		return response;
	}
	
	public UsuarioDto toDto(Usuario usuario) {
		UsuarioDto dto = new UsuarioDto();
		dto.setUsuarioId(usuario.getId_usuario());
		dto.setNombreCompleto(usuario.getNombre_usuario() + " " + usuario.getApellido_usuario());
		dto.setCorreo(usuario.getCorreo());
		dto.setTelefono(usuario.getTelefono());
		dto.setDireccion(usuario.getDireccion());
		
		return dto;
	}
	
}
