package com.builder_portfolio_management_systems.project.DTO;



import com.builder_portfolio_management_systems.project.Constants.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Status is required")
    private ProjectStatus status;

    @NotNull(message = "Client ID is required")
    private Long clientId;

    @NotNull(message = "Builder ID is required")
    private Long builderId;
}
