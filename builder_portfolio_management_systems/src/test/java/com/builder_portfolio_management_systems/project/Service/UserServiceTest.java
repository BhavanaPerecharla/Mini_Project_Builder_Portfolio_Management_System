package com.builder_portfolio_management_systems.project.Service;

import com.builder_portfolio_management_systems.project.Constants.Role;
import com.builder_portfolio_management_systems.project.DTO.UserRequest;
import com.builder_portfolio_management_systems.project.DTO.UserResponse;
import com.builder_portfolio_management_systems.project.Mapper.UserMapper;
import com.builder_portfolio_management_systems.project.Model.User;
import com.builder_portfolio_management_systems.project.Repository.UserRepository;
import com.builder_portfolio_management_systems.project.ServiceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void createUser_shouldSaveAndReturnUserResponse() {
        // Arrange
        UserRequest request = new UserRequest();
        request.setName("MaheshBabu");
        request.setEmail("maheshbabu@gmail.com");
        request.setPassword("password123");
        request.setRole(Role.CLIENT);

        User userEntity = new User();
        userEntity.setName("MaheshBabu");
        userEntity.setEmail("maheshbabu@gmail.com");
        userEntity.setPassword("encodedPassword");
        userEntity.setRole(Role.CLIENT);

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setName("MaheshBabu");
        savedUser.setEmail("maheshbabu@gmail.com");
        savedUser.setPassword("encodedPassword");
        savedUser.setRole(Role.CLIENT);

        UserResponse expectedResponse = new UserResponse();
        expectedResponse.setId(1L);
        expectedResponse.setName("MaheshBabu");
        expectedResponse.setEmail("maheshbabu@gmail.com");
        expectedResponse.setRole(Role.CLIENT);

        // Mock behaviors
        when(userMapper.toEntity(request)).thenReturn(userEntity);
        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");
        when(userRepository.save(userEntity)).thenReturn(savedUser);
        when(userMapper.toDto(savedUser)).thenReturn(expectedResponse);

        // Act
        UserResponse result = userService.createUser(request);

        // Assert
        assertEquals(expectedResponse.getId(), result.getId());
        assertEquals(expectedResponse.getName(), result.getName());
        assertEquals(expectedResponse.getEmail(), result.getEmail());
        assertEquals(expectedResponse.getRole(), result.getRole()); // Enum comparison is fine
    }

    @Test
    void getAllUsers_shouldReturnListOfUserResponses() {
        // Arrange
        User user1 = new User(1L, "Bhavana", "bhavana@gmail.com", "pass", Role.ADMIN);
        User user2 = new User(2L, "Krishna", "krishna@gmail.com", "pass", Role.CLIENT);

        UserResponse response1 = new UserResponse();
        response1.setId(1L);
        response1.setName("Bhavana");
        response1.setEmail("bhavana@gmail.com");
        response1.setRole(Role.ADMIN);

        UserResponse response2 = new UserResponse();
        response2.setId(2L);
        response2.setName("Krishna");
        response2.setEmail("krishna@gmail.com");
        response2.setRole(Role.CLIENT);


        when(userRepository.findAll()).thenReturn(List.of(user1, user2));
        when(userMapper.toDto(user1)).thenReturn(response1);
        when(userMapper.toDto(user2)).thenReturn(response2);

        // Act
        List<UserResponse> result = userService.getAllUsers();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Bhavana", result.get(0).getName());
        assertEquals(Role.CLIENT, result.get(1).getRole());
    }
}
