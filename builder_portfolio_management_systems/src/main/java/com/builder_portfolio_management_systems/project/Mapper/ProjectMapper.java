package com.builder_portfolio_management_systems.project.Mapper;



import com.builder_portfolio_management_systems.project.Model.Project;
import com.builder_portfolio_management_systems.project.Model.User;


import com.builder_portfolio_management_systems.project.DTO.ProjectRequest;
import com.builder_portfolio_management_systems.project.DTO.ProjectResponse;
/**
 * ProjectMapper handles the conversion between Project entities and DTOs.
 * This helps separate the persistence layer (Entity) from the data transfer layer (DTO),
 * ensuring clean architecture and better maintainability.
 */

public class ProjectMapper {

    /**
     * Converts a ProjectRequest DTO to a Project entity.
     *
     * @param dto     The incoming project creation request from client.
     * @param client  The User object representing the client.
     * @param builder The User object representing the builder.
     * @return A populated Project entity ready to be saved.
     */
    public static Project toEntity(ProjectRequest dto, User client, User builder) {
        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setClient(client);
        project.setBuilder(builder);
        return project;
    }
    /**
     * Converts a Project entity to a ProjectResponse DTO.
     * This is useful when returning project details to the client.
     *
     * @param project The Project entity from the database.
     * @return A ProjectResponse DTO containing clean, structured response data.
     */

    

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

     /**
     * Converts a Project entity to a ProjectResponse DTO.
     * This method is functionally identical to `toDto()` and may be redundant.
     * Consider removing or renaming for clarity if both are not needed.
     *
     * @param project The Project entity to convert.
     * @return A ProjectResponse DTO with selected project details.
     */
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
