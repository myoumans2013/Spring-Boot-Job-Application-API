package com.youmanscode.jobapplicationtrackerapi.application;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping("{id}")
    public Interview createInterviewById(@RequestBody Interview interview, @PathVariable Long id) {
        return interviewService.createInterviewById(interview, id);
    }

    @GetMapping()
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @DeleteMapping
    public void deleteAllInterviews() {
        interviewService.deleteAllInterviews();
    }

}
