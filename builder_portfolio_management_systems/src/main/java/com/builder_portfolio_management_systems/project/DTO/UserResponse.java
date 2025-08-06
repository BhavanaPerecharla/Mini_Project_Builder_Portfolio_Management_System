package com.builder_portfolio_management_systems.project.DTO;

import com.builder_portfolio_management_systems.project.Constants.Role; // Enum representing user roles
import lombok.Data; // Lombok annotation to generate boilerplate code like getters, setters, toString(), etc.

/**
 * UserResponse is a Data Transfer Object (DTO) used to send user details
 * back to the client in a safe and structured manner.
 * 
 * This class typically excludes sensitive information such as passwords.
 */
@Data // Lombok generates getters, setters, toString(), equals(), and hashCode() automatically
public class UserResponse {

    /**
     * Unique identifier for the user.
     */
    private Long id;

    /**
     * Full name of the user.
     */
    private String name;

    /**
     * Email address of the user.
     */
    private String email;

    /**
     * Role assigned to the user (e.g., ADMIN, CLIENT, BUILDER).
     */
    private Role role;
}
