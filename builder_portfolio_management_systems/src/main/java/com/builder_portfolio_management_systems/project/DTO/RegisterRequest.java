package com.builder_portfolio_management_systems.project.DTO;

// Importing validation constraints
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Lombok annotations for generating boilerplate code
import lombok.*;

/**
 * Data Transfer Object (DTO) for user registration requests.
 * 
 * This class is used to collect and validate the data sent by a user during registration.
 */
@Data // Generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Generates a no-args constructor (required for deserialization)
@AllArgsConstructor // Generates a constructor with all fields
public class RegisterRequest {

    /**
     * Full name of the user.
     * Cannot be blank.
     */
    @NotBlank(message = "Name is required")
    private String name;

    /**
     * Email address of the user.
     * Must be a valid email format.
     */
    @Email(message = "Invalid email format")
    private String email;

    /**
     * Password chosen by the user.
     * Cannot be blank.
     */
    @NotBlank(message = "Password is required")
    private String password;

    /**
     * Role assigned to the user upon registration.
     * Expected values: ADMIN, BUILDER, CLIENT, MANAGER.
     * Cannot be blank.
     */
    @NotBlank(message = "Role is required")
    private String role;
}
