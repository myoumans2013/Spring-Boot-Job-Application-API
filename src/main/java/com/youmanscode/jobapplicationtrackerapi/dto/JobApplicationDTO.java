package com.youmanscode.jobapplicationtrackerapi.dto;

import com.youmanscode.jobapplicationtrackerapi.enums.ApplicationStatus;

import java.time.LocalDate;

public class JobApplicationDTO {

    private Long id;
    private String companyName;
    private String jobTitle;
    private ApplicationStatus status;
    private LocalDate dateApplied;
    private String jobLink;
    private String notes;

    public JobApplicationDTO(Long id, String companyName, String jobTitle, ApplicationStatus status, LocalDate dateApplied, String jobLink, String notes) {
        this.id = id;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.status = status;
        this.dateApplied = dateApplied;
        this.jobLink = jobLink;
        this.notes = notes;
    }

    public JobApplicationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getJobLink() {
        return jobLink;
    }

    public void setJobLink(String jobLink) {
        this.jobLink = jobLink;
    }

}
