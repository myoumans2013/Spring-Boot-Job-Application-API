# Job Application Tracker

A full-stack job application tracker built with Spring Boot, React, and PostgreSQL for managing job applications and interviews.

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- Docker Compose

### Frontend
- React
- Vite
- JavaScript
- CSS

### Deployment
- Render
- Supabase PostgreSQL

## Features

- Create, read, update, and delete job applications
- Filter applications by application status
- Search applications by job title
- Add interviews to individual job applications
- Delete interviews
- Display job applications and interviews through React
- Loading and error handling
- Delete confirmation
- PostgreSQL persistence
- Separate local and production environments
- Local PostgreSQL development with Docker
- Production PostgreSQL database with Supabase
- Frontend and backend deployment with Render

## Project Structure

The application follows a standard frontend/backend architecture:

React Frontend  
↓  
Spring Boot REST API  
↓  
Spring Data JPA  
↓  
PostgreSQL

The backend is separated into:

- Controllers
- Services
- Repositories
- Entities
- DTOs
- API configuration

The frontend separates:

- React components
- Application state
- API request functions
- Styling

## Main API Endpoints

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

## Development Environments

The project uses separate local and production configurations.

### Local Development

Local development uses:

- React/Vite on `localhost:5173`
- Spring Boot on `localhost:8080`
- PostgreSQL through Docker Compose
- Spring Boot `local` profile
- Vite `.env.development`

Flow:

React  
↓  
Local Spring Boot API  
↓  
Local Docker PostgreSQL

### Production

Production uses:

- Render frontend
- Render backend
- Supabase PostgreSQL
- Render environment variables
- Vite `.env.production`

Flow:

Render Frontend  
↓  
Render Spring Boot API  
↓  
Supabase PostgreSQL

## Run Locally

Start PostgreSQL:

```bash
docker compose up -d
