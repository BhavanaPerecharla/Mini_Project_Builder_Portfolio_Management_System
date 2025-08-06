package com.builder_portfolio_management_systems.project.Config;

// Importing required Spring Security and configuration classes
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.context.annotation.Bean;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig class configures the security settings for the application.
 * It defines how HTTP requests are secured using Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Defines the security filter chain bean that customizes the security behavior.
     * 
     * @param http the HttpSecurity object used to configure web based security
     * @return a SecurityFilterChain bean that Spring Security uses to secure the application
     * @throws Exception in case of configuration errors
     */
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disables CSRF protection. Useful in stateless APIs or for simplicity in development.
        http
                .csrf(csrf -> csrf.disable()) // disable CSRF
             // Configures authorization rules for HTTP requests
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // allow all requests
                )
            // Enables HTTP Basic authentication with default settings
                .httpBasic(Customizer.withDefaults()); 

       // Builds and returns the configured SecurityFilterChain
        return http.build();
    }
}
