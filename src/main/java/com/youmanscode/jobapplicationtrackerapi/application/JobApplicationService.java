package com.youmanscode.jobapplicationtrackerapi.application;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Create Service for API requests
 */

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;


    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public List<JobApplication> getAllApplications() {
        return jobApplicationRepository.findAll();
    }

    public JobApplication createApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public void deleteAllApplications() {
        jobApplicationRepository.deleteAll();
    }

    public List<JobApplication> getApplicationByID(Long id) {
        Optional<JobApplication> getID = jobApplicationRepository.findById(id);
        if (getID.isEmpty()) {
            throw new IllegalStateException("Can't find id");
        } else {
            JobApplication jobApplication = getID.get();
            return Collections.singletonList(jobApplication);

        }
    }

    public void deleteApplicationById(Long id) {
        Optional<JobApplication> application = jobApplicationRepository.findById(id);
        if (application.isEmpty()) {
            throw new IllegalStateException("Cannot find id");
        } else {
            JobApplication jobApplication = application.get();
            jobApplicationRepository.delete(jobApplication);
        }
    }
}
