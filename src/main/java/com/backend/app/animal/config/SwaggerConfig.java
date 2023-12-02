package com.backend.app.animal.config;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


	@Bean
	public Docket apiDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.backend.app.animal.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Animal", 
				"Servicio para registro de Animales",
				"0.0.1", "Terminos y Servios", 
				new Contact("Alan Perez", "https://facebook.com", "alan.perezlp@uanl.edu.mx"), 
				"LICENSE", "LICENSE URL", Collections.emptyList());
	}
	
}
