package com.youmanscode.jobapplicationtrackerapi.application;

import com.youmanscode.jobapplicationtrackerapi.dto.JobApplicationDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "https://job-application-tracker-frontend-2o21.onrender.com")
@RestController
@RequestMapping("api/applications")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping("/jobTitle/{jobTitle}")
    public List<JobApplicationDTO> findByJobTitle(@PathVariable String jobTitle) {
        return jobApplicationService.findByJobTitle(jobTitle);
    }

    @GetMapping("/status/{status}")
    public List<JobApplicationDTO> findByStatus(@PathVariable ApplicationStatus status) {
        return jobApplicationService.findByStatus(status);
    }

    @GetMapping()
    public List<JobApplicationDTO> getAllApplications(LocalDate date) {
        return jobApplicationService.getAllApplications(date);
    }

    @GetMapping("{id}")
    public JobApplication getApplicationById(@PathVariable Long id) {
        System.out.println("Job application created!");
        return jobApplicationService.getApplicationById(id);
    }

    @PostMapping()
    public JobApplication createJobApplication(@Valid @RequestBody JobApplication jobApplication) {
        return jobApplicationService.createApplication(jobApplication);
    }

    @PutMapping("{id}")
    public JobApplication updateJobApplicationById(@PathVariable Long id, @Valid @RequestBody JobApplication jobApplication) {
        return jobApplicationService.updateJobApplicationById(id, jobApplication);
    }


    @DeleteMapping
    public String deleteAllApplications() {
        jobApplicationService.deleteAllApplications();
        return "All applications have been deleted.";
    }

    @DeleteMapping("{id}")
    public String deleteApplicationById(@PathVariable Long id) {
        jobApplicationService.deleteApplicationById(id);
        return "Job application #" + id + " has been deleted.";
    }


}
