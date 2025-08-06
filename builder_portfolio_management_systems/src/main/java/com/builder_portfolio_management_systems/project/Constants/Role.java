package com.builder_portfolio_management_systems.project.Constants;

/**
 * Enum representing different user roles in the Builder Portfolio Management System.
 * 
 * Using enums for roles ensures type safety and avoids hardcoding role names throughout the application.
 */
public enum Role {

    // ADMIN role: Has full access to the system, can manage users, projects, and configurations.
    ADMIN,

    // BUILDER role: Typically represents construction companies or individuals who create and manage projects.
    BUILDER,

    // CLIENT role: Represents customers who view project portfolios, progress, and updates.
    CLIENT
}

