package com.cibertec.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.biblioteca_Entity.Trabajadores;
import com.cibertec.dto.LoginRequest;
import com.cibertec.security.AuthService;
import com.cibertec.service.TrabajadoresService;

@RestController
@RequestMapping("/api/v1/trabajadores-service-ws/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private TrabajadoresService trabajadorService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		try {
			String token = authService.login(request.email(), request.password());
			Trabajadores user = trabajadorService.login(request.email(), request.password());

			Map<String, Object> response = new HashMap<>();
			response.put("token", token);
			response.put("rol", user.getRol().getRoles());
			response.put("email", user.getEmail());
			response.put("nombre", user.getNombre());
			response.put("apellido", user.getApellido());
			response.put("edad", user.getEdad());
			response.put("id_trabajador", user.getId_trabajador());

			return ResponseEntity.ok(response);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", e.getMessage()));
		}
	}

	@PostMapping("/crear-admin")
	public ResponseEntity<?> crearAdmin(@RequestBody Trabajadores admin) {
		try {
			trabajadorService.crearAdmin(admin);

			Map<String, String> response = new HashMap<>();
			response.put("mensaje", "Administrador creado exitosamente");
			response.put("email", admin.getEmail());

			return ResponseEntity.ok(response);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
		}
	}
}