package com.builder_portfolio_management_systems.project.DTO;

// Importing Role enum for type-safe user roles
import com.builder_portfolio_management_systems.project.Constants.Role;

// Importing validation annotations
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Lombok annotation to automatically generate getters, setters, toString(), etc.
import lombok.Data;

/**
 * Data Transfer Object (DTO) used for creating or updating a user.
 * 
 * This class defines the expected structure of user input data in request bodies,
 * typically for endpoints like user registration or admin-driven user creation.
 */
@Data // Lombok annotation that generates getters, setters, toString(), equals(), and hashCode()
public class UserRequest {

    /**
     * Full name of the user.
     * Cannot be null or blank.
     */
    @NotBlank(message = "Name is mandatory")
    private String name;

    /**
     * Email address of the user.
     * Must be valid and cannot be blank.
     */
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    /**
     * Password chosen by the user.
     * Cannot be blank.
     */
    @NotBlank(message = "Password is mandatory")
    private String password;

    /**
     * Role assigned to the user.
     * Expected values: ADMIN, CLIENT, BUILDER (defined in Role enum).
     * Note: Optional here, but you can add @NotNull if needed for stricter validation.
     */
    private Role role;
}
