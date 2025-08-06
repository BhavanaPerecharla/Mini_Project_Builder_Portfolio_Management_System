package com.builder_portfolio_management_systems.project.DTO;

// Enum representing the status of the project
import com.builder_portfolio_management_systems.project.Constants.ProjectStatus;

// Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
import lombok.Data;

/**
 * Data Transfer Object (DTO) used to send project data in API responses.
 * 
 * This class represents the structure of project information returned
 * to the client (frontend) after a project is created, fetched, or updated.
 */
@Data // Lombok annotation to generate boilerplate code (getters, setters, etc.)
public class ProjectResponse {

    // Unique identifier of the project
    private Long id;

    // Title of the project
    private String title;

    // Optional description about the project
    private String description;

    // Current status of the project (e.g., UPCOMING, IN_PROGRESS, COMPLETED)
    private ProjectStatus status;

    // ID of the client associated with the project
    private Long clientId;

    // ID of the builder responsible for the project
    private Long builderId;

    /**
     * No-argument constructor.
     * Required for frameworks like Jackson for JSON serialization/deserialization.
     */
    public ProjectResponse() {
    }

    /**
     * All-arguments constructor to quickly initialize all fields.
     * 
     * @param id          Project ID
     * @param title       Project title
     * @param description Project description
     * @param status      Project status
     * @param clientId    ID of the associated client
     * @param builderId   ID of the associated builder
     */
    public ProjectResponse(Long id, String title, String description, ProjectStatus status, Long clientId, Long builderId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.clientId = clientId;
        this.builderId = builderId;
    }
}
