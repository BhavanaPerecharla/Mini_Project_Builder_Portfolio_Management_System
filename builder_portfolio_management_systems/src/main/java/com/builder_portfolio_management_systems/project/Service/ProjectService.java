package com.builder_portfolio_management_systems.project.Service;


import java.util.List;


import com.builder_portfolio_management_systems.project.DTO.ProjectRequest;
import com.builder_portfolio_management_systems.project.DTO.ProjectResponse;


public interface ProjectService {
    ProjectResponse createProject(ProjectRequest request);
    List<ProjectResponse> getAllProjects();
    ProjectResponse getProjectById(Long id);
    ProjectResponse updateProject(Long id, ProjectRequest request);
    void deleteProject(Long id);
}
