package com.youmanscode.jobapplicationtrackerapi.application;

import com.youmanscode.jobapplicationtrackerapi.dto.InterviewDTO;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://spring-boot-job-application-api.onrender.com")
@RestController
@RequestMapping("api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping("{id}")
    public InterviewDTO createInterviewById(@RequestBody Interview interview, @PathVariable Long id) {
        return interviewService.createInterviewById(interview, id);
    }

    @GetMapping("/getMostRecentInterview/{id}")
    public InterviewDTO getMostRecentInterviewByJobApplicationId(@PathVariable Long id, JobApplication jobApplication) {
        return interviewService.getRecentInterview(jobApplication, id);
    }

    @GetMapping()
    public List<InterviewDTO> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/JopAppInterviews/{id}")
    public List<InterviewDTO> getInterviewsPerJobApplicationId(@PathVariable Long id) {
        return interviewService.getInterviewsPerJobApplicationId(id);
    }

    @DeleteMapping({"/deleteJobInterviewsByJobAppId/{id}"})
    public void deleteInterviewByInterviewId(@PathVariable Long id) {
        interviewService.deleteInterviewByInterviewId(id);
    }

    @DeleteMapping
    public void deleteAllInterviews() {
        interviewService.deleteAllInterviews();
    }


}
