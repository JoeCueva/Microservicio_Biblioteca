package com.cibertec.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cibertec.client.UsuarioClient;

@Configuration
public class UsuarioClientConf {

	@Bean
	UsuarioClient usuarioClient(HttpClientConf config, @Value("${app.usuario-service.base-url}") String baseUrl) {
		return config.createClient(UsuarioClient.class, baseUrl);
	}
}