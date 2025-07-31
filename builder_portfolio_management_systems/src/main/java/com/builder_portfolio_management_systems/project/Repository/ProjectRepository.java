package com.builder_portfolio_management_systems.project.Repository;



import com.builder_portfolio_management_systems.project.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
