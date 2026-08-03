package com.youmanscode.jobapplicationtrackerapi.repository;

import com.youmanscode.jobapplicationtrackerapi.entity.Interview;
import com.youmanscode.jobapplicationtrackerapi.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

    List<Interview> findByJobApplication_Id(Long id);

    Optional<Interview> findFirstByJobApplicationOrderByInterviewDateDesc(JobApplication id);
    

}
