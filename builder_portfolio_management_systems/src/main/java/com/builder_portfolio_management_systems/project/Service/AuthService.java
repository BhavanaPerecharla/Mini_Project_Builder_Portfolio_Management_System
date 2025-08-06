package com.builder_portfolio_management_systems.project.Service;

import com.builder_portfolio_management_systems.project.DTO.LoginRequest;
import com.builder_portfolio_management_systems.project.DTO.LoginResponse;
import com.builder_portfolio_management_systems.project.Model.User;
import com.builder_portfolio_management_systems.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * AuthService is responsible for handling authentication logic.
 * It validates user credentials and returns appropriate login responses.
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Authenticates a user using their email and password.
     *
     * @param loginRequest DTO containing user's email and raw password.
     * @return LoginResponse containing user details if authentication is successful.
     * @throws RuntimeException if email doesn't exist or password doesn't match.
     */
    public LoginResponse login(LoginRequest loginRequest) {
        // Fetch user by email. If not found, throw an exception.
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Compare the raw password from request with the encoded password in the database.
        boolean match = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if (!match) {
            throw new RuntimeException("Invalid email or password");
        }

        // If authentication is successful, return user details in response.
        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getRole().name(),
                "Login successful"
        );
    }
}
