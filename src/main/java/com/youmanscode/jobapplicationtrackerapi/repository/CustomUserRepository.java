package com.youmanscode.jobapplicationtrackerapi.repository;

import com.youmanscode.jobapplicationtrackerapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// finds and tracks users
public interface CustomUserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);
}
