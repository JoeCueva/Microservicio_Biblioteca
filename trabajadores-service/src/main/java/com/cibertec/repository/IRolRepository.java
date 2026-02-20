package com.cibertec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.biblioteca_Entity.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
	Optional<Rol> findByRoles(String rol);

}
