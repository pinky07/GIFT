package com.gft.GiFT.common.infraestructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedMethods(HttpMethod.GET.name(),
                            HttpMethod.PUT.name(),
                            HttpMethod.POST.name(),
                            HttpMethod.DELETE.name(),
                            HttpMethod.OPTIONS.name())
                    .allowedOrigins("http://localhost:8080", "http://localhost:4090")
                    .allowedHeaders("Content-Type");
            }
        };
    }

}