package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.biblioteca_Entity.Rol;
import com.cibertec.dto.RolDto;
import com.cibertec.repository.IRolRepository;

@Service
public class RolServices {

	@Autowired
	private IRolRepository rolRepository;

	public List<Rol> listarRoles() {
		return rolRepository.findAll();
	}

	public RolDto buscarRolPorId(Integer id) {
		Rol rol = rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));

		RolDto dto = new RolDto();
		dto.setId_rol(rol.getId_rol());
		dto.setRoles(rol.getRoles());

		return dto;
	}
}