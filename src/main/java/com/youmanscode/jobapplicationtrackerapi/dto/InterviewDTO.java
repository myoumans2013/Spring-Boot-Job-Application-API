package com.youmanscode.jobapplicationtrackerapi.dto;

import java.time.LocalDate;

public class InterviewDTO {

    Long id;
    LocalDate interviewDate;
    String interviewerName;
    String interviewerType;
    String notes;
    Long jobApplicationId;
    String companyName;
    String jobTitle;

    public InterviewDTO(Long id, LocalDate interviewDate, String interviewerType, String interviewerName, String notes, Long jobApplicationId, String companyName, String jobTitle) {
        this.id = id;
        this.interviewDate = interviewDate;
        this.interviewerType = interviewerType;
        this.interviewerName = interviewerName;
        this.notes = notes;
        this.jobApplicationId = jobApplicationId;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
    }

    public InterviewDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getInterviewerType() {
        return interviewerType;
    }

    public void setInterviewerType(String interviewerType) {
        this.interviewerType = interviewerType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getJobApplicationId() {
        return jobApplicationId;
    }

    public void setJobApplicationId(Long jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
