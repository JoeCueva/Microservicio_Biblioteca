package com.cibertec.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class JacksonConf {
	@Bean
	ObjectMapper jsonMapper() {
		return new ObjectMapper()
				.registerModule(new JavaTimeModule());
	}
}
