package com.example.spring_sample.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Study API",
                version = "0.0.1",
                description = "Spring boot Study API"
        ))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

}
