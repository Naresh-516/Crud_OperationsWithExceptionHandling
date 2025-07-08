package com.nt.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI employeeAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee API")
                        .version("1.0")
                        .description("Jala Academy Employee Management System")
                        .contact(new Contact()
                                .name("Kashetti Naresh")
                                .email("naresh.kashetti@example.com")));
    }
}
