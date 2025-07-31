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
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest request) {
        // Map DTO to Entity
        User user = userMapper.toEntity(request);

        // Hash the password using BCrypt
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Save the user
        User savedUser = userRepository.save(user);

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }


        // Map back to DTO
        return userMapper.toDto(savedUser);
    }


    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDto(user);
    }


    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
