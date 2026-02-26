package com.cibertec.controller;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.dto.PrestamoDto;
import com.cibertec.dto.PrestamoRequest;
import com.cibertec.dto.PrestamoResponse;
import com.cibertec.dto.PrstamoDetalleCompletoDto;
import com.cibertec.service.PrestamoService;
import com.cibertec.service.ReporteService;

@RestController
@RequestMapping("/api/v1/prestamo-service-ws")
public class PrestamoController {

	@Autowired
	private PrestamoService prestamosService;

	@Autowired
	private ReporteService reporteService;

	@GetMapping
	public List<PrestamoResponse> getPrestamos() {
		return prestamosService.getPrestamoslist();
	}

	@GetMapping("/{id}")
	public PrestamoResponse getPrestamo(@PathVariable Integer id) {
		return prestamosService.getPrestamo(id);
	}

	@GetMapping("/usuario/{id}")
	public List<PrestamoResponse> getPrestamoPorUsuario(@PathVariable Integer id) {
		return prestamosService.getPrestamoPorUsuario(id);
	}

	@GetMapping("/libro/{id}")
	public List<PrestamoDto> getPrestamoPorLibro(@PathVariable Integer id) {
		return prestamosService.getPrestamoPorLibro(id);
	}

	@PostMapping
	public ResponseEntity<PrestamoResponse> crearPrestamo(@RequestBody PrestamoRequest request) {
		PrestamoResponse response = prestamosService.crearPrestamo(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PrestamoResponse> actualizarPrestamo(@PathVariable Integer id,
			@RequestBody PrestamoRequest request) {
		PrestamoResponse response = prestamosService.actualizarPrestamo(id, request);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPrestamo(@PathVariable Integer id) {
		prestamosService.eliminarPrestamo(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/detalle-completo")
	public ResponseEntity<PrstamoDetalleCompletoDto> getDetalleCompleto(@PathVariable Integer id) {
		PrstamoDetalleCompletoDto detalle = prestamosService.getDetalleCompleto(id);
		return ResponseEntity.ok(detalle);
	}

	@GetMapping("/reporte/ficha")
	public ResponseEntity<byte[]> descargarFicha(@RequestParam(required = false) Integer id) {

		byte[] pdfBytes = reporteService.generarFichaPrestamo(id);
		if (pdfBytes != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);

			headers.setContentDispositionFormData("inline", "Ficha_Prestamo.pdf");
			return ResponseEntity.ok().headers(headers).body(pdfBytes);
		} else {
			return ResponseEntity.internalServerError().build();
		}

	}
}
