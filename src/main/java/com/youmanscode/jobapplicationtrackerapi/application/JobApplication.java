package com.youmanscode.jobapplicationtrackerapi.application;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;


/**
 * Create main JobApplication entity/object with contrustors/getters/setters
 */
@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String companyName;
    String jobTitle;
    @Enumerated(EnumType.STRING)
    ApplicationStatus status;
    LocalDate dateApplied;
    String jobLink;
    String notes;

    public JobApplication() {
    }

    public JobApplication(Long id, String companyName, ApplicationStatus status, String jobTitle, LocalDate dateApplied, String jobLink, String notes) {
        this.id = id;
        this.companyName = companyName;
        this.status = status;
        this.jobTitle = jobTitle;
        this.dateApplied = dateApplied;
        this.jobLink = jobLink;
        this.notes = notes;
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

    public String getJobLink() {
        return jobLink;
    }

    public void setJobLink(String jobLink) {
        this.jobLink = jobLink;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
