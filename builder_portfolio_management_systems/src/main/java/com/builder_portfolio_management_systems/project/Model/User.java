package com.builder_portfolio_management_systems.project.Model;



import com.builder_portfolio_management_systems.project.Constants.Role;
import jakarta.persistence.*;
import lombok.*;


/**
 * Entity class representing a User in the system.
 * A User can have roles like ADMIN, CLIENT, or BUILDER.
 */
@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email; // Used for login; must be unique

    @Column(nullable = false)
    private String password; // Used for login authentication

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // ADMIN, BUILDER, CLIENT

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
