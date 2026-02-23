package com.cibertec.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cibertec.client.LibroClient;

@Configuration
public class LibroClientConf {

    @Bean
    LibroClient libroClient(HttpClientConf config,
                            @Value("${app.libro-service.base-url}") String baseUrl) {
        return config.createClient(LibroClient.class, baseUrl);
    }
}