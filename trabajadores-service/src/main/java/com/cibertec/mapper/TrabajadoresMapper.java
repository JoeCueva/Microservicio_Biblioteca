package com.cibertec.mapper;

import com.cibertec.biblioteca_Entity.Trabajadores;
import com.cibertec.dto.RolDto;
import com.cibertec.dto.TrabajadoresResponse;

public class TrabajadoresMapper {

    public TrabajadoresResponse toResponse(Trabajadores trabajadores) {
        TrabajadoresResponse response = new TrabajadoresResponse();

        response.setId_trabajador(trabajadores.getId_trabajador());
        response.setNombre(trabajadores.getNombre());
        response.setApellido(trabajadores.getApellido());
        response.setEmail(trabajadores.getEmail());
        response.setEdad(trabajadores.getEdad());

        if (trabajadores.getRol() != null) {
            RolDto rolDto = new RolDto();
            rolDto.setId_rol(trabajadores.getRol().getId_rol());
            rolDto.setRoles(trabajadores.getRol().getRoles());
            response.setRol(rolDto);
        }

        return response;
    }
}