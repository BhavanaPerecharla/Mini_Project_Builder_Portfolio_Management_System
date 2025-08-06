package com.builder_portfolio_management_systems.project.Service;


import java.util.List;

import com.builder_portfolio_management_systems.project.DTO.UserRequest;
import com.builder_portfolio_management_systems.project.DTO.UserResponse;

/**
 * UserService interface provides operations related to user management.
 * It abstracts business logic for creating, retrieving, and managing user data.
 */
public interface UserService {

    /**
     * Creates a new user from the given request data.
     *
     * @param request UserRequest object containing user details (name, email, password, role).
     * @return UserResponse representing the created user.
     */
    UserResponse createUser(UserRequest request);

    /**
     * Retrieves a list of all users in the system.
     *
     * @return List of UserResponse objects representing all users.
     */
    List<UserResponse> getAllUsers();

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id Long - Unique identifier of the user.
     * @return UserResponse representing the user with the given ID.
     */
    UserResponse getUserById(Long id);
}
