package com.youmanscode.jobapplicationtrackerapi.exceptionHandling;

public class ResponseStatusException extends RuntimeException {
    public ResponseStatusException(String message) {
        super(message);
    }
}
