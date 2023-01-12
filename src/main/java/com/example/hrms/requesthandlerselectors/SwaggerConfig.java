package com.example.hrms.requesthandlerselectors;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;


@Configuration
public class SwaggerConfig {
	@Bean
    public Docket customImplementation() {

        return new Docket(DocumentationType.SWAGGER_2)
        		   .select()
                   .paths(PathSelectors.any())
                   .apis(RequestHandlerSelectors.basePackage("com.example.hrms"))
                   .build()
                   .securitySchemes(Arrays.asList(apiKey()))
                   .securityContexts(Arrays.asList(securityContext()))
                   .apiInfo(apiInfo())
                   .pathMapping("/")
                   .useDefaultResponseMessages(false)
                   .directModelSubstitute(LocalDate.class, String.class)
                   .genericModelSubstitutes(ResponseEntity.class);

    }
	
	 ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Swagger with Spring Boot + Security")
	                .version("1.0.0")
	                .description("Your Description")
	                .contact(new Contact("Kübra Özdemir", "https://www.jforce.com.tr/?gclid=EAIaIQobChMIp7DhqO6e-wIV-o9oCR3wUQmGEAAYASAAEgKGxPD_Bw","kubra.ozdemir@jforce.com"))
	                .build();
	    }
	 private ApiKey apiKey() {
		    return new ApiKey("JWT", "Authorization", "header");
		}

		private SecurityContext securityContext() {
		    return SecurityContext.builder().securityReferences(defaultAuth()).build();
		}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}

}
