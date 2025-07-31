package com.builder_portfolio_management_systems.project.DTO;



import com.builder_portfolio_management_systems.project.Constants.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO used to capture incoming data when creating or updating a Project.
 * This class is used in the request body of POST and PUT operations.
 */
@Data
public class ProjectRequest {

    /**
     * Title of the project (e.g., "Skyline Towers").
     * Must not be null or blank.
     */
    @NotBlank(message = "Project title is required.")
    private String title;

    /**
     * Description of the project detailing scope, size, or purpose.
     * Must not be null or blank.
     */
    @NotBlank(message = "Project description is required.")
    private String description;

    /**
     * Current status of the project.
     * Must be one of the predefined enum values: UPCOMING, IN_PROGRESS, COMPLETED.
     */
    @NotNull(message = "Project status is required (e.g., UPCOMING, IN_PROGRESS, COMPLETED).")
    private ProjectStatus status;

    /**
     * ID of the client who owns the project.
     * Must not be null.
     */
    @NotNull(message = "Client ID is required.")
    private Long clientId;

    /**
     * ID of the builder responsible for executing the project.
     * Must not be null.
     */
    @NotNull(message = "Builder ID is required.")
    private Long builderId;

    /**
     * Default constructor.
     */
    public ProjectRequest() {
        // Default constructor for serialization/deserialization
    }


    /**
     * Constructor to initialize all fields.
     *
     * @param title       Title of the project.
     * @param description Description of the project.
     * @param status      Current status of the project.
     * @param clientId    ID of the client who owns the project.
     * @param builderId   ID of the builder responsible for executing the project.
     */
    public ProjectRequest(String title, String description, ProjectStatus status, Long clientId, Long builderId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.clientId = clientId;
        this.builderId = builderId;

    }
}
