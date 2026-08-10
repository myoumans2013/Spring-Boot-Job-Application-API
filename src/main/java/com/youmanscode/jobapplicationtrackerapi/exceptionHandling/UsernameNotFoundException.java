package com.youmanscode.jobapplicationtrackerapi.exceptionHandling;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String message) {
        super(message);
    }
}
