package com.youmanscode.jobapplicationtrackerapi.application;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Access JpaRepository methods for JobApplication
 */
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByStatus(ApplicationStatus status);

    List<JobApplication> findByJobTitle(String jobTitle);

}

