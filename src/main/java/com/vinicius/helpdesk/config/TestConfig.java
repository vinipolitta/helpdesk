package com.vinicius.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.helpdesk.services.DBServices;

@Configuration
@Profile("dev")
public class TestConfig {
	
	@Autowired
	private DBServices dbService;
	
	@Bean
	public void instanciaDB() {
		this.dbService.instaciaDB();
	}
}
