package com.builder_portfolio_management_systems.project.Config;

/**
 * AppConfig is a configuration class for defining application-level beans.
 * It helps in managing common configuration-related tasks such as
 * defining password encoders, data sources, etc.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Indicates that this class contains Spring @Bean definitions
@Configuration
public class AppConfig {

     /**
     * This method creates and returns a BCryptPasswordEncoder bean.
     * 
     * BCryptPasswordEncoder is used for hashing passwords securely.
     * It's a strong algorithm that applies a salt automatically and
     * is widely used for securing user passwords in Spring Security.
     * 
     * @return BCryptPasswordEncoder instance to be managed by Spring container
     */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
