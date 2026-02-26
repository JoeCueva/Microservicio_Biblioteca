package com.cibertec.service;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReporteService {

	@Autowired
	private DataSource dataSource;

	public byte[] generarFichaPrestamo(Integer idPrestamo) {
		try {
			ClassPathResource resource = new ClassPathResource("reportes/DetallePrestamo.jasper");
			InputStream input = resource.getInputStream();

			Map<String, Object> parametros = new HashMap<>();
			parametros.put("id_prestamo_buscar", idPrestamo);
			
			Connection conexion = dataSource.getConnection();
			JasperPrint jasperPrint = JasperFillManager.fillReport(input, parametros, conexion);
			
			conexion.close(); 
			
			return JasperExportManager.exportReportToPdf(jasperPrint);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}