package com.cibertec.mapper;

import com.cibertec.dto.RolDto;

public class RolMapper {

	public RolDto toDto(RolDto rol) {
		RolDto Dto = new RolDto();

		Dto.setId_rol(rol.getId_rol());
		Dto.setRoles(rol.getRoles());

		return Dto;

	}

}
