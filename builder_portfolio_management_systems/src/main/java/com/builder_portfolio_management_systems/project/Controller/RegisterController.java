package com.builder_portfolio_management_systems.project.Controller;

// Importing required DTOs and service
import com.builder_portfolio_management_systems.project.DTO.RegisterRequest;
import com.builder_portfolio_management_systems.project.Service.RegisterService;

// For validating the incoming request
import jakarta.validation.Valid;

// For clean constructor injection
import lombok.RequiredArgsConstructor;

// For sending HTTP responses
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that handles user registration functionality.
 * Exposes an endpoint under "/api/register" to allow new users to register.
 */
@RestController  // Indicates this class is a REST controller (JSON responses)
@RequestMapping("/api/register")  // Base URL path for registration-related API
@RequiredArgsConstructor  // Lombok annotation to auto-generate constructor for final fields
public class RegisterController {

    // Injects RegisterService (used to handle the actual registration logic)
    private final RegisterService registerService;

    /**
     * Endpoint to register a new user.
     * 
     * @param request RegisterRequest DTO that contains user registration data
     * @return ResponseEntity with a success message (or error, if applicable)
     */
    @PostMapping  // Handles HTTP POST requests to /api/register
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest request) {
        // Delegates user registration to the service layer
        String result = registerService.registerUser(request);

        // Returns an HTTP 200 OK response with the result message
        return ResponseEntity.ok(result);
    }
}
