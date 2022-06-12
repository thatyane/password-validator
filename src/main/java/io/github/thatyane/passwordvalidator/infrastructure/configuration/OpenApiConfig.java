package io.github.thatyane.passwordvalidator.infrastructure.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Value("${api.version}")
    private String apiVersion;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Password Validator - Developer Documentation")
                        .description("API to validate passwords")
                        .version(apiVersion)
                        .contact(contact()))
                .externalDocs(new ExternalDocumentation()
                        .description("Open API YAML")
                        .url("http://localhost:8080/api-docs.yaml"));
    }

    private Contact contact() {
        return new Contact().name("Thatyane Pontes").email("thatyanepontes@gmail.com");
    }
}
