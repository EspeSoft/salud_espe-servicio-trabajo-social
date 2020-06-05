package com.saludespe.trabajosocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication
public class SaludespeServicioTrabajoSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaludespeServicioTrabajoSocialApplication.class, args);
	}

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.saludespe.trabajosocial"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Servicio Trabajo Social API",
				"Documentacion generada para el servicio trabajo social",
				"1.0",
				"Derechos reservados",
				new Contact("Universidad de las Fuerzas Armadas", "https://github.com/diegoismael81", "diegoismael81@gmail.com"),
				"API Licence", "https://www.espe.edu.ec/", Collections.emptyList());
	}

}
