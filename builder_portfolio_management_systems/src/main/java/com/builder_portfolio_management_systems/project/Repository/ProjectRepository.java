package com.builder_portfolio_management_systems.project.Repository;

import com.builder_portfolio_management_systems.project.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProjectRepository is the Data Access Layer for the Project entity.
 * It provides built-in CRUD operations and custom query capabilities
 * by extending JpaRepository.
 *
 * - JpaRepository<Project, Long>:
 *     - Project: The entity type managed by this repository.
 *     - Long: The type of the primary key (ID) of the Project entity.
 *
 * Spring Data JPA will automatically generate implementations for
 * common operations such as save(), findById(), findAll(), deleteById(), etc.
 *
 * You can also define custom query methods here if needed.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

 
}
