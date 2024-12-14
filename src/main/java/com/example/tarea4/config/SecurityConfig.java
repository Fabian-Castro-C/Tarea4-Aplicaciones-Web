package com.example.tarea4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**").authenticated() // Protege /admin
                        .anyRequest().permitAll() // El resto de las rutas son públicas
                )
                .formLogin() // Habilita el formulario de login
                .and()
                .httpBasic(); // Habilita autenticación básica

        return http.build();
    }
}