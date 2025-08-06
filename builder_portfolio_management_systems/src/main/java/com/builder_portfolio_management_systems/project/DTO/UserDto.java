package com.builder_portfolio_management_systems.project.DTO;

// Importing Role enum for user roles (ADMIN, BUILDER, CLIENT, etc.)
import com.builder_portfolio_management_systems.project.Constants.Role;

// Importing validation annotations
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Importing Lombok annotations
import lombok.*;

/**
 * Data Transfer Object (DTO) for transferring user information across layers.
 * 
 * Used when creating, updating, or retrieving user data in a safe and structured way.
 */
@Data // Generates getters, setters, toString(), equals(), and hashCode() methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
@Builder // Enables the builder pattern for easy object creation
public class UserDto {

    // Unique identifier for the user (optional in creation, used during update or response)
    private Long id;

    // User's full name; must not be blank
    @NotBlank(message = "Name is required")
    private String name;

    // User's email; must be a valid email format and not blank
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    // User's password; must not be blank
    @NotBlank(message = "Password is required")
    private String password;

    // User's role; cannot be null; defined by Role enum (ADMIN, BUILDER, CLIENT, etc.)
    @NotNull(message = "Role is required")
    private Role role;
}
