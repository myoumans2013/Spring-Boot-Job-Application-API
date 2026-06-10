package com.youmanscode.jobapplicationtrackerapi.application;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {
    private final InterviewRepository interviewRepository;
    private final JobApplicationRepository jobApplicationRepository;

    public InterviewService(InterviewRepository interviewRepository, JobApplicationRepository jobApplicationRepository) {
        this.interviewRepository = interviewRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public Interview createInterviewById(Interview interview, Long id) {
        Optional<JobApplication> application = jobApplicationRepository.findById(id);
        if (application.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            JobApplication foundJobApplication = application.get();
            interview.setJobApplication(foundJobApplication);
            interviewRepository.save(interview);
        }
        return interview;
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public void deleteAllInterviews() {
        interviewRepository.deleteAll();
    }


}
