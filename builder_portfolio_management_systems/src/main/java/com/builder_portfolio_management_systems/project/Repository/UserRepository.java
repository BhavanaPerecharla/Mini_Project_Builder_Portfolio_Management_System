package com.builder_portfolio_management_systems.project.Repository;


import com.builder_portfolio_management_systems.project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    // Used for login (authentication)
    Optional<User> findByEmail(String email);
}
