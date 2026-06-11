package com.youmanscode.jobapplicationtrackerapi.application;

import com.youmanscode.jobapplicationtrackerapi.dto.JobApplicationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Create Service for API requests
 */

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final InterviewRepository interviewRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository, InterviewRepository interviewRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.interviewRepository = interviewRepository;
    }

    public JobApplicationDTO jobApplicationDTO(JobApplication jobApplication) {
        JobApplicationDTO jobApplicationDTO = new JobApplicationDTO();

        jobApplicationDTO.setId(jobApplication.getId());
        jobApplicationDTO.setCompanyName(jobApplication.getCompanyName());
        jobApplicationDTO.setStatus(jobApplication.getStatus());
        jobApplicationDTO.setDateApplied(jobApplication.getDateApplied());
        jobApplicationDTO.setJobLink(jobApplication.getJobLink());
        jobApplicationDTO.setNotes(jobApplication.getNotes());
        jobApplicationDTO.setInterviewCount(interviewRepository.countInterviewsByJobApplicationId(jobApplication.getId()));

        return jobApplicationDTO;
    }

    public List<JobApplication> findByStatus(ApplicationStatus status) {
        return jobApplicationRepository.findByStatus(status);
    }

    public List<JobApplication> findByJobTitle(String jobTitle) {
        return jobApplicationRepository.findByJobTitleContainingIgnoreCase(jobTitle);
    }

    public List<JobApplicationDTO> getAllApplications() {
        List<JobApplication> applications = jobApplicationRepository.findAll();
        List<JobApplicationDTO> jobApplicationDTOS = new ArrayList<>();

        for (JobApplication application : applications) {
            jobApplicationDTOS.add(jobApplicationDTO(application));
        }

        return jobApplicationDTOS;
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

    public JobApplication getApplicationById(Long id) {
        Optional<JobApplication> application = jobApplicationRepository.findById(id);
        if (application.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return application.get();
        }
    }

    public void deleteApplicationById(Long id) {
        Optional<JobApplication> application = jobApplicationRepository.findById(id);
        JobApplication jobApplication = application.get();
        jobApplicationRepository.delete(jobApplication);

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
