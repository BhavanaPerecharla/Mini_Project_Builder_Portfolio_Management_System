package com.builder_portfolio_management_systems.project.Controller;


import com.builder_portfolio_management_systems.project.Constants.Role;
import com.builder_portfolio_management_systems.project.DTO.UserRequest;
import com.builder_portfolio_management_systems.project.DTO.UserResponse;
import com.builder_portfolio_management_systems.project.Service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserRequest userRequest;
    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        userRequest = new UserRequest();
        userRequest.setName("Bhavana");
        userRequest.setEmail("bhavana@example.com");
        userRequest.setRole(Role.CLIENT);

        userResponse = new UserResponse();
        userResponse.setId(1L);
        userResponse.setName("Bhavana");
        userResponse.setEmail("bhavana@example.com");
        userResponse.setRole(Role.CLIENT);
    }

    @Test
    void testCreateUser_ShouldReturnCreatedUser() {
        when(userService.createUser(userRequest)).thenReturn(userResponse);

        ResponseEntity<UserResponse> response = userController.createUser(userRequest);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Bhavana", response.getBody().getName());
        assertEquals("bhavana@example.com", response.getBody().getEmail());
    }

    @Test
    void testGetAllUsers_ShouldReturnUserList() {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(userResponse));

        ResponseEntity<List<UserResponse>> response = userController.getAllUsers();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("Bhavana", response.getBody().get(0).getName());
    }


}
