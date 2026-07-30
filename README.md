# Job Application Tracker API

A Spring Boot REST API for tracking job applications and interviews.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Supabase PostgreSQL
- Docker Compose
- Gradle
- Render Deployment

## Features

- Create, read, update, and delete job applications
- Filter applications by status
- Search applications by job title
- Add interviews to job applications
- PostgreSQL persistence
- Supabase cloud database
- Render backend deployment
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

## Deployment

This API is deployed using Render.

The production database is hosted with Supabase PostgreSQL.

## Run Locally

Start PostgreSQL with Docker:

```bash
docker compose up -d
