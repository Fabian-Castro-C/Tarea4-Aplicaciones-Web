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
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/admin/**").authenticated() // Protege /admin
                        .anyRequest().permitAll() // El resto de las rutas son públicas
                )
                .formLogin(form -> form
                        // No se especifica loginPage, se usa el formulario predeterminado
                        .defaultSuccessUrl("/admin", true) // Redirige a /admin tras un login exitoso
                        .permitAll() // Permite acceso al formulario de login sin autenticación
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL para cerrar sesión
                        .logoutSuccessUrl("/") // Redirige al inicio tras cerrar sesión
                        .permitAll()
                );

        return http.build();
    }
}
