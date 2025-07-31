package com.builder_portfolio_management_systems.project.Controller;



import com.builder_portfolio_management_systems.project.Constants.ProjectStatus;
import com.builder_portfolio_management_systems.project.DTO.ProjectRequest;
import com.builder_portfolio_management_systems.project.DTO.ProjectResponse;
import com.builder_portfolio_management_systems.project.Service.ProjectService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;


class ProjectControllerTest {

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectController projectController;

    private ProjectRequest projectRequest;
    private ProjectResponse projectResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        projectRequest = new ProjectRequest();
        projectRequest.setTitle("Green Villas");
        projectRequest.setDescription("Luxury apartments");
        projectRequest.setStatus(ProjectStatus.UPCOMING);
        projectRequest.setClientId(1L);
        projectRequest.setBuilderId(2L);

        projectResponse = new ProjectResponse();
        projectResponse.setId(1L);
        projectResponse.setTitle("Green Villas");
        projectResponse.setDescription("Luxury apartments");
        projectResponse.setStatus(ProjectStatus.UPCOMING);
        projectResponse.setClientId(1L);
        projectResponse.setBuilderId(2L);
    }

    @Test
    void testCreateProject_ShouldReturnCreatedProject() {
        when(projectService.createProject(projectRequest)).thenReturn(projectResponse);

        ResponseEntity<ProjectResponse> response = projectController.createProject(projectRequest);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(projectResponse.getTitle(), response.getBody().getTitle());

        verify(projectService, times(1)).createProject(projectRequest);
    }

    @Test
    void testGetAllProjects_ShouldReturnList() {
        when(projectService.getAllProjects()).thenReturn(Arrays.asList(projectResponse));

        ResponseEntity<List<ProjectResponse>> response = projectController.getAllProjects();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(projectService, times(1)).getAllProjects();
    }
}
