package com.builder_portfolio_management_systems.project.DTO;



public class LoginResponse {

    private Long userId;
    private String name;
    private String role;
    private String message;

    public LoginResponse(Long userId, String name, String role, String message) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.message = message;
    }

    // Getters
    public Long getUserId() { return userId; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getMessage() { return message; }
}
