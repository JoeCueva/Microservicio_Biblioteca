package com.cibertec.biblioteca_Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_rol; 
	
	private String roles;

	public Rol() {
		super();
	}
	
	public Rol(Integer id_rol, String roles) {
		super();
		this.id_rol = id_rol;
		this.roles = roles;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Rol [id_rol=" + id_rol + ", roles=" + roles + ", getId_rol()=" + getId_rol() + ", getRoles()="
				+ getRoles() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
