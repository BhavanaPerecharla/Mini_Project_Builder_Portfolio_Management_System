package com.builder_portfolio_management_systems.project.Constants;

/**
 * Enum representing the different statuses a project can have.
 * 
 * This is useful for maintaining type safety and avoiding the use of
 * hard-coded string values when working with project status in the system.
 */
public enum ProjectStatus {
    
    // Indicates that the project is planned but not yet started
    UPCOMING,

    // Indicates that the project is currently in progress
    IN_PROGRESS,

    // Indicates that the project has been finished
    COMPLETED
}

