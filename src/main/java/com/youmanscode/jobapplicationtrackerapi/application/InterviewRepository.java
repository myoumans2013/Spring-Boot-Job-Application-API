package com.youmanscode.jobapplicationtrackerapi.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

    public List<Interview> findByJobApplication_Id(Long id);
}
