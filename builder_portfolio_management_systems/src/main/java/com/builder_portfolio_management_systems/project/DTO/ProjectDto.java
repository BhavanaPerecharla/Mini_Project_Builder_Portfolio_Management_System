package com.builder_portfolio_management_systems.project.DTO;

// Enum for project status (e.g., UPCOMING, IN_PROGRESS, COMPLETED)
import com.builder_portfolio_management_systems.project.Constants.ProjectStatus;

// Jakarta Bean Validation annotations
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Lombok annotations to reduce boilerplate code
import lombok.*;

/**
 * Data Transfer Object (DTO) for transferring project data between layers
 * (e.g., between controller and service, or between frontend and backend).
 *
 * Includes validation annotations to ensure required fields are provided.
 */
@Data // Generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
@Builder // Enables the builder pattern for object creation
public class ProjectDto {

    // Unique identifier for the project (optional in creation, required in updates)
    private Long id;

    // Title of the project - cannot be null or blank
    @NotBlank(message = "Title is required")
    private String title;

    // Optional description about the project
    private String description;

    // Status of the project (e.g., UPCOMING, IN_PROGRESS, COMPLETED) - cannot be null
    @NotNull(message = "Status is required")
    private ProjectStatus status;

    // ID of the client who owns or is associated with the project - required
    @NotNull(message = "Client ID is required")
    private Long clientId;

    // ID of the builder responsible for the project - required
    @NotNull(message = "Builder ID is required")
    private Long builderId;
}
