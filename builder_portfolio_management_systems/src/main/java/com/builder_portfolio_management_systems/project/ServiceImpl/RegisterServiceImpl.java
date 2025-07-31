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
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User already registered with this email");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.valueOf(request.getRole().toUpperCase())); // ✅ Correct


        userRepository.save(user);

        // Save to Builder, Client, or Manager table if needed
        // Example: if (request.getRole().equalsIgnoreCase("BUILDER")) { ... }

        return "User registered successfully with role: " + request.getRole();
    }
}
