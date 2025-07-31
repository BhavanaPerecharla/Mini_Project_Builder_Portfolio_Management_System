package com.builder_portfolio_management_systems.project.DTO;



import com.builder_portfolio_management_systems.project.Constants.Role;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private Role role;
}
