package com.fundooapp.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Fundoo Notes API", version = "1.0", description = "Fundoo Notes User Management API"))
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT", in = SecuritySchemeIn.HEADER)
public class OpenApiConfig {

}