package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cibertec.biblioteca_Entity.Prestamos;
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamos, Integer> {

	@Query("SELECT p FROM Prestamos p WHERE p.usuarioId = :usuarioId")
	List<Prestamos> findByUsuarioId(@Param("usuarioId") Integer usuarioId);

	@Query("SELECT p FROM Prestamos p WHERE p.libroId = :libroId")
	List<Prestamos> findByLibroId(@Param("libroId") Integer libroId);
}
