package com.builder_portfolio_management_systems.project.Controller;



import com.builder_portfolio_management_systems.project.DTO.LoginRequest;
import com.builder_portfolio_management_systems.project.DTO.LoginResponse;
import com.builder_portfolio_management_systems.project.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
