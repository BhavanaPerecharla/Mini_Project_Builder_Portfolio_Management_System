package com.builder_portfolio_management_systems.project.Controller;



import com.builder_portfolio_management_systems.project.DTO.RegisterRequest;
import com.builder_portfolio_management_systems.project.Service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;


    @PostMapping
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest request) {
        String result = registerService.registerUser(request);
        return ResponseEntity.ok(result);
    }
}
