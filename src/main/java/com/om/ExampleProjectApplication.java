package com.om;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleProjectApplication.class, args);
	}

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
}
