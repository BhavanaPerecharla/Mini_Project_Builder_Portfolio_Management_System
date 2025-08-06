package com.builder_portfolio_management_systems.project.Service;

import java.util.List;

import com.builder_portfolio_management_systems.project.DTO.ProjectRequest;
import com.builder_portfolio_management_systems.project.DTO.ProjectResponse;

/**
 * ProjectService defines the contract for all project-related operations.
 * It includes methods for creating, retrieving, updating, and deleting projects.
 */
public interface ProjectService {

    /**
     * Creates a new project based on the provided request data.
     *
     * @param request ProjectRequest containing project title, description, builder/client info, etc.
     * @return ProjectResponse containing the details of the newly created project.
     */
    ProjectResponse createProject(ProjectRequest request);

    /**
     * Retrieves a list of all existing projects.
     *
     * @return List of ProjectResponse representing all projects in the system.
     */
    List<ProjectResponse> getAllProjects();

    /**
     * Retrieves a specific project by its unique ID.
     *
     * @param id Unique identifier of the project.
     * @return ProjectResponse containing project details if found.
     */
    ProjectResponse getProjectById(Long id);

    /**
     * Updates an existing project with new data.
     *
     * @param id      ID of the project to update.
     * @param request ProjectRequest with updated data.
     * @return ProjectResponse containing the updated project information.
     */
    ProjectResponse updateProject(Long id, ProjectRequest request);

    /**
     * Deletes a project by its ID.
     *
     * @param id ID of the project to be deleted.
     */
    void deleteProject(Long id);
}
