package com.builder_portfolio_management_systems.project.DTO;

/**
 * Data Transfer Object (DTO) for login response.
 * 
 * This class is used to send back user-related information
 * after successful authentication, such as user ID, name,
 * role, and a custom message.
 */
public class LoginResponse {

    // Unique identifier of the user
    private Long userId;

    // Full name of the logged-in user
    private String name;

    // Role of the user (e.g., ADMIN, BUILDER, CLIENT)
    private String role;

    // Custom message to include in the response (e.g., "Login successful")
    private String message;

    /**
     * Parameterized constructor to initialize all fields of the response.
     *
     * @param userId  ID of the user
     * @param name    Name of the user
     * @param role    Role of the user
     * @param message Response message
     */
    public LoginResponse(Long userId, String name, String role, String message) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.message = message;
    }

    // Getter for userId
    public Long getUserId() {
        return userId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for role
    public String getRole() {
        return role;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }
}
