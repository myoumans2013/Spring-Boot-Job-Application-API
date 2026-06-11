package com.youmanscode.jobapplicationtrackerapi.application;

import com.youmanscode.jobapplicationtrackerapi.dto.InterviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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

    // take in Interview object and map it to InterviewDataTransferObject (DTO)
    public InterviewDTO mapToDTO(Interview interview) {
        InterviewDTO interviewDTO = new InterviewDTO();
        interviewDTO.setId(interview.getId());
        interviewDTO.setInterviewDate(interview.getInterviewDate());
        interviewDTO.setInterviewerType(interview.getInterviewerType());
        interviewDTO.setInterviewerName(interview.getInterviewerName());
        interviewDTO.setNotes(interview.getNotes());
        interviewDTO.setJobApplicationId(interview.getJobApplication().getId());
        interviewDTO.setCompanyName(interview.getJobApplication().getCompanyName());
        interviewDTO.setJobTitle(interview.getJobApplication().getJobTitle());

        return interviewDTO;
    }

    public InterviewDTO createInterviewById(Interview interview, Long id) {
        Optional<JobApplication> application = jobApplicationRepository.findById(id);
        if (application.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            JobApplication foundJobApplication = application.get();
            interview.setJobApplication(foundJobApplication);
            interviewRepository.save(interview);
        }
        return mapToDTO(interview);
    }

    public List<InterviewDTO> getAllInterviews() {
        List<Interview> interviews = interviewRepository.findAll();
        List<InterviewDTO> dtos = new ArrayList<>();

        for (Interview interview : interviews) {
            dtos.add(mapToDTO(interview));
        }
        return dtos;
    }

    public List<InterviewDTO> getInterviewsPerJobApplicationId(Long id) {
        List<Interview> interviews = interviewRepository.findByJobApplication_Id(id);
        List<InterviewDTO> dtos = new ArrayList<>();

        for (Interview interview : interviews) {
            dtos.add(mapToDTO(interview));
        }

        return dtos;

    }

    public InterviewDTO getRecentInterview(JobApplication jobApplication, Long id) {
        Optional<Interview> interview = interviewRepository.findFirstByJobApplicationOrderByInterviewDateDesc(jobApplication);
        if (interview.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Interview getInterview = interview.get();
        return mapToDTO(getInterview);
    }

    public void deleteAllInterviews() {
        interviewRepository.deleteAll();
    }


}
