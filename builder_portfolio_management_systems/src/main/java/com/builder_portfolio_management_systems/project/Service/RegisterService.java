package com.builder_portfolio_management_systems.project.Service;

import com.builder_portfolio_management_systems.project.DTO.RegisterRequest;

/**
 * RegisterService defines the contract for user registration functionality.
 * It handles the creation of new users (ADMIN, CLIENT, BUILDER, etc.)
 * and returns a status message or result.
 */
public interface RegisterService {

    /**
     * Registers a new user based on the provided registration request.
     *
     * @param request RegisterRequest containing name, email, password, and role.
     * @return A String message indicating the success or failure of the registration.
     */
    String registerUser(RegisterRequest request);
}
