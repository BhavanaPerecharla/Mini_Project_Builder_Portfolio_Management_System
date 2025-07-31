package com.builder_portfolio_management_systems.project.Model;



import com.builder_portfolio_management_systems.project.Constants.ProjectStatus;
import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class representing a Project.
 * Each project is linked to a client and a builder (both are Users).
 */
@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Project ID (Primary Key)

    @Column(nullable = false)
    private String title; // Project title

    @Column(length = 1000)
    private String description; // Project description

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus status; // Enum: UPCOMING, IN_PROGRESS, COMPLETED

    // Relation to client (user with CLIENT role)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    // Relation to builder (user with BUILDER role)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "builder_id", nullable = false)
    private User builder;
}
