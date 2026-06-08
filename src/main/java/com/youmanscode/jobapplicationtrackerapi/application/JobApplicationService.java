package com.youmanscode.jobapplicationtrackerapi.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (jobApplicationRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return jobApplicationRepository.findAll();
        }
    }

    public JobApplication createApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public void deleteAllApplications() {
        if (jobApplicationRepository.findAll().isEmpty()) {
            System.out.println("There are no job applications to delete.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            jobApplicationRepository.deleteAll();
            throw new ResponseStatusException(HttpStatus.OK);
        }
    }

    public List<JobApplication> getApplicationByID(Long id) {
        Optional<JobApplication> application = jobApplicationRepository.findById(id);
        if (application.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            JobApplication jobApplication = application.get();
            return Collections.singletonList(jobApplication);

        }
    }

    public void deleteApplicationById(Long id) {
        Optional<JobApplication> application = jobApplicationRepository.findById(id);
        if (application.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            JobApplication jobApplication = application.get();
            jobApplicationRepository.delete(jobApplication);
        }
    }

    public JobApplication updateJobApplicationById(Long id, JobApplication updatedApplication) {
        Optional<JobApplication> application = jobApplicationRepository.findById(id);
        if (application.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            JobApplication existingApplication = application.get();
            existingApplication.setCompanyName(updatedApplication.getCompanyName());
            existingApplication.setJobTitle(updatedApplication.getJobTitle());
            existingApplication.setStatus(updatedApplication.getStatus());
            existingApplication.setDateApplied(updatedApplication.getDateApplied());
            existingApplication.setJobLink(updatedApplication.getJobLink());
            existingApplication.setNotes(updatedApplication.getNotes());
            jobApplicationRepository.save(existingApplication);
            return existingApplication;
        }
    }
}
