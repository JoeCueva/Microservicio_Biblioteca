package com.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cibertec.biblioteca_Entity")
public class TrabajadoresServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajadoresServiceApplication.class, args);
	}

}
