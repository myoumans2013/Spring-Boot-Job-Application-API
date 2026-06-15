package com.youmanscode.jobapplicationtrackerapi.application;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Access JpaRepository methods for JobApplication
 */
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findAllByOrderByDateAppliedDesc(LocalDate dateApplied);

    List<JobApplication> findByStatus(ApplicationStatus status);

    List<JobApplication> findByJobTitleContainingIgnoreCase(String jobTitle);

}

