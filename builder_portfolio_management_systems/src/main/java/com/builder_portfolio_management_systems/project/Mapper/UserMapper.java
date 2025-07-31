package com.builder_portfolio_management_systems.project.Mapper;



import com.builder_portfolio_management_systems.project.DTO.UserRequest;
import com.builder_portfolio_management_systems.project.DTO.UserResponse;
import com.builder_portfolio_management_systems.project.Model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setRole(request.getRole());

        // Do NOT set password here. It's handled in service with hashing.
        return user;
    }

    public UserResponse toDto(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }
}
