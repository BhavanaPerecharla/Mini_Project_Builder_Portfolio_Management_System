package com.builder_portfolio_management_systems.project.Repository;

import com.builder_portfolio_management_systems.project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserRepository is the Data Access Layer for the User entity.
 * It extends JpaRepository to provide built-in CRUD operations and
 * allows the definition of custom queries.
 *
 * - JpaRepository<User, Long>:
 *     - User: Entity class this repository manages.
 *     - Long: Type of the primary key of the User entity.
 *
 * Spring Data JPA auto-generates method implementations at runtime.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Checks if a user already exists with the given email.
     *
     * @param email The email to check.
     * @return true if a user exists with the email, false otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * Retrieves a user by their email.
     * Used during authentication to verify user credentials.
     *
     * @param email The user's email.
     * @return Optional containing User if found, or empty if not found.
     */
    Optional<User> findByEmail(String email);
}
