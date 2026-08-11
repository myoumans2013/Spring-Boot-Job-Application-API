package com.youmanscode.jobapplicationtrackerapi.security;

import com.youmanscode.jobapplicationtrackerapi.entity.User;
import com.youmanscode.jobapplicationtrackerapi.exceptionHandling.UsernameNotFoundException;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final CustomUserRepository customUserRepository;

    public CustomUserDetailsService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username)
            throws org.springframework.security.core.userdetails.UsernameNotFoundException {
        User user = customUserRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find username."));

        return new CustomUserDetails(user);
    }
}
