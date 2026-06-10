# BIMU Spring Backend

Backend REST API for BIMU, a cycling route management platform.

This project is a Spring Boot backend built to demonstrate backend development skills with Java, REST APIs, authentication, PostgreSQL and clean backend structure.

## Tech Stack

* Java 17
* Spring Boot 3.5.15
* Spring Web
* Spring Security
* JWT Authentication
* Spring Data JPA
* PostgreSQL
* H2 local database
* Swagger / OpenAPI
* Gradle
* JUnit

## Current Features

* User registration
* User login
* JWT-based authentication
* Protected endpoints
* Basic route CRUD structure
* Swagger documentation
* H2 local profile for quick development
* PostgreSQL Docker setup for realistic backend development

## Run locally with H2

```bash
gradle bootRun
```

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

H2 Console:

```text
http://localhost:8080/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:bimu
```

## Run PostgreSQL with Docker

```bash
docker compose up -d
```

Then run:

```bash
gradle bootRun --args='--spring.profiles.active=postgres'
```

## Main Endpoints

### Auth

```http
POST /api/auth/register
POST /api/auth/login
```

### Routes

```http
GET /api/routes
GET /api/routes/{id}
POST /api/routes
DELETE /api/routes/{id}
```

### Test protected endpoint

```http
GET /api/users/me
```

## Project Goal

The goal of this project is to rebuild the backend of BIMU using a more enterprise-oriented Java stack, focusing on maintainability, security and scalability.
