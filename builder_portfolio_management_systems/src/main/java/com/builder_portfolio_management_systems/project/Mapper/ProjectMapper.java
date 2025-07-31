package com.builder_portfolio_management_systems.project.Mapper;



import com.builder_portfolio_management_systems.project.Model.Project;
import com.builder_portfolio_management_systems.project.Model.User;


import com.builder_portfolio_management_systems.project.DTO.ProjectRequest;
import com.builder_portfolio_management_systems.project.DTO.ProjectResponse;


public class ProjectMapper {

    public static Project toEntity(ProjectRequest dto, User client, User builder) {
        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setClient(client);
        project.setBuilder(builder);
        return project;
    }

    public static ProjectResponse toDto(Project project) {
        ProjectResponse dto = new ProjectResponse();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setDescription(project.getDescription());
        dto.setStatus(project.getStatus());
        dto.setClientId(project.getClient().getId());
        dto.setBuilderId(project.getBuilder().getId());
        return dto;
    }
    public static ProjectResponse toResponse(Project project) {
        ProjectResponse dto = new ProjectResponse();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setDescription(project.getDescription());
        dto.setStatus(project.getStatus());
        dto.setClientId(project.getClient().getId());
        dto.setBuilderId(project.getBuilder().getId());
        return dto;
    }
}
