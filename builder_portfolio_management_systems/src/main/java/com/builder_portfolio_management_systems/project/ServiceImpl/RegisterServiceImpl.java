package com.builder_portfolio_management_systems.project.ServiceImpl;

import com.builder_portfolio_management_systems.project.Constants.Role;
import com.builder_portfolio_management_systems.project.DTO.RegisterRequest;
import com.builder_portfolio_management_systems.project.Exception.UserAlreadyExistsException;
import com.builder_portfolio_management_systems.project.Model.User;
import com.builder_portfolio_management_systems.project.Repository.UserRepository;
import com.builder_portfolio_management_systems.project.Service.RegisterService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  // Lombok annotation to generate constructor for final fields
public class RegisterServiceImpl implements RegisterService {

    // Injecting dependencies via constructor
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Registers a new user based on the RegisterRequest DTO
     * 
     * @param request contains name, email, password, and role of the user
     * @return success message after user is saved in the database
     */
    @Override
    public String registerUser(RegisterRequest request) {
        // Check if a user already exists with the same email
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User already registered with this email");
        }

        // Create a new user entity and populate it from the request
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Encrypt the password before storing it
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Convert the provided role (String) to enum value (case-insensitive)
        user.setRole(Role.valueOf(request.getRole().toUpperCase())); // e.g., "builder" -> Role.BUILDER

        // Save the user to the database
        userRepository.save(user);

        // Optional: You can handle role-specific tables here if needed
        // Example: if (request.getRole().equalsIgnoreCase("BUILDER")) { save to builder table }

        return "User registered successfully with role: " + request.getRole();
    }
}

