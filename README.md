# Mini_Project_Builder_Portfolio_Management_System
A role-based portfolio management system for builders, clients, and admins to manage construction projects, tasks, budgets, and timelines.

This is a Spring Boot-based mini project that manages user registrations and project portfolios for a real estate company. It supports CRUD operations for users and projects with role-based logic for **Admins**, **Clients**, **Builders**

---

## ✅ Features

- User Management (`User`):
  - Register users with role-based logic (Admin, Builder, Client)
  - View all users
- Project Management (`Project`):
  - Create and fetch project details
  - Associate projects with Clients and Builders
- REST API architecture
- DTO → Entity mapping using custom mappers
- Clean layered architecture
- Unit tests for services and controllers using JUnit and Mockito

---


## 📁 Project Structure
com.builder_portfolio_management_systems.project

│

├── config/ # Spring Security or Swagger configs (optional)

├── constants/ # Enums like Role and ProjectStatus

├── controller/ # REST Controllers (API endpoints)

├── dto/ # Data Transfer Objects (Request/Response)

├── mapper/ # Mappers to convert between DTOs and Entities

├── model/ # Entity classes mapped to PostgreSQL tables

├── repository/ # Spring Data JPA Repositories

├── service/ # Interfaces for business logic

├── serviceImpl/ # Implementations of the service interfaces

├── exception/ # Global exception handling (optional)

└── BuilderPortfolioManagementSystemsApplication.java # Main app class


---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven
- JUnit & Mockito (for unit testing)
- Postman (for API testing)

---


### 🖥️ Prerequisites

- Java 17+
- Maven
- PostgreSQL (running locally)
- IDE like IntelliJ / VS Code

Author

Bhavana Perecharla






