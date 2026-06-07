package com.youmanscode.jobapplicationtrackerapi.application;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping()
    public JobApplication createJobApplication(@RequestBody JobApplication jobApplication) {
        return jobApplicationService.createApplication(jobApplication);
    }

    @GetMapping("{id}")
    public List<JobApplication> getApplicationById(@PathVariable Long id) {
        System.out.println("Job application created!");
        return jobApplicationService.getApplicationByID(id);
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
