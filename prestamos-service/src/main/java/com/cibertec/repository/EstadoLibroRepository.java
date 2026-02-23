package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.biblioteca_Entity.EstadoLibro;
@Repository
public interface EstadoLibroRepository extends JpaRepository<EstadoLibro, Integer>{

}
