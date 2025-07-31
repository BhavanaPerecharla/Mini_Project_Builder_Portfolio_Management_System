package com.builder_portfolio_management_systems.project.DTO;


import com.builder_portfolio_management_systems.project.Constants.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    private Role role; // e.g., ADMIN, CLIENT, BUILDER
}
