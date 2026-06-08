package com.youmanscode.jobapplicationtrackerapi.application;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Valid
@RestController
@RequestMapping("api/applications")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping()
    public List<JobApplication> getAllApplications() {
        return jobApplicationService.getAllApplications();
    }

    @GetMapping("{id}")
    public List<JobApplication> getApplicationById(@PathVariable Long id) {
        System.out.println("Job application created!");
        return jobApplicationService.getApplicationByID(id);
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
