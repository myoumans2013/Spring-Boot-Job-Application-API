package com.youmanscode.jobapplicationtrackerapi.security;

import com.youmanscode.jobapplicationtrackerapi.entity.User;
import com.youmanscode.jobapplicationtrackerapi.exceptionHandling.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService {
    private final CustomUserRepository customUserRepository;

    public CustomUserDetailsService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }

    public User findUserByUsername(String username) {
        return customUserRepository.findUserByUsername(username)
                .orElseThrow(()
                        -> new UsernameNotFoundException("Cannot find user"));
    }
}
