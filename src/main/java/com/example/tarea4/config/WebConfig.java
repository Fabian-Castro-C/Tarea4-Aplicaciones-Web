package com.example.tarea4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapea la carpeta "uploads" en la raíz del proyecto a "/uploads/**"
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}