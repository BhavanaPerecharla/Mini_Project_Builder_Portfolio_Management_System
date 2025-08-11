-- ============================
-- Table: users
-- ============================
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,                 -- Auto-increment PK
    name VARCHAR(255) NOT NULL,               -- User's name
    email VARCHAR(255) NOT NULL UNIQUE,        -- Unique login email
    password VARCHAR(255) NOT NULL,            -- Login password
    role VARCHAR(50) NOT NULL                  -- ADMIN, BUILDER, CLIENT (Enum stored as String)
);

-- ============================
-- Table: projects
-- ============================
CREATE TABLE projects (
    id BIGSERIAL PRIMARY KEY,                 -- Auto-increment PK
    title VARCHAR(255) NOT NULL,               -- Project title
    description VARCHAR(1000),                 -- Optional description
    status VARCHAR(50) NOT NULL,               -- UPCOMING, IN_PROGRESS, COMPLETED (Enum stored as String)
    client_id BIGINT NOT NULL,                  -- FK to users table (client)
    builder_id BIGINT NOT NULL,                 -- FK to users table (builder)
    
    CONSTRAINT fk_project_client FOREIGN KEY (client_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_project_builder FOREIGN KEY (builder_id) REFERENCES users (id) ON DELETE CASCADE
);


