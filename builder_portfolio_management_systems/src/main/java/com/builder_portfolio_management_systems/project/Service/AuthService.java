package com.builder_portfolio_management_systems.project.Service;



import com.builder_portfolio_management_systems.project.DTO.LoginRequest;
import com.builder_portfolio_management_systems.project.DTO.LoginResponse;
import com.builder_portfolio_management_systems.project.Model.User;
import com.builder_portfolio_management_systems.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        boolean match = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if (!match) {
            throw new RuntimeException("Invalid email or password");
        }

        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getRole().name(),
                "Login successful"
        );
    }
}
