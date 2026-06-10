# Job Application Tracker API

A Spring Boot REST API for tracking job applications and interviews.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker Compose
- Gradle

## Features

- Create, read, update, and delete job applications
- Filter applications by status
- Search applications by job title
- Add interviews to job applications
- PostgreSQL persistence with Docker
- Basic validation and error handling

## Main Endpoints

### Job Applications

- `GET /api/applications`
- `GET /api/applications/{id}`
- `POST /api/applications`
- `PUT /api/applications/{id}`
- `DELETE /api/applications/{id}`
- `GET /api/applications/status/{status}`
- `GET /api/applications/jobTitle/{jobTitle}`

### Interviews

- `POST /api/interviews/{applicationId}`
- `GET /api/interviews`

## Run Locally

Start PostgreSQL:

```bash
docker compose up -d
