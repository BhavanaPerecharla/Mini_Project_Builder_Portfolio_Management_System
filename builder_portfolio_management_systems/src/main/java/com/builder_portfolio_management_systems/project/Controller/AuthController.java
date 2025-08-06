package com.builder_portfolio_management_systems.project.Controller;

// Importing required classes and annotations
import com.builder_portfolio_management_systems.project.DTO.LoginRequest;
import com.builder_portfolio_management_systems.project.DTO.LoginResponse;
import com.builder_portfolio_management_systems.project.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for handling authentication-related API requests.
 * Exposes endpoints under the "/auth" path.
 */
@RestController  // Marks this class as a REST controller where each method returns a JSON response
@RequestMapping("/auth")  // Base URL path for all endpoints in this controller
@CrossOrigin  // Enables Cross-Origin Resource Sharing (CORS) to allow frontend apps (e.g. Vue/React) to access this API
public class AuthController {

    // Injects the AuthService dependency
    @Autowired
    private AuthService authService;

    /**
     * Handles user login requests.
     * 
     * @param loginRequest contains the user's email and password
     * @return ResponseEntity with a JWT token or relevant login response
     */
    @PostMapping("/login")  // Maps HTTP POST requests to /auth/login
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        // Delegates login logic to AuthService
        LoginResponse response = authService.login(loginRequest);
        // Returns the response wrapped in HTTP 200 OK
        return ResponseEntity.ok(response);
    }
}
