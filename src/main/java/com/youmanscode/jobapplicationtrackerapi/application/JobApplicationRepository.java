package com.youmanscode.jobapplicationtrackerapi.application;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Access JpaRepository methods for JobApplication
 */
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}
