package com.cibertec.biblioteca_Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Trabajadores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_trabajador;
	private String nombre;
	private String apellido;
	@Column(unique = true)
	private String email;
	private Integer edad;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;

	public Trabajadores() {
		super();
	}
	
	public Trabajadores(Integer id_trabajador, String nombre, String apellido, String email, Integer edad,
			String password, Rol rol) {
		super();
		this.id_trabajador = id_trabajador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
		this.password = password;
		this.rol = rol;
	}

	public Integer getId_trabajador() {
		return id_trabajador;
	}

	public void setId_trabajador(Integer id_trabajador) {
		this.id_trabajador = id_trabajador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Trabajadores [id_trabajador=" + id_trabajador + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", edad=" + edad + ", password=" + password + ", rol=" + rol
				+ ", getId_trabajador()=" + getId_trabajador() + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getEmail()=" + getEmail() + ", getEdad()=" + getEdad() + ", getPassword()="
				+ getPassword() + ", getRol()=" + getRol() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
