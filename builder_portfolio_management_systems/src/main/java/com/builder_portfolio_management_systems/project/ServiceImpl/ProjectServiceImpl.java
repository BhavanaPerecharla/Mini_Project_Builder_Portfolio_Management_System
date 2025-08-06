package com.builder_portfolio_management_systems.project.ServiceImpl;



import com.builder_portfolio_management_systems.project.Constants.Role;
import com.builder_portfolio_management_systems.project.DTO.ProjectRequest;
import com.builder_portfolio_management_systems.project.DTO.ProjectResponse;
import com.builder_portfolio_management_systems.project.Mapper.ProjectMapper;
import com.builder_portfolio_management_systems.project.Model.Project;
import com.builder_portfolio_management_systems.project.Model.User;
import com.builder_portfolio_management_systems.project.Repository.ProjectRepository;
import com.builder_portfolio_management_systems.project.Repository.UserRepository;
import com.builder_portfolio_management_systems.project.Service.ProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of ProjectService to handle all business logic related to projects.
 */

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a new project after validating builder and client roles.
     *
     * @param request ProjectRequest containing project and user (builder & client) info.
     * @return ProjectResponse representing the created project.
     */
    
    @Override
    public ProjectResponse createProject(ProjectRequest request) {

        // Validate client
        
        User client = userRepository.findById(request.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found with ID: " + request.getClientId()));
        if (client.getRole() != Role.CLIENT) {
            throw new IllegalArgumentException("User with ID "+ request.getClientId()+" is not a CLIENT");
        }

          // Validate builder
        User builder = userRepository.findById(request.getBuilderId())
                .orElseThrow(() -> new IllegalArgumentException("Builder not found with ID: " + request.getBuilderId()));
        if (builder.getRole() != Role.BUILDER) {
            throw new IllegalArgumentException("User with ID "+ request.getBuilderId()+" is not a BUILDER");
        }

        Project project = ProjectMapper.toEntity(request, client, builder);
        Project saved = projectRepository.save(project);
        return ProjectMapper.toResponse(saved);
    }

    /**
     * Fetches and returns all projects from the repository.
     *
     * @return List of ProjectResponse.
     */

    @Override
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectMapper::toResponse)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a single project by its ID.
     *
     * @param id Project ID.
     * @return ProjectResponse if found.
     */
    
    @Override
    public ProjectResponse getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return ProjectMapper.toResponse(project);
    }

    /**
     * Updates a project's details by its ID.
     *
     * @param id Project ID to update.
     * @param request ProjectRequest containing updated data.
     * @return Updated ProjectResponse.
     */

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Project existing = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        User client = userRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        User builder = userRepository.findById(request.getBuilderId())
                .orElseThrow(() -> new RuntimeException("Builder not found"));

        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setStatus(request.getStatus());
        existing.setClient(client);
        existing.setBuilder(builder);

        Project updated = projectRepository.save(existing);
        return ProjectMapper.toResponse(updated);
    }

     /**
     * Deletes a project by its ID.
     *
     * @param id Project ID to delete.
     */
    @Override
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found");
        }
        projectRepository.deleteById(id);
    }
}
