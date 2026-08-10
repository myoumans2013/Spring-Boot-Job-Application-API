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

### Job Applications

- `GET /api/applications/getAll`
- `GET /api/applications/getApplication/{id}`
- `POST /api/applications/createApplication`
- `PUT /api/applications/updateApplication/{id}`
- `DELETE /api/applications/deleteApplication/{id}`
- `DELETE /api/applications/deleteAll`
- `GET /api/applications/status/{status}`
- `GET /api/applications/jobTitle/{jobTitle}`

### Interviews

- `POST /api/interviews/createInterview/{id}`
- `GET /api/interviews/getMostRecentInterview/{id}`
- `GET /api/interviews/getAll`
- `GET /api/interviews/JopAppInterviews/{id}`
- `DELETE /api/interviews/deleteInterview/{id}`
- `DELETE /api/interviews/deleteAll`

## Deployment

This API is deployed using Render.

The production database is hosted with Supabase PostgreSQL.

## Run Locally

Start PostgreSQL with Docker:

```bash
docker compose up -d
