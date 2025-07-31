package com.builder_portfolio_management_systems.project.Service;

import com.builder_portfolio_management_systems.project.DTO.ProjectRequest;
import com.builder_portfolio_management_systems.project.DTO.ProjectResponse;
import com.builder_portfolio_management_systems.project.Model.Project;
import com.builder_portfolio_management_systems.project.Repository.ProjectRepository;
import com.builder_portfolio_management_systems.project.ServiceImpl.ProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.builder_portfolio_management_systems.project.Constants.ProjectStatus;
import com.builder_portfolio_management_systems.project.Model.User;
import com.builder_portfolio_management_systems.project.Repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import com.builder_portfolio_management_systems.project.Constants.Role;
import com.builder_portfolio_management_systems.project.Mapper.ProjectMapper;
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // ✅ Success case
    @Test
    void createProject_shouldSaveAndReturnProjectResponse() {
        Long clientId = 1L;
        Long builderId = 2L;

        ProjectRequest request = new ProjectRequest();
        request.setTitle("Test Project");
        request.setDescription("Test Description");
        request.setStatus(ProjectStatus.IN_PROGRESS);
        request.setClientId(clientId);
        request.setBuilderId(builderId);

        User client = new User();
        client.setId(clientId);
        client.setRole(Role.CLIENT);

        User builder = new User();
        builder.setId(builderId);
        builder.setRole(Role.BUILDER);

        Project savedProject = ProjectMapper.toEntity(request, client, builder);
        savedProject.setId(100L); // Simulate DB-generated ID

        when(userRepository.findById(clientId)).thenReturn(Optional.of(client));
        when(userRepository.findById(builderId)).thenReturn(Optional.of(builder));
        when(projectRepository.save(any(Project.class))).thenReturn(savedProject);

        ProjectResponse response = projectService.createProject(request);

        assertNotNull(response);
        assertEquals(100L, response.getId());
        assertEquals("Test Project", response.getTitle());
        assertEquals("Test Description", response.getDescription());
        assertEquals(ProjectStatus.IN_PROGRESS, response.getStatus());
        assertEquals(clientId, response.getClientId());
        assertEquals(builderId, response.getBuilderId());
    }

    // ❌ Failure: Client not found
    @Test
    void createProject_shouldThrowExceptionWhenClientNotFound() {
        ProjectRequest request = new ProjectRequest();
        request.setClientId(1L);
        request.setBuilderId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            projectService.createProject(request);
        });

        assertEquals("Client not found with ID: 1", ex.getMessage());
        verify(userRepository, times(1)).findById(1L);
    }

    // ❌ Failure: Builder not found
    @Test
    void createProject_shouldThrowExceptionWhenBuilderNotFound() {
        User client = new User();
        client.setId(1L);
        client.setRole(Role.CLIENT);

        ProjectRequest request = new ProjectRequest();
        request.setClientId(1L);
        request.setBuilderId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(client));
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            projectService.createProject(request);
        });

        assertEquals("Builder not found with ID: 2", ex.getMessage());
    }

    // ❌ Failure: Client is not CLIENT role
    @Test
    void createProject_shouldThrowExceptionWhenClientIsNotClientRole() {
        User client = new User();
        client.setId(1L);
        client.setRole(Role.ADMIN); // Wrong role

        User builder = new User();
        builder.setId(2L);
        builder.setRole(Role.BUILDER);

        ProjectRequest request = new ProjectRequest();
        request.setClientId(1L);
        request.setBuilderId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(client));
        when(userRepository.findById(2L)).thenReturn(Optional.of(builder));

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            projectService.createProject(request);
        });

        assertEquals("User with ID 1 is not a CLIENT", ex.getMessage());
    }


}
