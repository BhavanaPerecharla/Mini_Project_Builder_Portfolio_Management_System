package com.builder_portfolio_management_systems.project.Service;

import com.builder_portfolio_management_systems.project.DTO.RegisterRequest;

public interface RegisterService {
    String registerUser(RegisterRequest request);
}