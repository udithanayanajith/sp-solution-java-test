package com.practical_test.uditha97.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI orderServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("News API")
                        .description("API for News Cat and Headings.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Uditha")
                                .email("uditha.com")));
    }
}
