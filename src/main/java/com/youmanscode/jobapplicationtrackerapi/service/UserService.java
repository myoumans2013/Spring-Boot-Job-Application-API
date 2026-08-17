package com.youmanscode.jobapplicationtrackerapi.service;

import com.youmanscode.jobapplicationtrackerapi.entity.User;
import com.youmanscode.jobapplicationtrackerapi.security.CustomUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final CustomUserRepository customUserRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(CustomUserRepository customUserRepository, PasswordEncoder passwordEncoder) {
        this.customUserRepository = customUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveNewUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return customUserRepository.save(user);
    }
}
