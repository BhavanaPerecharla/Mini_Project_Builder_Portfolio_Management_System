package com.builder_portfolio_management_systems.project.ServiceImpl;

import com.builder_portfolio_management_systems.project.DTO.UserRequest;
import com.builder_portfolio_management_systems.project.DTO.UserResponse;
import com.builder_portfolio_management_systems.project.Model.User;
import com.builder_portfolio_management_systems.project.Mapper.UserMapper;
import com.builder_portfolio_management_systems.project.Repository.UserRepository;
import com.builder_portfolio_management_systems.project.Service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Generates constructor for all final fields (Dependency Injection)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * Creates a new user in the system
     *
     * @param request The request containing user details
     * @return The created user's details in response format
     */
    @Override
    public UserResponse createUser(UserRequest request) {
        // ✅ Check if email already exists BEFORE creating/saving user
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Convert DTO (UserRequest) to Entity (User)
        User user = userMapper.toEntity(request);

        // Hash the password using BCrypt encoder for security
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Save the user entity to the database
        User savedUser = userRepository.save(user);

        // Convert saved entity back to DTO (UserResponse)
        return userMapper.toDto(savedUser);
    }

    /**
     * Retrieves a user by their ID
     *
     * @param id ID of the user
     * @return UserResponse DTO if found
     */
    @Override
    public UserResponse getUserById(Long id) {
        // Search user by ID or throw exception if not found
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Convert to DTO
        return userMapper.toDto(user);
    }

    /**
     * Returns a list of all users in the system
     *
     * @return List of UserResponse DTOs
     */
    @Override
    public List<UserResponse> getAllUsers() {
        // Fetch all users, convert each entity to DTO, and return list
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}

