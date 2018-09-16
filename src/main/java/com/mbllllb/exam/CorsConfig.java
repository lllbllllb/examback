package com.mbllllb.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("*") // TODO: for PRODUCTION replace the "*" for actual origin
                        .allowedMethods("POST", "GET", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .allowCredentials(true)
                        .allowedHeaders("Content-Type")
                        .maxAge(4800);
            }
        };
    }
}