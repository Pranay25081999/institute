package com.example.institute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.*")
public class InstituteApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
	return springApplicationBuilder.sources(InstituteApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(InstituteApplication.class, args);
	}

}
