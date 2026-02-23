package com.cibertec.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.cibertec.dto.LibroDto;

@HttpExchange("/api/v1/libros-service-ws/libros")
public interface LibroClient {

    @GetExchange("/{id}")
    LibroDto getLibro(@PathVariable Integer id);
}