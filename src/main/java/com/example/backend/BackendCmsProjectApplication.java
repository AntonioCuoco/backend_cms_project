package com.example.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendCmsProjectApplication {

	public static void main(String[] args) {
			System.setProperty("spring.devtools.restart.enabled", "false");
			SpringApplication.run(BackendCmsProjectApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
