package com.builder_portfolio_management_systems.project.Controller;

// Importing required DTOs and service
import com.builder_portfolio_management_systems.project.DTO.ProjectRequest;
import com.builder_portfolio_management_systems.project.DTO.ProjectResponse;
import com.builder_portfolio_management_systems.project.Service.ProjectService;

// For request validation
import jakarta.validation.Valid;

// For response handling
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// For returning list of projects
import java.util.List;

// Lombok annotation to generate a constructor for final fields
import lombok.RequiredArgsConstructor;

/**
 * Controller for handling project-related API endpoints.
 * Allows creating, reading, updating, and deleting (CRUD) projects.
 */
@RestController // Marks the class as a REST controller (returns JSON by default)
@RequestMapping("/projects") // Base URL path for all project-related endpoints
@RequiredArgsConstructor // Generates a constructor for the final field (projectService)
public class ProjectController {

    // Injects the ProjectService using constructor injection (preferred with Lombok's @RequiredArgsConstructor)
    private final ProjectService projectService;

    /**
     * Endpoint to create a new project.
     *
     * @param request ProjectRequest object containing project details
     * @return Created ProjectResponse with status 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest request) {
        return ResponseEntity.status(201).body(projectService.createProject(request));
    }

    /**
     * Endpoint to retrieve all projects.
     *
     * @return List of all ProjectResponse objects with status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    /**
     * Endpoint to retrieve a project by its ID.
     *
     * @param id Project ID (extracted from URL path)
     * @return ProjectResponse with the given ID, status 200 (OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    /**
     * Endpoint to update an existing project by ID.
     *
     * @param id Project ID to update
     * @param request New project data to replace existing values
     * @return Updated ProjectResponse with status 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody @Valid ProjectRequest request) {
        return ResponseEntity.ok(projectService.updateProject(id, request));
    }

    /**
     * Endpoint to delete a project by ID.
     *
     * @param id Project ID to delete
     * @return 204 No Content if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
