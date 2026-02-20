package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.biblioteca_Entity.Libros;

public interface LibrosRepository extends JpaRepository<Libros, Integer> {
    boolean existsByIsbn(String isbn);
}
