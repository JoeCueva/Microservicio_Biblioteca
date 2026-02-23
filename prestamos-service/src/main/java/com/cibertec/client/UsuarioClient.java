package com.cibertec.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.cibertec.dto.UsuarioDto;

@HttpExchange("/api/v1/usuario-service-ws")
public interface UsuarioClient {

	@GetExchange("/{id}")
	UsuarioDto getUsuario(@PathVariable Integer id);
}
