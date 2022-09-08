package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.service.DBService;

@Configuration
@Profile("dev")
public class TestConfig {
	
	@Autowired
	private DBService service;

	@Bean
	public void inicializar() {
		service.inicializarBancoDado();
	}
}
