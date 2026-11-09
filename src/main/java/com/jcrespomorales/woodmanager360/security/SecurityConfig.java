package com.jcrespomorales.woodmanager360.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    // Registra la cadena de filtros de Spring Security para las peticiones HTTP.
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Desactiva CSRF (útil en APIs stateless o durante desarrollo).
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // Permite todas las rutas sin autenticación.
                .anyRequest().permitAll()
            );

        // Construye y devuelve la configuración final de seguridad.
        return http.build();
    }
}