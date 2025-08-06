package com.builder_portfolio_management_systems.project.DTO;

// Importing validation annotations
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for login requests.
 * 
 * This class is used to capture and validate the login credentials
 * (email and password) sent by the user during authentication.
 */
public class LoginRequest {

    /**
     * User's email address.
     * 
     * - Must be a valid email format (e.g., user@example.com)
     * - Cannot be null or blank
     */
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    private String email;

    /**
     * User's password.
     * 
     * - Cannot be null or blank
     */
    @NotBlank(message = "Password is required")
    private String password;

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
