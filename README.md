# ASSIGNMENT 1

# Simple Task Management System

1. Setup Instructions

---

- Ensure Java 17+ and Maven are installed.
- Install and run PostgreSQL.
- Create database and table:

  CREATE DATABASE tasks_db;

  \c taskdb

  CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(255),
  status VARCHAR(255) NOT NULL CHECK (status IN ('pending', 'complete', 'decline')),
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  );

- Configure database credentials in src/main/resources/application.properties:

  spring.application.name=simple-task-management-system

  spring.datasource.url=jdbc:postgresql://localhost:5432/tasks_db
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.datasource.driver-class-name=org.postgresql.Driver

  mybatis.mapper-locations=classpath:mappers/\*.xml
  mybatis.type-aliases-package=com.assignment.simple_task_management_system.model

  server.port=8080

  logging.level.org.mybatis=DEBUG

  logging.level.java.sql=DEBUG

- Run the application:

  mvn spring-boot:run

- The app runs at: http://localhost:8080

---

2. API Endpoints

---

- GET /tasks - List all tasks
- GET /tasks/{id} - Get task by ID
- POST /tasks - Create a new task
- PUT /tasks/{id} - Update a task
- DELETE /tasks/{id} - Delete a task

---

3. Tools / Libraries Used

---

- Spring Boot
- Spring Web
- MyBatis
- PostgreSQL
- Maven
- jakarta Validation API
