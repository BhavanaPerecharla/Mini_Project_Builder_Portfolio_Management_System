package com.builder_portfolio_management_systems.project.DTO;


import com.builder_portfolio_management_systems.project.Constants.ProjectStatus;
import lombok.Data;

@Data
public class ProjectResponse {
    private Long id;
    private String title;
    private String description;
    private ProjectStatus status;
    private Long clientId;
    private Long builderId;

    public ProjectResponse() {
    }
    public ProjectResponse(Long id, String title, String description, ProjectStatus status, Long clientId, Long builderId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.clientId = clientId;
        this.builderId = builderId;
    }

}
