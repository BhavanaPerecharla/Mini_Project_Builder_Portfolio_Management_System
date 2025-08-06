package com.builder_portfolio_management_systems.project.Mapper;



import com.builder_portfolio_management_systems.project.DTO.UserRequest;
import com.builder_portfolio_management_systems.project.DTO.UserResponse;
import com.builder_portfolio_management_systems.project.Model.User;
import org.springframework.stereotype.Component;

/**
 * UserMapper is responsible for converting between User entities and DTOs.
 * This abstraction helps in keeping entity logic separate from how data is exposed
 * to the clients or received from them.
 */

@Component
public class UserMapper {

    /**
     * Converts a UserRequest DTO to a User entity.
     * This method is typically used during user registration or creation.
     *
     * @param request The DTO containing user input data.
     * @return A User entity populated with request data.
     */

    public User toEntity(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setRole(request.getRole());

        // Do NOT set password here. It's handled in service with hashing.
        return user;
    }

     /**
     * Converts a User entity to a UserResponse DTO.
     * This is used when sending user data back to the client, excluding sensitive fields.
     *
     * @param user The User entity retrieved from the database.
     * @return A UserResponse DTO with relevant user details.
     */

    public UserResponse toDto(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }
}
